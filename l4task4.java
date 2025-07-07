 class Car{
    String model;
    int year;
    double price;

    Car(){
        model = "Unknown";
        year = 0;
        price = 0.0;
    }
    public void displaycarDetails(){
        System.out.println("Model : " + model);
        System.out.println("Year : " + year);
        System.out.println("Price : " + price);
    }
}
public class l4task4 {
    
    public static void main(String[] args) {
        Car myCar = new Car();          // object
        myCar.displaycarDetails();      // method call


        }
}

