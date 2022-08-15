import java.util.ArrayList;

public class Bank {
    // fields
    private String name;
    private ArrayList<Branch> branches;

    // constructor
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    // method to add a new branch
    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    // method to add a customer to a specific branch
    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null)
            return branch.newCustomer(customerName, initialAmount);
        return false;
    }

    // method to add a transaction to a specific customer in a specific branch
    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null)
            return branch.addCustomerTransaction(customerName, amount);
        return false;
    }

    // method to check if a branch exists or not (using name)
    private Branch findBranch(String branchName) {
        for (Branch checkedBranch : branches) {
            if (checkedBranch.getName().equals(branchName))
                return checkedBranch;
        }
        return null;
    }

    // method to return a list of customers for the branch
    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName() + " : ");
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer : " + branchCustomer.getName() + "[" + (i+1) + "]");
                if (showTransactions) {
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    System.out.println("Transactions :");
                    for (int j = 0; j < transactions.size(); j++)
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                }
            }
            return true;
        }
        else
            return false;
    }
}
