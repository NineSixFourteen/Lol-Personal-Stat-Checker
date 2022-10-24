package Stats.FetchSystem.Fetcher;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

import Stats.FetchSystem.Storage.Builders.MatchIntervalBuilder;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;

public class FetchIntervals {


    public static ArrayList<ArrayList<MatchInterval>> getIntervals(JsonNode node,String MatchID,ArrayList<String> names){
        ArrayList<MatchIntervalBuilder> builders = new ArrayList<>();
        for(int i =0; i< 10; i++){
            builders.add(new MatchIntervalBuilder().addName(names.get(i), MatchID));
        }
        int i = 0;
        JsonNode temp;
        for(JsonNode nde : node.get("info").get("frames")  ){
            switch(i){
                case 11: case 16: case 21: case 31: case 36:
                    temp = nde.get(("participantFrames"));
                    int l = 0;
                    for(JsonNode frame : temp){
                        putInfo(builders,frame,i,l);
                        l++;
                    }
            }
            for(JsonNode event : nde.get("events")){
                if((event.get("type").asText().equals("CHAMPION_KILL"))){
                    if(event.get("killerId").asInt() > 0){
                        builders.get(event.get("killerId").asInt() -1 ).addKill(event.get("timestamp").asInt());
                    }
                    builders.get(event.get("victimId").asInt() -1 ).addDeaths(event.get("timestamp").asInt());
                    if(event.get("assistingParticipantIds") != null){
                        for(JsonNode assist : event.get("assistingParticipantIds")){
                            builders.get(assist.asInt() -1 ).addAssits(event.get("timestamp").asInt());
                        }
                    }
                }
            }
            i++;
        }
        ArrayList<ArrayList<MatchInterval>> players = new ArrayList<>();
        for(MatchIntervalBuilder build : builders){
            players.add(build.build());
        }
        return players;
    }

    private static void putInfo(ArrayList<MatchIntervalBuilder> builders, JsonNode frame, int i,int l) {
        MatchIntervalBuilder builder = builders.get(l);
        builder.setGold(i - 1, frame.get("totalGold").asInt());
        builder.setLevel(i - 1, frame.get("level").asInt());
        builder.setMinions(i - 1, frame.get("minionsKilled").asInt());
        builder.setJungle(i - 1, frame.get("jungleMinionsKilled").asInt());
        builder.setXp(i - 1, frame.get("xp").asInt());
        builder.setDamageDone(i - 1, frame.get("damageStats").get("totalDamageDoneToChampions").asInt());
    }
    
    
}
