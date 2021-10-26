import java.util.*;
import java.time.*;

public class Guest extends Person {
    public Guest(String _name, String _address, int _bankAccount, int _phoneNo, LocalDate _dateOfBirth) {
        super.name = _name;
        super.address = _address;
        super.bankAccount = _bankAccount;
        super.phoneNo = _phoneNo;
        super.dateOfBirth = _dateOfBirth;
    }
}