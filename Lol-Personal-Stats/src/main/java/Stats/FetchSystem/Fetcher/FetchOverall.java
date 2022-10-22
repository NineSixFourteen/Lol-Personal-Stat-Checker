package Stats.FetchSystem.Fetcher;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

import Stats.FetchSystem.Storage.MatchOverall;
import Stats.FetchSystem.Storage.MatchOverallBuilder;

public class FetchOverall {

    public static ArrayList<MatchOverall> getPlayers(JsonNode node){
        ArrayList<MatchOverall> players = new ArrayList<>();
        String matchId = node.get("metadata").get("matchId").asText();
        //System.out.println(node.get("info"));
        for(JsonNode nde : node.get("info").get("participants")){
            players.add(getPlayer(nde,matchId));
        }
        return players;
    }

    public static MatchOverall getPlayer(JsonNode node,String id){
        MatchOverallBuilder mob = new MatchOverallBuilder();
        JsonNode chal = node.get("challenges");
        mob.setKDA(
            node.get("kills").asInt(), 
            node.get("deaths").asInt(),
            node.get("assists").asInt()
        ).setID(id)
         .setName(node.get("summonerName").asText())
         .setVision(
            node.get("wardsPlaced").asInt(),
            node.get("wardsKilled").asInt(), 
            node.get("visionScore").asInt()
        ).setObjectives(
            node.get("dragonKills").asInt(), 
            node.get("baronKills").asInt(), 
            node.get("objectivesStolen").asInt()
        ).setDamage(
            node.get("totalDamageDealtToChampions").asInt(), 
            node.get("totalDamageTaken").asInt()
        ).setTurrets(
            node.get("damageDealtToTurrets").asInt(), 
            node.get("turretKills").asInt(), chal.get("turretPlatesTaken").asInt()
        ).setJungle(
            chal.get("alliedJungleMonsterKills").asInt(), 
            chal.get("enemyJungleMonsterKills").asInt(), 
            chal.get("buffsStolen").asInt()
        ).setSkillShots(
            chal.get("skillshotsDodged").asInt(), 
            chal.get("skillshotsHit").asInt(),
            chal.get("landSkillShotsEarlyGame").asInt()
        ).setCS(
            chal.get("maxCsAdvantageOnLaneOpponent").asInt(), 
            chal.get("laneMinionsFirst10Minutes").asInt()
        ).setKills(
            chal.get("maxKillDeficit").asInt(), 
            chal.get("soloKills").asInt(), 
            chal.get("pickKillWithAlly").asInt(), 
            chal.get("immobilizeAndKillWithAlly").asInt()
        ).setWards(
            node.get("visionWardsBoughtInGame").asInt(),
            chal.get("controlWardsPlaced").asInt(), 
            chal.get("stealthWardsPlaced").asInt()
        ).setOthers(
            node.get("basicPings").asInt(),
            node.get("bountyLevel").asInt(), 
            chal.get("abilityUses").asInt()
        ).setCC(
            node.get("timeCCingOthers").asInt(), 
            node.get("totalTimeCCDealt").asInt()
        ).setFB(
            node.get("firstBloodKill").asBoolean(), 
            node.get("firstBloodAssist").asBoolean(),
            node.get("firstTowerKill").asBoolean()
        ).setkeys(
            node.get("summoner1Casts").asInt(), 
            node.get("summoner1Id").asInt(),
            node.get("summoner2Casts").asInt(),
            node.get("summoner2Id").asInt()
        ).setHeal(
            node.get("totalHealsOnTeammates").asInt(), 
            node.get("totalDamageShieldedOnTeammates").asInt()
        );
        return mob.build();
    }
    
}
