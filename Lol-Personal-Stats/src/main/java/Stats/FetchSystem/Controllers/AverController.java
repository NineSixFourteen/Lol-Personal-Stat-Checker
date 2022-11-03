package Stats.FetchSystem.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Stats.FetchSystem.Helpers.filter;
import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Entitys.MatchOverall1;
import Stats.FetchSystem.Storage.Entitys.MatchOverall2;
import Stats.FetchSystem.Storage.Other.AverageMatch;
import Stats.FetchSystem.Storage.Other.MatchOverall;
import Stats.FetchSystem.Storage.Repository.MatchHistoryRespository;
import Stats.FetchSystem.Storage.Repository.MatchIntervalRespository;
import Stats.FetchSystem.Storage.Repository.MatchOverall1Respository;
import Stats.FetchSystem.Storage.Repository.MatchOverall2Respository;

@Controller
public class AverController {
    @Autowired
    MatchIntervalRespository match;
    @Autowired
    MatchOverall1Respository overall1;
    @Autowired
    MatchOverall2Respository overall2;
    @Autowired 
    MatchHistoryRespository history;

    @GetMapping("/average/PlayerGames")
    public @ResponseBody AverageMatch getPlayerGames(
        @RequestParam(name = "name", required = false, defaultValue = "") String name,
        @RequestParam(name = "GM", required = false, defaultValue = "all") String gms)
    {
        List<MatchOverall1> mo1 = overall1.findByName(name);
        List<MatchOverall2> mo2;
        if(gms.equals("all")){    
            mo2 = overall2.findByName(name); 
        } else {
            List<MatchHistory> histories = getHistorys(mo1);
            histories = filter.incldeOnlyGameMode2(Arrays.asList(gms.split(",")), histories);
            mo2 = new ArrayList<>();
            mo1 = new ArrayList<>();
            for(MatchHistory matchHistory : histories){
               mo2.add(overall2.findByMatchIDAndName(matchHistory.getMatchID(), name).get(0));
            } 
            for(MatchHistory matchHistory : histories){
                mo1.add(overall1.findByMatchIDAndName(matchHistory.getMatchID(), name).get(0));
             } 
        }
        System.out.println(mo1.size());
        System.out.println(mo2.size());
        AverageMatch am = new AverageMatch();
        for(int i = 0; i < mo1.size(); i++){
            am.add(new MatchOverall(mo1.get(i), mo2.get(i)));
        }
        return am.build();
    }
    @GetMapping("/average/ChampGames")
    public @ResponseBody AverageMatch getChampGames(
        @RequestParam(name = "name", required = false, defaultValue = "") String name,
        @RequestParam(name = "GM", required = false, defaultValue = "all") String gms)
    {
        List<MatchOverall1> mo1 = overall1.findByChampion(name);
        List<MatchOverall2> mo2;
        List<MatchHistory> histories = getHistorys(mo1);
        var names = getMatchIdAndName(mo1);
        if(!gms.equals("all")){
            histories = filter.incldeOnlyGameMode2(Arrays.asList(gms.split(",")), histories);
        }
        mo2 = new ArrayList<>();
        mo1 = new ArrayList<>();
        for(MatchHistory matchHistory : histories){
            mo2.add(overall2.findByMatchIDAndName(matchHistory.getMatchID(), names.get(matchHistory.getMatchID())).get(0));
        } 
        for(MatchHistory matchHistory : histories){
            mo1.add(overall1.findByMatchIDAndName(matchHistory.getMatchID(), names.get(matchHistory.getMatchID())).get(0));
        } 
        System.out.println(mo1.size());
        System.out.println(mo2.size());
        AverageMatch am = new AverageMatch();
        for(int i = 0; i < mo1.size(); i++){
            am.add(new MatchOverall(mo1.get(i), mo2.get(i)));
        }
        return am.build();
    }

    @GetMapping("/average/Positions")
    public @ResponseBody List<AverageMatch> getPosition(){
        String[] posistions = new String[]{"TOP","JUNGLE","MIDDLE","BOTTOM","SUPPORT"};
        List<AverageMatch> match = new ArrayList<>();
        for(String pos : posistions){
            List<MatchOverall1> mo1 = overall1.findByPosition(pos);
            List<MatchOverall2> mo2 = new ArrayList<>();
            List<MatchHistory> histories = getHistorys(mo1);
            var names = getMatchIdAndName(mo1);
            mo1 = new ArrayList<>();
            for(MatchHistory matchHistory : histories){
                mo2.add(overall2.findByMatchIDAndName(matchHistory.getMatchID(), names.get(matchHistory.getMatchID())).get(0));
            } 
            for(MatchHistory matchHistory : histories){
                mo1.add(overall1.findByMatchIDAndName(matchHistory.getMatchID(), names.get(matchHistory.getMatchID())).get(0));
            } 
            AverageMatch am = new AverageMatch();
            for(int i = 0; i < mo1.size(); i++){
                am.add(new MatchOverall(mo1.get(i), mo2.get(i)));
            }
            match.add(am.build());
        }
        return match;
    }
    @GetMapping("/average/PlayerPosition")
    public @ResponseBody List<AverageMatch> getPlayerPosition(
        @RequestParam(name = "name", required = false, defaultValue = "") String name) {
        List<AverageMatch> match = new ArrayList<>();
        List<MatchOverall1> m1s = overall1.findByName(name);
        List<MatchOverall2> m2s = overall2.findByName(name);
        for(int i = 0; i < 6;i++){
            match.add(new AverageMatch());
        }
        for(int i = 0; i < m1s.size();i++){
            MatchOverall mo = new MatchOverall(m1s.get(i), m2s.get(i));
            match.get(5).add(mo);
            switch(m1s.get(i).getPosition()){
                case "TOP":
                    match.get(0).add(mo);break;
                case "JUNGLE":
                    match.get(1).add(mo);break;
                case "MIDDLE":
                    match.get(2).add(mo);break;
                case "BOTTOM":
                    match.get(3).add(mo);break;
                case "SUPPORT":
                    match.get(4).add(mo);break;
            }
        }
        return match;
    }
    //Helper 

    private HashMap<String,String> getMatchIdAndName(List<MatchOverall1> mo1) {
        HashMap<String,String> MatchIds = new HashMap<>();
        for(MatchOverall1 m1 : mo1){
            MatchIds.put(m1.getMatchID(), m1.getName());
        }
        return MatchIds;
    }

    private List<MatchHistory> getHistorys(List<MatchOverall1> mo1) {
        ArrayList<MatchHistory> historys = new ArrayList<>();
        for(MatchOverall1 m1 : mo1){
            historys.add(history.findByMatchID(m1.getMatchID()).get(0));
        }
        return historys;
    }


    
}
