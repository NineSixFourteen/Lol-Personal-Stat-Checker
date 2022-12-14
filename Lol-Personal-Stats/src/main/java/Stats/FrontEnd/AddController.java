package Stats.FrontEnd;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Stats.BackEnd.Entitys.MatchInterval;
import Stats.BackEnd.Other.MatchRecord;
import Stats.BackEnd.Other.PlayerRecord;
import Stats.BackEnd.Repository.MatchHistoryRespository;
import Stats.BackEnd.Repository.MatchIntervalRespository;
import Stats.BackEnd.Repository.MatchOverall1Respository;
import Stats.BackEnd.Repository.MatchOverall2Respository;
import Stats.InfoFetcher.Fetcher;

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

    @GetMapping("/add/Match")
    public @ResponseBody String index(@RequestParam String id){
        MatchRecord x = Fetcher.getMatchRecord(id);
        if(x == null){
            return "Failed Game Not Found";
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
        return "Match has been saved";
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

    @GetMapping("/add/Player")
    public @ResponseBody String addPlayer(
        @RequestParam(name = "name", required = true) String name,
        @RequestParam(name = "amount", required = false, defaultValue = "50") String amount
    ){
        int am; 
        String Msg = "";
        try{
            am = Integer.parseInt(amount);
        }catch(Exception e){
            Msg += "amount was not an int converting to 50";
            am = 50;
        }
        boolean x = Fetcher.test();
        if(!x) {
            return Msg + "\n Key is not working";
        }
        String s= Fetcher.puuid(name);
        if(s.equals("1")){
            return Msg + "\n Summoner was not found";
        }
        List<String> games = Fetcher.getGames(s, am);
        if(games.isEmpty()){
            return Msg + "\n Summoner was not found";
        }
        am = games.size() < am ? games.size() : am; // check there is enough games
        addGames(games, am);
        return Msg;
    }

    public void addGames(List<String> games, int am ){
        int i = 0; 
        int fails = 0;
        while(i < am){
            if(saveGame(games.get(i))){
                System.out.println("Saved Game " + games.get(i));
                i++;
                fails = 0 ;
            } else {
                fails++;
                if(fails == 4){
                    i++;
                }else{
                    try {
                        System.out.println("Failed Game " + games.get(i));
                        TimeUnit.MINUTES.sleep(1);
                        System.out.println("Reattempt Game " + games.get(i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("Finished");
    }

    @GetMapping("/add/test")
    public @ResponseBody String test(){
        boolean x = Fetcher.test();
        if(x){
            return "Key is working";
        } else {
            return "Key is not working";
        }
    }    

}
