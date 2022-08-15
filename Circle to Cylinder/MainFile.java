public class MainFile {
    public static void main(String[] args) {
        Circle c1 = new Circle(-10);
        System.out.println(c1.getRadius());

        Cylinder c2 = new Cylinder(10, 10);
        System.out.println(c2.getVolume());
    }
}
