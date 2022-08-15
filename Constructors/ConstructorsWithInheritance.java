// writing details of shape class
class ConstructorsWithInheritance {
    // writing fields
    private int x;
    private int y;

    // writing constructor
    public ConstructorsWithInheritance(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// use constructors in a derived class
class rectangle extends ConstructorsWithInheritance {
    private int weight;
    private int height;

    // 1st constructor (2 arguments)
    public rectangle(int x, int y) {
        this(x, y, 0, 0);
    }

    // 2nd constructor (all arguments)
    public rectangle(int x, int y, int weight, int height) {
        super(x, y);
        this.weight = weight;
        this.height = height;
    }
}
