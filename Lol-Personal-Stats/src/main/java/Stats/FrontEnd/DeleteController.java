package Stats.FrontEnd;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Stats.BackEnd.Entitys.MatchHistory;
import Stats.BackEnd.Entitys.MatchInterval;
import Stats.BackEnd.Entitys.MatchOverall1;
import Stats.BackEnd.Other.MatchRecord;
import Stats.BackEnd.Other.PlayerRecord;
import Stats.BackEnd.Repository.MatchHistoryRespository;
import Stats.BackEnd.Repository.MatchIntervalRespository;
import Stats.BackEnd.Repository.MatchOverall1Respository;
import Stats.BackEnd.Repository.MatchOverall2Respository;
import Stats.InfoFetcher.Fetcher;

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
    
    @GetMapping("/delete/Match")
    public @ResponseBody String deleteMatch(@RequestParam String id){
        System.out.println("Deleting " +id)  ;
        deleteRecords(id);
        return "Match has been deleted";
    }

    @GetMapping("/delete/Player")
    public @ResponseBody String deletePlayer(@RequestParam String name){
        List<MatchOverall1> matches = overall1.findByName(name);
        int i = 0;
        for(MatchOverall1 mo1 : matches){
            System.out.println("Deleting " + mo1.getMatchID())  ;
            deleteRecords(mo1.getMatchID());
            i++;
        }
        return "Deleted " + i + " games with player " + name;
    }

    @GetMapping("/clean")
    public @ResponseBody String clean(){
        List<String> ids = new ArrayList<>();
        List<String> dups = new ArrayList<>();
        for(MatchHistory mh : history.findAll()){
            if(ids.contains(mh.getMatchID()) && !dups.contains(mh.getMatchID())){
                dups.add(mh.getMatchID());
            } else {
                ids.add(mh.getMatchID());
            }
        }
        
        for(String dup : dups){
            deleteRecords(dup);
        }
        deleteNulls();
        addGames(dups, dups.size());
        return "Cleaning complete";
    }

    private void deleteNulls() {
        for(var x : match.findAll()){
            if(x.getMatchID() == null){
                match.deleteById(x.getId());
            }
        }
        for(var x : overall1.findAll()){
            if(x.getMatchID() == null){
                overall1.deleteById(x.getId());
            }
        }
        for(var x : overall2.findAll()){
            if(x.getMatchId() == null){
                overall2.deleteById(x.getId());
            }
        }
        for(var x : history.findAll()){
            if(x.getMatchID() == null){
                history.deleteById(x.getId());
            }
        }
    }

    public boolean saveGame(String id){
        MatchRecord x = Fetcher.getMatchRecord(id);
        if(x == null){
            return false; 
        }
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
        return true;
    }

    public void addGames(List<String> games, int am ){
        int i = 0; 
        while(i < am){
            if(saveGame(games.get(i))){
                System.out.println("Saved Game " + games.get(i));
                i++;
            } else {
                try {
                    System.out.println("Failed Game " + games.get(i));
                    TimeUnit.MINUTES.sleep(1);
                    System.out.println("Reattempt Game " + games.get(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Finished");
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
