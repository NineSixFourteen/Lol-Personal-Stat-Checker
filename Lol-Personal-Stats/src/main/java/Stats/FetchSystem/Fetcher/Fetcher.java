package Stats.FetchSystem.Fetcher;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Stats.Helpers.GetInfo;
import Stats.Helpers.Helper;

public class Fetcher {
    
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

}
