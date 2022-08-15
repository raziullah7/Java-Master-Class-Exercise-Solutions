public class Calculator {
    private Floor floor;
    private Carpet carpet;

    // constructor
    public Calculator(Floor floor, Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    // final cost calculator
    public double getTotalCost() {
        return (floor.getArea() * carpet.getCost());
    }
}
