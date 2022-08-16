public abstract class ListItem {
    // fields
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;
    protected Object value;

    // constructor
    public ListItem(Object value) {
        this.value = value;
    }

    // getters and setters
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }

    // abstract methods
    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);
    abstract int compareTo(ListItem item);
}
