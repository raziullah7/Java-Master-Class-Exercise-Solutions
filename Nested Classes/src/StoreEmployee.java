import java.util.Comparator;

public class StoreEmployee extends Employee {
    private String store;

    public StoreEmployee() { }
    public StoreEmployee(int empId, String name, int yearStarted, String store) {
        super(empId, name, yearStarted);
        this.store = store;
    }

    @Override
    public String toString() {
        return "%-8s%s".formatted(store, super.toString());
    }

    // inner class
    public class StoreComparator<T extends StoreEmployee> implements Comparator<StoreEmployee> {
        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            // comparing the stores
            int result = o1.store.compareTo(o2.store);
            // if equal, compare the yearStarted
            if (result == 0) {
                // returns the comparison of yearStarted using the parent's Comparator
                return new Employee.EmployeeComparator<>("yearStarted").compare(o1, o2);
            }
            return result;
        }
    }
}
