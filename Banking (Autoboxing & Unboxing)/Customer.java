import java.util.ArrayList;

public class Customer {
    // fields
    private String name;
    private ArrayList<Double> transactions;

    // constructor
    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addTransaction(initialAmount);
    }

    // method add an amount to the transactions ArrayList
    public void addTransaction (double amount) {
        // demonstrating autoboxing
        this.transactions.add(amount);
    }

    // getters
    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
