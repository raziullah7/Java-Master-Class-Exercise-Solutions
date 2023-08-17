import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem {
    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int stdCount = 10;

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < stdCount; i++) {
            students.add(new Student());
        }
        printMoreLists(students);
//        printList(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < stdCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        printMoreLists(lpaStudents);
//        printList(lpaStudents);

        // making use of testList()
        testList(new ArrayList<>(List.of("Ann", "Barry", "Charlie")));
        testList(new ArrayList<>(List.of(1, 2, 3)));
        System.out.println();

        // checking the QueryItem and QueryList
        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("Course", "Python");
        printMoreLists(matches);

        // testing the static getMatches method
        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
//        var students2021_2 = QueryList.<Student>getMatches(new ArrayList<>(), "YearStarted", "2021");
        printMoreLists(students2021);

        // does not meet all the requirements, hence error
        // this is because Employee is a subtype of QueryList but not a subtype of
        // Student, therefore it causes an error
//        QueryList<Employee> employeeQueryList = new QueryList<>();
    }

    public static void printMoreLists(List<? extends Student> students) {
        /*'super' for lower bound*/    /*'extends' for upper bound*/
        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
         System.out.println();
    }

    // to handle both Sting and Integer, the overloading does not work with <>
    // so we use the ? wildcard and use instanceof operator to decide
    public static void testList(List<?> list) {
        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            }
            else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

    /*public static <T extends Student> void printList(List<T extends Student> students) {
        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }*/
}