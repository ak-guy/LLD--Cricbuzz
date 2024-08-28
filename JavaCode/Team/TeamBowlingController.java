package Team;

import Team.Player.Player;
import java.util.*;

public class TeamBowlingController {
    Deque<Player> bowlers;
    Map<Player, Integer> bowlersOverCount;
    Player currentBowler;
    
    public TeamBowlingController(List<Player> bowlersList) {
        this.bowlers = new LinkedList<>();
        bowlersOverCount = new HashMap<>();
        for (Player bowler: bowlersList) {
            this.bowlers.addLast(bowler);
            bowlersOverCount.put(bowler, 0);
        }
    }

    public void getNextBowler(int maxOverCountPerBowler) {
        Player possibleBowler = bowlers.poll();
        if (bowlersOverCount.get(possibleBowler)+1 == maxOverCountPerBowler) {
            currentBowler = possibleBowler;
        }else {
            currentBowler = possibleBowler;
            bowlers.addLast(possibleBowler);
            bowlersOverCount.put(possibleBowler, bowlersOverCount.get(possibleBowler)+1);
        }
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }
}
