public class Tester {
    public static void main(String[] args) {
        Table table = new Table();
        MLBPlayerKey key1 = new MLBPlayer("dodgers", "dinkypinky", 23, 22);
        MLBPlayerKey key3 = new MLBPlayer("dodgers", "DanglyCunt", 69, 23);
        MLBPlayerKey key2 = new MLBPlayer("dodgers", "droopyFuck", 10, 24);
        MLBPlayerKey key4 = new MLBPlayer("dodgers", "let'sGetThisBread", 21, 25);
//        MLBPlayerKey key1 = new MLBPlayer("dodgers", "dinkypinky", 23, 22);
//        MLBPlayerKey key2 = new MLBPlayerKey(2, "a");
//        MLBPlayerKey key3 = new MLBPlayerKey(7, "a");
//        MLBPlayerKey key4 = new MLBPlayerKey(6, "a");
//        MLBPlayerKey key5 = new MLBPlayerKey(8, "a");
//        MLBPlayerKey key6 = new MLBPlayerKey(1, "a");
//        MLBPlayerKey key7 = new MLBPlayerKey(3, "a");
//        MLBPlayerKey key8 = new MLBPlayerKey(4, "a");
        //MLBPlayerKey key5 = new MLBPlayerKey(20, "E");
        table.insert(key1);
        table.insert(key2);
        table.insert(key3);
        table.insert(key4);
//        table.insert(key5);
//        table.insert(key6);
//        table.insert(key7);
//        table.insert(key8);
        System.out.println(table.search(key1));
        System.out.println(table.getHeight());
        System.out.println(table.getSize());
        System.out.println(table.getAverageHeight());
        table.showTree();
        table.delete(key2);
        System.out.println("/////////////////////////////////////////////////////");
        table.showTree();

//        System.out.println(table.getSizeForNode());
    }

}
