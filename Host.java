import java.util.*;
import java.time.*;

public class Host extends Person {
    private List<Listing> listings;

    public Host(String _name, String _address, int _bankAccount, int _phoneNo, LocalDate _dateOfBirth) {
        super.name = _name;
        super.address = _address;
        super.bankAccount = _bankAccount;
        super.phoneNo = _phoneNo;
        super.dateOfBirth = _dateOfBirth;
    }
}
