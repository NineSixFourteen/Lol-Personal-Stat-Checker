package Stats.ListUpdater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Stats.FetchSystem.Helpers.GetInfo;
import Stats.FetchSystem.Helpers.Helper;

public class SendMatches {


    public static void main(String[] args) throws InterruptedException, IOException {
        ArrayList<String> recentMatches = getMatchIDList(0);
        String mostRecent = GetMatches.GetMostRecentGame();
        if(recentMatches.contains(mostRecent)){
            for(String recent : recentMatches){
                if(recent.equals(mostRecent)){return;}
                SendMatch(recent);
                //System.out.println(recent);
            }
        }
    }

    public static ArrayList<String> getMatchIDList(int start) throws MalformedURLException, IOException{
        String matchUrl = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/";
        String URL = matchUrl + GetInfo.getPUUID() + "/ids?start=" + (start * 100) + "&count=100"; 
        final HttpURLConnection con = (HttpURLConnection) new URL(URL).openConnection();
        con.setRequestProperty( "X-Riot-Token", GetInfo.getAPIKey());
        InputStream is = con.getInputStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = Helper.readAll(rd);
            String[] strs = jsonText.substring(1,jsonText.length() - 1).split(",");
            ArrayList<String> matches = new ArrayList<>();
            for(String str : strs){
                matches.add(str.substring(1,str.length() -1));
            }
            return matches;
          } finally {
            is.close();
          }
    }

    private static void sendDelete(Integer[] ov1, Integer[] ov2) throws IOException{
        String command  = "curl localhost:8080/delete/ov1 -d id=";
        String command2 = "curl localhost:8080/delete/ov2 -d id=";
        for(Integer o1 : ov1){
            ProcessBuilder processBuilder = new ProcessBuilder((command + o1).split(" "));
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
        }
        for(Integer o2 : ov2){
            ProcessBuilder processBuilder = new ProcessBuilder((command2 + o2).split(" "));
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ( (line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            System.out.println(builder.toString());
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

    private static ArrayList<String> getMatchList() {
        try{
            File file = new File(GetInfo.fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<String> matches = new ArrayList<>();
            String st;
            while ((st = br.readLine()) != null)matches.add(st);
            return matches;
        } catch(Exception e){
            e.printStackTrace();   
        }
        return null;
    }
}
    
