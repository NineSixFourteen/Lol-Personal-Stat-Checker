package Stats.FetchSystem.Storage.Other;

import java.util.ArrayList;

import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;

public class MatchRecord {

    MatchHistory matchHistory; 
    ArrayList<MatchOverall> overals;
    ArrayList<ArrayList<MatchInterval>> intervals;
    
    public MatchRecord(MatchHistory matchHistory, ArrayList<MatchOverall> overals,
            ArrayList<ArrayList<MatchInterval>> intervals) {
        this.matchHistory = matchHistory;
        this.overals = overals;
        this.intervals = intervals;
    }
    public MatchHistory getMatchHistory() {
        return matchHistory;
    }
    public void setMatchHistory(MatchHistory matchHistory) {
        this.matchHistory = matchHistory;
    }
    public ArrayList<MatchOverall> getOverals() {
        return overals;
    }
    public void setOverals(ArrayList<MatchOverall> overals) {
        this.overals = overals;
    }
    public ArrayList<ArrayList<MatchInterval>> getIntervals() {
        return intervals;
    }
    public void setIntervals(ArrayList<ArrayList<MatchInterval>> intervals) {
        this.intervals = intervals;
    }

    

    
}
