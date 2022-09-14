import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Dana Cummings", 8, 12);
        // creates a shallow copy
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);

        // results of the shallow copy are shared from the original list
        seatCopy.get(1).reserve();
        if (theatre.reserveSeat("A02")) {
            System.out.println("Please for A02");
        }
        else {
            System.out.println("Seat already reserved");
        }

        // theatre.seats and seatCopy are separate lists, but they
        // share the same objects
//        Collections.reverse(seatCopy);
        Collections.shuffle(seatCopy);
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seats");
        printList(theatre.seats);

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min Seat Number : " + minSeat.getSeatNumber());
        System.out.println("Max Seat Number : " + maxSeat.getSeatNumber());


//        theatre.getSeats();
//        if ((theatre.reserveSeat("D07"))) {
//            System.out.println("Reservation available, please pay");
//        } else {
//            System.out.println("Seat unavailable");
//        }
    }

    // method to print a list given as argument
    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("====================================================");
    }
}
