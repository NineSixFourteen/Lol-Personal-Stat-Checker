package Stats.FetchSystem.Fetcher;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;

import Stats.FetchSystem.QueryTest;
import Stats.FetchSystem.Storage.MatchInterval;
import Stats.FetchSystem.Storage.MatchIntervalBuilder;
import Stats.PrettyPrinters.PrettyFetch;

public class FetchIntervals {

    public static void main(String[] args) throws IOException {
        JsonNode node = QueryTest.getTimeLine();
        ArrayList<ArrayList<MatchInterval>> x = getIntervals(node);
        PrettyFetch.prettyPlayerInterval(x.get(0)); 
    }

    public static ArrayList<ArrayList<MatchInterval>> getIntervals(JsonNode node){
        ArrayList<MatchIntervalBuilder> builders = new ArrayList<>();
        for(int i =0; i< 10; i++){
            builders.add(new MatchIntervalBuilder());
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
                    System.out.println(event.get("timestamp"));
                    System.out.println(event.get("killerId").asInt() - 1);
                    builders.get(event.get("killerId").asInt() -1 ).addKill(event.get("timestamp").asInt());
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
