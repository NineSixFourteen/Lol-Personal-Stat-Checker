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
import Stats.FetchSystem.Storage.MatchHistory;
import Stats.FetchSystem.Storage.MatchHistoryBuilder;

public class Fetcher {
    

    public static MatchHistory getHistory(String matchID){
        JsonNode node = getMatch(matchID);
        MatchHistoryBuilder mhb = new MatchHistoryBuilder();
        JsonNode particpants = node.get("info").get("participants");
        mhb.setID(node.get("metadata").get("matchId").asText())
         .setGameMode(node.get("info").get("queueId").asInt())
         .setDate(getDates(node.get("info").get("gameCreation").asLong()))
         .setLength(getLength(node.get("info").get("gameStartTimestamp").asLong(),node.get("info").get("gameEndTimestamp").asLong()))
         .setWinner(node.get("info").get("teams").get(0).get("win").asBoolean())
         .setTeams(
            Arrays.asList(
                particpants.get(0).get("summonerName").asText(),
                particpants.get(1).get("summonerName").asText(),
                particpants.get(2).get("summonerName").asText(),
                particpants.get(3).get("summonerName").asText(),
                particpants.get(4).get("summonerName").asText()
                ),
            Arrays.asList(
                particpants.get(5).get("summonerName").asText(),
                particpants.get(6).get("summonerName").asText(),
                particpants.get(7).get("summonerName").asText(),
                particpants.get(8).get("summonerName").asText(),
                particpants.get(9).get("summonerName").asText()
            )
          );
          return mhb.build();
    }

    private static int getLength(long asLong, long asLong2) {
       long length = asLong2 - asLong;
       length /= 1000;
       return (int) length;
    }

    private static int getDates(long creation) {
        creation -= 1640999396418L;
        creation /=  86400000;
        return (int) creation;
    }

    private static JsonNode getMatch(String matchID){
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
