import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
// Person record is a static nested class of Main class
    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Main.Person("Lucy", "Van Pelt"),
                new Main.Person("Sally", "Brown"),
                new Main.Person("Linus", "Sebastian"),
                new Main.Person("Peppermint", "Patty"),
                new Main.Person("Charlie", "White")
        ));

        // using anonymous class (sorting by lastName)
        var comparatorLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        };
        people.sort(comparatorLastName);
        System.out.println(people);

        // using lambda expression (sorting by firstName)
        // people.sort((Comparator.comparing(o -> o.firstName)));
        people.sort(((o1, o2) -> o1.firstName.compareTo(o2.firstName)));
        System.out.println(people);

        // the limitation of lambda expression is that it can only be used for
        // Functional Interfaces or Single Abstract Method(SAM) i.e., interfaces
        // that only have a single abstract method.
        // the annotation @FunctionalInterface which represents that the following
        // interface has only one 1 abstract method (will give an error otherwise).
    }
}