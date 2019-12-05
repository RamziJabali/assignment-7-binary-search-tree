import java.util.*;

public class MainMenu {
    private static Scanner kb = new Scanner(System.in);
    private static Random rand = new Random();
    private static Table playTable;

    public static void main(String[] args) {
        int userChoice;
        do {
            System.out.println("Enter 1 to test a single table");
            System.out.println("Enter 2 to test many table");
            System.out.println("Enter 3 to quit");
            userChoice = kb.nextInt();

            switch (userChoice) {
                case 1:
                    manipulateSingleTable();
                    break;
                case 2:
                    manipulateManyTables();
                    break;
                case 3:
                    quit();
                    break;
            }
        } while (userChoice != 3);
    }

    private static void quit() {
        System.out.println("Ending app..");
    }

    private static void manipulateManyTables() {
        Table table;
        int largestSize;
        int average;
        int size;
        int[] height = new int[10];
        int[] averageDepth = new int[10];
        int[] sizes = new int[10];
        for (int i = 16; i <= 32768; i += i) {
            for (int j = 0; j < 10; j++) {
                table = new Table();
                for (int ix = 0; ix < i; ix++) {
                    table.insert(createRandomKey());
                }
                height[j] = table.getHeight();
                averageDepth[j] = table.getAverageHeight();
                sizes[j] = table.getSize();
            }
            largestSize = height[0];
            average = averageDepth[0];
            size = sizes[0];
            for (int i1 = 0; i < 10; i++) {
                if (largestSize < height[i1]) {
                    largestSize = height[i1];
                    average = averageDepth[i1];
                }
            }
            System.out.println("The largest tree was of size " + largestSize);
            System.out.println("The largest tree is of size " + size);
            System.out.println("The average of the expected case is " + average);
            System.out.println();
            System.out.println();
        }
    }

    private static void manipulateSingleTable() {
        int userChoice;
        do {
            System.out.println("Enter 0 to quit");
            System.out.println("Enter 1 to Initialize empty table");
            System.out.println("Enter 2 to insert an item into the table");
            System.out.println("Enter 3 delete Item from table");
            System.out.println("Enter 4 search for item with given key");
            System.out.println("Enter 5 to get the height/depth of the table ");
            System.out.println("Enter 6 to get the size of the table");
            System.out.println("Enter 7 get average level of the table");
            System.out.println("Enter 8 display contents of the tree, in a tree like fashion");
            System.out.println("Enter 9 display the entire contents of the table in order of their keys");
            userChoice = kb.nextInt();
            switch (userChoice) {
                case 1:
                    initializeEmptyTable();
                    break;
                case 2:
                    insertItemInTable();
                    break;
                case 3:
                    deleteItemFromTable();
                    break;
                case 4:
                    findItem();
                    break;
                case 5:
                    getHeightOfTable();
                    break;
                case 6:
                    getSize();
                    break;
                case 7:
                    getAverageLevel();
                    break;
                case 8:
                    showTree();
                    break;
                case 9:
                    printSummary();
                    break;
            }
        } while (userChoice != 0);
    }

    private static void printSummary() {
        System.out.println(playTable);
    }

    private static void showTree() {
        playTable.showTree();
    }

    private static void getAverageLevel() {
        System.out.println("The average level is: " + playTable.getAverageHeight());
    }

    private static void getSize() {
        System.out.println("Table size is: " + playTable.getSize());
    }

    private static void getHeightOfTable() {
        System.out.println("The maximum height of the table is " + playTable.getHeight());
    }

    private static void findItem() {
        System.out.println(playTable.search(createPlayerKey()));
    }

    private static void deleteItemFromTable() {
        playTable.delete(createPlayerKey());
        System.out.println("Complete...");
    }

    private static void insertItemInTable() {
        playTable.insert(createPlayer());
        System.out.println("Complete...");
    }

    private static MLBPlayer createPlayer() {
        System.out.println("Enter the name of the player ");
        String playerName = kb.next();
        System.out.println("Enter the name of the team the player is in");
        String playerTeam = kb.next();
        System.out.println("Enter the Jersey number of the player ");
        int playerNum = kb.nextInt();
        System.out.println("Enter the player batting average");
        int playerBatting = kb.nextInt();
        return new MLBPlayer(playerTeam, playerName, playerBatting, playerNum);
    }

    private static MLBPlayerKey createPlayerKey() {
        System.out.println("Enter the name of the team the player is in");
        String playerTeam = kb.next();
        System.out.println("Enter the Jersey number of the player ");
        int playerNum = kb.nextInt();
        return new MLBPlayerKey(playerNum, playerTeam);
    }

    private static MLBPlayerKey createRandomKey() {
        String playerTeam = "";
        int playerNum = rand.nextInt();
        return new MLBPlayerKey(playerNum, playerTeam);
    }

    private static void initializeEmptyTable() {
        playTable = new Table();
        System.out.println("Complete...");
    }
}
