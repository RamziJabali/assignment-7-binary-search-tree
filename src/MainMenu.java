import java.util.*;

public class MainMenu {
    private static Scanner kb = new Scanner(System.in);

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

    }

    private static void manipulateSingleTable() {
        Table playTable;
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

    }

    private static void showTree() {

    }

    private static void getAverageLevel() {

    }

    private static void getSize() {

    }

    private static void getHeightOfTable() {

    }

    private static void findItem() {

    }

    private static void deleteItemFromTable() {
    }

    private static void insertItemInTable() {

    }

    private static void initializeEmptyTable() {

    }
}
