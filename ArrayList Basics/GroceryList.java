import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item) {
        System.out.println(item + " has been added to the list.");
        groceryList.add(item);
    }

    public void setGroceryItem(int position, String item) {
        groceryList.set(position, item);
    }

    public void printItem() {
        int itemNumber = 1;
        if (groceryList.size() == 0)
            System.out.println("There are no items in the list.");
        for (String item : groceryList) {
            System.out.println(itemNumber++ + ". " + item);
        }
    }

    public String findGroceryItem(String searchItem) {
        // groceryList.contains(searchItem);
        int position = groceryList.indexOf(searchItem);
        if (position >= 0)
            return groceryList.get(position);
        return null;
    }

    public void modifyGroceryItem(int position, String item) {
        System.out.print(groceryList.get(position) + " ");
        groceryList.set(position, item);
        System.out.println("has been replaced by " + item);
    }

    public void removeGroceryItem(int position) {
        groceryList.remove(position);
    }
}