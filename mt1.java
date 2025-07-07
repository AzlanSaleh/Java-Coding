package com;
import java.util.Scanner;

// Car Class
class Car {
    private String brand;
    private String model;
    private double price;

    // Default Constructor
    public Car() {
        this.brand = "Generic";
        this.model = "Basic";
        this.price = 10000.0;
    }

    // Constructor with Brand Only
    public Car(String brand) {
        this.brand = brand;
        this.model = "Basic";
        this.price = 10000.0;
    }

    // Fully Parameterized Constructor
    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        if (price >= 5000) {
            this.price = price;
        } else {
            this.price = 10000.0;
        }
    }

    // Method to Display Car Details
    public void display() {
        System.out.println("Car Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
    }
}

// Main Program
public class mt1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // First Car: Default Constructor
        Car car1 = new Car();

        // Second Car: Constructor with Brand Only
        System.out.print("Enter brand for the second car: ");
        String brand2 = scanner.nextLine();
        Car car2 = new Car(brand2);

        // Third Car: Fully Parameterized Constructor
        System.out.print("Enter brand for the third car: ");
        String brand3 = scanner.nextLine();
        System.out.print("Enter model for the third car: ");
        String model3 = scanner.nextLine();
        System.out.print("Enter price for the third car: ");
        double price3 = scanner.nextDouble();
        Car car3 = new Car(brand3, model3, price3);

        // Display Details of All Cars
        System.out.println("\nDetails of Car 1:");
        car1.display();

        System.out.println("\nDetails of Car 2:");
        car2.display();

        System.out.println("\nDetails of Car 3:");
        car3.display();

        scanner.close();
    }
}
