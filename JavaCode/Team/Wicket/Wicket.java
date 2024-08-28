package Team.Wicket;

import Innings.BallsDetail;
import Innings.OverDetails;
import Team.Player.Player;
import Enums.WicketType;

public class Wicket {
    public Player wicketTakenBy;
    WicketType wicketType;
    OverDetails overDetails;
    BallsDetail ballsDetail;

    public Wicket(Player wicketTakenBy, WicketType wicketType, OverDetails over, BallsDetail balls) {
        this.wicketTakenBy = wicketTakenBy;
        this.wicketType = wicketType;
        this.overDetails = over;
        this.ballsDetail = balls;
    }
}
