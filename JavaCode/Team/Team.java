package Team;

import java.util.*;
import Team.Player.Player;


public class Team {
    String teamName;
    Queue<Player> playingPlayers;
    List<Player> benchedPlayers;
    BattingController battingController;
    BowlingController bowlingController;
}
