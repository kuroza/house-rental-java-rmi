import java.util.*;
import java.time.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Rental extends UnicastRemoteObject implements RentalInterface {
    private List<ListingInterface> listings;
    private List<ReservationInterface> reservations;

    public Rental() throws RemoteException {
        listings = new ArrayList<ListingInterface>();
        reservations = new ArrayList<ReservationInterface>();
    }

    public void addListing(int _id, String _title, String _location, int _noOfRooms, double _price,
            boolean _availability) throws RemoteException {
        ListingInterface newListing = new Listing(_id, _title, _location, _noOfRooms, _price, _availability);
        listings.add(newListing);
    }

    public void deleteListing(int _id) {
        try {
            for (int i = 0; i < listings.size(); i++) {
                if (listings.get(i).getId() == _id)
                    listings.remove(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addReservation(int _id, LocalDateTime _checkIn, LocalDateTime _checkOut, int _noOfGuest,
            double _payment, LocalDateTime _bookingDateTime) {
        try {
            ReservationInterface newReservation = new Reservation(_id, _checkIn, _checkOut, _noOfGuest, _payment,
                    _bookingDateTime);
            reservations.add(newReservation);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteReservation(int _id) {
        try {
            for (int i = 0; i < reservations.size(); i++) {
                if (reservations.get(i).getId() == _id)
                    reservations.remove(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ListingInterface getListingByTitle(String _title) throws RemoteException {
        for (ListingInterface listing : listings) {
            if (listing.getTitle().equals(_title))
                return listing;
        }
        return new Listing();
    }

    public ListingInterface getListingById(int _id) throws RemoteException {
        for (ListingInterface listing : listings) {
            if (listing.getId() == _id)
                return listing;
        }
        return new Listing();
    }

    public List<ListingInterface> getAllListings() {
        if (listings != null) {
            return listings;
        }
        return Collections.emptyList();
    }

    public List<ReservationInterface> getAllReservations() {
        if (reservations != null) {
            return reservations;
        }
        return Collections.emptyList();
    }

    public ReservationInterface getReservationById(int _id) throws RemoteException {
        for (ReservationInterface reservation : reservations) {
            if (reservation.getId() == _id)
                return reservation;
        }
        return new Reservation();
    }

    public List<ListingInterface> sortListingsByTitle(List<ListingInterface> listings) {
        Collections.sort(listings, new ListingTitleComparator());
        return sortListings(listings);
    }

    public List<ListingInterface> sortListingsById(List<ListingInterface> listings) {
        Collections.sort(listings, new ListingIdComparator());
        return sortListings(listings);
    }

    public List<ListingInterface> sortListings(List<ListingInterface> listings) {
        List<ListingInterface> sortedListings = new ArrayList<ListingInterface>();
        for (ListingInterface listing : listings) {
            sortedListings.add(listing);
        }
        return sortedListings;
    }
}
