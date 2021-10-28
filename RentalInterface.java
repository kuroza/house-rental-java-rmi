import java.util.*;
import java.time.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RentalInterface extends Remote {
        public void addListing(int _id, String _title, String _location, int _noOfRooms, double _price,
                        boolean _availability) throws Exception;

        public void addReservation(int _id, LocalDateTime _checkIn, LocalDateTime _checkOut, int _noOfGuest,
                        double _payment, LocalDateTime _bookingDateTime) throws Exception;

        public List<Listing> getAllListings() throws Exception;

        public List<Reservation> getAllReservations() throws Exception;

        public Listing getListingByTitle(String _title) throws Exception;

        public void deleteListing(int _id) throws Exception;

        public void deleteReservation(int _id) throws Exception;

        public List<Listing> sortListingsByTitle(List<Listing> listings) throws Exception;
}
