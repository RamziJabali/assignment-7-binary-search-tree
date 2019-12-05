public class MLBPlayer extends MLBPlayerKey {
    private String playerName;
    private double battingAverage;

    public MLBPlayer(String teamName_, String playerName_, int battingAverage_, int jerseyNum_) {
        super(jerseyNum_, teamName_);
        playerName = playerName_;
        battingAverage = battingAverage_;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return "Player # " + getJerseyNum() + " " +playerName + " of the " + getTeamName() +
                "\n Has a batting average of: " + battingAverage + "\n" +
                "";
    }
}

