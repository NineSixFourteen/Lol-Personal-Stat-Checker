package Stats.ListUpdater;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import Stats.FetchSystem.Helpers.GetInfo;
import Stats.FetchSystem.Helpers.Helper;

public class SendMatches {


    public static void main(String[] args) throws InterruptedException, IOException {
        ArrayList<String> recentMatches = getMatchIDList(0);
        for(String recent : recentMatches){
            SendMatch(recent);
        }
        SendClean();
    }

    private static void SendClean() {
        ProcessBuilder processBuilder = new ProcessBuilder("curl localhost:8080/clean".split(" "));
        processBuilder.directory(new File("C:\\Users\\aidan\\"));
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ( (line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getMatchIDList(int start) throws MalformedURLException, IOException{
        String matchUrl = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/";
        String URL = matchUrl + GetInfo.getPUUID() + "/ids?start=" + (start * 50) + "&count=50"; 
        final HttpURLConnection con = (HttpURLConnection) new URL(URL).openConnection();
        con.setRequestProperty( "X-Riot-Token", GetInfo.getAPIKey());
        InputStream is = con.getInputStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = Helper.readAll(rd);
            String[] strs = jsonText.substring(1,jsonText.length() - 1).split(",");
            ArrayList<String> matches = new ArrayList<>();
            ArrayList<String> matcher = new ArrayList<>();
            for(String str : strs){
                matches.add(str.substring(1,str.length() -1));
            }
            for(String str : matches){
                matcher.add(str);
            }
            return matcher;
          } finally {
            is.close();
          }
    }
    private static void SendMatch(String match) {
        try{
            String command = "curl localhost:8080/AddMatch -d id=" + match;
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.directory(new File("C:\\Users\\aidan\\"));
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ( (line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            System.out.println(builder.toString());
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
    
