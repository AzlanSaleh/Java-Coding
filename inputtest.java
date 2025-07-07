import java.util.Scanner;

public class inputtest {
  
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            System.out.print("enter marks : ");
            int marks = scn.nextInt();
        if(marks >= 90){
                System.out.println("grade : A");
            }
            else if (marks >= 80){ 
                System.out.println("grade : B");
            }
            else if(marks >= 70){ 
                System.out.println("grade : C");
            }
            else if(marks < 70){
                System.out.println("grade : D");
            }
            
            scn.close();
        }
    }
    