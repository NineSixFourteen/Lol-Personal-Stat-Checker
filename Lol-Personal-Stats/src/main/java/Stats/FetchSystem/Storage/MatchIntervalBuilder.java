package Stats.FetchSystem.Storage;

import java.util.ArrayList;

public class MatchIntervalBuilder {

    private MatchInterval match10;
    private MatchInterval match15;
    private MatchInterval match20;
    private MatchInterval match25;
    private MatchInterval match30;

    public MatchIntervalBuilder(){
        match10 = new MatchInterval(10);
        match15 = new MatchInterval(15);
        match20 = new MatchInterval(20);
        match25 = new MatchInterval(25);
        match30 = new MatchInterval(30);
    }

    public MatchIntervalBuilder addKill(int timestamp){
        if(timestamp < 66000){
            match10.addKill();match15.addKill();match20.addKill();match25.addKill(); match30.addKill();
        } else if(timestamp < 96000){
            match15.addKill();match20.addKill();match25.addKill();match30.addKill();
        } else if(timestamp < 126000){
            match20.addKill();match25.addKill();match30.addKill();
        } else if(timestamp < 156000){
            match25.addKill();match30.addKill();
        } else if(timestamp < 186000){
            match30.addKill();
        }
        return this;
    }

    public MatchIntervalBuilder addDeaths(int timestamp){
        if(timestamp < 66000){
            match10.addDeaths();match15.addDeaths();match20.addDeaths();match25.addDeaths(); match30.addDeaths();
        } else if(timestamp < 96000){
            match15.addDeaths();match20.addDeaths();match25.addDeaths();match30.addDeaths();
        } else if(timestamp < 126000){
            match20.addDeaths();match25.addDeaths();match30.addDeaths();
        } else if(timestamp < 156000){
            match25.addDeaths();match30.addDeaths();
        } else if(timestamp < 186000){
            match30.addDeaths();
        }
        return this;
    }

    public MatchIntervalBuilder addAssits(int timestamp){
        if(timestamp < 66000){
            match10.addAssists();match15.addAssists();match20.addAssists();match25.addAssists();match30.addAssists();
        } else if(timestamp < 96000){
            match15.addAssists();match20.addAssists();match25.addAssists();match30.addAssists();
        } else if(timestamp < 126000){
            match20.addAssists();match25.addAssists();match30.addAssists();
        } else if(timestamp < 156000){
            match25.addAssists();match30.addAssists();
        } else if(timestamp < 186000){
            match30.addAssists();
        }
        return this;
    }

    public MatchIntervalBuilder setDamageDone(int num , int DamageDone){
        switch(num){
            case 10:match10.setDamageDone(DamageDone);break;
            case 15:match15.setDamageDone(DamageDone);break;
            case 20:match20.setDamageDone(DamageDone);break;
            case 25:match25.setDamageDone(DamageDone);break;
            case 30:match30.setDamageDone(DamageDone);break;
        }
        return this;
    }

    public MatchIntervalBuilder setLevel(int num , int level){
        switch(num){
            case 10:match10.setLevel(level);break;
            case 15:match15.setLevel(level);break;
            case 20:match20.setLevel(level);break;
            case 25:match25.setLevel(level);break;
            case 30:match30.setLevel(level);break;
        }
        return this;
    }

    public MatchIntervalBuilder setMinions(int num , int minions){
        switch(num){
            case 10:match10.setMinions(minions);break;
            case 15:match15.setMinions(minions);break;
            case 20:match20.setMinions(minions);break;
            case 25:match25.setMinions(minions);break;
            case 30:match30.setMinions(minions);break;
      }
      return this;
    }

    public MatchIntervalBuilder setXp(int num , int xp){
        switch(num){
            case 10:match10.setXp(xp);break;
            case 15:match15.setXp(xp);break;
            case 20:match20.setXp(xp);break;
            case 25:match25.setXp(xp);break;
            case 30:match30.setXp(xp);break;
      }
      return this;
    }

    public MatchIntervalBuilder setGold(int num , int gold){
        switch(num){
            case 10:match10.setGold(gold);break;
            case 15:match15.setGold(gold);break;
            case 20:match20.setGold(gold);break;
            case 25:match25.setGold(gold);break;
            case 30:match30.setGold(gold);break;
      }
      return this;
    }

    public ArrayList<MatchInterval> build(){
        ArrayList<MatchInterval> intervals = new ArrayList<>();
        intervals.add(match10);
        intervals.add(match15);
        intervals.add(match20);
        intervals.add(match25);
        intervals.add(match30);
        return intervals;
    }
}
