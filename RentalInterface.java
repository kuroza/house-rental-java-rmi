import java.util.*;
import java.time.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RentalInterface extends Remote {
    public void addListing(String title, String location, int noOfRooms, double price, boolean availability)
            throws Exception;

    public void addReservation(LocalDateTime _checkIn, LocalDateTime _checkOut, int _noOfGuest, double _payment,
            LocalDateTime _bookingDateTime) throws Exception;

    public List<Listing> getAllListings() throws Exception;

    public List<Reservation> getAllReservations() throws Exception;

    public Listing getListingByTitle(String _title) throws Exception;
}
