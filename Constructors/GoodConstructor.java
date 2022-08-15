// writing details of rectangle class
// using constructor chaining (putting all the work on the last constructor)
public class GoodConstructor {
    // writing fields
    private int x;
    private int y;
    private int width;
    private int height;

    // 1st constructor for rectangle (no arguments)
    public GoodConstructor() {
        this(0, 0, 0, 0);
    }

    // 2nd constructor for rectangle (2 arguments)
    public GoodConstructor(int width, int height) {
        this(0, 0, width, height);
    }

    // 3rd constructor for rectangle (all arguments)
    public GoodConstructor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
