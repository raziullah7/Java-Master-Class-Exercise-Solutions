public class Cylinder extends Circle {
    //field
    private double height;

    // parameterized constructor
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = (height < 0)? 0 : height;
    }

    // getter
    public double getHeight() {
        return height;
    }

    // volume getter
    public double getVolume() {
        return (super.getArea() * height);
    }
}
