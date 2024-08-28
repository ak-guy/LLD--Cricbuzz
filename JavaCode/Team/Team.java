package Team;

import java.util.*;
import Team.Player.Player;


public class Team {
    String teamName;
    Queue<Player> playingPlayers;
    List<Player> benchedPlayers;
    TeamBattingController battingController;
    TeamBowlingController bowlingController;
    public boolean isWinner = false;

    public Team(String teamName, Queue<Player> playingPlayers, List<Player> benchedPlayers, List<Player> bowlersList) {
        this.teamName = teamName;
        this.playingPlayers = playingPlayers;
        this.benchedPlayers = benchedPlayers;
        battingController = new TeamBattingController(playingPlayers);
        bowlingController = new TeamBowlingController(bowlersList);
    }

    public void getNextBatsman() throws Exception {
        battingController.getNextPlayer();
    }

    public void getNextBowler(int maxOverCountPerBowler) {
        bowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public void printBattingScoreCard() {
        for (Player player : playingPlayers) {
            player.printPlayerBattingScorecard();
        }
    }

    public void printBowlingScoreCard() {
        for (Player player : playingPlayers) {
            if (player.bowlingScoreCard.oversDelivered > 0) {
                player.printBowlingScoreCard();
            }
        }
    }

    public int getTotalRuns(){
        int totalRun=0;
        for (Player player: playingPlayers){
            totalRun += player.battingScoreCard.totalRuns;
        }
        return totalRun;
    }

    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public Queue<Player> getPlayingPlayers() {
        return playingPlayers;
    }
    public void setPlayingPlayers(Queue<Player> playingPlayers) {
        this.playingPlayers = playingPlayers;
    }
    public List<Player> getBenchedPlayers() {
        return benchedPlayers;
    }
    public void setBenchedPlayers(List<Player> benchedPlayers) {
        this.benchedPlayers = benchedPlayers;
    }
    public TeamBattingController getBattingController() {
        return battingController;
    }
    public void setBattingController(TeamBattingController battingController) {
        this.battingController = battingController;
    }
    public TeamBowlingController getBowlingController() {
        return bowlingController;
    }
    public void setBowlingController(TeamBowlingController bowlingController) {
        this.bowlingController = bowlingController;
    }
}
