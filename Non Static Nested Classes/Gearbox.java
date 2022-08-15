import java.util.ArrayList;

public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        Gear neutral = new Gear(0, 0.0);
    }

    public void clutchIsIn (boolean in) {
        this.clutchIsIn = in;
    }

    public void addGear (int number, double ratio) {
        if (number > 0 && number <= maxGears)
            this.gears.add(new Gear(number, ratio));
    }

    public void changeGear (int newGear) {
        if (newGear >= 0 && newGear < this.gears.size() && this.clutchIsIn) {
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected.");
        }
        else {
            this.currentGear = 0;
            System.out.println("Grind!");
        }
    }

    public double wheelSpeed (int revs) {
        if (this.clutchIsIn) {
            System.out.println("Scream!");
            return 0.0;
        }
        return revs * gears.get(currentGear).getRatio();
    }

    // This class is only applicable in context with the Gearbox class, hence it's
    // an inner class. All public and private methods of Gearbox are accessible to
    // Gear class (non-static inner class)
    private class Gear {
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed (int revs) {
            return revs * (this.ratio);
        }
    }
}
