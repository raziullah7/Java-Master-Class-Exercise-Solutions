public class Circle {
    // field
    private double radius;

    // parameterized constructor
    public Circle(double radius) {
        this.radius = (radius < 0)? 0 : radius;
    }

    // getter
    public double getRadius() {
        return radius;
    }

    // area getter
    public double getArea() {
        return radius * radius * Math.PI;
    }
}
