import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"
        ));

        for (String myString : list) {
            System.out.print(myString + "    ");
        }

        System.out.println("\n----------------------------------------------");

        list.forEach(myString -> System.out.print(myString + "    "));

        System.out.println("\n----------------------------------------------");

        String prefix = "XD ";
        list.forEach(myString -> {
            char first = myString.charAt(0);
            System.out.println(prefix + myString + " means " + first);
        });

        // if a variable is used in a lambda expression, it must be final
        // not be changed after the use in the lambda expression
//        prefix = "Wait wait wait! This won't work! It's already final!!!";

        System.out.println("\n----------------------------------------------");

        // using "Integer" instead of "int" because the generics don't work with
        // primitive types. So, we use the wrapper classes like Integer, Double, etc
        var result = calculator((Integer a, Integer b) -> a + b, 5, 2);
    }

    // making a function that takes a lambda expression along with its
    // arguments and returns the result of the passed lambda expression
    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("Result of Operation : " + result);
        return result;
    }
}