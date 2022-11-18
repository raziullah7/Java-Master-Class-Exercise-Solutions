import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "A compiled, high level, object oriented, platform independent language");
        languages.put("Python", "An interpreted, object-oriented language with dynamic semantics");
        languages.put("Algol", "An algorithmic language");
        // the return value "null" means that a new key value pair is being added
        System.out.println(languages.put("BASIC", "Beginners All Purpose Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        System.out.println(languages.get("Java"));

        // returns the value of key, meaning that the key is being overwritten,
        // and it was previously initiated at some point
        /*System.out.println(languages.put("Java","It just won't end :("));
        System.out.println(languages.get("Java"));*/

        if (languages.containsKey("Java"))
            System.out.println("Java already exists");
        else
            System.out.println(languages.put("Java","It just won't end :("));
    }
}
