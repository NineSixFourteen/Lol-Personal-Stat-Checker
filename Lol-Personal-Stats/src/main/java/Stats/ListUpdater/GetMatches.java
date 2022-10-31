package Stats.ListUpdater;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Stats.FetchSystem.Helpers.GetInfo;

public class GetMatches {
   public static String GetMostRecentGame() {
      String JdbcURL = "jdbc:mysql://localhost:3306/Personal_Stat_Checker";
      String Username = "root";
      String password = GetInfo.getPassword();
      Connection con = null;
      Statement stmt = null;
      ResultSet rs = null;
      try {
        con = DriverManager.getConnection(JdbcURL, Username, password);
        Statement st = con.createStatement();
        String query = ("SELECT * FROM match_history ORDER BY id LIMIT 1;");
        rs = st.executeQuery(query);
        if (rs.next()) {
        return rs.getString("MatchId");
        }
      } catch (Exception e) {
        System.out.println("Failed to get most recent game");        
      }
      return "ERROR";
   }
}
    
