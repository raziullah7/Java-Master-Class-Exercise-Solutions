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
            // for numbers to seats
            for (int seatNum = 1; seatNum < seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    // inner class Seat
    public class Seat {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }
    }
}
