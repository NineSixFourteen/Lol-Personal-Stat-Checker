package Stats.FetchSystem.Storage.Entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Match Overall Important
@Entity
public class MatchOverall1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String MatchID;
    private String Name; 
    private String Champion;
    private String Position; 
    private String team;
    private int Kills;
    private int Deaths;
    private int Assists;
    private int Gold;
    private int WardsPlaced;
    private int WardsDestroyed;
    private int CS;
    private int DamageDealt; 
    private int DamageTaken;
    private int TurretsTaken;
    private int TurretDamage;
    private int DragonsTaken;
    private int BaronsTaken;
    private int ObjectiveSteals;
    private int VisionScore;
    public MatchOverall1() {
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public String getPosition() {
        return Position;
    }
    public void setPosition(String position) {
        Position = position;
    }
    public String getMatchID() {
        return MatchID;
    }
    public void setMatchID(String matchID) {
        MatchID = matchID;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getChampion() {
        return Champion;
    }
    public void setChampion(String champion) {
        Champion = champion;
    }
    public int getKills() {
        return Kills;
    }
    public void setKills(int kills) {
        Kills = kills;
    }
    public int getDeaths() {
        return Deaths;
    }
    public void setDeaths(int deaths) {
        Deaths = deaths;
    }
    public int getAssists() {
        return Assists;
    }
    public void setAssists(int assists) {
        Assists = assists;
    }
    public int getGold() {
        return Gold;
    }
    public void setGold(int gold) {
        Gold = gold;
    }
    public int getWardsPlaced() {
        return WardsPlaced;
    }
    public void setWardsPlaced(int wardsPlaced) {
        WardsPlaced = wardsPlaced;
    }
    public int getWardsDestroyed() {
        return WardsDestroyed;
    }
    public void setWardsDestroyed(int wardsDestroyed) {
        WardsDestroyed = wardsDestroyed;
    }
    public int getCS() {
        return CS;
    }
    public void setCS(int cS) {
        CS = cS;
    }
    public int getDamageDealt() {
        return DamageDealt;
    }
    public void setDamageDealt(int damageDealt) {
        DamageDealt = damageDealt;
    }
    public int getDamageTaken() {
        return DamageTaken;
    }
    public void setDamageTaken(int damageTaken) {
        DamageTaken = damageTaken;
    }
    public int getTurretsTaken() {
        return TurretsTaken;
    }
    public void setTurretsTaken(int turretsTaken) {
        TurretsTaken = turretsTaken;
    }
    public int getTurretDamage() {
        return TurretDamage;
    }
    public void setTurretDamage(int turretDamage) {
        TurretDamage = turretDamage;
    }
    public int getDragonsTaken() {
        return DragonsTaken;
    }
    public void setDragonsTaken(int dragonsTaken) {
        DragonsTaken = dragonsTaken;
    }
    public int getBaronsTaken() {
        return BaronsTaken;
    }
    public void setBaronsTaken(int baronsTaken) {
        BaronsTaken = baronsTaken;
    }
    public int getObjectiveSteals() {
        return ObjectiveSteals;
    }
    public void setObjectiveSteals(int objectiveSteals) {
        ObjectiveSteals = objectiveSteals;
    }
    public int getVisionScore() {
        return VisionScore;
    }
    public void setVisionScore(int visionScore) {
        VisionScore = visionScore;
    }
    
}
