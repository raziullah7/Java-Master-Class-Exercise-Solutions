public class Main {
    public static void main(String[] args) {
        // old java formatting technique (using escape sequences)
        String bullets = "Print a Bulleted List :" +
                "\n\u2022 First Bullet" +
                "\n\t\u2022 Sub Bullet";
        System.out.println(bullets + "\n");

        // new java formatting technique (introduces in JDK 15)
        String textBlock = """
                Print a Bulleted List :
                \u2022 First Bullet
                    \u2022 Sub Bullet""";
        System.out.println(textBlock + "\n");

        // another way to print stuff in Java
        int age = 35;
        // %n is line separator
        System.out.printf("The age is : %d%n", age);
        int yearOfBirth = 2023 - age;
        System.out.printf("Age: %d\tBirth Year: %d%n", age, yearOfBirth);
    }
}