public class Carpet {
    private double cost;

    // constructor
    public Carpet(double cost) {
        this.cost = cost < 0? 0: cost;
    }

    // cost returner
    public double getCost() {
        return cost;
    }
}