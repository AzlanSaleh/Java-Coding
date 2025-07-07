import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Flight class
abstract class Flight {
    private String flightNumber;
    private String destination;
    private int totalSeats;
    private int bookedSeats;

    public Flight(String flightNumber, String destination, int totalSeats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }

    public void bookSeat() throws FlightFullException {
        if (bookedSeats >= totalSeats) {
            throw new FlightFullException("Flight is fully booked.");
        }
        bookedSeats++;
    }

    public void cancelSeat() throws InvalidSeatException {
        if (bookedSeats <= 0) {
            throw new InvalidSeatException("No seats to cancel.");
        }
        bookedSeats--;
    }

    public abstract void displayFlightDetails();
}

// DomesticFlight class
class DomesticFlight extends Flight {
    public DomesticFlight(String flightNumber, String destination, int totalSeats) {
        super(flightNumber, destination, totalSeats);
    }

    @Override
    public void displayFlightDetails() {
        System.out.println("Domestic Flight - Number: " + getFlightNumber() + ", Destination: " + getDestination() + ", Available Seats: " + getAvailableSeats());
    }
}

// InternationalFlight class
class InternationalFlight extends Flight {
    public InternationalFlight(String flightNumber, String destination, int totalSeats) {
        super(flightNumber, destination, totalSeats);
    }

    @Override
    public void displayFlightDetails() {
        System.out.println("International Flight - Number: " + getFlightNumber() + ", Destination: " + getDestination() + ", Available Seats: " + getAvailableSeats());
    }
}

// Bookable interface
interface Bookable {
    void bookFlight(Flight flight) throws FlightFullException;
}

// Cancellable interface
interface Cancellable {
    void cancelFlight(Flight flight) throws InvalidSeatException;
}

// Customer class
abstract class Customer {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public abstract void displayCustomerDetails();
}

// RegularCustomer class
class RegularCustomer extends Customer implements Bookable, Cancellable {
    public RegularCustomer(String customerId, String name) {
        super(customerId, name);
    }

    @Override
    public void bookFlight(Flight flight) throws FlightFullException {
        flight.bookSeat();
        System.out.println("Regular customer " + getName() + " booked a seat on flight " + flight.getFlightNumber());
    }

    @Override
    public void cancelFlight(Flight flight) throws InvalidSeatException {
        flight.cancelSeat();
        System.out.println("Regular customer " + getName() + " canceled a seat on flight " + flight.getFlightNumber());
    }

    @Override
    public void displayCustomerDetails() {
        System.out.println("Regular Customer - ID: " + getCustomerId() + ", Name: " + getName());
    }
}

// VIPCustomer class
class VIPCustomer extends Customer implements Bookable, Cancellable {
    public VIPCustomer(String customerId, String name) {
        super(customerId, name);
    }

    @Override
    public void bookFlight(Flight flight) throws FlightFullException {
        flight.bookSeat();
        System.out.println("VIP customer " + getName() + " booked a seat on flight " + flight.getFlightNumber());
    }

    @Override
    public void cancelFlight(Flight flight) throws InvalidSeatException {
        flight.cancelSeat();
        System.out.println("VIP customer " + getName() + " canceled a seat on flight " + flight.getFlightNumber());
    }

    @Override
    public void displayCustomerDetails() {
        System.out.println("VIP Customer - ID: " + getCustomerId() + ", Name: " + getName());
    }
}

// Custom exceptions
class FlightFullException extends Exception {
    public FlightFullException(String message) {
        super(message);
    }
}

class InvalidSeatException extends Exception {
    public InvalidSeatException(String message) {
        super(message);
    }
}

// Main class to test the system
public class l11t3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create flights
        Flight domesticFlight = new DomesticFlight("DF101", "New York", 2);
        Flight internationalFlight = new InternationalFlight("IF202", "London", 3);

        // Create customers
        System.out.println("Enter Regular Customer ID:");
        String regularCustomerId = scanner.nextLine();
        System.out.println("Enter Regular Customer Name:");
        String regularCustomerName = scanner.nextLine();
        Customer regularCustomer = new RegularCustomer(regularCustomerId, regularCustomerName);

        System.out.println("Enter VIP Customer ID:");
        String vipCustomerId = scanner.nextLine();
        System.out.println("Enter VIP Customer Name:");
        String vipCustomerName = scanner.nextLine();
        Customer vipCustomer = new VIPCustomer(vipCustomerId, vipCustomerName);

        // Display flight details
        domesticFlight.displayFlightDetails();
        internationalFlight.displayFlightDetails();

        // Booking and canceling flights
        try {
            System.out.println("Booking a seat for Regular Customer on Domestic Flight...");
            ((Bookable) regularCustomer).bookFlight(domesticFlight);

            System.out.println("Booking a seat for VIP Customer on Domestic Flight...");
            ((Bookable) vipCustomer).bookFlight(domesticFlight);

            System.out.println("Attempting to overbook Domestic Flight...");
            ((Bookable) vipCustomer).bookFlight(domesticFlight); // This will throw FlightFullException
        } catch (FlightFullException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Canceling a seat for Regular Customer on Domestic Flight...");
            ((Cancellable) regularCustomer).cancelFlight(domesticFlight);

            System.out.println("Attempting to cancel another seat for Regular Customer...");
            ((Cancellable) regularCustomer).cancelFlight(domesticFlight); // This will throw InvalidSeatException
        } catch (InvalidSeatException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Display updated flight details
        domesticFlight.displayFlightDetails();

        scanner.close();
    }
}