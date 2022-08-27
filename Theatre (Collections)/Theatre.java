import java.util.ArrayList;
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
    }

    // inner class Seat
    public class Seat {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
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
