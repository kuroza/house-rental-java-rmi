import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface RentalInterface extends Remote {
    public void addListing(String title, String location, int noOfRooms, double price, boolean availability)
            throws Exception;

    public List<Listing> getAllListings() throws Exception;

    public List<Reservation> getAllReservations() throws Exception;

    public Listing getListingByTitle(String _title) throws Exception;

    public void setName(String name) throws Exception;

    public String getName() throws Exception;
}
