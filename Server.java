import java.util.*;
import java.time.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Server {
    public static void main(String args[]) {
        try {
            Registry reg = LocateRegistry.createRegistry(1234);
            reg.rebind("rental", new Rental());
            System.out.println("Server started");
        } catch (Exception e) {
            System.out.printf(e.toString());
        }
    }
}
