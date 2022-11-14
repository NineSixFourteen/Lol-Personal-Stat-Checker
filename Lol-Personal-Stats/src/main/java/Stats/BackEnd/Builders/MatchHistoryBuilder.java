package Stats.BackEnd.Builders;

import java.time.LocalDate;

import Stats.BackEnd.Entitys.MatchHistory;

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
        seconds %= 60;
        mes += seconds > 9 ? seconds : "0" + seconds ;
        mh.setGameLength(mes);
        return this;
    }

    public MatchHistoryBuilder setDate(int daysSince){
        LocalDate x = LocalDate.of(2022,1,1).plusDays(daysSince);
        mh.setDate(x.toString());
        return this;
    }
    
    public MatchHistory build(){
        return mh;
    }
}
