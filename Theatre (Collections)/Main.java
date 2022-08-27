import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Dana Cummings", 8, 12);
//        theatre.getSeats();
        if ((theatre.reserveSeat("D07"))) {
            System.out.println("Reservation available, please pay");
        } else {
            System.out.println("Seat unavailable");
        }
    }
}
