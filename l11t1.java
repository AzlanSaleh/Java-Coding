import java.util.Scanner;

// Rentable interface
interface Rentable {
    double calculateRent(int days) throws IllegalArgumentException;
    void bookVehicle() throws IllegalStateException;
}

// Abstract Vehicle class  
abstract class Vehicle implements Rentable {
    private String vehicleId;
    private String model;
    private boolean isBooked;

    public Vehicle(String vehicleId, String model) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.isBooked = false;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public boolean isBooked() {
        return isBooked;
    }

    protected void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public void bookVehicle() throws IllegalStateException {
        if (isBooked) {
            throw new IllegalStateException("Vehicle is already booked.");
        }
        setBooked(true);
        System.out.println("Vehicle " + model + " has been booked.");
    }
}

// Car class
class Car extends Vehicle {
    private static final double DAILY_RATE = 50.0;

    public Car(String vehicleId, String model) {
        super(vehicleId, model);
    }

    @Override
    public double calculateRent(int days) throws IllegalArgumentException {
        if (days <= 0) {
            throw new IllegalArgumentException("Rental duration must be greater than 0.");
        }
        return days * DAILY_RATE;
    }
}

// Bike class
class Bike extends Vehicle {
    private static final double DAILY_RATE = 20.0;

    public Bike(String vehicleId, String model) {
        super(vehicleId, model);
    }

    @Override
    public double calculateRent(int days) throws IllegalArgumentException {
        if (days <= 0) {
            throw new IllegalArgumentException("Rental duration must be greater than 0.");
        }
        return days * DAILY_RATE;
    }
}

// Truck class
class Truck extends Vehicle {
    private static final double DAILY_RATE = 100.0;

    public Truck(String vehicleId, String model) {
        super(vehicleId, model);
    }

    @Override
    public double calculateRent(int days) throws IllegalArgumentException {
        if (days <= 0) {
            throw new IllegalArgumentException("Rental duration must be greater than 0.");
        }
        return days * DAILY_RATE;
    }
}

// RentalService class demonstrating polymorphism
class RentalService {
    public void rentVehicle(Vehicle vehicle, int days) {
        try {
            double cost = vehicle.calculateRent(days);
            vehicle.bookVehicle();
            System.out.println("Rental cost for " + vehicle.getModel() + ": $" + cost);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Main class to test the system
public class l11t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalService rentalService = new RentalService();

        while (true) {
            System.out.println("Enter vehicle type (Car, Bike, Truck) or 'exit' to quit:");
            String vehicleType = scanner.nextLine();

            if (vehicleType.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter vehicle ID:");
            String vehicleId = scanner.nextLine();

            System.out.println("Enter vehicle model:");
            String model = scanner.nextLine();

            System.out.println("Enter rental duration in days:");
            int days;
            try {
                days = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for days. Please enter a valid number.");
                continue;
            }

            Vehicle vehicle;
            switch (vehicleType.toLowerCase()) {
                case "car":
                    vehicle = new Car(vehicleId, model);
                    break;
                case "bike":
                    vehicle = new Bike(vehicleId, model);
                    break;
                case "truck":
                    vehicle = new Truck(vehicleId, model);
                    break;
                default:
                    System.out.println("Invalid vehicle type. Please enter Car, Bike, or Truck.");
                    continue;
            }

            rentalService.rentVehicle(vehicle, days);
        }

        scanner.close();
        System.out.println("Thank you for using the rental service.");
    }
}