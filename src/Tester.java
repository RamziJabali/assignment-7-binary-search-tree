public class Tester {
    public static void main(String[] args) {
        Table table = new Table();
        MLBPlayerKey key = new MLBPlayerKey(5, "a");
        MLBPlayerKey key2 = new MLBPlayerKey(2, "a");
        MLBPlayerKey key3 = new MLBPlayerKey(7, "a");
        MLBPlayerKey key4 = new MLBPlayerKey(6, "a");
        MLBPlayerKey key5 = new MLBPlayerKey(8, "a");
        MLBPlayerKey key6 = new MLBPlayerKey(1, "a");
        MLBPlayerKey key7 = new MLBPlayerKey(3, "a");
        MLBPlayerKey key8 = new MLBPlayerKey(4, "a");
        //MLBPlayerKey key5 = new MLBPlayerKey(20, "E");
        table.addNode(key);
        table.addNode(key2);
        table.addNode(key3);
        table.addNode(key4);
        table.addNode(key5);
        table.addNode(key6);
        table.addNode(key7);
        table.addNode(key8);
        //table.addNode(key5);
        System.out.println(table);
        //System.out.println(table.search(key));
        System.out.println(table.getHeight());
//        System.out.println(table.getSizeForNode());
    }

}
