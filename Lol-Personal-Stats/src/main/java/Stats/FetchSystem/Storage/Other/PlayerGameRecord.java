package Stats.FetchSystem.Storage.Other;

import java.util.List;

import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Entitys.MatchOverall1;
import Stats.FetchSystem.Storage.Entitys.MatchOverall2;

public class PlayerGameRecord {

    MatchHistory match; 
    PlayerRecord player;
    
    public PlayerGameRecord(MatchHistory match, MatchOverall1 over1, MatchOverall2 over2, List<MatchInterval> intervals) {
        this.match = match;
        player = new PlayerRecord(over1,over2,intervals);
    }
    public MatchHistory getMatch() {
        return match;
    }
    public void setMatch(MatchHistory match) {
        this.match = match;
    }
    
    
}
