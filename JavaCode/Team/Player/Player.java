package Team.Player;

import Enums.PlayerType;

public class Player {
    Person person;
    PlayerType playerType;
    public PlayerBattingScoreCard battingScoreCard;
    public PlayerBowlingScoreCard bowlingScoreCard;

    public Player(Person person, PlayerType playerType) {
        this.person = person;
        this.playerType = playerType;
        this.battingScoreCard = new PlayerBattingScoreCard();
        this.bowlingScoreCard = new PlayerBowlingScoreCard();
    }

    public void printPlayerBattingScorecard() {
        System.out.println("PlayerName: " + person.name + " -- totalRuns: " + battingScoreCard.totalRuns
                    + " -- totalBallsPlayed: " + battingScoreCard.totalBallsPlayed + " -- 4s: " + battingScoreCard.total4s
                    + " -- 6s: " + battingScoreCard.total6s + " -- outby: " +   ((battingScoreCard.wicketDetails != null) ? battingScoreCard.wicketDetails.wicketTakenBy.person.name : "notout"));
    }

    public void printBowlingScoreCard(){
        System.out.println("PlayerName: " + person.name + " -- totalOversThrown: " + bowlingScoreCard.oversDelivered
                + " -- totalRunsGiven: " + bowlingScoreCard.runsGiven + " -- WicketsTaken: " + bowlingScoreCard.wicketsTaken);
    }

}
