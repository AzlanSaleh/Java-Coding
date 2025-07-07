package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for returnable products
interface Returnable {
    void returnPolicy();
}

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Abstract methods
    public abstract void calculateDiscount();
    public abstract void displayDetails();
}

// Electronics class
class Electronics extends Product implements Returnable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public void calculateDiscount() {
        System.out.println("Discounted Price (10% off): " + (getPrice() * 0.9));
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics - ID: " + getProductId() + ", Name: " + getName() + ", Price: " + getPrice());
    }

    @Override
    public void returnPolicy() {
        System.out.println("Returnable within 15 days.");
    }
}

// Clothing class
class Clothing extends Product implements Returnable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public void calculateDiscount() {
        System.out.println("Discounted Price (20% off): " + (getPrice() * 0.8));
    }

    @Override
    public void displayDetails() {
        System.out.println("Clothing - ID: " + getProductId() + ", Name: " + getName() + ", Price: " + getPrice());
    }

    @Override
    public void returnPolicy() {
        System.out.println("Returnable within 7 days.");
    }
}

// Groceries class
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public void calculateDiscount() {
        System.out.println("Discounted Price (5% off): " + (getPrice() * 0.95));
    }

    @Override
    public void displayDetails() {
        System.out.println("Groceries - ID: " + getProductId() + ", Name: " + getName() + ", Price: " + getPrice());
    }
}

// Main class
public class l10t3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int numberOfProducts = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println("\nEnter details for product " + (i + 1) + ":");
            System.out.println("1. Electronics  2. Clothing  3. Groceries");
            System.out.print("Select product type: ");
            int productType = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter Product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Product Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            switch (productType) {
                case 1:
                    products.add(new Electronics(productId, name, price));
                    break;
                case 2:
                    products.add(new Clothing(productId, name, price));
                    break;
                case 3:
                    products.add(new Groceries(productId, name, price));
                    break;
                default:
                    System.out.println("Invalid product type. Skipping this product.");
            }
        }

        System.out.println("\n--- Product Details ---");
        for (Product product : products) {
            product.displayDetails();
            product.calculateDiscount();

            if (product instanceof Returnable) {
                ((Returnable) product).returnPolicy();
            }
            System.out.println();
        }

        scanner.close();
    }
}