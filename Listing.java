import java.io.Serializable;

public class Listing implements Serializable {
    // id
    private String title;
    private String location;
    private int noOfRooms;
    private double price;
    private boolean availability;

    public Listing(String _title, String _location, int _noOfRooms, double _price, boolean _availability) {
        title = _title;
        location = _location;
        noOfRooms = _noOfRooms;
        price = _price;
        availability = _availability;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public boolean getAvailability() {
        return availability;
    }
}
