package Stats.InfoFetcher;

import com.fasterxml.jackson.databind.JsonNode;

import Stats.BackEnd.Builders.MatchHistoryBuilder;
import Stats.BackEnd.Entitys.MatchHistory;

public class FetchMatchHistory {
    
    public static MatchHistory getHistory(JsonNode node){
        MatchHistoryBuilder mhb = new MatchHistoryBuilder();
        try{
        mhb.setID(node.get("metadata").get("matchId").asText())
         .setGameMode(node.get("info").get("queueId").asInt())
         .setDate(getDates(node.get("info").get("gameCreation").asLong()))
         .setLength(getLength(node.get("info").get("gameStartTimestamp").asLong(),node.get("info").get("gameEndTimestamp").asLong()))
         .setWinner(node.get("info").get("teams").get(0).get("win").asBoolean());
          return mhb.build();
        } catch(Exception e){
            return null;
        }
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
}