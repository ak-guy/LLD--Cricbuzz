package ScoreUpdater;

import Enums.RunType;
import Innings.BallsDetail;

public class BattingScoreUpdater implements ScoreUpdaterObserver {
    @Override
    public void update(BallsDetail balldetails) {
        int run = 0;
        if (balldetails.runType == RunType.SINGLE) {
            run = 1;
            balldetails.playedBy.battingScoreCard.totalSingles++;
        }else if (balldetails.runType == RunType.DOUBLE) {
            run = 2;
            balldetails.playedBy.battingScoreCard.totalDoubles++;
        }else if (balldetails.runType == RunType.FOUR) {
            run = 4;
            balldetails.playedBy.battingScoreCard.total4s++;
        }else if (balldetails.runType == RunType.SIX) {
            run = 6;
            balldetails.playedBy.battingScoreCard.total6s++;
        }

        balldetails.playedBy.battingScoreCard.totalRuns += run;
        balldetails.playedBy.battingScoreCard.totalBallsPlayed++;

        if (balldetails.wicket != null) {
            balldetails.playedBy.battingScoreCard.wicketDetails = balldetails.wicket;
        }
    }
}
