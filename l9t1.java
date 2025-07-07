package com;

import java.util.Scanner;

class ProductSales {
    private String productName;
    private String productCode;
    private int[] dailySales;

    // Constructor
    public ProductSales(String productName, String productCode, int days) {
        this.productName = productName;
        this.productCode = productCode;
        this.dailySales = new int[days];
    }

    // Getter and Setter for productName
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter and Setter for productCode
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    // Method to input sales data
    public void inputSalesData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sales data for " + productName + ":");
        for (int i = 0; i < dailySales.length; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            dailySales[i] = scanner.nextInt();
        }
    }

    // Method to calculate total weekly sales
    public int calculateTotalSales() {
        int total = 0;
        for (int sales : dailySales) {
            total += sales;
        }
        return total;
    }

    // Method to identify the highest sales day
    public int getHighestSalesDay() {
        int maxSales = dailySales[0];
        int day = 1;
        for (int i = 1; i < 7; i++) {
            if (dailySales[i] > maxSales) {
                maxSales = dailySales[i];
                day = i + 1;
            }
        }
        return day;
    }

    // Method to display total and highest sales
    public void displaySalesSummary() {
        System.out.println("Product: " + productName + " (Code: " + productCode + ")");
        System.out.println("Total Weekly Sales: " + calculateTotalSales());
        System.out.println("Highest Sales Day: Day " + getHighestSalesDay());
    }
}

public class l9t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input product details
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product code: ");
        String productCode = scanner.nextLine();

        // Create ProductSales object for a week (7 days)
        ProductSales productSales = new ProductSales(productName, productCode, 7);

        // Input daily sales data
        productSales.inputSalesData();

        // Display sales summary
        productSales.displaySalesSummary();

        scanner.close();
    }
}