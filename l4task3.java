class rectangle{
    int length;
    int width;
    public  int area(){
        return (length*width);
    }
}
public class l4task3 {
    public static void main(String[] args) {
        rectangle rect = new rectangle();
        rect.length = 5;
        rect.width = 3;
        System.out.println("area : " + rect.area());
    }

    
}
