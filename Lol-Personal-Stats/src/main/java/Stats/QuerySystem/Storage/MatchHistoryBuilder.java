package Stats.QuerySystem.Storage;

import java.util.ArrayList;

public class MatchHistoryBuilder {

    private MatchHistory mh;

    public MatchHistoryBuilder(){
        mh =  new MatchHistory();
    }

    public MatchHistoryBuilder setID(String id){
        mh.setMatchID(id);
        return this;
    }
    
    public MatchHistoryBuilder setGameMode(String mode){
        mh.setGameMode(mode);
        return this;
    }

    public MatchHistoryBuilder setWinner(String winner){
        mh.setWinningTeam(winner);
        return this;
    }
    public MatchHistoryBuilder setDate(int daysSince){
        // do some calulations with daysSince
        mh.setDate("s");
        return this;
    }
    
    public MatchHistoryBuilder setTeams(ArrayList<String> red ,ArrayList<String> blue ){
        // do all the set with the list
        return this;
    }
}
