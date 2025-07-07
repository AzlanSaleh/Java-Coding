import java.util.Scanner;
public class sample {
    public static int factorial(int a) {
        int f = 1;
        for(int i = a;i>0;i--){
            f *= i;
        }
        return f;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x;
        System.out.print("enter a number : ");
         x = scn.nextInt();
        System.out.println("factorial of number is : " + factorial(x));
        scn.close();
    }
}