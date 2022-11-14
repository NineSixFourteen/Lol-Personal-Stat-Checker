package Stats.Other;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import Stats.BackEnd.Entitys.MatchHistory;
import Stats.BackEnd.Entitys.MatchOverall1;
import Stats.BackEnd.Other.MatchRecord;
import Stats.BackEnd.Other.PlayerRecord;

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

    public static List<MatchOverall1> includeOnlyChamps(List<MatchOverall1> mo1, String[] champs) {
        return mo1.stream() 
            .filter(player -> contains(champs, player.getChampion()))
            .collect(Collectors.toList());
    }

    public static List<MatchOverall1> incldeOnlyPositions(List<MatchOverall1> mo1, String[] pos) {
        return mo1.stream() 
            .filter(player -> contains(pos, player.getPosition()))
            .collect(Collectors.toList());
    }

    public static List<MatchOverall1> includeOnlyChampsinPositions(List<MatchOverall1> mo1, String[] champs ,String[] pos) {
        return mo1.stream() 
            .filter(player -> contains(pos, player.getPosition()) && contains(champs, player.getChampion()) )
            .collect(Collectors.toList());
    }
    
    public static List<MatchOverall1> incldeOnlyGameMode(List<MatchOverall1> matches, String[] gmss, Iterable<MatchHistory> histories) {
        HashMap<String, String> match = new HashMap<>();
        for(MatchHistory history : histories ){
            match.put(history.getMatchID(), history.getGameMode());
        }
        for(String s : gmss){
            System.out.println(s);
        }
        return matches.stream()
            .filter(player -> contains(gmss,match.get(player.getMatchID())))
            .collect(Collectors.toList());
    }


    //Helpers
    public static boolean contains(String[] list, String goal){
        for(String item : list){
            if(item.trim().equals(goal)){
                return true;
            }
        }
        return false;
    }


}
