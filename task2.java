import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("enter rows : ");
        int n = scn.nextInt();
        System.out.print("enter columns : ");
        int m = scn.nextInt();
        for(int i=1 ; i <= n;i++){
            
            for(int j=1; j<=m+1;j++){
            System.out.print("* ");
            }
            System.out.println();
         }
        scn.close();
    }
}
