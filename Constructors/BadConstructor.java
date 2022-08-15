// writing details of rectangle class
// causes duplication of code, hence a bad approach
public class BadConstructor {
    // writing fields
    private int x;
    private int y;
    private int width;
    private int height;

    // 1st constructor for rectangle (no arguments)
    public BadConstructor() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    // 2nd constructor for rectangle (2 arguments)
    public BadConstructor(int width, int height) {
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
    }

    // 3rd constructor for rectangle (2 arguments)
    public BadConstructor(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
