package Stats.FetchSystem.Storage.Entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity 
@NamedQuery(name = "MatchOverall2.findByMatchIDAndName",
  query = "select h from MatchOverall2 h where h.MatchId = ?1 AND h.Name =?2")
@NamedQuery(name = "MatchOverall2.findByMatchID",
  query = "select h from MatchOverall2 h where h.MatchId = ?1")
public class MatchOverall2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String MatchId;
    private String Name;
    private int Pings;
    private int BountyL;
    private int AbiltyUses;
    private int StolenBuffs;
    private int ControlWardsPlaced;
    private int ControlWardsBought;
    private int DodgedSkillShots;
    private int HitSkillShots;
    private int JungleMonstersKilled;
    private int EnemyJungleKilled;
    private int EnemyCCd;
    private int timeCCother;
    private int CCandKillwAlley;
    private int SkillShotsEarly;
    private int landMinionsAt10;
    private int peakCsLead;
    private int peakKillDiff;
    private int PicksWAlley;
    private int SoloKills;
    private int StealthWardsPlaced;
    private int TurretPlates;
    private boolean FirstBloodKill;
    private boolean FirstBloodAssists;
    private boolean FirstTowerKill;
    private int DkeyUses;
    private String Dkey; 
    private int FkeyUses;
    private String Fkey;
    private int HealOnTeamates;
    private int SheildOnTeamates;
    public MatchOverall2() {
    }
    public String getMatchId() {
        return MatchId;
    }
    public void setMatchId(String matchId) {
        MatchId = matchId;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getPings() {
        return Pings;
    }
    public void setPings(int pings) {
        Pings = pings;
    }
    public int getBountyL() {
        return BountyL;
    }
    public void setBountyL(int bountyL) {
        BountyL = bountyL;
    }
    public int getAbiltyUses() {
        return AbiltyUses;
    }
    public void setAbiltyUses(int abiltyUses) {
        AbiltyUses = abiltyUses;
    }
    public int getJungleMonstersKilled() {
        return JungleMonstersKilled;
    }
    public void setJungleMonstersKilled(int jungleMonstersKilled) {
        JungleMonstersKilled = jungleMonstersKilled;
    }
    public int getStolenBuffs() {
        return StolenBuffs;
    }
    public void setStolenBuffs(int stolenBuffs) {
        StolenBuffs = stolenBuffs;
    }
    public int getControlWardsPlaced() {
        return ControlWardsPlaced;
    }
    public void setControlWardsPlaced(int controlWardsPlaced) {
        ControlWardsPlaced = controlWardsPlaced;
    }
    public int getControlWardsBought() {
        return ControlWardsBought;
    }
    public void setControlWardsBought(int controlWardsBought) {
        ControlWardsBought = controlWardsBought;
    }
    public int getDodgedSkillShots() {
        return DodgedSkillShots;
    }
    public void setDodgedSkillShots(int dodgedSkillShots) {
        DodgedSkillShots = dodgedSkillShots;
    }
    public int getHitSkillShots() {
        return HitSkillShots;
    }
    public void setHitSkillShots(int hitSkillShots) {
        HitSkillShots = hitSkillShots;
    }
    public int getEnemyJungleKilled() {
        return EnemyJungleKilled;
    }
    public void setEnemyJungleKilled(int enemyJungleKilled) {
        EnemyJungleKilled = enemyJungleKilled;
    }
    public int getEnemyCCd() {
        return EnemyCCd;
    }
    public void setEnemyCCd(int enemyCCd) {
        EnemyCCd = enemyCCd;
    }
    public int getTimeCCother() {
        return timeCCother;
    }
    public void setTimeCCother(int timeCCother) {
        this.timeCCother = timeCCother;
    }
    public int getCCandKillwAlley() {
        return CCandKillwAlley;
    }
    public void setCCandKillwAlley(int cCandKillwAlley) {
        CCandKillwAlley = cCandKillwAlley;
    }
    public int getSkillShotsEarly() {
        return SkillShotsEarly;
    }
    public void setSkillShotsEarly(int skillShotsEarly) {
        SkillShotsEarly = skillShotsEarly;
    }
    public int getLandMinionsAt10() {
        return landMinionsAt10;
    }
    public void setLandMinionsAt10(int landMinionsAt10) {
        this.landMinionsAt10 = landMinionsAt10;
    }
    public int getPeakCsLead() {
        return peakCsLead;
    }
    public void setPeakCsLead(int peakCsLead) {
        this.peakCsLead = peakCsLead;
    }
    public int getPeakKillDiff() {
        return peakKillDiff;
    }
    public void setPeakKillDiff(int peakKillDiff) {
        this.peakKillDiff = peakKillDiff;
    }
    public int getPicksWAlley() {
        return PicksWAlley;
    }
    public void setPicksWAlley(int picksWAlley) {
        PicksWAlley = picksWAlley;
    }
    public int getSoloKills() {
        return SoloKills;
    }
    public void setSoloKills(int soloKills) {
        SoloKills = soloKills;
    }
    public int getStealthWardsPlaced() {
        return StealthWardsPlaced;
    }
    public void setStealthWardsPlaced(int stealthWardsPlaced) {
        StealthWardsPlaced = stealthWardsPlaced;
    }
    public int getTurretPlates() {
        return TurretPlates;
    }
    public void setTurretPlates(int turretPlates) {
        TurretPlates = turretPlates;
    }
    public boolean isFirstBloodKill() {
        return FirstBloodKill;
    }
    public void setFirstBloodKill(boolean firstBloodKill) {
        FirstBloodKill = firstBloodKill;
    }
    public boolean isFirstBloodAssists() {
        return FirstBloodAssists;
    }
    public void setFirstBloodAssists(boolean firstBloodAssists) {
        FirstBloodAssists = firstBloodAssists;
    }
    public boolean isFirstTowerKill() {
        return FirstTowerKill;
    }
    public void setFirstTowerKill(boolean firstTowerKill) {
        FirstTowerKill = firstTowerKill;
    }
    public int getDkeyUses() {
        return DkeyUses;
    }
    public void setDkeyUses(int dkeyUses) {
        DkeyUses = dkeyUses;
    }
    public String getDkey() {
        return Dkey;
    }
    public void setDkey(String dkey) {
        Dkey = dkey;
    }
    public int getFkeyUses() {
        return FkeyUses;
    }
    public void setFkeyUses(int fkeyUses) {
        FkeyUses = fkeyUses;
    }
    public String getFkey() {
        return Fkey;
    }
    public void setFkey(String fkey) {
        Fkey = fkey;
    }
    public int getHealOnTeamates() {
        return HealOnTeamates;
    }
    public void setHealOnTeamates(int healOnTeamates) {
        HealOnTeamates = healOnTeamates;
    }
    public int getSheildOnTeamates() {
        return SheildOnTeamates;
    }
    public void setSheildOnTeamates(int sheildOnTeamates) {
        SheildOnTeamates = sheildOnTeamates;
    }

    
}
