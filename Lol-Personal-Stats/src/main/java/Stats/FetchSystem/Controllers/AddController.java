package Stats.FetchSystem.Controllers;

import java.util.ArrayList;

import javax.persistence.criteria.Fetch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Stats.FetchSystem.Fetcher.Fetcher;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Other.MatchOverall;
import Stats.FetchSystem.Storage.Other.MatchRecord;
import Stats.FetchSystem.Storage.Repository.MatchHistoryRespository;
import Stats.FetchSystem.Storage.Repository.MatchIntervalRespository;
import Stats.FetchSystem.Storage.Repository.MatchOverall1Respository;
import Stats.FetchSystem.Storage.Repository.MatchOverall2Respository;

public class AddController {
    
    @Autowired
    MatchIntervalRespository match;
    @Autowired
    MatchOverall1Respository overall1;
    @Autowired
    MatchOverall2Respository overall2;
    @Autowired 
    MatchHistoryRespository history;

    @PostMapping("/AddMatch")
    public @ResponseBody String index(@RequestParam String id){
        MatchRecord x = Fetcher.getMatchRecord(id);
        history.save(x.getMatchHistory());
        for(MatchOverall y : x.getOverals()){
            overall1.save(y.getMatch1());
            overall2.save(y.getMatch2());
        }
        for(ArrayList<MatchInterval> intervals : x.getIntervals()){
            for(MatchInterval interval : intervals){
                match.save(interval);
            }
        }
        return "Match has been saved";
    }
}
