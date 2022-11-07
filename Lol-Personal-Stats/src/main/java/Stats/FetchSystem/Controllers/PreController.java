package Stats.FetchSystem.Controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Stats.FetchSystem.Helpers.Helper;
import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Entitys.MatchOverall1;
import Stats.FetchSystem.Storage.Entitys.MatchOverall2;
import Stats.FetchSystem.Storage.Other.AverageMatch;
import Stats.FetchSystem.Storage.Other.MatchOverall;
import Stats.FetchSystem.Storage.Other.MatchRecord;
import Stats.FetchSystem.Storage.Other.PlayerGameRecord;
import Stats.FetchSystem.Storage.Repository.MatchHistoryRespository;
import Stats.FetchSystem.Storage.Repository.MatchIntervalRespository;
import Stats.FetchSystem.Storage.Repository.MatchOverall1Respository;
import Stats.FetchSystem.Storage.Repository.MatchOverall2Respository;

@Controller
public class PreController {

    @Autowired
    MatchIntervalRespository match;
    @Autowired
    MatchOverall1Respository overall1;
    @Autowired
    MatchOverall2Respository overall2;
    @Autowired 
    MatchHistoryRespository history;

    private List<AverageMatch> TotalAveragePosition;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        TotalAveragePosition = getTotalAverage();
    }

    private List<AverageMatch> getTotalAverage() {
        List<AverageMatch> match = new ArrayList<>();
        List<String> matches = new ArrayList<>();
        var m1s = history.findAll();
        m1s.forEach(
            x -> {
                matches.add(x.getMatchID());
            }
        );
        for(int i = 0; i < 8;i++){
            match.add(new AverageMatch());
        }
        for(String mat : matches){
            List<MatchOverall1> m1 = overall1.findByMatchID(mat);
            List<MatchOverall2> m2 = overall2.findByMatchID(mat);
            if(m1.size() != m2.size()){
                System.out.println("HELP THEY ARE NOT THE SAME M1: " + m1.size() + " AND M2: " + m2.size());
            }
            for(int i = 0; i < m1.size();i++){
                MatchOverall mo = new MatchOverall(m1.get(i),m2.get(i));
                match.get(0).add(mo);
                if(m1.get(i).getPosition().trim().length() == 0){
                    match.get(1).add(mo);
                } else {
                    match.get(2).add(mo);
                }
                switch(m1.get(i).getPosition()){
                    case "TOP":
                        match.get(3).add(mo);break;
                    case "JUNGLE":
                        match.get(4).add(mo);break;
                    case "MIDDLE":
                        match.get(5).add(mo);break;
                    case "BOTTOM":
                        match.get(6).add(mo);break;
                    case "SUPPORT":
                        match.get(7).add(mo);break;
                }
            }
        }
        return match;
    }
        
    @GetMapping("/pre/averagePos")
    public @ResponseBody List<AverageMatch> getAveragePos(){
        return TotalAveragePosition;
    }


    
}
