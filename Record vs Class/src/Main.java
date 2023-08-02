public class Main {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            DSAStudent s = new DSAStudent("S9230" + i,
                    switch (i) {
                        case 1 -> "Mary";
                        case 2 -> "Carol";
                        case 3 -> "John";
                        case 4 -> "Sara";
                        case 5 -> "Noah";
                        default -> "Unknown";
                    },
                    "05/11/1985",
                    "Java Masterclass");
            System.out.println(s);
        }

        DSAStudent recordStd = new DSAStudent("S92306", "Walter", "01/07/1983", "Meth Production Masterclass");
        Student classStd = new Student("S92307", "Jessie", "17/04/1993", "Meth Distribution Masterclass");

        // difference in access
        System.out.println(recordStd.name() + " is in " + recordStd.classList());
        System.out.println(classStd.getName() + " is in " + classStd.getClassList());

    }
}