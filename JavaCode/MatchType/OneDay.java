package MatchType;

public class OneDay implements MatchType {
    @Override
    public int noOfOvers() {
        return 50;
    }

    @Override
    public int maxOverBowlersAllowed() {
        return 8;
    }
}
