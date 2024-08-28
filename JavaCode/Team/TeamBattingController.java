package Team;

import java.util.Queue;
import Team.Player.Player;
import java.util.LinkedList;

public class TeamBattingController {
    Queue<Player> yetToPlay;
    Player striker;
    Player nonStriker;

    public TeamBattingController(Queue<Player> playing11) {
        yetToPlay = new LinkedList<>();
        yetToPlay.addAll(playing11);
    }

    public void getNextPlayer() throws Exception {
        if (yetToPlay.isEmpty()) {
            throw new Exception();
        }else if (striker == null) {
            striker = yetToPlay.poll();
        }else if (nonStriker == null) {
            nonStriker = yetToPlay.poll();
        }
    }

    public Player getStriker() {
        return striker;
    }

    public void setStriker(Player striker) {
        this.striker = striker;
    }

    public Player getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(Player nonStriker) {
        this.nonStriker = nonStriker;
    }

}
