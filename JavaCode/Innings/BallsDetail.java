package Innings;

import Team.Player.Player;
import Team.Team;
import Enums.*;
import ScoreUpdater.BattingScoreUpdater;
import ScoreUpdater.BowlingScoreUpdater;
import ScoreUpdater.ScoreUpdaterObserver;
import java.util.*;
import Team.Wicket.Wicket;

public class BallsDetail {
    public int ballNo;
    public BallType ballType;
    public RunType runType;
    public Player playedBy;
    public Player bowledBy;
    public Wicket wicket;
    List<ScoreUpdaterObserver> scoreUpdaterObserverList = new ArrayList<>();

    public BallsDetail(int ballNo) {
        this.ballNo = ballNo;
        scoreUpdaterObserverList.add(new BattingScoreUpdater());
        scoreUpdaterObserverList.add(new BowlingScoreUpdater());
    }

    // observiee
    public void notifyObserver(BallsDetail ballsDetail) {
        for (ScoreUpdaterObserver observer : scoreUpdaterObserverList) {
            observer.update(ballsDetail);
        }
    }

    public void startBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails overDetails) {
        playedBy = battingTeam.battingController.getStriker();
        bowledBy = overDetails.bowledBy;
        ballType = getDummyBallType();

        if (isWicketTaken()) {
            runType = RunType.ZERO;
            wicket = new Wicket(bowlingTeam.getCurrentBowler(), WicketType.BOLD, overDetails, this);
            battingTeam.battingController.setStriker(null);
        }else {
            runType = getDummyRunType();
            if (runType == RunType.SINGLE) {
                battingTeam.battingController.setStriker(battingTeam.battingController.getNonStriker());
                battingTeam.battingController.setNonStriker(playedBy);
            }
        }

        notifyObserver(this);
    }

    private RunType getDummyRunType() {

        double val = Math.random();
        if (val < 0.4) {
            return RunType.SINGLE;
        } else if (val >= 0.4 && val < 0.7) {
            return RunType.DOUBLE;
        } else if (val >= 0.7 && val < 0.9) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }

    public BallType getDummyBallType(){
        double val = Math.random();
        if (val <= 0.1) {
            return BallType.NOBALL;
        } else if (val >= 0.9) {
            return BallType.WIDEBALL;
        } else {
            return BallType.NORMAL;
        }
    }

    private boolean isWicketTaken() {
        if (Math.random() < 0.2) {
            return true;
        } else {
            return false;
        }
    }
}
