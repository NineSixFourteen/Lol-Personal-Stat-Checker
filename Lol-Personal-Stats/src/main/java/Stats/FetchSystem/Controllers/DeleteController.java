package Stats.FetchSystem.Controllers;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Stats.FetchSystem.Fetcher.Fetcher;
import Stats.FetchSystem.Helpers.GetInfo;
import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Other.MatchRecord;
import Stats.FetchSystem.Storage.Other.PlayerRecord;
import Stats.FetchSystem.Storage.Repository.MatchHistoryRespository;
import Stats.FetchSystem.Storage.Repository.MatchIntervalRespository;
import Stats.FetchSystem.Storage.Repository.MatchOverall1Respository;
import Stats.FetchSystem.Storage.Repository.MatchOverall2Respository;

@Controller
public class DeleteController {
    @Autowired
    MatchIntervalRespository match;
    @Autowired
    MatchOverall1Respository overall1;
    @Autowired
    MatchOverall2Respository overall2;
    @Autowired 
    MatchHistoryRespository history;
    
    @PostMapping("/delete/ov1")
    public @ResponseBody String delete1(@RequestParam int id){
        overall1.deleteById(id);
        return "id has been deleted";
    }
    @PostMapping("/delete/ov2")
    public @ResponseBody String delete2(@RequestParam int id){
        overall2.deleteById(id);
        return "id has been deleted";
    }
    @GetMapping("/clean")
    public @ResponseBody String clean(){
        List<String> ids = new ArrayList<>();
        List<String> dups = new ArrayList<>();
        for(MatchHistory mh : history.findAll()){
            if(ids.contains(mh.getMatchID())){
                dups.add(mh.getMatchID());
            }
            ids.add(mh.getMatchID());
        }
        writeDups(dups);
        for(String dup : dups){
            deleteRecords(dup);
        }
        for(String dup : dups){
            getRecord(dup);
        }
        return "Cleaning complete";
    }

    private void getRecord(String dup) {
        MatchRecord x = Fetcher.getMatchRecord(dup);
        history.save(x.getMatchHistory());
        for(PlayerRecord y : x.getPlayers()){
            overall1.save(y.getMo().getMatch1());
            overall2.save(y.getMo().getMatch2());
        }
        for(PlayerRecord player : x.getPlayers()){
            for(MatchInterval interval : player.getIntervals()){
                match.save(interval);
            }
        }
    }


    private static void writeDups(List<String> dups){
        try {
            FileWriter myWriter = new FileWriter(GetInfo.fileName);
            String x = "";
            for(String dup : dups){
                x += dup + ", ";
            }
            x = x.substring(0, x.length() - 2);
            myWriter.write(x);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private void deleteRecords(String dup) {
        for(var x : match.findByMatchID(dup)){
            match.deleteById(x.getId());
        }
        for(var x : history.findByMatchID(dup)){
            history.deleteById(x.getId());
        }
        for(var x : overall1.findByMatchID(dup)){
            overall1.deleteById(x.getId()); 
        }
        for(var x : overall2.findByMatchID(dup)){
            overall2.deleteById(x.getId()); 
        }
    
    }
}
