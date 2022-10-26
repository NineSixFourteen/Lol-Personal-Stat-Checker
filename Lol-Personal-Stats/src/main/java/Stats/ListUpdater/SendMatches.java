package Stats.ListUpdater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SendMatches {

    private static String LastUpdatedGame = "EUW1_6115488981"; 
    private static String fileName = ("C:\\Users\\aidan\\Documents\\GitHub\\Lol-Personal-Stat-Checker\\Lol-Personal-Stats\\src\\main\\java\\Stats\\ListUpdater\\output.txt");

    public static void main(String[] args) throws InterruptedException, IOException {
        sendDelete(
        new Integer[]{36515,36517,36519,36521,36523,36525,36527,36529,36531,36533},
        new Integer[]{36516,36518,36520,36522,36524,36526,36528,36530,36532,36534}
        );
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
            String command = "curl localhost:8080/match -d id=" + match;
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
            File file = new File(fileName);
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
    
