import java.util.*;
import java.time.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Rental extends UnicastRemoteObject implements RentalInterface {
    private List<Listing> listings;
    private List<Reservation> reservations;

    public Rental() throws Exception {
        super();
        listings = new ArrayList<Listing>();
        reservations = new ArrayList<Reservation>();
    }

    public void addListing(String title, String location, int noOfRooms, double price, boolean availability) {
        Listing newListing = new Listing(title, location, noOfRooms, price, availability);
        listings.add(newListing);
    }

    public void deleteListing(int id) {
        // search listing id for each listing in listings
        // remove listing from listings
    }

    public void addReservation(LocalDateTime _checkIn, LocalDateTime _checkOut, int _noOfGuest, double _payment,
            LocalDateTime _bookingDateTime) {
        Reservation newReservation = new Reservation(_checkIn, _checkOut, _noOfGuest, _payment, _bookingDateTime);
        reservations.add(newReservation);
    }

    public void deleteReservation() {

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

    // public Reservation getReservation() {
    // }

    // Search

    // Sort
}
