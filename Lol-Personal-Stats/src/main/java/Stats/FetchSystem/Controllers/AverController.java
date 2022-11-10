package Stats.FetchSystem.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
        AverageMatch am = new AverageMatch();
        for(int i = 0; i < mo1.size(); i++){
            am.add(new MatchOverall(mo1.get(i), mo2.get(i)));
        }
        return am.build();
    }
    @GetMapping("/average/ChampGames")
    public @ResponseBody List<AverageMatch> getChampGames(
        @RequestParam(name = "name", required = true) String name,
        @RequestParam(name = "champ", required = true) String champ)
    {
        List<MatchOverall1> m1s = overall1.findByName(name);
        List<MatchOverall2> m2s = overall2.findByName(name);
        List<AverageMatch> am = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            am.add(new AverageMatch());
        } 
        for(int i = 0; i < m1s.size(); i++){
            if(m1s.get(i).getChampion().equals(champ)){
                MatchOverall mo = new MatchOverall(m1s.get(i), m2s.get(i));
                am.get(0).add(mo);
                if(m1s.get(i).getPosition().trim().length() != 0 ){
                    am.get(1).add(mo);
                } else {
                    am.get(2).add(mo);
                }
            }
        }
        List<AverageMatch> am2 = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            am2.add(am.get(i).build());
        }
        return am2;
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
        for(int i = 0; i < 8;i++){
            match.add(new AverageMatch());
        }
        for(int i = 0; i < m1s.size();i++){
            MatchOverall mo = new MatchOverall(m1s.get(i), m2s.get(i));
            match.get(0).add(mo);
            if(m1s.get(i).getPosition().trim().length() != 0 ){
                match.get(1).add(mo);
            } else {
                match.get(2).add(mo);
            }
            switch(m1s.get(i).getPosition()){
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
        return match;
    }

    @GetMapping("/average/Player/Team")
    public @ResponseBody List<AverageMatch> getPlayerTeam(
        @RequestParam(name = "name", required = false, defaultValue = "") String name) {
        List<AverageMatch> match = new ArrayList<>();
        List<MatchOverall1> m1s = overall1.findByName(name);
        List<String> matches = getMatchId(m1s);
        for(int i = 0; i < 8;i++){
            match.add(new AverageMatch());
        }
        for(String mat : matches){
            List<MatchOverall1> m1 = overall1.findByMatchID(mat);
            List<MatchOverall2> m2 = overall2.findByMatchID(mat);
            String team = m1.stream()
                .filter(m -> m.getName().equals(name)) // filter to only the player
                .collect(Collectors.toList()) //convert to list
                .get(0).getTeam(); // get Team of index 0 which is the player
            if(m1.size() != m2.size()){
                System.out.println("HELP THEY ARE NOT THE SAME M1: " + m1.size() + " AND M2: " + m2.size());
            }
            for(int i = 0; i < m1.size();i++){
                if(!m1.get(i).getName().equals(name) && m1.get(i).getTeam().equals(team)){
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
        }
        return match;
    }

    @GetMapping("/average/Stats")
    public @ResponseBody AverageMatch getStats(
        @RequestParam(name = "name",  required = true)  String name,
        @RequestParam(name = "champ", required = true)  String champ,
        @RequestParam(name = "pos",   required = true)  String pos,
        @RequestParam(name = "gms",   required = true)  String gms )
    {
        List<MatchOverall1> matches;
        if(name == "all"){
            matches = new ArrayList<>();
            var x = overall1.findAll();
            for(var y : x){
                matches.add(y);
            }
        } else {
            matches = overall1.findByName(name);
        } 
        if(!champ.equals("all")){
            String[] champs = champ.split(",");
            matches = filter.includeOnlyChamps(matches, champs);
        }
        if(!pos.equals("all")){
            String[] poss = pos.split(",");
            matches = filter.incldeOnlyPositions(matches, poss); 
        }
        if(!gms.equals("all")){
            String[] gmss = gms.split(",");
            matches = filter.incldeOnlyGameMode(matches, gmss,history.findAll()); 
        }
        AverageMatch am = new AverageMatch();
        for(MatchOverall1 mo1 : matches){
            MatchOverall2 m2 = overall2.findByMatchIDAndName(mo1.getMatchID(),mo1.getName()).get(0);
            MatchOverall  mo = new MatchOverall(mo1, m2);
            am.add(mo);
        }
        am = am.build();
        return am;
    }

    @GetMapping("/average/Team")
    public @ResponseBody AverageMatch getTeam(
        @RequestParam(name = "name",   required = true)  String name,
        @RequestParam(name = "champ",  required = true)  String champ,
        @RequestParam(name = "pos",    required = true)  String pos,
        @RequestParam(name = "gms",    required = true)  String gms, 
        @RequestParam(name = "team",   required = true)  String team,
        @RequestParam(name = "Oname",  required = true)  String Oname,
        @RequestParam(name = "Ochamp", required = true)  String Ochamp,
        @RequestParam(name = "Opos",   required = true)  String Opos,
        @RequestParam(name = "Ogms",   required = true)  String Ogms
    ){
        List<MatchOverall1> matches;
        if(name == "all"){
            matches = new ArrayList<>();
            var x = overall1.findAll();
            for(var y : x){
                matches.add(y);
            }
        } else {
            matches = overall1.findByName(name);
        } 
        if(!champ.equals("all")){
            String[] champs = champ.split(",");
            matches = filter.includeOnlyChamps(matches, champs);
        }
        if(!pos.equals("all")){
            String[] poss = pos.split(",");
            matches = filter.incldeOnlyPositions(matches, poss); 
        }
        if(!gms.equals("all")){
            String[] gmss = gms.split(",");
            matches = filter.incldeOnlyGameMode(matches, gmss,history.findAll()); 
        }
        List<String> matchs = new ArrayList<>();
        for(MatchOverall1 mo1 : matches){
            matchs.add(mo1.getMatchID());
        }
        AverageMatch am = new AverageMatch();
        for(String match : matchs){
            String side;
            if(team.equals("true")){
                side = getSide(match, name);
            } else {
                side = getSide(match, name) == "Blue" ? "Red" : "Blue";
            }
            if(!Ogms.equals("all")){
                String[] Ogmss = Ogms.split(",");
                if(!filter.contains(Ogmss, history.findByMatchID(match).get(0).getGameMode())){
                    continue;
                }
            }
            List<MatchOverall1> mo1 = overall1.findByMatchID(match);
            for(MatchOverall1 m1 : mo1 ){
                if(!side.equals(m1.getTeam())){
                    continue;
                }
                if(!Oname.equals("all") && !Oname.equals(m1.getName())){
                    continue;
                }
                if(!Ochamp.equals("all") && !Ochamp.equals(m1.getChampion())){
                    continue;
                }
                if(!Opos.equals("all") && !filter.contains(Opos.split(","), m1.getPosition())){
                    continue;
                }
                am.add( 
                    new MatchOverall(m1, overall2.findByMatchIDAndName(m1.getMatchID(), m1.getName()).get(0))
                );
            }
        }
        return am.build();
    }


    //Helper 
    private String getSide(String match2, String name) {
        return overall1.findByMatchIDAndName(match2, name).get(0).getTeam();
    }

    private HashMap<String,String> getMatchIdAndName(List<MatchOverall1> mo1) {
        HashMap<String,String> MatchIds = new HashMap<>();
        for(MatchOverall1 m1 : mo1){
            MatchIds.put(m1.getMatchID(), m1.getName());
        }
        return MatchIds;
    }


    private List<String> getMatchId(List<MatchOverall1> mo1) {
        List<String> MatchIds = new ArrayList<>();
        for(MatchOverall1 m1 : mo1){
            MatchIds.add(m1.getMatchID());
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
