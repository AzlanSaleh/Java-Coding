package com;
// RentalVehicle Class
class RentalVehicle {
    private String vehicleType;
    private double rentalPrice;
    private int rentalDuration;

    // Fully Parameterized Constructor
    public RentalVehicle(String vehicleType, double rentalPrice, int rentalDuration) {
        this.vehicleType = vehicleType;
        this.rentalPrice = rentalPrice;
        this.rentalDuration = rentalDuration;
    }

    // Partial Constructor with Default Rental Price
    public RentalVehicle(String vehicleType, int rentalDuration) {
        this.vehicleType = vehicleType;
        this.rentalDuration = rentalDuration;
        this.rentalPrice = 100.0; // Default rental price
    }

    // Getters and Setters
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    // Method to Display Rental Vehicle Details
    public void displayDetails() {
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Rental Price: $" + rentalPrice);
        System.out.println("Rental Duration: " + rentalDuration + " days");
    }
}

// Main Program
public class mt3 {
    public static void main(String[] args) {
        // Create RentalVehicle using Fully Parameterized Constructor
        RentalVehicle vehicle1 = new RentalVehicle("Car", 200.0, 5);

        // Create RentalVehicle using Partial Constructor
        RentalVehicle vehicle2 = new RentalVehicle("Bike", 3);

        // Display Details of Both Vehicles
        System.out.println("Rental Vehicle 1 Details:");
        vehicle1.displayDetails();

        System.out.println("\nRental Vehicle 2 Details:");
        vehicle2.displayDetails();
    }
}
