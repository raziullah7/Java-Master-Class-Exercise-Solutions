public class Main {
    public static void main(String[] args) {
        Static_Initialization_Block_Test SIBTest = new Static_Initialization_Block_Test();
        SIBTest.someMethod();
        System.out.println();
        System.out.println("Owner is " + Static_Initialization_Block_Test.owner);
    }
}
