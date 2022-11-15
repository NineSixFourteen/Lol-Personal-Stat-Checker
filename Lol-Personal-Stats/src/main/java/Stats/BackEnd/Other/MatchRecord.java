package Stats.BackEnd.Other;

import java.util.ArrayList;
import java.util.List;

import Stats.BackEnd.Entitys.MatchHistory;
import Stats.BackEnd.Entitys.MatchInterval;
import Stats.BackEnd.Entitys.MatchOverall1;
import Stats.BackEnd.Entitys.MatchOverall2;

public class MatchRecord {

    MatchHistory matchHistory; 
    List<PlayerRecord> players;
    
    public MatchRecord(MatchHistory matchHistory, ArrayList<MatchOverall> overals,
            List<ArrayList<MatchInterval>> intervals) {
        this.matchHistory = matchHistory;
        players = new ArrayList<>();
        for(int i = 0; i < overals.size();i++){
            players.add(new PlayerRecord(overals.get(i).getMatch1(),overals.get(i).getMatch2(),intervals.get(i)));
        }
    }
    
    public MatchRecord(MatchHistory matchHistory, List<MatchOverall1> overal1,List<MatchOverall2> overal2,
    List<ArrayList<MatchInterval>> intervals) {
        this.matchHistory = matchHistory;
        players = new ArrayList<>();
        for(int i = 0; i < overal1.size();i++){
            players.add(new PlayerRecord(overal1.get(i),overal2.get(i),intervals.get(i)));
        }
    }
    
    public MatchHistory getMatchHistory() {
        return matchHistory;
    }
    public void setMatchHistory(MatchHistory matchHistory) {
        this.matchHistory = matchHistory;
    }
    public List<PlayerRecord> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<PlayerRecord> players) {
        this.players = players;
    }
    
}
