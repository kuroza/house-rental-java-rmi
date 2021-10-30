import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface ReservationInterface extends Remote {
    public int getId() throws RemoteException;

    public LocalDateTime getCheckInDateTime() throws RemoteException;

    public void setCheckInDateTime(LocalDateTime _checkIn) throws RemoteException;

    public LocalDateTime getCheckOutDateTime() throws RemoteException;

    public void setCheckOutDateTime(LocalDateTime _checkOut) throws RemoteException;

    public int getNoOfGuest() throws RemoteException;

    public void setNoOfGuest(int _noOfGuest) throws RemoteException;

    public double getTotalPayment() throws RemoteException;

    public LocalDateTime getBookingDateTime() throws RemoteException;
}
