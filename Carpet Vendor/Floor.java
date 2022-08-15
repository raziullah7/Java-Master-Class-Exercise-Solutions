public class Floor {
    private double width;
    private double length;

    // constructor
    public Floor(double width, double length) {
        // check for width
        if (width < 0)
            this.width = 0;
        else
            this.width = width;
        // check for length
        if (length < 0)
            this.length = 0;
        else
            this.length = length;
    }

    // area calculating method
    public double getArea() {
        return length * width;
    }
}