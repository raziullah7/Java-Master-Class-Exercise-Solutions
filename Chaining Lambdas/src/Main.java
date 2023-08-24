import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // implementing "Convenience Methods" on Function

        String name = "Tim";
        // defining lambda and assigning it to the empty Function<T,R>
        Function<String, String> uCase = String::toUpperCase;
        // calling the method of Function<T,R>
        System.out.println(uCase.apply(name));

        // chaining lambdas using the "andThen()" method
        Function<String, String> lastName = s -> s.concat(" Hortons");
        // chaining here, "andThen()" executes the invoking lambda first
        // the argument second. Here, (1.)uCase lambda  (2.)lastName lambda
        Function<String, String> uCaseLastName = uCase.andThen(lastName);
        // printing the result
        System.out.println(uCaseLastName.apply(name));

        // chaining here, "compose()" executes the the argument first
        // invoking lambda seconds. Here, (1.)lastName lambda  (2.)uCase lambda
        // it's execution order is reverse to that of "andThen()" method
        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        // chaining multiple lambdas anonymously
        Function<String, String[]> f0 = uCase
                .andThen(s -> s.concat(" Hortons"))
                .andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(f0.apply(name)));

        Function<String, String> f1 = uCase
                .andThen(s -> s.concat(" Hortons"))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() + ", " + s[0]);
        System.out.println((f1.apply(name)));

        Function<String, Integer> f2 = uCase
                .andThen(s -> s.concat(" Hortons"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(", ", s))
                .andThen(String::length);
        System.out.println((f2.apply(name)));

        //-------------------------------------------------------------------------
        // implementing "Convenience Methods" on Consumer
        String[] names = {"Ann", "Bob", "Carol"};
        Consumer<String> s0 = s -> System.out.print(s.charAt(0));
        Consumer<String> s1 = System.out::println;

        Arrays.asList(names).forEach(s0
                .andThen(s -> System.out.print(" - "))
                .andThen(s1));

        //-------------------------------------------------------------------------
        // implementing "Convenience Methods" on Predicate
        Predicate<String> p1 = s -> s.equals("TIM");
        Predicate<String> p2 = s -> s.equalsIgnoreCase("Tim");
        Predicate<String> p3 = s -> s.startsWith("T");
        Predicate<String> p4 = s -> s.endsWith("e");

        // using "or()" convenience method
        Predicate<String> combined1 = p1.or(p2);
        System.out.println("Combined1 = " + combined1.test(name));

        // using "and()" convenience method
        Predicate<String> combined2 = p3.and(p4);
        System.out.println("Combined2 = " + combined2.test(name));
        // this also works for printing
        // s1.accept("Combined2 = " + combined2.test(name));

        // using "negate()" convenience method
        Predicate<String> combined3 = p3.and(p4).negate();
        System.out.println("Combined3 = " + combined3.test(name));

        //-------------------------------------------------------------------------
        System.out.println("--------------------------------------------");

        record Person(String firstName, String lastName) {}

        // creating a list
        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("King", "Shark"),
                new Person("Gordon", "Ramsey"),
                new Person("Ali", "Baba"),
                new Person("John", "Wick")
        ));
        // sorting the list and printing it
        list.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        list.forEach(System.out::println);

        System.out.println("--------------------------------------------");

        // another way of sorting
        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);

        System.out.println("--------------------------------------------");

        // sorting with multiple layers
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName));
        list.forEach(System.out::println);

        System.out.println("--------------------------------------------");

        // sorting with multiple layers with reverse order
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName).reversed());
        list.forEach(System.out::println);
    }
}