package Stats.FetchSystem.Storage.Other;

import java.util.ArrayList;
import java.util.List;

import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Entitys.MatchOverall1;
import Stats.FetchSystem.Storage.Entitys.MatchOverall2;

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
        System.out.println(overal1.size());
        System.out.println(overal2.size());
        System.out.println(intervals.size());
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
