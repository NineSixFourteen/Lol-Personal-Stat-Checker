package Stats.FrontEnd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Stats.BackEnd.Entitys.MatchHistory;
import Stats.BackEnd.Entitys.MatchInterval;
import Stats.BackEnd.Entitys.MatchOverall1;
import Stats.BackEnd.Entitys.MatchOverall2;
import Stats.BackEnd.Other.MatchOverall;
import Stats.BackEnd.Other.MatchRecord;
import Stats.BackEnd.Repository.MatchHistoryRespository;
import Stats.BackEnd.Repository.MatchIntervalRespository;
import Stats.BackEnd.Repository.MatchOverall1Respository;
import Stats.BackEnd.Repository.MatchOverall2Respository;
import Stats.Other.Helper;
import Stats.Other.filter;


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
    
    @GetMapping("/get/Player/matches")
    public @ResponseBody List<MatchRecord> getPlayerLast10(
        @RequestParam(name = "name", required = true) String name,
        @RequestParam(name = "filterType", required = false, defaultValue = "-1") String type,
        @RequestParam(name = "filter", required = false, defaultValue = "") String f )
    {
        System.out.println(type + " " + f);
        List<MatchOverall1> mo1 = overall1.findByName(name);
        switch(type){
            case "0":
                String[] champs = f.split(",");
                mo1 = filter.includeOnlyChamps(mo1,champs);
                break;
            case "1":
                String[] pos = f.split(",");
                mo1 = filter.incldeOnlyPositions(mo1,pos);
                break;
            case "2":
                String[] parts = f.split("-");
                String[] poss; 
                if(parts.length == 1){
                    poss = new String[]{""};
                } else{
                    poss = parts[1].split(","); 
                }
                String[] cha = parts[0].split(","); 
                
                mo1 = filter.includeOnlyChampsinPositions(mo1,cha, poss);
                break;
        }
        List<MatchHistory> mh = new ArrayList<>();
        for(MatchOverall1 m1 : mo1){
            mh.add(history.findByMatchID(m1.getMatchID()).get(0));
        }
        List<String> last10 = getItems(mh, 100);
        ArrayList<MatchRecord> games = new ArrayList<>();
        for(String id : last10){
            games.add(getMatchOffline(id));
        }
        return games;
    }

    private List<String> getItems(List<MatchHistory> mh,int size) {
        Comparator<MatchHistory> byDate = (MatchHistory mh1, MatchHistory mh2) -> mh2.getMatchID().compareTo(mh1.getMatchID());
        mh.sort(byDate);
        int len = mh.size() < size ? mh.size() : size;
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

}
