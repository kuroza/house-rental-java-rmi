import java.util.*;
import java.time.*;
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

            rental.addReservation(LocalDateTime.of(2021, 10, 31, 14, 00), LocalDateTime.of(2021, 11, 01, 12, 00), 4, 79,
                    LocalDateTime.of(2021, 10, 29, 16, 00));
            List<Reservation> newReservations = rental.getAllReservations();

            for (Reservation reservation : newReservations) {
                printReservation(reservation);
            }
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

    public static void printReservation(Reservation reservation) {
        System.out.println("Check in date and time: " + reservation.getCheckInDateTime());
        System.out.println("Check out date and time: " + reservation.getCheckOutDateTime());
        System.out.println("No. of guests: " + reservation.getNoOfGuest());
        System.out.println("Total payment: $" + reservation.getTotalPayment());
        System.out.println("Booking date and time: " + reservation.getBookingDateTime());
    }
}
