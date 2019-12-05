public class Table {
    private TNode root;
    private String text = "";

    public Table(Keyed key) {
        root = new TNode(key);
    }

    public Table() {
        root = null;
    }

    public void addNode(Keyed value) {
        TNode newNode = new TNode(value);
        if (root == null) {
            root = newNode;
        } else {
            TNode focusNode = root;//have to start with root as we traverse
            TNode parent;//future parent for new node
            while (true) {// to change what the node focus is
                parent = focusNode;
                if (parent.value.keyComp(value) == -1) {//using keyComp to compare values
                    focusNode = focusNode.left;// if it is less than the root go to the left
                    if (focusNode == null) {// if it has no child to the left
                        parent.left = newNode;//set the left child to new node
                        return;//to get us out of the infinite loop
                    }
                } else {
                    focusNode = focusNode.right;// if we reach here we know that we need to put our node on the right child
                    if (focusNode == null) {// if it is null add it to the right child
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    private void inOrderTraversal(TNode focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.left);
            text += focusNode + "\n";
            inOrderTraversal(focusNode.right);
        }
    }

    private int maximumHeight(TNode node) {
        if (node == null)
            return 0;
        else {
            int leftTreeDepth = maximumHeight(node.left);
            int rightTreeDepth = maximumHeight(node.right);
            if (leftTreeDepth > rightTreeDepth) {
                return (leftTreeDepth + 1);
            } else
                return (rightTreeDepth + 1);
        }
    }

    public void delete(Keyed value) {

    }

    public TNode search(Keyed value) {
        TNode focusNode = root;

        while (!focusNode.value.equals(value)) {
            if (focusNode.value.keyComp(value) == -1) {
                focusNode = focusNode.left;
            } else {
                focusNode = focusNode.right;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public void showTree() {

    }

    public int getAverageLevel(Keyed value) {
        return -0;
    }

    public int getHeight() {
        return maximumHeight(root);
    }

    @Override
    public String toString() {
        text = "";
        inOrderTraversal(root);
        return text;
    }
}
