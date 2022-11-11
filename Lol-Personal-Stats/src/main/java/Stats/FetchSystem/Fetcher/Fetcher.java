package Stats.FetchSystem.Fetcher;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Stats.FetchSystem.Helpers.GetInfo;
import Stats.FetchSystem.Helpers.Helper;
import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Other.MatchOverall;
import Stats.FetchSystem.Storage.Other.MatchRecord;

public class Fetcher {

    public static void main(String[] args) {
        System.out.println(getGames(GetInfo.getPUUID(), 140));
    }

    public static List<String> getGames(String puuid, int amount){
        List<String> gameIDs = new ArrayList<>();
        for(int i = 0; i < (amount/100 + 1); i++ ) {
            String url = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/"+ puuid + "/ids?start="+ i*100 + "&count=100";
            try {
                final HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
                con.setRequestProperty( "X-Riot-Token", GetInfo.getAPIKey());
                InputStream is = con.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = Helper.readAll(rd);
                ObjectMapper mapper = new ObjectMapper();
                is.close();
                var x = mapper.readTree(jsonText);
                for(var y : x){
                    gameIDs.add(y.asText());
                } 
            }
            catch(Exception e){
                System.out.println("Failed to get player games");
                e.printStackTrace();
                return null;
            }
        }
        return gameIDs;
    }

    public static MatchRecord getMatchRecord(String matchID){
        JsonNode match = getMatch(matchID);
        if(match == null){
            return null;
        }
        JsonNode timeline = getTimeLine(matchID);
        if(timeline == null){
            return null;
        }
        MatchHistory history = FetchMatchHistory.getHistory(match);
        if(history == null){
            return null;
        }
        ArrayList<MatchOverall> overals = FetchOverall.getPlayers(match);
        ArrayList<String> names = new ArrayList<>();
        for(MatchOverall over : overals){
            names.add(over.getMatch1().getName());
        }
        ArrayList<ArrayList<MatchInterval>> intervals = FetchIntervals.getIntervals(timeline, matchID,names);
        return new MatchRecord(history, overals, intervals);
    }
    
    public static JsonNode getMatch(String matchID){
        String matchUrl = "https://europe.api.riotgames.com/lol/match/v5/matches/";
        String URL = matchUrl + matchID;
        InputStream is;
        try {
            final HttpURLConnection con = (HttpURLConnection) new URL(URL).openConnection();
            con.setRequestProperty( "X-Riot-Token", GetInfo.getAPIKey());
            is = con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = Helper.readAll(rd);
            ObjectMapper mapper = new ObjectMapper();
            is.close();
            return mapper.readTree(jsonText);    
        } catch (Exception e) {
            System.out.println("Failed to get match " + matchID);
            return null;
        }
    }

    
    public static JsonNode getTimeLine(String match) {
        try{
            String url = "https://europe.api.riotgames.com/lol/match/v5/matches/" + match +  "/timeline";
            final HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestProperty( "X-Riot-Token", GetInfo.getAPIKey());
            InputStream is = con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = Helper.readAll(rd);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(jsonText); 
        }   catch(Exception e){
            return null;
        }
      }

    public static boolean test() {
        try{
            String url = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/Sckioon";
            final HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestProperty( "X-Riot-Token", GetInfo.getAPIKey());
            InputStream is = con.getInputStream();
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public static String puuid(String name){
        try{
            String url = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name;
            final HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestProperty( "X-Riot-Token", GetInfo.getAPIKey());
            InputStream is = con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = Helper.readAll(rd);
            ObjectMapper mapper = new ObjectMapper();
            var node = mapper.readTree(jsonText);
            return node.get("puuid").asText();
        } catch(Exception e){
            return "1";
        }
    } 

}
