import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class PlainOld {
    private static int last_id = 1;

    private int id;

    public PlainOld() {
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld Object: id = " + id);
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "Anna", "Bob", "Chunk", "Robert"
        ));
        // replacing lambda with method reference
//        list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);

        // replacing lambdas with method references
//        calculator((a, b) -> a + b, 10, 20);
//        calculator((a, b) -> a + b, 3.5, 7.5);
        calculator(Integer::sum, 10, 20);
        calculator(Double::sum, 3.5, 7.5);

        System.out.println("---------------------------------------------------------");

        // making a Supplier object of type PlainOld, but this does not run the
        // code in the constructor of PlainOld. That code is run when the specified
        // methods of Supplier get executed i.e., Supplier.get() method
        Supplier<PlainOld> reference0 = () -> new PlainOld();
        Supplier<PlainOld> reference1 = PlainOld::new;

//        PlainOld newPojo = reference1.get();

        System.out.println("Getting array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);

        // concatenating 2 strings
        calculator((s1, s2) -> s1 + s2, "Hello ", "World");
        // here, when we convert the lambda "(s1, s2) -> s1.concat(s2)" to its
        // equivalent method reference, it implicitly uses 2 arguments, and it
        // must also be passed to a Functional Interface that takes 2 parameters
        calculator((s1, s2) -> s1.concat(s2), "Hello ", "World");
        calculator(String::concat, "Hello ", "World");

        // to demonstrate this, I will use BinaryOperator and UnaryOperator
        // interfaces on String::concat method reference
        BinaryOperator<String> test1 = String::concat;
        // UnaryOperator<String> test2 = String::concat;
        // UnaryOperator throws an error that "Instance Methods cannot be
        // called on Reference Types (static types)"

        // this works because there is only one argument needed
        UnaryOperator<String> test2 = String::toUpperCase;

        // in case of BinaryOperator, the first argument is the one which
        // the concat method is invoked and the second argument is passed
        // in it. The First Argument is therefore called "Unbounded Receiver"
        // while the Second Argument is called "Bounded Receiver"

        // invoking the above defined objects
        System.out.println("---------------------------------------------------------");
        System.out.println(test1.apply("Hello ", "World!"));
        System.out.println(test2.apply("Hello "));

        // we can use transform method for testing as it accepts an object
        System.out.println("---------------------------------------------------------");
        String result = "Yellow".transform(test2);
        System.out.println("Result = " + result);

        result = result.transform(String::toLowerCase);
        System.out.println("Result = " + result);

        Function<String, Boolean> f0 = String::isEmpty;
        boolean resultBoolean = result.transform(f0);
        System.out.println("Result = " + resultBoolean);

    }

    private static <T> void calculator(BinaryOperator<T> function, T val1, T val2) {
        T result = function.apply(val1, val2);
        System.out.println("Result: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}