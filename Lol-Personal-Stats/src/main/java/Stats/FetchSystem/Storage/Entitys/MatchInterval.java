package Stats.FetchSystem.Storage.Entitys;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MatchInterval {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name; 
    private String MatchID;
    private int time; 
    private int kills; 
    private int deaths;
    private int assists;
    private int damageDone;
    private int level;
    private int minions;
    private int jungle;
    private int xp;
    private int gold;

    public MatchInterval(int time) {
        this.time = time;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMatchID() {
        return MatchID;
    }
    public void setMatchID(String matchID) {
        MatchID = matchID;
    }
    public int getTime() {
        return time;
    }
    public int getKills() {
        return kills;
    }
    public void addKill() {
        this.kills++;
    }
    public int getDeaths() {
        return deaths;
    }
    public void addDeaths() {
        this.deaths++;
    }
    public int getAssists() {
        return assists;
    }
    public void addAssists() {
        this.assists++;
    }
    public int getDamageDone() {
        return damageDone;
    }
    public void setDamageDone(int damageDone) {
        this.damageDone = damageDone;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getMinions() {
        return minions;
    }
    public void setMinions(int minions) {
        this.minions = minions;
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }
    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public int getJungle() {
        return jungle;
    }
    public void setJungle(int jungle) {
        this.jungle = jungle;
    }
    
}
