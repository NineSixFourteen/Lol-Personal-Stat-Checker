package Stats.BackEnd.Entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name = "MatchHistory.findByMatchID",
  query = "select h from MatchHistory h where h.MatchID = ?1 ")
public class MatchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String MatchID; 
    private String GameMode; 
    private String WinningTeam;
    private String GameLength;

    private String Date;
    
    public MatchHistory() {
    }

    public Integer getId() {
        return id;
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

}
