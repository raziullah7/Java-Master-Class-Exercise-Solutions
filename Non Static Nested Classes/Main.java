public class Main {
    public static void main(String[] args) {
        // can't access directly because it's not public access
        /*Gearbox mcLaren = new Gearbox(6);
        // impossible to make an object of Gear class (inner class) without
        // having an instance of the Gearbox class
        Gearbox.Gear first = mcLaren.new Gear(1, 12.3);
        System.out.println(first.driveSpeed(1000));*/

        // using gearBox class with private inner class
        Gearbox rx8 = new Gearbox(6);
        rx8.operateClutch(true);
        rx8.changeGear(1);
        rx8.operateClutch(false);
        System.out.println(rx8.wheelSpeed(1000));
        rx8.changeGear(2);
        System.out.println(rx8.wheelSpeed(3000));
        rx8.operateClutch(true);
        rx8.changeGear(3);
        System.out.println(rx8.wheelSpeed(5000));
    }
}
