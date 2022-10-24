package Stats.FetchSystem.Storage.Builders;

import Stats.FetchSystem.Storage.Entitys.MatchOverall1;
import Stats.FetchSystem.Storage.Entitys.MatchOverall2;
import Stats.FetchSystem.Storage.Other.MatchOverall;

public class MatchOverallBuilder {

    private MatchOverall1 match1;
    private MatchOverall2 match2;

    public MatchOverallBuilder(){
        match1 = new MatchOverall1();
        match2 = new MatchOverall2();
    }

    public MatchOverallBuilder setID(String id){
        match1.setMatchID(id);
        match2.setMatchId(id);
        return this;
    }

    public MatchOverallBuilder setName(String name){
        match1.setName(name);
        match2.setName(name);
        return this;
    }

    public MatchOverallBuilder setPosition(String pos, int team){
        match1.setPosition(pos);
        if(team == 100){
            match1.setTeam("Blue");
        } else {
            match1.setTeam("Red");
        }
        return this;
    }

    public MatchOverallBuilder setMatch(String Champ, int gold, int CS ){
        match1.setChampion(Champ);
        match1.setGold(gold);
        match1.setCS(CS);
        return this;
    }

    public MatchOverallBuilder setKDA(int Kills, int Deaths, int Assists){
        match1.setKills(Kills);
        match1.setDeaths(Deaths);
        match1.setAssists(Assists);
        return this;
    }

    public MatchOverallBuilder setVision(int wardsPlaced, int wardsDestroyed, int VisionScore){
        match1.setWardsPlaced(wardsPlaced);
        match1.setWardsDestroyed(wardsDestroyed);
        match1.setVisionScore(VisionScore);
        return this;
    }

    public MatchOverallBuilder setObjectives(int Dragons, int Barons, int steals){
        match1.setBaronsTaken(Barons);
        match1.setDragonsTaken(Dragons);
        match1.setObjectiveSteals(steals);
        return this;
    }

    public MatchOverallBuilder setDamage(int Dealt, int Taken){
        match1.setDamageDealt(Dealt);
        match1.setDamageTaken(Taken);
        return this;
    }

    public MatchOverallBuilder setTurrets(int Dealt, int Taken,int plates){
        match1.setTurretDamage(Dealt);
        match1.setTurretsTaken(Taken);
        match2.setTurretPlates(Taken);
        return this;
    }

    public MatchOverallBuilder setJungle(int fMonsters, int eMonsters, int stolenBuffs){
        match2.setJungleMonstersKilled(eMonsters);
        match2.setEnemyJungleKilled(eMonsters);
        match2.setStolenBuffs(stolenBuffs);
        return this;
    }

    public MatchOverallBuilder setSkillShots(int dodged, int hit, int hitEarly){
        match2.setSkillShotsEarly(hitEarly);
        match2.setHitSkillShots(hit);
        match2.setDodgedSkillShots(dodged);
        return this;
    }

    public MatchOverallBuilder setCS(int min10, int peakCS){
        match2.setPeakCsLead(peakCS);
        match2.setLandMinionsAt10(min10);
        return this;
    }

    public MatchOverallBuilder setKills(int peakDiff, int soloKills, int picksWAlley, int ccAndKillWAlley){
        match2.setPeakKillDiff(peakDiff);
        match2.setSoloKills(soloKills);
        match2.setPicksWAlley(picksWAlley);
        match2.setCCandKillwAlley(ccAndKillWAlley);
        return this;
    }

    public MatchOverallBuilder setWards(int bought, int placed, int stealWards){
        match2.setControlWardsBought(bought);
        match2.setControlWardsPlaced(placed);
        match2.setStealthWardsPlaced(stealWards);
        return this;
    }

    public MatchOverallBuilder setOthers(int Pings, int BountyL, int abiltyUses){
        match2.setPings(Pings);
        match2.setBountyL(BountyL);
        match2.setAbiltyUses(abiltyUses);
        return this;
    }

    public MatchOverallBuilder setCC(int enemyCC, int CCother){
        match2.setEnemyCCd(enemyCC);
        match2.setTimeCCother(CCother);
        return this;
    }

    public MatchOverallBuilder setFB(boolean kill, boolean assist, boolean tower){
        match2.setFirstBloodKill(kill);
        match2.setFirstBloodAssists(assist);
        match2.setFirstTowerKill(tower);
        return this;
    }

    public MatchOverallBuilder setkeys(int dPresses, int dKeyID, int fPresses, int fKeyID){
        String dKey = matchSum(dKeyID);
        String fKey = matchSum(fKeyID);
        match2.setDkeyUses(dPresses);
        match2.setDkey(dKey);
        match2.setFkeyUses(fPresses);
        match2.setFkey(fKey);
        return this;
    }

    private String matchSum(int KeyID) { //TODO THIS 
        switch(KeyID){
            default: return "flash"; 
        }
    }

    public MatchOverallBuilder setHeal(int heal, int shield){
        match2.setHealOnTeamates(heal);
        match2.setSheildOnTeamates(shield);
        return this;
    }

    public MatchOverall build(){
        return new MatchOverall(match1, match2);
    }


    
}
