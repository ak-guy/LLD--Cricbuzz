package Innings;

import java.util.ArrayList;
import java.util.List;

import Enums.BallType;
import Team.Player.Player;
import Team.Team;

public class OverDetails {
    int overNumber;
    List<BallsDetail> balls;
    int extraBallsCount;
    Player bowledBy;

    public OverDetails(int overNumber, Player bowledBy) {
        this.overNumber = overNumber;
        this.bowledBy = bowledBy;
        balls = new ArrayList<>();
    }

    public boolean startOverDelivery(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception {
        int ballCount = 1;
        while(ballCount <= 6) {
            BallsDetail ball = new BallsDetail(ballCount);
            ball.startBallDelivery(battingTeam, bowlingTeam, this);
            if (ball.ballType == BallType.NORMAL) {
                balls.add(ball);
                ballCount++;
                if (ball.wicket != null) {
                    battingTeam.getNextBatsman();
                }
                if (runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin) {
                    battingTeam.isWinner = true;
                    return true;
                }
            }else {
                extraBallsCount++;
            }
        }
        return false;
    }

}
