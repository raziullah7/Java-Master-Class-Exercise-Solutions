import java.util.*;

public class Theatre {
    // fields
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    // this simply checks the property being compared, but
    // Comparable checks the objects as equal
    // Comparator is inconsistent with equals
    // Comparable is consistent with equals
    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            // not sure what it does
            // return Double.compare(seat1.getPrice(), seat2.getPrice());

            if (seat1.getPrice() < seat2.getPrice())
                return -1;
            else if (seat1.getPrice() > seat2.getPrice())
                return 1;
            else
                return 0;
        }
    };
    public Theatre(String theatreName, int numberOfRows, int seatsPerRow) {
        this.theatreName = theatreName;

        // the last row by casting A (first row) into an integer and
        // getting the last row by adding the total rows - 1 to it
        int lastRow = (int)'A' + (numberOfRows - 1);

        // running a loop from A's ASCII code to the lastRow's ASCII code
        for (char row = 'A'; row <= lastRow; row++) {
            // for assigning numbers to seats and adding to the List (seats)
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;
                // price of first 3 rows is 14.00
                // (not for first and last 4 seats which are near the edges)
                if (row < 'D' && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00;
                }
                // price after row F is 7.00, also, starting from row D, the price
                // for first and last 4 seats which are near the edges is 7.00
                else if (row > 'F' || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }
                // adding the seat to the List<Seat>
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    // getter
    public String getTheatreName() {
        return theatreName;
    }

    // for testing
    public Collection<Seat> getSeats() {
        return seats;
    }

    // method to reserve a seat
    public boolean reserveSeat(String seatNumber) {
        /*
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
            // (compare == 0) match found!
            else
                return midVal.reserve();
        }
        */

        // originally written
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat > 0) {
            seats.get(foundSeat).reserve();
            System.out.println("Please pay for " + seatNumber);
            return true;
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
        private double price;
        private boolean reserved = false;

        // constructor
        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        // implementing compareTo() for the comparable interface
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        // getters
        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }

        // method to book a reservation
        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " Reserved");
                return true;
            }
            return false;
        }

        // method to cancel a reservation
        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reserved Seat " + seatNumber + " Cancelled");
                return true;
            }
            else
                return false;
        }

        //

    }
}
