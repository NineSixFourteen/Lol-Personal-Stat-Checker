package Stats.FetchSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Stats.FetchSystem.Storage.Repository.MatchHistoryRespository;
import Stats.FetchSystem.Storage.Repository.MatchIntervalRespository;
import Stats.FetchSystem.Storage.Repository.MatchOverall1Respository;
import Stats.FetchSystem.Storage.Repository.MatchOverall2Respository;

@Controller
public class TestController {

    @Autowired
    MatchIntervalRespository match;
    @Autowired
    MatchOverall1Respository overall1;
    @Autowired
    MatchOverall2Respository overall2;
    @Autowired 
    MatchHistoryRespository history;

    @GetMapping("/testPlayer")
    public @ResponseBody String test(
        @RequestParam(name = "id", required = false, defaultValue = "") String id,
        @RequestParam(name = "name", required = false, defaultValue = "") String name )
    {
        boolean foundH = history.findByMatchID(id).size() < 1;
        boolean found1 = overall1.findByMatchIDAndName(id, name).size() < 1;
        boolean found2 = overall2.findByMatchIDAndName(id, name).size() < 1;
        //boolean foundIs = match.findByMatchIDAndName(id, name) != null;
        return "Name : " + name + " ID : " + id + "\n" + 
            "Found History : " + foundH  + "\n" + 
            "Found Overall1 : " + found1  + "\n" + 
            "Found Overall2 : " + found2  + "\n" + 
            "Found Intervals : " + false  + "\n";
    }
    
    
}
