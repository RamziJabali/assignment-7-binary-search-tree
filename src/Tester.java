public class Tester {
    public static void main(String[] args) {
        Table table = new Table();
        MLBPlayerKey key = new MLBPlayerKey(1, "diamondbacks");
        MLBPlayerKey key2 = new MLBPlayerKey(2, "dodgers");
        MLBPlayerKey key3 = new MLBPlayerKey(21, "C");
        MLBPlayerKey key4 = new MLBPlayerKey(23, "D");
        MLBPlayerKey key5 = new MLBPlayerKey(20, "E");
        table.addNode(key);
        table.addNode(key2);
        table.addNode(key3);
        table.addNode(key4);
        table.addNode(key5);
        System.out.println(table);
        System.out.println(table.search(key));
    }

}
