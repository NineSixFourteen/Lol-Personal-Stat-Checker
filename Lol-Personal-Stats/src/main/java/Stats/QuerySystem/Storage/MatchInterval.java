package Stats.QuerySystem.Storage;

public class MatchInterval {
    
    private int time; 

    private int kills; 
    private int deaths;
    private int assists;
    
    private int damageDone;
    private int level;
    private int minions; 
    private int xp;
    private int gold;

    public MatchInterval(int time) {
        this.time = time;
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
    
}
