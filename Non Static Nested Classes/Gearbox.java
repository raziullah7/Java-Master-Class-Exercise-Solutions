import java.util.ArrayList;

public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        Gear neutral = new Gear(0, 0.0);
    }

    // This class is only applicable in context with the Gearbox class, hence it's
    // an inner class. All public and private methods of Gearbox are accessible to
    // Gear class (non-static inner class)
    public class Gear {
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double driveSpeed (int revs) {
            return revs * (this.ratio);
        }
    }
}
