public class Main {
    public static void main(String[] args) {
        String birthDate = "02/08/2001";
        int startIndex = birthDate.indexOf("2001");
        System.out.println("Starting Index : " + startIndex);
        System.out.println("Birth Year : " + birthDate.substring(startIndex));

        String newDate = String.join("/", "02", "08", "2001");
        System.out.println("newDate : " + newDate);

        newDate = "02";
        newDate = newDate.concat("/");
        newDate = newDate.concat("08");
        newDate = newDate.concat("/");
        newDate = newDate.concat("2001");
        System.out.println("newDate : " + newDate);

        // method chaining
        newDate = "02";
        newDate = newDate.concat("/").concat("08").concat("/").concat("2001");
        System.out.println("newDate : " + newDate);

        // replace methods
        System.out.println(newDate.replace('/', '-'));
        System.out.println(newDate.replaceFirst("/", "--"));
        System.out.println(newDate.replaceAll("/", "---"));

        // repeat and indent
        System.out.println("ABC\n".repeat(3));
        System.out.println("-".repeat(20));

        System.out.println("ABC\n".repeat(3).indent(8));
        System.out.println("-".repeat(20));

        System.out.println("    ABC\n".repeat(3).indent(-2));
        System.out.println("-".repeat(20));
    }
}