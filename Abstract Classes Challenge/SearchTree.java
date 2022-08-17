public class SearchTree implements NodeList {
    private ListItem root = null;

    // constructor
    public SearchTree(ListItem root) {
        this.root = root;
    }

    // overriding methods
    @Override
    public ListItem getRoot() {
        return this.root;
    }

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
                    // there's no node to the right, simply add the newItem
                    currentItem.setNext(newItem);
                    return true;
                }
            }

            else if (comparison > 0) {
                // newItem is less than currentItem
                if (currentItem.previous() != null) {
                    // moving left if possible
                    currentItem = currentItem.previous();
                }
                else {
                    // there's no node to the left, add the newItem
                    currentItem.setPrevious(newItem);
                    return true;
                }
            }

            else {  // comparison == 0
                // newItem and currentItem are equal, so don't add
                System.out.println(newItem.getValue() + " is already present, not added");
                return false;
            }
        }

        return false;
    }

    // for removing, we start from the right and keep traversing
    // left until we reach a node with no left child
    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting Item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        // this section only finds the element to be removed
        // the actual removal is done by "performRemoval()" method
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            }
            else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }
            else {
                // we have found the no removing it
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    // method for removing item from the binary tree
    private void performRemoval(ListItem item, ListItem parent) {
        if (item.next() == null) {
            // there is no right tree to the item
            // make parent point to the left tree
            if (parent.next() == item) {
                // item is the right child of the parent
                parent.setNext(item.previous());
            }
            else if (parent.previous() == item) {
                // item is the left child of the parent
                parent.setPrevious(item.previous());
            }
            else {
                // parent itself is the item, which is the root
                this.root = item.previous();
            }
        }
        else if (item.previous() == null) {
            // there is no left tree to the item
            // so make parent point to the right tree
            if (parent.next() == item) {
                // item is the right child of the parent
                // (as there can be more elements to the right)
                parent.setNext(item.next());
            }
            else if (parent.previous() == item) {
                // item is the left child of the parent
                parent.setPrevious(item.next());
            }
            else {
                // parent itself is the item, which is the root
                this.root = item.next();
            }
        }
        else {
            // neither right nor left are null, deletion just became a lot trickier!
            // from the right subtree find the smallest value (i.e., the leftmost)
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            // now put the smallest value into our node to be deleted
            item.setValue(current.getValue());
            // and delete the smallest
            if (leftmostParent == item) {
                // there was no smallest node, so 'current' points to the smallest
                // node (the one that must now be deleted)
                item.setNext(current.next());
            }
            else {
                // set the smallest node's parent to point to the right child
                // (which may or may not be null)
                leftmostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        // recursive method
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
