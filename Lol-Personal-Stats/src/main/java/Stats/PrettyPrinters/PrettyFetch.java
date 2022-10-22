package Stats.PrettyPrinters;

import Stats.FetchSystem.Storage.MatchHistory;
import Stats.FetchSystem.Fetcher.Fetcher;

public class PrettyFetch {

    public static void main(String[] args) {
        prettyMatchHistory(Fetcher.getHistory("EUW1_6117044283"));
    }
    
    public static void prettyMatchHistory(MatchHistory mh){
        System.out.println("Match ID : " + mh.getMatchID());
        System.out.println("Gamemode : " + mh.getGameMode());
        System.out.println("Date : " + mh.getDate());
        System.out.println("Game Length : " + mh.getGameLength());
        String[] pos = new String[]{"Top", "Jgl", "Mid","Adc","Sup"};
        System.out.println("Blue:");
        int i = 0; 
        for(String player : mh.getBlue()){
            System.out.println(pos[i++] + ": " + player);
        }
        System.out.println("Red:");
        i = 0; 
        for(String player : mh.getRed()){
            System.out.println(pos[i++] + ": " + player);
        }
    }
}
