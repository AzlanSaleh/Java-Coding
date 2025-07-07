import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void withdraw(double amount) throws Exception;

    public abstract void deposit(double amount) throws Exception;
}

// Interface TransactionLimit
interface TransactionLimit {
    void checkLimit(double amount) throws Exception;
}

// SavingsAccount Class
class SavingsAccount extends BankAccount implements TransactionLimit {
    private static final double DAILY_LIMIT = 5000.0;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) throws Exception {
        checkLimit(amount);
        if (amount > getBalance()) {
            throw new Exception("Insufficient balance.");
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrawn: " + amount + ", New Balance: " + getBalance());
    }

    @Override
    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Deposit amount must be positive.");
        }
        setBalance(getBalance() + amount);
        System.out.println("Deposited: " + amount + ", New Balance: " + getBalance());
    }

    @Override
    public void checkLimit(double amount) throws Exception {
        if (amount > DAILY_LIMIT) {
            throw new Exception("Withdrawal amount exceeds daily limit of " + DAILY_LIMIT);
        }
    }
}

// CurrentAccount Class
class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 1000.0;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > getBalance() + OVERDRAFT_LIMIT) {
            throw new Exception("Withdrawal exceeds overdraft limit.");
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrawn: " + amount + ", New Balance: " + getBalance());
    }

    @Override
    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Deposit amount must be positive.");
        }
        setBalance(getBalance() + amount);
        System.out.println("Deposited: " + amount + ", New Balance: " + getBalance());
    }
}

// Main Class
public class ass3q2 {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of accounts: ");
        int accountCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < accountCount; i++) {
            try {
                System.out.print("Enter account type (Savings/Current): ");
                String accountType = scanner.nextLine();

                System.out.print("Enter account number: ");
                String accountNumber = scanner.nextLine();

                System.out.print("Enter initial balance: ");
                double balance = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                if (accountType.equalsIgnoreCase("Savings")) {
                    accounts.add(new SavingsAccount(accountNumber, balance));
                } else if (accountType.equalsIgnoreCase("Current")) {
                    accounts.add(new CurrentAccount(accountNumber, balance));
                } else {
                    System.out.println("Invalid account type. Skipping...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        for (BankAccount account : accounts) {
            try {
                System.out.println("Account: " + account.getAccountNumber());
                System.out.print("Enter deposit amount for account " + account.getAccountNumber() + ": ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);

                System.out.print("Enter withdrawal amount for account " + account.getAccountNumber() + ": ");
                double withdrawalAmount = scanner.nextDouble();
                account.withdraw(withdrawalAmount);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("========================");
        System.out.println("Azlan Saleh\nB24F1068AI015");
        System.out.println("========================");
    }
}

