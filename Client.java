import java.util.*;
import java.time.*;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class Client {
    public static void main(String args[]) {
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1234);
            RentalInterface rental = (RentalInterface) reg.lookup("rental");
            ListingInterface listing = (ListingInterface) reg.lookup("listing");
            ReservationInterface reservation = (ReservationInterface) reg.lookup("reservation");
            UserInterface user = (UserInterface) reg.lookup("user");
            System.out.println("Connected to RMI server\n");

            user.addUser("john@mail.com", "password");
            userLogin(user, "john@mail.com", "password");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void scannerInput() {

    }

    public static void userLogin(UserInterface user, String _email, String _password) {
        try {
            if (user.checkIfCredentialsMatch(_email, _password))
                System.out.println("User " + _email + " has logged in.");
            else
                System.out.println("User email or password do not match. Please try again.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printListing(ListingInterface iListing) {
        try {
            System.out.println("Listing id: " + iListing.getId());
            System.out.println("Title: " + iListing.getTitle());
            System.out.println("Location: " + iListing.getLocation());
            System.out.println("No. of rooms: " + iListing.getNoOfRooms());
            System.out.println("Price: $" + iListing.getPrice());
            System.out.println("Availabile: " + iListing.getAvailability());
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printReservation(ReservationInterface reservation) {
        try {
            System.out.println("Reservation id: " + reservation.getId());
            System.out.println("Check in date and time: " + reservation.getCheckInDateTime());
            System.out.println("Check out date and time: " + reservation.getCheckOutDateTime());
            System.out.println("No. of guests: " + reservation.getNoOfGuest());
            System.out.println("Total payment: $" + reservation.getTotalPayment());
            System.out.println("Booking date and time: " + reservation.getBookingDateTime());
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printUser(UserInterface user) {
        try {
            System.out.println("Email: " + user.getEmail());
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printAllUsers(UserInterface user) {
        try {
            List<User> newUsers = user.getAllUsers();
            System.out.println("Printing all users: ");
            for (UserInterface userX : newUsers) {
                printUser(userX);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printAllListings(RentalInterface rental) {
        try {
            List<ListingInterface> newListings = rental.getAllListings();
            System.out.println("Printing all listings: ");
            for (ListingInterface listing : newListings) {
                printListing(listing);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printAllReservations(RentalInterface rental) {
        try {
            List<ReservationInterface> newReservations = rental.getAllReservations();
            if (newReservations.size() != 0) { // should I check if it's not empty?
                System.out.println("Printing all reservations: ");
                for (ReservationInterface reservation : newReservations)
                    printReservation(reservation);
            } else {
                System.out.println("Reservation list is empty\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void sortAndPrintListingsByTitle(RentalInterface rental) {
        try {
            List<ListingInterface> newListings = rental.getAllListings();
            newListings = rental.sortListingsByTitle(newListings);
            System.out.println("Sorting listings by title:\n");
            for (ListingInterface listing : newListings) {
                printListing(listing);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void sortAndPrintListingsById(RentalInterface rental) {
        try {
            List<ListingInterface> newListings = rental.getAllListings();
            newListings = rental.sortListingsById(newListings);
            System.out.println("Sorting listings by ID:\n");
            for (ListingInterface listing : newListings) {
                printListing(listing);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void run() {
        // rental.addListing(3, "EZ Rental3", "Gadong", 2, 50, true);
        // rental.addListing(4, "Venice Rental4", "Beribi", 3, 70, true);
        // rental.addListing(5, "LaFlame Rental5", "Rimba", 2, 60, true);
        // rental.addListing(6, "Almera Rental6", "Jerudong", 1, 30, true);

        // Listing rental5 = rental.getListingByTitle("Rental5");
        // if (rental5 != null)
        // printListing(rental5);
        // else
        // System.out.println("Listing doesn't exist\n");

        // rental.addReservation(1, LocalDateTime.of(2021, 10, 31, 14, 00),
        // LocalDateTime.of(2021, 11, 01, 12, 00), 4,
        // 79, LocalDateTime.of(2021, 10, 29, 16, 00));
        // printAllReservations(rental);
        // rental.deleteReservation(1);
        // printAllReservations(rental);
        // printReservation(rental.getReservationById(1));

        // rental.deleteListing(3);
        // printAllListings(rental);
        // sortAndPrintListingsByTitle(rental);
        // sortAndPrintListingsById(rental);
    }
}
