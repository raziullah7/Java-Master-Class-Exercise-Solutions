import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.print("Enter Your Choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printItem();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("""
                
                Press
                \t0 - To print the choice options.
                \t1 - To print the list of grocery items.
                \t2 - To add an item to the list.
                \t3 - To modify an item in the list.
                \t4 - To remove an item from the list.
                \t5 - To search for an item in the list.
                \t6 - To quit the application.""");
    }

    private static void addItem() {
        System.out.print("Please enter the grocery item : ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    private static void modifyItem() {
        System.out.println("Enter item number : ");
        int itemNum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter replacement item : ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNum-1, newItem);
    }

    private static void removeItem() {
        System.out.print("Enter position of the item : ");
        groceryList.removeGroceryItem(scanner.nextInt() - 1);
    }

    private static void searchForItem() {
        System.out.println("Item to search for : ");
        String searchItem = scanner.nextLine();
        if (groceryList.findGroceryItem(searchItem) != null)
            System.out.println("Found " + searchItem + " in the grocery list.");
        else
            System.out.println(searchItem + " was not found in the grocery list.");
    }

}
