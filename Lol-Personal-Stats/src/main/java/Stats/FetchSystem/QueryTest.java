package Stats.FetchSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import Stats.Helpers.GetInfo;
import Stats.Helpers.Helper;


public class QueryTest {


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
