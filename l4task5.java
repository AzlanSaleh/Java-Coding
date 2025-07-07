class bankAccount{
    int accountNumber;
    double balance;

    bankAccount(){
        accountNumber = 0;
        balance = 0.0;
    }

    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        balance -= amount;
    }
}

public class l4task5 {
    public static void main(String[] args) {
        bankAccount b1 = new bankAccount(); 
        b1.deposit(5000);
        b1.withdraw(500);
        System.out.println("Remaining Balance: " + b1.balance);

        }
    }
    

