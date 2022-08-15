import java.util.ArrayList;

public class Branch {
    // fields
    private String name;
    private ArrayList<Customer> customers;

    // constructor
    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // method to create a new customer
    public boolean newCustomer(String customerName, double initialAmount) {
        if(findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    // method to add a transaction to an existing customer
    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    // method to check if a customer exists or not (using name)
    private Customer findCustomer(String customerName) {
        for (Customer checkedCustomer : customers) {
            if (checkedCustomer.getName().equals(customerName))
                return checkedCustomer;
        }
        return null;
    }
}
