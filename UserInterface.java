import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserInterface extends Remote {
    public void addUser(String _email, String _password) throws NoSuchAlgorithmException, RemoteException;

    public Boolean checkIfCredentialsMatch(String _email, String _password)
            throws NoSuchAlgorithmException, RemoteException;

    public String getEmail() throws RemoteException;

    public void setEmail(String _email) throws RemoteException;

    public void setPassword(String _password) throws RemoteException;

    public String getname() throws RemoteException;

    public void setname(String _name) throws RemoteException;

    public String getAddress() throws RemoteException;

    public void setAddress(String _address) throws RemoteException;

    public int getBankAccount() throws RemoteException;

    public void setBankAcccount(int _bankAccount) throws RemoteException;

    public int getPhoneNo() throws RemoteException;

    public void setPhoneNo(int _phoneNo) throws RemoteException;

    public List<User> getAllUsers() throws RemoteException;
}
