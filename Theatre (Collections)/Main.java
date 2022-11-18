import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Dana Cummings", 8, 12);
        /*// creates a shallow copy, which simply points to the original list items
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);*/

        // results of the shallow copy are shared from the original list
        // seatCopy.get(1).reserve();
        theatre.reserveSeat("D12");
        /*if (theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        }
        else {
            System.out.println("Seat already reserved");
        }*/

        theatre.reserveSeat("B13");

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);
        /*if (theatre.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        }
        else {
            System.out.println("Seat already reserved");
        }*/
/*
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

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);

        theatre.getSeats();
        if ((theatre.reserveSeat("D07"))) {
            System.out.println("Reservation available, please pay");
        } else {
            System.out.println("Seat unavailable");
        }*/
    }

    // method to print a list given as argument
    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println("\n====================================================");
    }

    // method to perform bubble sort manually
    // merge sort requires far more memory than bubble sort
    // merge sort is faster than bubble sort
    /*public static void sortList(List<? extends Theatre.Seat> list){
    *//*
    The '?' is known as a wildcard. It allows you to broaden the scope of the
    parameter type, in this case Theatre.Seat. In other words, instead of narrowing
    the parameter type to just objects of type Theatre.Seat you could include
    possible subtypes of Theatre.Seat for the List in question
    *//*
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    // swapping the contents of i-th and j-th elements
                    *//*Theatre.Seat someSeat = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, someSeat);*//*
                    Collections.swap(list, i, j);
                }
            }
        }
    }*/
}
