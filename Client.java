import java.util.*;
import java.rmi.registry.*;

public class Client {
    public static void main(String args[]) {
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1234);
            RentalInterface rental = (RentalInterface) reg.lookup("server");
            System.out.println("Connected to RMI server\n");

            rental.addListing("Rental3", "Gadong", 2, 50, true);
            rental.addListing("Rental4", "Beribi", 3, 70, true);
            List<Listing> newListings = rental.getAllListings();

            for (Listing listing : newListings) {
                printListing(listing);
            }

            Listing rental3 = rental.getListingByTitle("Rental3");
            if (rental3 != null)
                printListing(rental3);
            else
                System.out.println("Listing doesn't exist");

        } catch (Exception e) {
            System.out.printf(e.toString());
        }
    }

    public static void printListing(Listing listing) {
        System.out.println("Title: " + listing.getTitle());
        System.out.println("Location: " + listing.getLocation());
        System.out.println("No. of rooms: " + listing.getNoOfRooms());
        System.out.println("Price: $" + listing.getPrice());
        System.out.println("Availabile: " + listing.getAvailability());
        System.out.println();
    }
}
