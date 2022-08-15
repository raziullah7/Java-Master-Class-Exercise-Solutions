public class Main {
    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(6);
        // impossible to make an object of Gear class (inner class) without
        // having an instance of the Gearbox class
        Gearbox.Gear first = mcLaren.new Gear(1, 12.3);
        System.out.println(first.driveSpeed(1000));
    }
}
