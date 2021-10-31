import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.util.*;

public class User extends UnicastRemoteObject implements UserInterface {
    int id;
    String name;
    String email;
    String password;
    String address;
    int bankAccount;
    int phoneNo;
    LocalDate dateOfBirth;

    List<User> users;

    public User() throws RemoteException {
        users = new ArrayList<User>();
    }

    public User(String _email, String _password) throws RemoteException {
        email = _email;
        password = _password;
    }

    public void addUser(String _email, String _password) throws NoSuchAlgorithmException, RemoteException {
        if (checkIfEmailNotUsed(users, _email)) {
            String hashedPassword = hashWith256(_password);
            users.add(new User(_email, hashedPassword));
        }
    }

    private static String hashWith256(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] byteOfPassword = password.getBytes(StandardCharsets.UTF_8);
        byte[] hashedByteArray = digest.digest(byteOfPassword);
        String encoded = Base64.getEncoder().encodeToString(hashedByteArray);
        return encoded;
    }

    private static Boolean checkIfEmailNotUsed(List<User> users, String _email) {
        if (users != null) {
            for (User user : users) {
                if (user.getEmail().equals(_email))
                    return false;
            }
        }
        return true;
    }

    public Boolean checkIfCredentialsMatch(String _email, String _password) throws NoSuchAlgorithmException {
        for (User user : users) {
            if (user.getEmail().equals(_email)) {
                String hashedPassword = hashWith256(_password);
                if (user.getPassword().equals(hashedPassword))
                    return true;
            }
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String _email) {
        email = _email;
    }

    private String getPassword() {
        return password;
    }

    public void setPassword(String _password) {
        password = _password;
    }

    public String getname() {
        return name;
    }

    public void setname(String _name) {
        name = _name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String _address) {
        address = _address;
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAcccount(int _bankAccount) {
        bankAccount = _bankAccount;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int _phoneNo) {
        phoneNo = _phoneNo;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
