package Stats.FetchSystem.Storage.Other;

import java.util.List;

import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Entitys.MatchOverall1;
import Stats.FetchSystem.Storage.Entitys.MatchOverall2;

public class PlayerRecord {

    MatchHistory match; 
    MatchOverall1 over1; 
    MatchOverall2 over2;
    List<MatchInterval> intervals;
    
    public PlayerRecord(MatchHistory match, MatchOverall1 over1, MatchOverall2 over2, List<MatchInterval> intervals) {
        this.match = match;
        this.over1 = over1;
        this.over2 = over2;
        this.intervals = intervals;
    }
    public MatchHistory getMatch() {
        return match;
    }
    public void setMatch(MatchHistory match) {
        this.match = match;
    }
    public MatchOverall1 getOver1() {
        return over1;
    }
    public void setOver1(MatchOverall1 over1) {
        this.over1 = over1;
    }
    public MatchOverall2 getOver2() {
        return over2;
    }
    public void setOver2(MatchOverall2 over2) {
        this.over2 = over2;
    }
    public List<MatchInterval> getIntervals() {
        return intervals;
    }
    public void setIntervals(List<MatchInterval> intervals) {
        this.intervals = intervals;
    }
    
    
}
