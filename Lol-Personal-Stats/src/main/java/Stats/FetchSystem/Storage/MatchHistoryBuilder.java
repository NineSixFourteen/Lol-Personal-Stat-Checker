package Stats.FetchSystem.Storage;

import java.time.LocalDate;
import java.util.List;

public class MatchHistoryBuilder {

    private MatchHistory mh;

    public MatchHistoryBuilder(){
        mh =  new MatchHistory();
    }

    public MatchHistoryBuilder setID(String id){
        mh.setMatchID(id);
        return this;
    }
    
    public MatchHistoryBuilder setGameMode(int queueID){
        switch(queueID){
            case 400 : mh.setGameMode("Draft");break;
            case 420 : mh.setGameMode("Solo/Duo");break;
            case 430 : mh.setGameMode("Blind");break;
            case 440 : mh.setGameMode("Flex");break;
            case 450 : mh.setGameMode("ARAM");break;
            default  : mh.setGameMode("Other");break;
        }
        return this;
    }

    public MatchHistoryBuilder setWinner(boolean win){
        if(win){
            mh.setWinningTeam("blue");
        }else {
            mh.setWinningTeam("red");
        }
        
        return this;
    }

    public MatchHistoryBuilder setLength(int seconds){
        String mes = "";
        mes += (seconds / 60);
        mes += ':';
        mes += seconds%60;
        mh.setGameLength(mes);
        return this;
    }

    public MatchHistoryBuilder setDate(int daysSince){
        LocalDate x = LocalDate.of(2022,1,1).plusDays(daysSince);
        mh.setDate(x.toString());
        return this;
    }
    
    public MatchHistoryBuilder setTeams(List<String> blue,List<String> red ){
        mh.setBlue(blue);
        mh.setRed(red);
        return this;
    }

    public MatchHistory build(){
        return mh;
    }
}
