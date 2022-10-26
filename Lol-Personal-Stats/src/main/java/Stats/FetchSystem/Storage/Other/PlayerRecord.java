package Stats.FetchSystem.Storage.Other;

import java.util.List;

import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Entitys.MatchOverall1;
import Stats.FetchSystem.Storage.Entitys.MatchOverall2;

public class PlayerRecord {

    private MatchOverall mo; 
    private List<MatchInterval> intervals;

    public PlayerRecord(MatchOverall1 over1, MatchOverall2 over2, List<MatchInterval> intervals) {
        mo = new MatchOverall(over1, over2);
        this.intervals = intervals;

    }

    public MatchOverall getMo() {
        return mo;
    }

    public void setMo(MatchOverall mo) {
        this.mo = mo;
    }

    public List<MatchInterval> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<MatchInterval> intervals) {
        this.intervals = intervals;
    }
    
}
