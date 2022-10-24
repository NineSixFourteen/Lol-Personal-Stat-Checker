package Stats.ListUpdater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SendMatches {

    private static String LastUpdatedGame = "EUW1_6115488981"; 
    private static String fileName = ("C:\\Users\\aidan\\Documents\\GitHub\\Lol-Personal-Stat-Checker\\Lol-Personal-Stats\\src\\main\\java\\Stats\\ListUpdater\\output.txt");

    public static void main(String[] args) throws InterruptedException, IOException {
        ArrayList<String> matches = getMatchList();
        for(int i = 0; i < 50;i++ ){
            SendMatch(matches.get(i)); // can only do 50 then stops 
            Thread.sleep(500);
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for(int i = 50; i < matches.size();i++){
            writer.write(matches.get(i));
        }
        writer.close();
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
    
