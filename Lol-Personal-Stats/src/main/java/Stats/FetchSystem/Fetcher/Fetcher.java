package Stats.FetchSystem.Fetcher;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Other.MatchOverall;
import Stats.FetchSystem.Storage.Other.MatchRecord;
import Stats.Helpers.GetInfo;
import Stats.Helpers.Helper;
import Stats.PrettyPrinters.PrettyFetch;

public class Fetcher {

    public static void main(String[] args) {
        MatchRecord mr = getMatchRecord("EUW1_6026976100");
        PrettyFetch.prettyMatchHistory(mr.getMatchHistory());
        PrettyFetch.prettyPlayer1(mr.getOverals().get(1).getMatch1());
        PrettyFetch.prettyPlayerInterval(mr.getIntervals().get(4));
    }

    public static MatchRecord getMatchRecord(String matchID){
        JsonNode match = getMatch(matchID);
        JsonNode timeline = getTimeLine(matchID);
        MatchHistory history = FetchMatchHistory.getHistory(match);
        ArrayList<MatchOverall> overals = FetchOverall.getPlayers(match);
        ArrayList<String> names = new ArrayList<>();
        for(MatchOverall over : overals){
            names.add(over.getMatch1().getName());
            System.out.println(names);
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
            e.printStackTrace();
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

}
