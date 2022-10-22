package Stats.QuerySystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Stats.Helpers.GetInfo;
import Stats.Helpers.Helper;


public class QueryTest {

    public static void main(String[] args) throws MalformedURLException, IOException {
        String matchID = "EUW1_6113347141";
        JsonNode node = getMatch(matchID);
        for(var x : node.get("info").get("participants")){
            System.out.println(x.get("summonerName") + " - " + x.get("individualPosition"));
        }
    }

    private static JsonNode getMatch(String ID) throws MalformedURLException, IOException{
        String matchUrl = "https://europe.api.riotgames.com/lol/match/v5/matches/";
        String URL = matchUrl + ID;
        final HttpURLConnection con = (HttpURLConnection) new URL(URL).openConnection();
        con.setRequestProperty( "X-Riot-Token", GetInfo.getAPIKey());
        InputStream is = con.getInputStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = Helper.readAll(rd);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(jsonText);    
          } finally {
            is.close();
          }
    }

    public static ArrayList<String> getMatchIDList(int start) throws MalformedURLException, IOException{
        String matchUrl = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/";
        String URL = matchUrl + GetInfo.getPUUID() + "/ids?start=" + (start * 100) + "&count=100"; 
        final HttpURLConnection con = (HttpURLConnection) new URL(URL).openConnection();
        con.setRequestProperty( "X-Riot-Token", GetInfo.getAPIKey());
        InputStream is = con.getInputStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = Helper.readAll(rd);
            String[] strs = jsonText.substring(1,jsonText.length() - 1).split(",");
            ArrayList<String> matches = new ArrayList<>();
            for(String str : strs){
                matches.add(str.substring(1,str.length() -1));
            }
            return matches;
          } finally {
            is.close();
          }
    }
    
}
