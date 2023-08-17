import java.util.Comparator;

public class Employee {
    // <T extends Employee> sets the upper bound, such that the parent of
    // Employee does not become an inferred type during the cast
    public static class EmployeeComparator<T extends Employee> implements Comparator<Employee> {
        private String sortType;

        public EmployeeComparator() {
            this.sortType = "name";
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {
            if (sortType.equalsIgnoreCase("yearStarted")) {
                return o1.yearStarted - o2.yearStarted;
            }
            return o1.name.compareTo(o2.name);
        }
    }

    private int empId;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public Employee(int empId, String name, int yearStarted) {
        this.empId = empId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(empId, name, yearStarted);
    }
}
