package algorithm_2106;
import java.util.Scanner;

public class 직사각형별찍기_Pro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i=0; i<b; i++){
            for(int j=0; j<a; j++){
               System.out.print("*");
            }
            System.out.println();
        }
   
    }
}
