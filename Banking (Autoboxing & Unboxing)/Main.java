public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("National Bank of Pakistan");
        bank.addBranch("Lahore");

        bank.addCustomer("Lahore", "Tim", 123987.77);
        bank.addCustomer("Lahore", "Mike", 44500.75);
        bank.addCustomer("Lahore", "Pierce", 200000.00);

        bank.addCustomerTransaction("Lahore", "Tim", 1239);
        bank.addCustomerTransaction("Lahore", "Mike", 4450);
        bank.addCustomerTransaction("Lahore", "Pierce", 20000);

        bank.listCustomers("Lahore", true);
    }
}
