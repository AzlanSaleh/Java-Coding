
class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;

    public String getProductId() { 
        return productId;
    }
    public void setProductId(String productId) { 
        this.productId = productId;
    }

    public String getProductName() { 
        return productName; 
    }
    public void setProductName(String productName) { 
        this.productName = productName;
    }

    public double getPrice() { 
        return price; 
    }
    public void setPrice(double price) {
        if (price >= 0) 
            this.price = price;
        else 
            System.out.println("Price cannot be negative.");
    }

    public int getQuantity() { 
        return quantity; 
    }
    public void setQuantity(int quantity) {
        if (quantity >= 0) 
            this.quantity = quantity;
        else 
            System.out.println("Quantity cannot be negative.");
    }

    public void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }
}
public class lab6task1 {

   
    public static void main(String[] args) {
        
        Product product = new Product();
  
        product.setProductId("p1768");
        product.setProductName("computer");
        product.setPrice(750.99);
        product.setQuantity(7);
        product.displayProduct();
    }
}


