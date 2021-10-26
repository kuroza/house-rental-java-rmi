import java.time.*;
import java.io.Serializable;

public class Reservation implements Serializable {
    // guest id?
    private int id;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private int noOfGuest;
    private double payment;
    private LocalDateTime bookingDateTime;

    public Reservation(int _id, LocalDateTime _checkIn, LocalDateTime _checkOut, int _noOfGuest, double _payment,
            LocalDateTime _bookingDateTime) {
        id = _id;
        checkIn = _checkIn;
        checkOut = _checkOut;
        noOfGuest = _noOfGuest;
        payment = _payment;
        bookingDateTime = _bookingDateTime;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCheckInDateTime() {
        return checkIn;
    }

    public void setCheckInDateTime(LocalDateTime _checkIn) {
        checkIn = _checkIn;
    }

    public LocalDateTime getCheckOutDateTime() {
        return checkOut;
    }

    public void setCheckOutDateTime(LocalDateTime _checkOut) {
        checkOut = _checkOut;
    }

    public int getNoOfGuest() {
        return noOfGuest;
    }

    public void setNoOfGuest(int _noOfGuest) {
        noOfGuest = _noOfGuest;
    }

    public double getTotalPayment() {
        return payment;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }
}
