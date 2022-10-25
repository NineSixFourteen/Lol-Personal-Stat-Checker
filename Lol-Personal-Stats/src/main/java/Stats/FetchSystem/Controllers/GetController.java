package Stats.FetchSystem.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Entitys.MatchOverall1;
import Stats.FetchSystem.Storage.Entitys.MatchOverall2;
import Stats.FetchSystem.Storage.Other.MatchOverall;
import Stats.FetchSystem.Storage.Other.MatchRecord;
import Stats.FetchSystem.Storage.Other.PlayerRecord;
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
    
    @GetMapping("/getPlayer")
    public @ResponseBody PlayerRecord getPlayer(
        @RequestParam(name = "id", required = false, defaultValue = "") String id,
        @RequestParam(name = "name", required = false, defaultValue = "") String name )
    {
        MatchHistory mh = history.findByMatchID(id).get(0);
        MatchOverall1 mo1 = overall1.findByMatchIDAndName(id, name).get(0);
        MatchOverall2 mo2 = overall2.findByMatchIDAndName(id, name).get(0);
        List<MatchInterval> intervals = match.findByMatchIDAndName(id, name);
        return new PlayerRecord(mh, mo1,mo2, intervals);
    }

    @GetMapping("/getMatch")
    public @ResponseBody MatchRecord getPlayer(
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
        ArrayList<ArrayList<MatchInterval>> intervals = seperateList(match.findByMatchID(id),names);
        return new MatchRecord(mh,mo, intervals);
    }

    private ArrayList<ArrayList<MatchInterval>> seperateList(List<MatchInterval> interva, ArrayList<String> names) {
        ArrayList<ArrayList<MatchInterval>> intervals = new ArrayList<>();
        for(int i = 0; i < 10;i++ ){
            intervals.add(new ArrayList<>());
        }
        for(MatchInterval mi : interva){
            int l = 0; 
            for(String name: names){
                if(name.equals(mi.getName())){
                    intervals.get(l).add(mi);
                    break;
                }l++;
            }
        }
        return intervals;
    }

    @GetMapping("/testPlayer")
    public @ResponseBody String test(
        @RequestParam(name = "id", required = false, defaultValue = "") String id,
        @RequestParam(name = "name", required = false, defaultValue = "") String name )
    {
        boolean foundH = history.findByMatchID(id).size() < 1;
        boolean found1 = overall1.findByMatchIDAndName(id, name).size() < 1;
        boolean found2 = overall2.findByMatchIDAndName(id, name).size() < 1;
        boolean foundIs = match.findByMatchIDAndName(id, name) != null;
        return "Name : " + name + " ID : " + id + "\n" + 
            "Found History : " + foundH  + "\n" + 
            "Found Overall1 : " + found1  + "\n" + 
            "Found Overall2 : " + found2  + "\n" + 
            "Found Intervals : " + false  + "\n";
    }
    
}
