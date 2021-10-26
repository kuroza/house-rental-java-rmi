import java.util.*;
import java.time.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Rental extends UnicastRemoteObject implements RentalInterface {
    private List<Listing> listings;
    private List<Reservation> reservations;

    public Rental() throws Exception {
        listings = new ArrayList<Listing>();
        reservations = new ArrayList<Reservation>();
    }

    public void addListing(int _id, String _title, String _location, int _noOfRooms, double _price,
            boolean _availability) {
        Listing newListing = new Listing(_id, _title, _location, _noOfRooms, _price, _availability);
        listings.add(newListing);
    }

    public void deleteListing(int _id) {
        for (int i = 0; i < listings.size(); i++) {
            if (listings.get(i).getId() == _id)
                listings.remove(i);
        }
    }

    public void addReservation(int _id, LocalDateTime _checkIn, LocalDateTime _checkOut, int _noOfGuest,
            double _payment, LocalDateTime _bookingDateTime) {
        Reservation newReservation = new Reservation(_id, _checkIn, _checkOut, _noOfGuest, _payment, _bookingDateTime);
        reservations.add(newReservation);
    }

    public void deleteReservation(int _id) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getId() == _id)
                reservations.remove(i);
        }
    }

    public Listing getListingByTitle(String _title) {
        for (Listing listing : listings) {
            if (listing.getTitle().equals(_title))
                return listing;
        }
        return null;
    }

    public List<Listing> getAllListings() {
        return listings;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public Reservation getReservationById(int _id) {
        for (Reservation reservation : reservations) {
            if (reservation.getId() == _id)
                return reservation;
        }
        return null;
    }

    // Search

    // Sort
}
