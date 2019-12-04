public class Table {
    public TNode root;

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

    public void inOrderTraversal(TNode focusNode){
        if(focusNode != null){
            inOrderTraversal(focusNode.left);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.right);
        }
    }

    public void delete(Keyed value) {

    }

    public Keyed search(Keyed value) {
        return null;
    }

    public void showTree() {

    }

    public int getAverageLevel(Keyed value) {
        return -0;
    }


}
