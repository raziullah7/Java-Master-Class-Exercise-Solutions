import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>( List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane", 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Jim", 2018)
        ));

        /*var comparator = new EmployeeComparator<>();
        employees.sort(comparator);*/

        // ascending order for yearStarted
        employees.sort(new Employee.EmployeeComparator<>("yearStarted"));
        for (Employee e : employees) {
            System.out.println(e);
        }
        System.out.println();

        // descending order for yearStarted
        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());
        for (Employee e : employees) {
            System.out.println(e);
        }

//------------------------------------------------------------------------------------------

        System.out.println("\nStore Members : ");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Ronald", 2015, "Target"),
                new StoreEmployee(10515, "Caroline", 2021, "Walmart"),
                new StoreEmployee(10105, "Jenny", 2013, "Meg"),
                new StoreEmployee(10215, "Laura", 2020, "Decent"),
                new StoreEmployee(10322, "Ali", 2018, "Al Rahim")
        ));

        // this actually uses the comparator for the parent class Employee
        // we need an actual instance of the StoreEmployee to use its Comparator
        var comparator = new StoreEmployee.EmployeeComparator<>();
        storeEmployees.sort(comparator);

        // this works
        var genericEmployee = new StoreEmployee();
        var comparator2 = genericEmployee.new StoreComparator<>();
        storeEmployees.sort(comparator2);

        // this also works
        var comparator3 = new StoreEmployee().new StoreComparator<>();
//        storeEmployees.sort(comparator3);

        for (var emp : storeEmployees) {
            System.out.println(emp);
        }

    }
}