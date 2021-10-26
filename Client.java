import java.util.*;
import java.time.*;
import java.rmi.registry.*;

public class Client {
    public static void main(String args[]) {
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1234);
            RentalInterface rental = (RentalInterface) reg.lookup("rental");
            System.out.println("Connected to RMI server\n");

            rental.addListing(3, "Rental3", "Gadong", 2, 50, true);
            rental.addListing(4, "Rental4", "Beribi", 3, 70, true);
            printAllListings(rental);

            // check if rental exists
            Listing rental5 = rental.getListingByTitle("Rental5");
            if (rental5 != null)
                printListing(rental5);
            else
                System.out.println("Listing doesn't exist\n");

            rental.addReservation(1, LocalDateTime.of(2021, 10, 31, 14, 00), LocalDateTime.of(2021, 11, 01, 12, 00), 4,
                    79, LocalDateTime.of(2021, 10, 29, 16, 00));
            printAllReservations(rental);

            rental.deleteReservation(1);
            printAllReservations(rental);

            rental.deleteListing(3);
            printAllListings(rental);
        } catch (Exception e) {
            System.out.printf(e.toString());
        }
    }

    public static void printListing(Listing listing) {
        System.out.println("Listing id: " + listing.getId());
        System.out.println("Title: " + listing.getTitle());
        System.out.println("Location: " + listing.getLocation());
        System.out.println("No. of rooms: " + listing.getNoOfRooms());
        System.out.println("Price: $" + listing.getPrice());
        System.out.println("Availabile: " + listing.getAvailability());
        System.out.println();
    }

    public static void printReservation(Reservation reservation) {
        System.out.println("Reservation id: " + reservation.getId());
        System.out.println("Check in date and time: " + reservation.getCheckInDateTime());
        System.out.println("Check out date and time: " + reservation.getCheckOutDateTime());
        System.out.println("No. of guests: " + reservation.getNoOfGuest());
        System.out.println("Total payment: $" + reservation.getTotalPayment());
        System.out.println("Booking date and time: " + reservation.getBookingDateTime());
        System.out.println();
    }

    public static void printAllListings(RentalInterface rental) {
        try {
            List<Listing> newListings = rental.getAllListings();
            for (Listing listing : newListings) {
                printListing(listing);
            }
        } catch (Exception e) {
            System.out.printf(e.toString());
        }
    }

    public static void printAllReservations(RentalInterface rental) {
        try {
            List<Reservation> newReservations = rental.getAllReservations();
            if (newReservations.size() != 0) {
                for (Reservation reservation : newReservations)
                    printReservation(reservation);
            } else {
                System.out.println("Reservation list is empty\n");
            }
        } catch (Exception e) {
            System.out.printf(e.toString());
        }
    }
}
