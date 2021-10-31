import java.util.*;
import java.rmi.RemoteException;
import java.time.*;

public class Host extends User {
    public Host(String _email, String _password) throws RemoteException {
        super.email = _email;
        super.password = _password;
    }

    public Host(String _name, String _address, int _bankAccount, int _phoneNo, LocalDate _dateOfBirth)
            throws RemoteException {
        super.name = _name;
        super.address = _address;
        super.bankAccount = _bankAccount;
        super.phoneNo = _phoneNo;
        super.dateOfBirth = _dateOfBirth;
    }
}
