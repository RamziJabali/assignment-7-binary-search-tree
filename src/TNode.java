public class TNode {
    public Keyed value;
    public TNode left, right;

    public TNode(Keyed _key) {
        value = _key;
        left = right = null;
    }

    @Override
    public String toString() {
        if (value instanceof MLBPlayerKey) {
            return ((MLBPlayerKey) value).getTeamName() + " Number " + ((MLBPlayerKey) value).getJerseyNum();
        }
        return null;
        //   return "Player " + key.getPlayerName() + "Has a batting average of" + key.getBattingAverage() + "";
    }
}
