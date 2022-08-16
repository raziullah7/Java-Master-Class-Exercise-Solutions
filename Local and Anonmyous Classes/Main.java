import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        // local class, useful if you want to assign exactly the same object
        // to several buttons at the same time
        /*class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("I've been attached");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        }
        btnPrint.setOnClickListener(new ClickListener());*/
        //-----------------------------OR----------------------------------
        // using anonymous class, very useful in a lot of cases
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listen();
    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 0 -> quit = true;
                case 1 -> btnPrint.onClick();
            }
        }
    }
}
