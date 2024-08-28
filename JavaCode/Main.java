import java.util.*;

import Enums.PlayerType;
import MatchType.MatchType;
import MatchType.T20;
import Team.Team;
import Team.Player.Person;
import Team.Player.Player;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        Team teamA = obj.addTeam("India");
        Team teamB = obj.addTeam("Australia");

        MatchType matchType = new T20();
        Match match = new Match(teamA, teamB, matchType, null);
        match.startMatch();
    }

    private Team addTeam(String name) {
        Queue<Player> playing11 = new LinkedList<>();
        Player p1 = addPlayer(name+"1", PlayerType.ALLROUNDER);
        Player p2 = addPlayer(name+"2", PlayerType.ALLROUNDER);
        Player p3 = addPlayer(name+"3", PlayerType.ALLROUNDER);
        Player p4 = addPlayer(name+"4", PlayerType.ALLROUNDER);
        Player p5 = addPlayer(name+"5", PlayerType.ALLROUNDER);
        Player p6 = addPlayer(name+"6", PlayerType.ALLROUNDER);
        Player p7 = addPlayer(name+"7", PlayerType.ALLROUNDER);
        Player p8 = addPlayer(name+"8", PlayerType.ALLROUNDER);
        Player p9 = addPlayer(name+"9", PlayerType.ALLROUNDER);
        Player p10 = addPlayer(name+"10", PlayerType.ALLROUNDER);
        Player p11 = addPlayer(name+"11", PlayerType.ALLROUNDER);

        playing11.add(p1);
        playing11.add(p2);
        playing11.add(p3);
        playing11.add(p4);
        playing11.add(p5);
        playing11.add(p6);
        playing11.add(p7);
        playing11.add(p8);
        playing11.add(p9);
        playing11.add(p10);
        playing11.add(p11);

        List<Player> bowlersList = new ArrayList<>();
        bowlersList.add(p1);
        bowlersList.add(p4);
        bowlersList.add(p9);
        bowlersList.add(p5);

        Team team = new Team(name, playing11, null, bowlersList);
        return team;
    }

    private Player addPlayer(String playerName, PlayerType playerType) {
        Person person = new Person();
        person.name = playerName;
        Player player = new Player(person, playerType);
        return player;
    }
}