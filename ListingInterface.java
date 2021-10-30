import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ListingInterface extends Remote {
    public int getId() throws RemoteException;

    public String getTitle() throws RemoteException;

    public void setTitle(String _title) throws RemoteException;

    public String getLocation() throws RemoteException;

    public void setLocation(String _location) throws RemoteException;

    public int getNoOfRooms() throws RemoteException;

    public void setNoOfRooms(int _noOfRooms) throws RemoteException;

    public double getPrice() throws RemoteException;

    public void setPrice(double _price) throws RemoteException;

    public boolean getAvailability() throws RemoteException;

    public void setAvailability(boolean _availability) throws RemoteException;
}
