public class TNode {
    public Keyed value;
    public TNode left, right;

    public TNode(Keyed _key) {
        value = _key;
        left = right = null;
    }
}
