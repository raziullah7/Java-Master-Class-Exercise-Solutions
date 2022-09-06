import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Theatre {
    // fields
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numberOfRows, int seatsPerRow) {
        this.theatreName = theatreName;

        // the last row by casting A (first row) into an integer and
        // getting the last row by adding the total rows - 1 to it
        int lastRow = (int)'A' + (numberOfRows - 1);

        // running a loop from A's ASCII code to the lastRow's ASCII code
        for (char row = 'A'; row <= lastRow; row++) {
            // for assigning numbers to seats and adding to the List (seats)
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    // getter
    public String getTheatreName() {
        return theatreName;
    }

    // for testing
    public void getSeats() {
        for (Seat seat : seats)
            System.out.println(seat.getSeatNumber());
    }

    // method to reserve a seat
    public boolean reserveSeat(String seatNumber) {
        // binary search actual code
        int low = 0;
        int high = seats.size() - 1;
        while (low <= high) {
            // recalculates mid in every iteration
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int compare = midVal.getSeatNumber().compareTo(seatNumber);

            // required item is above the current mid-point
            // move low-point 1 above the current mid-point
            if (compare < 0)
                low = mid + 1;
            // required item is below the current mid-point
            // move high-point 1 below the current mid-point
            else if (compare > 0)
                high = mid - 1;
            // (comapre == 0) match found!
            else
                return midVal.reserve();
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
//----------------------------------------------------------------------------------
/*          // binary search method (much more efficient)
        Seat requestedSeat = new Seat(seatNumber);
        // using the binary search built-in method, which requires the
        // Comparable interface to be implemented for the respective class
        // foundSeat gets an int in the range -1 to 1
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0)
            return seats.get(foundSeat).reserve();
        else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
*/
//----------------------------------------------------------------------------------
/*          // brute force method
        Seat requestedSeat = null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }
        if (requestedSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
        return requestedSeat.reserve();
*/
    }

            // inner class Seat
    // implementing comparable interface to optimize searching
    // otherwise it is like a brute force method, which is only working
    // because Seat class has very few fields. Implementing comparable
    // enables the binary search capabilities of List
    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        // constructor
        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        // implementing compareTo() for the comparable interface
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        // getter
        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " Reserved");
                return true;
            }
            else return false;
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reserved Seat " + seatNumber + " Cancelled");
                return true;
            }
            else return false;
        }
    }
}
