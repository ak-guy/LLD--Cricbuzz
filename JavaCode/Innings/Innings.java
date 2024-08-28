package Innings;

import Team.Team;
import Team.Player.Player;
import java.util.*;

import MatchType.MatchType;

public class Innings {
    Team battingTeam;
    Team bowlingTeam;
    MatchType matchType;
    List<OverDetails> overs;

    public Innings(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        this.overs = new ArrayList<>();
    }

    public void startInnings(int runsToChase) {
        try {
            battingTeam.getNextBatsman();
        } catch (Exception e) {

        }

        int noOfOvers = matchType.noOfOvers();
        for (int overNumber=1; overNumber<=noOfOvers; overNumber++) {
            // choose bowler
            bowlingTeam.getNextBowler(matchType.noOfOvers());
            
            OverDetails over = new OverDetails(overNumber, battingTeam.getBowlingController().getCurrentBowler());
            overs.add(over);
            try {
                boolean won = over.startOverDelivery(battingTeam, bowlingTeam, runsToChase);
                if (won == true) {
                    break;
                }
            }catch (Exception e){
                break;
            }

            Player tempNonStriker = battingTeam.battingController.getNonStriker();
            battingTeam.getBattingController().setNonStriker(battingTeam.getBattingController().getStriker());
            battingTeam.getBattingController().setStriker(tempNonStriker);
        }
    }

    public int getTotalRuns() {
        return battingTeam.getTotalRuns();
    }
}
