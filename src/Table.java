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
            return;
        }
        addNodeHelper(newNode, root);
    }

    public void addNodeHelper(TNode newNode, TNode parentNode) {
        TNode focusNode = parentNode;//have to start with parent as we traverse
        TNode parent;//future parent for new node
        while (true) {// to change what the node focus is
            parent = focusNode;
            if (parent.keyComp(newNode) < 0) {//using keyComp to compare values
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

    private void printInOrderTraversal(TNode focusNode) {
        if (focusNode != null) {
            printInOrderTraversal(focusNode.left);
            text += focusNode + "\n";
            printInOrderTraversal(focusNode.right);
        }
    }

    public int getSize() {
        return getSizeForNode(root);
    }

    private int getSizeForNode(TNode node) {
        if (node == null) {
            return 1;
        }
        int leftTreeDepth = getSizeForNode(node.left);
        int rightTreeDepth = getSizeForNode(node.right);
        return leftTreeDepth + rightTreeDepth;
    }

    private int maximumHeight(TNode node) {
        if (node == null) {
            return 0;
        }
        int leftTreeDepth = maximumHeight(node.left);
        int rightTreeDepth = maximumHeight(node.right);
        if (leftTreeDepth > rightTreeDepth) {
            return (leftTreeDepth + 1);
        }
        return (rightTreeDepth + 1);
    }

    public void delete(Keyed value) {
        if (root == null) {
            return;
        }
        if (root.value.keyComp(value) == 0) {
            root = null;
            return;
        }
        deleteHelper(value, null, root);
    }

    public void deleteHelper(Keyed value, TNode parentNode, TNode currentNode) {
        if (currentNode.value.keyComp(value) == 0) {
            if (currentNode.left == null && currentNode.right == null) {
                deleteDanglingLeaf(value, parentNode);
                return;
            }
            if (currentNode.left == null && currentNode.right != null) {
                deleteLeftlessTree(value, parentNode, currentNode);
                return;
            }
            if (currentNode.left != null && currentNode.right == null) {
                deleteRightlessTree(value, parentNode, currentNode);
                return;
            }
            deletePopulatedChildrenNode(parentNode, currentNode);
            return;
        }
        if (currentNode.value.keyComp(value) < 0) {
            deleteHelper(value, currentNode, currentNode.left);
            return;
        }
        deleteHelper(value, currentNode, currentNode.right);
    }

    private void deletePopulatedChildrenNode(TNode parentNode, TNode currentNode) {
        addNodeHelper(currentNode.left, currentNode.right);
        currentNode.left = null;
        if (currentNode.keyComp(parentNode) > 0) {
            parentNode.right = currentNode.right;
        } else {
            parentNode.left = currentNode.right;
        }
        currentNode.right = null;
    }

    private void deleteLeftlessTree(Keyed value, TNode parentNode, TNode currentNode) {
        if (parentNode.value.keyComp(value) < 0) {
            parentNode.left = currentNode.right;
            return;
        }
        parentNode.right = currentNode.right;
    }

    private void deleteRightlessTree(Keyed value, TNode parentNode, TNode currentNode) {
        if (parentNode.value.keyComp(value) < 0) {
            parentNode.left = currentNode.left;
            return;
        }
        parentNode.right = currentNode.left;
    }

    private void deleteDanglingLeaf(Keyed value, TNode parentNode) {
        if (parentNode.value.keyComp(value) < 0) {
            parentNode.left = null;
            return;
        }
        parentNode.right = null;
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

    public int getAverageHeight() {
        return getSize() / getHeight();
    }

    public int getHeight() {
        return maximumHeight(root);
    }

    @Override
    public String toString() {
        text = "";
        printInOrderTraversal(root);
        return text;
    }
}
