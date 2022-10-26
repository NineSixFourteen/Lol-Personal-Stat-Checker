package Stats.FetchSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Stats.FetchSystem.Fetcher.Fetcher;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Other.MatchRecord;
import Stats.FetchSystem.Storage.Other.PlayerRecord;
import Stats.FetchSystem.Storage.Repository.MatchHistoryRespository;
import Stats.FetchSystem.Storage.Repository.MatchIntervalRespository;
import Stats.FetchSystem.Storage.Repository.MatchOverall1Respository;
import Stats.FetchSystem.Storage.Repository.MatchOverall2Respository;

@Controller
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
        for(PlayerRecord y : x.getPlayers()){
            overall1.save(y.getMo().getMatch1());
            overall2.save(y.getMo().getMatch2());
        }
        for(PlayerRecord player : x.getPlayers()){
            for(MatchInterval interval : player.getIntervals()){
                match.save(interval);
            }
        }
        return "Match has been saved";
    }

    
}
