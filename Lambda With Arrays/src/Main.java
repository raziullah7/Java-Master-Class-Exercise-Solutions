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
    }
}