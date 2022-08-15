public class Car {
    // fields
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    // constructor
    public Car(int cylinders, String name) {
        engine = true;
        this.cylinders = cylinders;
        this.name = name;
        wheels = 4;
    }

    // getters and setters
    public int getCylinders() {
        return this.cylinders;
    }

    public String getName() {
        return this.name;
    }

    // custom behaviour methods
    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine()";
    }

    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate()";
    }

    public String brake() {
        return getClass().getSimpleName() + " ->  brake()";
    }

}
