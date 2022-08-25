public class Static_Initialization_Block_Test {
    public static final String owner;

    // any "static{...}" blocks will be called before all other blocks

    static {
        owner = "Tim";
        System.out.println("1st Initialization Call of Static Initialization Block Test");
    }

    public Static_Initialization_Block_Test() {
        System.out.println("Constructor of Static Initialization Block Test Called!");
    }

    static {
        System.out.println("2nd Initialization Call of Static Initialization Block Test");
    }

    public void someMethod() {
        System.out.println("someMethod() Called!");
    }

}
