package Innings;

import Team.Team;
import java.util.*;

import MatchType.MatchType;



public class Innings {
    Team battingTeam;
    Team bowlingTeam;
    List<OverDetails> overs;

    public Innings(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.overs = new ArrayList<>();
    }

    public void startInnings(int toChase) {

    }
}
