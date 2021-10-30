import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Listing extends UnicastRemoteObject implements ListingInterface, Serializable {
    private int id;
    private String title;
    private String location;
    private int noOfRooms;
    private double price;
    private boolean availability;

    public Listing() throws RemoteException {
    }

    public Listing(int _id, String _title, String _location, int _noOfRooms, double _price, boolean _availability)
            throws RemoteException {
        id = _id;
        title = _title;
        location = _location;
        noOfRooms = _noOfRooms;
        price = _price;
        availability = _availability;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String _title) {
        title = _title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String _location) {
        location = _location;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int _noOfRooms) {
        noOfRooms = _noOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double _price) {
        price = _price;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean _availability) {
        availability = _availability;
    }
}
