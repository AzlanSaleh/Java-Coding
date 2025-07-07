package com;
import java.util.Scanner;

// Account Class
class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Default Constructor
    public Account() {
        this.accountNumber = "0000";
        this.accountHolder = "Unknown";
        this.balance = 0.0;
    }

    // Parameterized Constructor
    public Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    // Fully Parameterized Constructor
    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        if (balance >= 1000) {
            this.balance = balance;
        } else {
            this.balance = 1000.0;
        }
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= 1000) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount. Minimum balance must be 1000.");
        }
    }

    // Display Account Details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

// Main Program
public class mt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // First Account: Default Constructor
        Account account1 = new Account();

        // Second Account: Parameterized Constructor
        System.out.print("Enter account number for the second account: ");
        String accountNumber2 = scanner.nextLine();
        System.out.print("Enter account holder name for the second account: ");
        String accountHolder2 = scanner.nextLine();
        Account account2 = new Account(accountNumber2, accountHolder2);

        // Third Account: Fully Parameterized Constructor
        System.out.print("Enter account number for the third account: ");
        String accountNumber3 = scanner.nextLine();
        System.out.print("Enter account holder name for the third account: ");
        String accountHolder3 = scanner.nextLine();
        System.out.print("Enter initial balance for the third account: ");
        double balance3 = scanner.nextDouble();
        Account account3 = new Account(accountNumber3, accountHolder3, balance3);

        // Perform Deposit and Withdraw Operations
        System.out.println("\nPerforming operations on the first account:");
        account1.deposit(0);
        account1.withdraw(0);
        account1.displayAccountDetails();

        System.out.println("\nPerforming operations on the second account:");
        account2.deposit(3000);
        account2.withdraw(500);
        account2.displayAccountDetails();

        System.out.println("\nPerforming operations on the third account:");
        account3.deposit(2000);
        account3.withdraw(1500);
        account3.displayAccountDetails();

        scanner.close();
    }
}