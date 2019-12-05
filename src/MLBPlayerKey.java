public class MLBPlayerKey implements Keyed {
    private int jerseyNum;
    private String teamName;

    public MLBPlayerKey(int jerseyNum_, String teamName_) {
        jerseyNum = jerseyNum_;
        teamName = teamName_;
    }

    public int getJerseyNum() {
        return jerseyNum;
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public int keyComp(Keyed key) {
        if (key instanceof MLBPlayerKey) {
            MLBPlayerKey otherPlayer = (MLBPlayerKey) key;
            if (otherPlayer.teamName.equals(teamName)) {
                if (otherPlayer.jerseyNum == jerseyNum) {
                    return 0;
                }
                if (otherPlayer.jerseyNum < jerseyNum) {
                    return -1;
                }
                return 1;
            }
            return otherPlayer.teamName.compareToIgnoreCase(teamName);
        }
        return -1;
    }

    @Override
    public String toStr() {
        return jerseyNum + " " + teamName.charAt(0) + teamName.charAt(1) + teamName.charAt(2);
    }
}
