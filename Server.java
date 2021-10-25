import java.util.*;
import java.time.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Server extends UnicastRemoteObject implements RentalInterface {
    private List<Listing> listings;
    private List<Reservation> reservations;

    public Server() throws Exception {
        listings = new ArrayList<Listing>();
        reservations = new ArrayList<Reservation>();
    }

    public static void main(String args[]) {
        try {
            Registry reg = LocateRegistry.createRegistry(1234);
            reg.rebind("server", new Server());
            System.out.println("Server started");
        } catch (Exception e) {
            System.out.printf(e.toString());
        }
    }

    // Host

    public void addListing(String title, String location, int noOfRooms, double price, boolean availability) {
        Listing newListing = new Listing(title, location, noOfRooms, price, availability);
        listings.add(newListing);
    }

    public void deleteListing(int id) {
        // search listing id for each listing in listings
        // remove listing from listings
    }

    // Guest

    public void addReservation(LocalDateTime _checkIn, LocalDateTime _checkOut, int _noOfGuest, double _payment,
            LocalDateTime _bookingDateTime) {
        Reservation newReservation = new Reservation(_checkIn, _checkOut, _noOfGuest, _payment, _bookingDateTime);
        reservations.add(newReservation);
    }

    public void deleteReservation() {

    }

    // Getters

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
