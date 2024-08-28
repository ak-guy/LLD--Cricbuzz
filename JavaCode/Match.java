import Team.Team;
import MatchType.MatchType;
import java.util.Date;
import Innings.Innings;

public class Match {
    Team teamA;
    Team teamB;
    MatchType matchType;
    Date date;
    String venue;
    Team tossWinner;
    Innings[] innings;

    public Match(Team teamA, Team teamB, MatchType matchType, String venue) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.matchType = matchType;
        this.venue = venue;
        this.innings = new Innings[2];
    }

    public Team toss(Team teamA, Team teamB) {
        if (Math.random() < 0.5) {
            return teamA;
        }
        return teamB;
    }


    public void startMatch() {
        // toss
        this.tossWinner = toss(teamA, teamB);

        // starting innings
        for (int inning=1; inning<=2; inning++) {
            Innings currentInnings;
            Team battingTeam;
            Team bowlingTeam;

            // assuming tosswinner is batting first
            if (inning == 1) {
                battingTeam = tossWinner;
                bowlingTeam = tossWinner.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;
                currentInnings = new Innings(battingTeam, bowlingTeam, matchType);
                currentInnings.startInnings(-1);
            }else {
                bowlingTeam = tossWinner;
                battingTeam = tossWinner.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;
                currentInnings = new Innings(battingTeam, bowlingTeam, matchType);
                currentInnings.startInnings(innings[0].getTotalRuns());
                if (bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()) {
                    bowlingTeam.isWinner = true;
                }
            }

            innings[inning-1] = currentInnings;

            //printing current inning details
            System.out.println();
            System.out.println("INNING " + inning + " -- total Run: " + battingTeam.getTotalRuns());
            System.out.println("---Batting ScoreCard : " + battingTeam.getTeamName() + "---");

            battingTeam.printBattingScoreCard();

            System.out.println();
            System.out.println("---Bowling ScoreCard : " + bowlingTeam.getTeamName() + "---");
            bowlingTeam.printBowlingScoreCard();
        }

        System.out.println();
        if(teamA.isWinner) {
            System.out.println("-----Winner----- : " + teamA.getTeamName());
        }else {
            System.out.println("-----Winner----- : " + teamB.getTeamName());
        }
    }
}
