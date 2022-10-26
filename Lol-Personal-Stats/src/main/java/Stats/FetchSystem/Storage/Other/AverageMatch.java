package Stats.FetchSystem.Storage.Other;

public class AverageMatch {

    private int total; 
    private float kills; 
    private float deaths; 
    private float assists;
    private float gold; 
    private float wardsPlaced;
    private float wardsDestroyed;
    private float cs;
    private float damageDealt;
    private float damageTaken;
    private float turretDamage;
    private float turretsTaken;
    private float dragonsTaken;
    private float baronsTaken;
    private float objectiveSteals;
    private float visionScore;
    private float pings;
    private float bountyL;
    private float abiltyUses;
    private float stolenBuffs;
    private float controlWardsBought;
    private float controlWardsPlaced;
    private float dodgedSkillShots;
    private float hitSkillShots;
    private float jungleMonstersKilled;
    private float enemyJungleKilled;
    private float enemyCCd;
    private float timeCCother;
    private float cCandKillwAlley;
    private float skillShotsEarly;
    private float landMinionsAt10;
    private float peakCsLead;
    private float peakKillDiff;
    private float picksWAlley;
    private float soloKills;
    private float stealthWardsPlaced;
    private float turretPlates;
    private float firstBloodKills;
    private float firstBloodAssists;
    private float FirstTowerKill;
    private float heal;
    private float shield;

    public AverageMatch() {
        this.total = 0;
        this.kills = 0;
        this.deaths = 0;
        this.assists = 0;
        this.gold = 0;
        this.wardsPlaced = 0;
        this.wardsDestroyed = 0;
        this.cs = 0;
        this.damageDealt = 0;
        this.damageTaken = 0;
        this.turretDamage = 0;
        this.turretsTaken = 0;
        this.dragonsTaken = 0;
        this.baronsTaken = 0;
        this.objectiveSteals = 0;
        this.visionScore = 0;
        this.pings = 0;
        this.bountyL = 0;
        this.abiltyUses = 0;
        this.stolenBuffs = 0;
        this.controlWardsBought = 0;
        this.controlWardsPlaced = 0;
        this.dodgedSkillShots = 0;
        this.hitSkillShots = 0;
        this.jungleMonstersKilled = 0;
        this.enemyJungleKilled = 0;
        this.enemyCCd = 0;
        this.timeCCother = 0;
        this.cCandKillwAlley = 0;
        this.skillShotsEarly = 0;
        this.landMinionsAt10 = 0;
        this.peakCsLead = 0;
        this.peakKillDiff = 0;
        this.picksWAlley = 0;
        this.soloKills = 0;
        this.stealthWardsPlaced = 0;
        this.turretPlates = 0;
        this.firstBloodKills = 0;
        this.firstBloodAssists = 0;
        FirstTowerKill = 0;
        this.heal = 0;
        this.shield = 0;
    }

    public AverageMatch(int total, float kills, float deaths, float assists, float gold, float wardsPlaced,
            float wardsDestroyed, float cs, float damageDealt, float damageTaken, float turretDamage,
            float turretsTaken, float dragonsTaken, float baronsTaken, float objectiveSteals, float visionScore,
            float pings, float bountyL, float abiltyUses, float stolenBuffs, float controlWardsBought,
            float controlWardsPlaced, float dodgedSkillShots, float hitSkillShots, float jungleMonstersKilled,
            float enemyJungleKilled, float enemyCCd, float timeCCother, float cCandKillwAlley, float skillShotsEarly,
            float landMinionsAt10, float peakCsLead, float peakKillDiff, float picksWAlley, float soloKills,
            float stealthWardsPlaced, float turretPlates, float firstBloodKills, float firstBloodAssists,
            float firstTowerKill, float heal, float shield) {
        this.total = total;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.gold = gold;
        this.wardsPlaced = wardsPlaced;
        this.wardsDestroyed = wardsDestroyed;
        this.cs = cs;
        this.damageDealt = damageDealt;
        this.damageTaken = damageTaken;
        this.turretDamage = turretDamage;
        this.turretsTaken = turretsTaken;
        this.dragonsTaken = dragonsTaken;
        this.baronsTaken = baronsTaken;
        this.objectiveSteals = objectiveSteals;
        this.visionScore = visionScore;
        this.pings = pings;
        this.bountyL = bountyL;
        this.abiltyUses = abiltyUses;
        this.stolenBuffs = stolenBuffs;
        this.controlWardsBought = controlWardsBought;
        this.controlWardsPlaced = controlWardsPlaced;
        this.dodgedSkillShots = dodgedSkillShots;
        this.hitSkillShots = hitSkillShots;
        this.jungleMonstersKilled = jungleMonstersKilled;
        this.enemyJungleKilled = enemyJungleKilled;
        this.enemyCCd = enemyCCd;
        this.timeCCother = timeCCother;
        this.cCandKillwAlley = cCandKillwAlley;
        this.skillShotsEarly = skillShotsEarly;
        this.landMinionsAt10 = landMinionsAt10;
        this.peakCsLead = peakCsLead;
        this.peakKillDiff = peakKillDiff;
        this.picksWAlley = picksWAlley;
        this.soloKills = soloKills;
        this.stealthWardsPlaced = stealthWardsPlaced;
        this.turretPlates = turretPlates;
        this.firstBloodKills = firstBloodKills;
        this.firstBloodAssists = firstBloodAssists;
        FirstTowerKill = firstTowerKill;
        this.heal = heal;
        this.shield = shield;
    }
    public int getTotal() {
        return total;
    }
    public float getKills() {
        return kills;
    }
    public float getDeaths() {
        return deaths;
    }
    public float getAssists() {
        return assists;
    }
    public float getGold() {
        return gold;
    }
    public float getWardsPlaced() {
        return wardsPlaced;
    }
    public float getWardsDestroyed() {
        return wardsDestroyed;
    }
    public float getCs() {
        return cs;
    }
    public float getDamageDealt() {
        return damageDealt;
    }
    public float getDamageTaken() {
        return damageTaken;
    }
    public float getTurretDamage() {
        return turretDamage;
    }
    public float getTurretsTaken() {
        return turretsTaken;
    }
    public float getDragonsTaken() {
        return dragonsTaken;
    }
    public float getBaronsTaken() {
        return baronsTaken;
    }
    public float getObjectiveSteals() {
        return objectiveSteals;
    }
    public float getVisionScore() {
        return visionScore;
    }
    public float getPings() {
        return pings;
    }
    public float getBountyL() {
        return bountyL;
    }
    public float getAbiltyUses() {
        return abiltyUses;
    }
    public float getStolenBuffs() {
        return stolenBuffs;
    }
    public float getControlWardsBought() {
        return controlWardsBought;
    }
    public float getControlWardsPlaced() {
        return controlWardsPlaced;
    }
    public float getDodgedSkillShots() {
        return dodgedSkillShots;
    }
    public float getHitSkillShots() {
        return hitSkillShots;
    }
    public float getJungleMonstersKilled() {
        return jungleMonstersKilled;
    }
    public float getEnemyJungleKilled() {
        return enemyJungleKilled;
    }
    public float getEnemyCCd() {
        return enemyCCd;
    }
    public float getTimeCCother() {
        return timeCCother;
    }
    public float getcCandKillwAlley() {
        return cCandKillwAlley;
    }
    public float getSkillShotsEarly() {
        return skillShotsEarly;
    }
    public float getLandMinionsAt10() {
        return landMinionsAt10;
    }
    public float getPeakCsLead() {
        return peakCsLead;
    }
    public float getPeakKillDiff() {
        return peakKillDiff;
    }
    public float getPicksWAlley() {
        return picksWAlley;
    }
    public float getSoloKills() {
        return soloKills;
    }
    public float getStealthWardsPlaced() {
        return stealthWardsPlaced;
    }
    public float getTurretPlates() {
        return turretPlates;
    }
    public float getFirstBloodKills() {
        return firstBloodKills;
    }
    public float getFirstBloodAssists() {
        return firstBloodAssists;
    }
    public float getFirstTowerKill() {
        return FirstTowerKill;
    }
    public float getHeal() {
        return heal;
    }
    public float getShield() {
        return shield;
    } 

    public AverageMatch add(MatchOverall mo){
        total++;
        kills += mo.getMatch1().getKills();
        deaths += mo.getMatch1().getDeaths();
        assists += mo.getMatch1().getAssists();
        wardsPlaced +=  mo.getMatch1().getWardsPlaced(); 
        wardsDestroyed += mo.getMatch1().getWardsDestroyed();
        cs += mo.getMatch1().getCS();
        damageDealt += mo.getMatch1().getDamageDealt(); damageTaken += mo.getMatch1().getDamageTaken(); 
        turretDamage += mo.getMatch1().getTurretDamage(); turretsTaken += mo.getMatch1().getTurretsTaken();
        dragonsTaken += mo.getMatch1().getDragonsTaken(); baronsTaken += mo.getMatch1().getBaronsTaken();
        objectiveSteals += mo.getMatch1().getObjectiveSteals(); visionScore+= mo.getMatch1().getVisionScore();
        pings += mo.getMatch2().getPings(); bountyL += mo.getMatch2().getBountyL(); abiltyUses += mo.getMatch2().getAbiltyUses();
        stolenBuffs += mo.getMatch2().getStolenBuffs(); controlWardsBought += mo.getMatch2().getControlWardsBought();  
        controlWardsPlaced += mo.getMatch2().getControlWardsPlaced(); dodgedSkillShots += mo.getMatch2().getDodgedSkillShots();
        hitSkillShots += mo.getMatch2().getHitSkillShots(); jungleMonstersKilled += mo.getMatch2().getJungleMonstersKilled();
        enemyJungleKilled += mo.getMatch2().getEnemyJungleKilled(); enemyCCd += mo.getMatch2().getEnemyCCd();
        timeCCother += mo.getMatch2().getTimeCCother(); cCandKillwAlley += mo.getMatch2().getCCandKillwAlley();
        skillShotsEarly += mo.getMatch2().getSkillShotsEarly(); landMinionsAt10 += mo.getMatch2().getLandMinionsAt10();
        peakCsLead += mo.getMatch2().getPeakCsLead(); peakKillDiff += mo.getMatch2().getPeakKillDiff();
        picksWAlley += mo.getMatch2().getPicksWAlley(); soloKills += mo.getMatch2().getSoloKills();
        stealthWardsPlaced += mo.getMatch2().getStealthWardsPlaced(); turretPlates += mo.getMatch2().getTurretPlates();
        firstBloodKills += mo.getMatch2().isFirstBloodKill() ? 1 : 0; firstBloodAssists += mo.getMatch2().isFirstBloodAssists() ? 1 : 0;;
        FirstTowerKill += mo.getMatch2().isFirstTowerKill() ? 1 : 0; heal +=  mo.getMatch2().getHealOnTeamates(); shield +=  mo.getMatch2().getSheildOnTeamates();
        return this;
    } 

    public AverageMatch build(){
        return new AverageMatch(
            total,
            kills / total,
            deaths / total, 
            assists / total, 
            gold / total, 
            wardsPlaced / total, 
            wardsDestroyed / total, 
            cs / total, 
            damageDealt / total, damageTaken / total, 
            turretDamage / total, turretsTaken / total, 
            dragonsTaken / total, baronsTaken / total, 
            objectiveSteals / total, visionScore / total, 
            pings / total, bountyL / total, abiltyUses / total, 
            stolenBuffs / total, controlWardsBought / total,  
            controlWardsPlaced / total, dodgedSkillShots / total, 
            hitSkillShots / total, jungleMonstersKilled / total, 
            enemyJungleKilled / total, enemyCCd / total, 
            timeCCother / total, cCandKillwAlley / total, 
            skillShotsEarly / total, landMinionsAt10 / total, 
            peakCsLead / total, peakKillDiff / total, 
            picksWAlley / total, soloKills / total, 
            stealthWardsPlaced / total, turretPlates / total, 
            firstBloodKills / total, firstBloodAssists / total, 
            FirstTowerKill / total, heal / total, 
            shield / total);
    }


    
    
    
}
