package Stats.FetchSystem.Storage.Other;

public class MatchIDAndName {

    private String matchID;
    private String playerName;
    public MatchIDAndName(String matchID, String playerName) {
        this.matchID = matchID;
        this.playerName = playerName;
    }
    public String getMatchID() {
        return matchID;
    }
    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    } 
    
    
}
