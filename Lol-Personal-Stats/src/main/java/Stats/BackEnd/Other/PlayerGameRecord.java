package Stats.BackEnd.Other;

import java.util.List;

import Stats.BackEnd.Entitys.MatchHistory;
import Stats.BackEnd.Entitys.MatchInterval;
import Stats.BackEnd.Entitys.MatchOverall1;
import Stats.BackEnd.Entitys.MatchOverall2;

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
