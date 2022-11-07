package Stats.FetchSystem.Controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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
        List<MatchOverall1> mo1 = overall1.findByName(name);
        List<MatchHistory> mh = new ArrayList<>();
        for(MatchOverall1 m1 : mo1){
            mh.add(history.findByMatchID(m1.getMatchID()).get(0));
        }
        List<String> last10 = last10(mh);
        ArrayList<MatchRecord> games = new ArrayList<>();
        for(String id : last10){
            games.add(getMatchOffline(id));
        }
        return games;
    }

    private List<String> last10(List<MatchHistory> mh) {
        Comparator<MatchHistory> byDate = (MatchHistory mh1, MatchHistory mh2) -> mh2.getMatchID().compareTo(mh1.getMatchID());
        mh.sort(byDate);
        int len = mh.size() < 100 ? mh.size() : 100;
        List<String> m = new ArrayList<>();
        for(int i = 0 ;  i < len ; i++){
            m.add(mh.get(i).getMatchID());
        }
        return m;
    }

    @GetMapping("/get/Champ/topChamps")
    public @ResponseBody HashMap<String,Integer> getChampTop5(
        @RequestParam(name = "name", required = false, defaultValue = "") String name )
    {
        HashMap<String,Integer> champCount = new HashMap<>();
        for(MatchOverall1 m1 : overall1.findByName(name)){
            String champ = m1.getChampion();
            if(champCount.containsKey(champ)){
                champCount.put(champ, champCount.get(champ) + 1);
            } else {
                champCount.put(champ, 1);
            }
        }
        return champCount;
    }

    @GetMapping("/get/Champs/played")
    public @ResponseBody List<HashMap<String,Integer>> getChamps(
        @RequestParam(name = "name", required = false, defaultValue = "") String name )
    {
        List<HashMap<String,Integer>> champCount = new ArrayList<>();
        for(int i = 0; i< 3; i++){
            champCount.add(new HashMap<>());
        }
        for(MatchOverall1 m1 : overall1.findByName(name)){
            String champ = m1.getChampion();
            if(champCount.get(0).containsKey(champ)){
                champCount.get(0).put(champ, champCount.get(0).get(champ) + 1);
            } else {
                champCount.get(0).put(champ, 1);
            }
            if(m1.getPosition().trim().length() != 0){
                if(champCount.get(1).containsKey(champ)){
                    champCount.get(1).put(champ, champCount.get(1).get(champ) + 1);
                } else {
                    champCount.get(1).put(champ, 1);
                }
            } else {
                if(champCount.get(2).containsKey(champ)){
                    champCount.get(2).put(champ, champCount.get(2).get(champ) + 1);
                } else {
                    champCount.get(2).put(champ, 1);
                }
            }
        }
        return champCount;
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
