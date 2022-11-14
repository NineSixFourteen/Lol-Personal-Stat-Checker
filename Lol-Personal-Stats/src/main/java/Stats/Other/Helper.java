package Stats.Other;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import Stats.BackEnd.Entitys.MatchInterval;

public class Helper {
    
    public static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
      }

    public static ArrayList<ArrayList<MatchInterval>> seperateList(List<MatchInterval> interva, ArrayList<String> names) {
      ArrayList<ArrayList<MatchInterval>> intervals = new ArrayList<>();
      for(int i = 0; i < 10;i++ ){
          intervals.add(new ArrayList<>());
      }
      for(MatchInterval mi : interva){
          int l = 0; 
          for(String name: names){
              if(name.equals(mi.getName())){
                  intervals.get(l).add(mi);
                  break;
              }l++;
          }
      }
      return intervals;
  }

}
