package Stats.PrettyPrinters;

import Stats.FetchSystem.Storage.Entitys.MatchHistory;
import Stats.FetchSystem.Storage.Entitys.MatchInterval;
import Stats.FetchSystem.Storage.Entitys.MatchOverall1;
import Stats.FetchSystem.Storage.Entitys.MatchOverall2;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import Stats.FetchSystem.Fetcher.FetchOverall;
import Stats.FetchSystem.Fetcher.Fetcher;

public class PrettyFetch {

    public static void main(String[] args) {
        JsonNode node = Fetcher.getMatch("EUW1_6117044283");
        //prettyMatchHistory(FetchMatchHistory.getHistory(node));
        //prettyPlayer1(FetchOverall.getPlayers(node).get(0).getMatch1());
        prettyPlayer2(FetchOverall.getPlayers(node).get(2).getMatch2());
    }
    

    public static void prettyMatchHistory(MatchHistory mh){
        System.out.println("Match ID : " + mh.getMatchID());
        System.out.println("Gamemode : " + mh.getGameMode());
        System.out.println("Date : " + mh.getDate());
        System.out.println("Game Length : " + mh.getGameLength());
        System.out.println("Winner: " + mh.getWinningTeam());
    }

    public static void prettyPlayer1(MatchOverall1 m1){
        System.out.println("Match ID : "         + m1.getMatchID()         );
        System.out.println("Name : "             + m1.getName()            );
        System.out.println("Position : "         + m1.getPosition()        );
        System.out.println("Kills : "            + m1.getKills()           );
        System.out.println("Deaths : "           + m1.getDeaths()          );
        System.out.println("Assists : "          + m1.getAssists()         );
        System.out.println("Gold : "             + m1.getGold()            );
        System.out.println("Wards Placed : "     + m1.getWardsPlaced()     );
        System.out.println("Wards Destoyed : "   + m1.getWardsDestroyed()  );
        System.out.println("CS : "               + m1.getCS()              );
        System.out.println("Damage Dealt : "     + m1.getDamageDealt()     );
        System.out.println("Damage Taken : "     + m1.getDamageTaken()     );
        System.out.println("Turrets Taken : "    + m1.getTurretsTaken()    );
        System.out.println("Turret Damage : "    + m1.getTurretDamage()    );
        System.out.println("Dragons Taken : "    + m1.getDragonsTaken()    );
        System.out.println("Barons Taken : "     + m1.getBaronsTaken()     );
        System.out.println("Objective Steals : " + m1.getObjectiveSteals() );
        System.out.println("Vision Score : "     + m1.getVisionScore()     );
    }

    private static void prettyPlayer2(MatchOverall2 m2) {
        System.out.println("Match ID : "                 + m2.getMatchId()              );
        System.out.println("Name : "                     + m2.getName()                 );
        System.out.println("Pings : "                    + m2.getPings()                );
        System.out.println("Bounty : "                   + m2.getBountyL()              );
        System.out.println("Ability Uses : "             + m2.getAbiltyUses()           );
        System.out.println("Jungle Monsters : "          + m2.getJungleMonstersKilled() );
        System.out.println("Stolen Buffs : "             + m2.getStolenBuffs()          );
        System.out.println("Control Wards placed : "     + m2.getControlWardsPlaced()   );
        System.out.println("Control Wards Bought : "     + m2.getControlWardsBought()   );
        System.out.println("Dodge Skill Shots : "        + m2.getDodgedSkillShots()     );
        System.out.println("Hit Skill Shots : "          + m2.getHitSkillShots()        );
        System.out.println("Enemy Jungle Killed : "      + m2.getEnemyJungleKilled()    );
        System.out.println("Enemys CC'd : "              + m2.getEnemyCCd()             );
        System.out.println("Time CC other : "            + m2.getTimeCCother()          );
        System.out.println("CC and Kill with Alley : "   + m2.getCCandKillwAlley()      );
        System.out.println("Skill Shots Early : "        + m2.getSkillShotsEarly()      );
        System.out.println("Lane Minions At 10: "        + m2.getLandMinionsAt10()      );
        System.out.println("Peak CS Lead : "             + m2.getPeakCsLead()           );
        System.out.println("Peak Kill Differnce : "      + m2.getPeakKillDiff()         );
        System.out.println("Picks With Alley : "         + m2.getPicksWAlley()          );
        System.out.println("Solo Kills : "               + m2.getSoloKills()            );
        System.out.println("Stealth Wards Placed : "     + m2.getStealthWardsPlaced()   );
        System.out.println("Turret Plates : "            + m2.getTurretPlates()         );
        System.out.println("First Blood Kill : "         + m2.isFirstBloodKill()        );
        System.out.println("First Blood Assists : "      + m2.isFirstBloodAssists()     );
        System.out.println("First Blood Tower : "        + m2.isFirstTowerKill()        );
        System.out.println("D Key : "                    + m2.getDkey()                 );
        System.out.println("D Key Uses : "               + m2.getDkeyUses()             );
        System.out.println("F Key : "                    + m2.getFkey()                 );
        System.out.println("F Key Uses : "               + m2.getFkeyUses()             );
        System.out.println("Amount Heal : "              + m2.getHealOnTeamates()       );
        System.out.println("Amount Shield : "            + m2.getSheildOnTeamates()     );
    }


    public static void prettyPlayerInterval(ArrayList<MatchInterval> arrayList) {
        for(int i = 0; i < arrayList.size();i++){
            MatchInterval match = arrayList.get(i);
            System.out.println("I : "  + i);
            System.out.println("Kills : "    + match.getKills());
            System.out.println("Deaths : "   + match.getDeaths());
            System.out.println("Gold : "     + match.getGold());
            System.out.println("Minions : "  + match.getMinions());
            System.out.println("Jungle : "   + match.getJungle());
            System.out.println("Assists : "        + match.getAssists());
            System.out.println("Damage Done : "    + match.getDamageDone());
            System.out.println("Level : "  + match.getLevel());
            System.out.println("Xp : "  + match.getXp());
            
        }
    }
}
