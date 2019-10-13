package MergeSort;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

 
public class ArraryGenerator {
    public static void main(String[] args) throws Exception{
        Scanner s= new Scanner(System.in);
        System.out.println("Enter file name ");
        String filename = s.nextLine();
         System.out.println("Enter number of element of arr :  ");
         int n = s.nextInt();
        try (PrintWriter p = new PrintWriter(new FileOutputStream(filename))) {
            p.print(n+"   ");
            for (int i = 0; i < n; i++) {
                p.print((int)(Math.random()*Integer.MAX_VALUE));
                p.print("   ");
               
           }
        }
         
    }
    
}
