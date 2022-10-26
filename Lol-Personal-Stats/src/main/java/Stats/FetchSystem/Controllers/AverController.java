package Stats.FetchSystem.Controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Stats.FetchSystem.Helpers.Helper;
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
    //Helper 

    private List<MatchHistory> getHistorys(List<MatchOverall1> mo1) {
        ArrayList<String> MatchIds = new ArrayList<>();
        for(MatchOverall1 m1 : mo1){
            MatchIds.add(m1.getMatchID());
        }
        ArrayList<MatchHistory> historys = new ArrayList<>();
        for(String matchId : MatchIds){
            historys.add(history.findByMatchID(matchId).get(0));
        }
        return historys;
    }


    
}
