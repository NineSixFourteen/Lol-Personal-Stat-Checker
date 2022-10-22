package Stats.FetchSystem.Storage;

import java.util.List;

public class MatchHistory {

    private String MatchID; 
    private String GameMode; 
    private String WinningTeam;
    private String GameLength;
    private String Date;
    private List<String> blue;
    private List<String> red;
    

    public MatchHistory() {
    }
    public String getMatchID() {
        return MatchID;
    }
    public void setMatchID(String matchID) {
        MatchID = matchID;
    }
    public String getGameMode() {
        return GameMode;
    }
    public void setGameMode(String gameMode) {
        GameMode = gameMode;
    }
    public String getWinningTeam() {
        return WinningTeam;
    }
    public void setWinningTeam(String winningTeam) {
        WinningTeam = winningTeam;
    }
    public String getGameLength() {
        return GameLength;
    }
    public void setGameLength(String gameLength) {
        GameLength = gameLength;
    }
    public String getDate() {
        return Date;
    }
    public void setDate(String date) {
        Date = date;
    }
    public List<String> getBlue() {
        return blue;
    }
    public void setBlue(List<String> blue) {
        this.blue = blue;
    }
    public List<String> getRed() {
        return red;
    }
    public void setRed(List<String> red) {
        this.red = red;
    }
    

}
