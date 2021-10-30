import java.util.*;
import java.time.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RentalInterface extends Remote {
        public void addListing(int _id, String _title, String _location, int _noOfRooms, double _price,
                        boolean _availability) throws RemoteException;

        public void addReservation(int _id, LocalDateTime _checkIn, LocalDateTime _checkOut, int _noOfGuest,
                        double _payment, LocalDateTime _bookingDateTime) throws RemoteException;

        public List<ListingInterface> getAllListings() throws RemoteException;

        public List<ReservationInterface> getAllReservations() throws RemoteException;

        public ListingInterface getListingByTitle(String _title) throws RemoteException;

        public ReservationInterface getReservationById(int _id) throws RemoteException;

        public void deleteListing(int _id) throws RemoteException;

        public void deleteReservation(int _id) throws RemoteException;

        public List<ListingInterface> sortListingsByTitle(List<ListingInterface> listings) throws RemoteException;

        public List<ListingInterface> sortListingsById(List<ListingInterface> listings) throws RemoteException;
}
