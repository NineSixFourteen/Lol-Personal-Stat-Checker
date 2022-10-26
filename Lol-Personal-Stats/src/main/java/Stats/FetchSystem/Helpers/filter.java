package Stats.FetchSystem.Helpers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Other.MatchRecord;
import Stats.FetchSystem.Storage.Other.PlayerRecord;

public class filter {

    public static List<MatchRecord> incldeOnlyGameMode(List<String> includes, List<MatchRecord> matchRecords){
        return matchRecords.stream() 
         .filter(x -> includes.contains(x.getMatchHistory().getGameMode()))
         .collect(Collectors.toList());
    } 

    public static List<MatchHistory> incldeOnlyGameMode2(List<String> includes, List<MatchHistory> matchHistories){
        return matchHistories.stream() 
         .filter(x -> includes.contains(x.getGameMode()))
         .collect(Collectors.toList());
    } 

    public static List<MatchRecord> incldeOnlyPosition(String name,List<String> includes, List<MatchRecord> matchRecords){
        return matchRecords.stream() 
         .filter(x -> includes.contains(getPosition(name, x.getPlayers())))
         .collect(Collectors.toList());
    } 

    public static List<MatchRecord> includeOnlyBewteenDates(LocalDate start, LocalDate end, List<MatchRecord> matchRecords ){
        return matchRecords.stream() 
        .filter(x -> isBewteen(start, end, x.getMatchHistory().getDate()))
        .collect(Collectors.toList());
    }

    //Helpers 
    private static boolean isBewteen(LocalDate start , LocalDate end , String dat){
        LocalDate date = LocalDate.parse(dat);
        return date.isAfter(start) && date.isBefore(end);
    }

    private static String getPosition(String name, List<PlayerRecord> players){
        for(PlayerRecord player : players){
            if(player.getMo().getMatch1().getName().equals(name)){
                return player.getMo().getMatch1().getPosition();
            }
        }
        return "";
    }
    
}