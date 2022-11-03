package Stats.FetchSystem.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Stats.FetchSystem.Helpers.Helper;
import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Entitys.MatchOverall1;
import Stats.FetchSystem.Storage.Entitys.MatchOverall2;
import Stats.FetchSystem.Storage.Other.MatchOverall;
import Stats.FetchSystem.Storage.Other.MatchRecord;
import Stats.FetchSystem.Storage.Other.PlayerGameRecord;
import Stats.FetchSystem.Storage.Repository.MatchHistoryRespository;
import Stats.FetchSystem.Storage.Repository.MatchIntervalRespository;
import Stats.FetchSystem.Storage.Repository.MatchOverall1Respository;
import Stats.FetchSystem.Storage.Repository.MatchOverall2Respository;

@Controller
public class GetController {

    @Autowired
    MatchIntervalRespository match;
    @Autowired
    MatchOverall1Respository overall1;
    @Autowired
    MatchOverall2Respository overall2;
    @Autowired 
    MatchHistoryRespository history;
    
    @GetMapping("/get/Player")
    public @ResponseBody PlayerGameRecord getPlayer(
        @RequestParam(name = "id", required = false, defaultValue = "") String id,
        @RequestParam(name = "name", required = false, defaultValue = "") String name )
    {
        MatchHistory mh = history.findByMatchID(id).get(0);
        MatchOverall1 mo1 = overall1.findByMatchIDAndName(id, name).get(0);
        MatchOverall2 mo2 = overall2.findByMatchIDAndName(id, name).get(0);
        List<MatchInterval> intervals = match.findByMatchIDAndName(id, name);
        return new PlayerGameRecord(mh, mo1,mo2, intervals);
    }

    @GetMapping("/get/Player/last10")
    public @ResponseBody List<MatchRecord> getPlayerLast10(
        @RequestParam(name = "name", required = false, defaultValue = "") String name )
    {
        System.out.println(name);
        List<MatchOverall1> mo1 = overall1.findByName(name);
        ArrayList<String> ids = new ArrayList<>();
        int size = mo1.size() < 10 ? mo1.size() : 10; // Checks if there is atleast 10 games on record
        for(int i = 0; i < size; i++ ){
            ids.add(mo1.get(i).getMatchID());
        }
        ArrayList<MatchRecord> games = new ArrayList<>();
        for(String id : ids){
            games.add(getMatchOffline(id));
        }
        return games;
    }

    @GetMapping("/get/Match")
    public @ResponseBody MatchRecord getMatch(
        @RequestParam(name = "id", required = false, defaultValue = "") String id)
    {
        MatchHistory mh = history.findByMatchID(id).get(0);
        List<MatchOverall1> mo1 = overall1.findByMatchID(id);
        List<MatchOverall2> mo2 = overall2.findByMatchID(id);
        ArrayList<MatchOverall> mo = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0; i < mo1.size(); i++){
            mo.add(new MatchOverall(mo1.get(i), mo2.get(i)));
            names.add(mo1.get(i).getName());
        }
        ArrayList<ArrayList<MatchInterval>> intervals = Helper.seperateList(match.findByMatchID(id),names);
        return new MatchRecord(mh,mo, intervals);
    }

    public MatchRecord getMatchOffline(String id)
    {
        MatchHistory mh = history.findByMatchID(id).get(0);
        List<MatchOverall1> mo1 = overall1.findByMatchID(id);
        List<MatchOverall2> mo2 = overall2.findByMatchID(id);
        ArrayList<MatchOverall> mo = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0; i < mo1.size(); i++){
            mo.add(new MatchOverall(mo1.get(i), mo2.get(i)));
            names.add(mo1.get(i).getName());
        }
        ArrayList<ArrayList<MatchInterval>> intervals = Helper.seperateList(match.findByMatchID(id),names);
        return new MatchRecord(mh,mo, intervals);
    }

    @GetMapping("/get/PlayerGames")
    public @ResponseBody List<MatchRecord> getPlayerGames(
        @RequestParam(name = "name", required = false, defaultValue = "") String name)
    {
        List<MatchOverall1> mo1 = overall1.findByName(name);
        ArrayList<String> matchIDs = new ArrayList<>();
        for(MatchOverall1 m1 : mo1){
            matchIDs.add(m1.getMatchID());
        } 
        ArrayList<MatchRecord> records = new ArrayList<>();
        for(String MatchID : matchIDs){
            List<MatchOverall1> over1 = overall1.findByMatchID(MatchID);
            ArrayList<String> names = new ArrayList<>();
            for(MatchOverall1 over : over1){
                names.add(over.getName());
            }
            records.add(
                new MatchRecord(
                    history.findByMatchID(MatchID).get(0),
                    overall1.findByMatchID(MatchID), 
                    overall2.findByMatchID(MatchID), 
                    Helper.seperateList(match.findByMatchID(MatchID),names)
                )
            );
        }
        return records;
    }

    @GetMapping("/get/ChampGames")
    public @ResponseBody List<MatchRecord> getChampGames(
        @RequestParam(name = "name", required = false, defaultValue = "") String name)
    {
        List<MatchOverall1> mo1 = overall1.findByChampion(name);
        ArrayList<String> matchIDs = new ArrayList<>();
        for(MatchOverall1 m1 : mo1){
            matchIDs.add(m1.getMatchID());
        } 
        ArrayList<MatchRecord> records = new ArrayList<>();
        for(String MatchID : matchIDs){
            List<MatchOverall1> over1 = overall1.findByMatchID(MatchID);
            ArrayList<String> names = new ArrayList<>();
            for(MatchOverall1 over : over1){
                names.add(over.getName());
            }
            records.add(
                new MatchRecord(
                    history.findByMatchID(MatchID).get(0),
                    overall1.findByMatchID(MatchID), 
                    overall2.findByMatchID(MatchID), 
                    Helper.seperateList(match.findByMatchID(MatchID),names)
                )
            );
        }
        return records;
    }

    //Helpers

 

}
