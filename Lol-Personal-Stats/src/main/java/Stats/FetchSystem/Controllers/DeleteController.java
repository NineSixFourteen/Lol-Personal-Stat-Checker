package Stats.FetchSystem.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import Stats.FetchSystem.Storage.Repository.MatchHistoryRespository;
import Stats.FetchSystem.Storage.Repository.MatchIntervalRespository;
import Stats.FetchSystem.Storage.Repository.MatchOverall1Respository;
import Stats.FetchSystem.Storage.Repository.MatchOverall2Respository;

@Controller
public class DeleteController {
    @Autowired
    MatchIntervalRespository match;
    @Autowired
    MatchOverall1Respository overall1;
    @Autowired
    MatchOverall2Respository overall2;
    @Autowired 
    MatchHistoryRespository history;
    
    @PostMapping("/delete/ov1")
    public @ResponseBody String delete1(@RequestParam int id){
        overall1.deleteById(id);
        return "id has been deleted";
    }
    @PostMapping("/delete/ov2")
    public @ResponseBody String delete2(@RequestParam int id){
        overall2.deleteById(id);
        return "id has been deleted";
    }
}
