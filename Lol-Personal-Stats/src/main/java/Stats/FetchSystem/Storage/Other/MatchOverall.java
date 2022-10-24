package Stats.FetchSystem.Storage.Other;

import Stats.FetchSystem.Storage.Entitys.MatchOverall1;
import Stats.FetchSystem.Storage.Entitys.MatchOverall2;

public class MatchOverall {

    private MatchOverall1 match1; 
    private MatchOverall2 match2;
    
    public MatchOverall(MatchOverall1 match1, MatchOverall2 match2) {
        this.match1 = match1;
        this.match2 = match2;
    }
    public MatchOverall1 getMatch1() {
        return match1;
    }
    public void setMatch1(MatchOverall1 match1) {
        this.match1 = match1;
    }
    public MatchOverall2 getMatch2() {
        return match2;
    }
    public void setMatch2(MatchOverall2 match2) {
        this.match2 = match2;
    } 

    
    
}
