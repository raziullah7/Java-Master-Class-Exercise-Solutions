import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class BasicLinkedList {
    public static void main(String[] args) {
        LinkedList<String> importantPlaces = new LinkedList<>();
        addInOrder(importantPlaces, "Lahore");
        addInOrder(importantPlaces, "Karachi");
        addInOrder(importantPlaces, "Quetta");
        addInOrder(importantPlaces, "Peshawar");
        addInOrder(importantPlaces, "Sialkot");

        // printList(importantPlaces);
        visit(importantPlaces);

    }

    private static void printList(LinkedList<String> importantPlaces) {
        // using iterator to loop through the linked list
        Iterator<String> i = importantPlaces.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("==============================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        // using a special kind of iterator for lists
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // it's a match (element and new city are equal)
                System.out.println(newCity + " is already added to the destination list");
                return false;
            }
            else if (comparison > 0) {
                // new city is greater than list element (in ASCII)
                stringListIterator.previous();
                // going back to the previous to element to place the new element in its place
                stringListIterator.add(newCity);
                return true;
            }
            else {      // if (comparison < 0)
                // list item is greater than the new city
                // do nothing and add the new city outside the loop
            }
        }
        // we added it outside the loop because if the new city is greater than any of
        // the cities in the list, then the new city will be added in its correct
        // alphabetical order. Else it will be added at the end of the list
        stringListIterator.add(newCity);
        return true;
    }

    public static void visit (LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean goingForward = true;
        boolean quit = false;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
            return;
        }
        else {
            // first element gets selected here
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            
            switch (action) {

                case 0 -> {
                    System.out.println("Holidays over");
                    quit = true;
                }

                case 1 -> {
                    // this check is used to set the direction of iterations forwards
                    if (!goingForward) {
                        if (listIterator.hasNext())
                            listIterator.next();
                        goingForward = true;
                    }
                    if (listIterator.hasNext())
                        System.out.println("Now visiting " + listIterator.next());
                    else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                }

                case 2 -> {
                    // this check is used to set the direction of iterations backwards
                    if (goingForward) {
                        if (listIterator.hasPrevious())
                            listIterator.previous();
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious())
                        System.out.println("Now visiting " + listIterator.previous());
                    else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                }

                case 3 -> printMenu();
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                Available Actions :
                Press 0 - to quit
                1 - to go to next city
                2 - to go to previous city
                3 - print available options
                """);
    }
}
