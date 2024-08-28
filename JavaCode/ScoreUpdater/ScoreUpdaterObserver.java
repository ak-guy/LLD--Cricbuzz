package ScoreUpdater;

import Innings.BallsDetail;

public interface ScoreUpdaterObserver {
    public void update(BallsDetail ballObject);
}
