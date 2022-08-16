// under the hood workings of the LinkedList datatype
public class MyLinkedList implements NodeList {
    // fields
    private ListItem root = null;

    // constructor
    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    // overriding methods from interface
    @Override
    public ListItem getRoot() {
        return this.root;
    }

    // method to add an item to a LinkedList
    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // the list was empty, so this item becomes the head of the list
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;

        // looping through all the ListItems
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);

            if (comparison < 0) {
                // newItem greater than currentItem
                if (currentItem.next() != null) {
                    // move to next item and perform the checks in the next iteration again
                    currentItem = currentItem.next();
                }
                else {
                    // end of the list reached, simply insert newItem
                    /*
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    */
                    // shortcut
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            }

            else if (comparison > 0) {
                // newItem is less than currentItem
                if (currentItem.previous() != null) {
                    // placing the newItem before the currentItem
                    /*
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                    */
                    // shortcut
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                }
                else {
                    // the Item without a previous is the root
                    /*
                    this.root.setPrevious(newItem);
                    newItem.setNext(this.root);
                    */
                    // shortcut
                    this.root.setPrevious(newItem).setNext(this.root);
                    this.root = newItem;
                }
                // in both cases, success is achieved, so returning true
                return true;
            }

            else {
                // newItem and currentItem are equal(duplicate)
                System.out.println(newItem.getValue() + " is already present, not added");
                return false;
            }
        }

        return false;
    }

    // method to remove an item from a LinkedList
    @Override
    public boolean removeItem(ListItem item) {
        if (item != null)
            System.out.println("Deleting item " + item.getValue());

        // starting from the first element
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                // equal (item to be removed is found)
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                }
                else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            }
            else if (comparison < 0) {
                // have not searched the whole list yet
                currentItem = currentItem.next();
            }
            else { // comparison > 0
                // we are at an item greater than the item to be deleted
                // hence, unable to find the required item in the list
                return false;
            }
        }
        // we have reached the end of the list without
        // being able to find the item to be deleted
        // (it means that the item does not exist)
        return false;
    }

    // method to traverse the LinkedList
    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        }
        else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
