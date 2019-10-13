package MergeSort;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;



public class SeqanialMergeSort {
    
    public static int[] loadArray(String filename) throws Exception{
        Scanner s= new Scanner(new FileInputStream(filename));
        int n = s.nextInt();
        int []b = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            b[i]= s.nextInt();
        }
        return b;
    }
    public static void storeArray(int []a,String filename) throws Exception
    {
        PrintWriter p = new PrintWriter(new FileOutputStream(filename));
            p.print(a.length+"   ");
            for (int i = 0; i < a.length; i++) {
                p.print(a[i]);
                p.print("   ");
               
           }
            p.close();
    }
    public static void mergeInPlace(int [] a,int l,int m,int h){
        int right = m+1;
        while(l<=m && right <=h){
        if (a[l]<=a[right]){
            l++;
        }
        else{
            int temp = a[right];
               System.arraycopy(a, l, a, l+1, right-l);
               a[l]= temp;
               l++;
               right++;
               m++;
               
        }}
    }
    public static void mergeSort(int []a ,int l,int h){
        if(h>l){
            int m = (l+h)/2;
            mergeSort(a, l, m);
            mergeSort(a, m+1,h);
            mergeInPlace(a, l, m, h);
        }
    }
    public static void main(String[] args) throws Exception{
        long t1 = System.currentTimeMillis();
      int a[]=  loadArray("array.txt");
        mergeSort(a, 0,a.length-1);
        storeArray(a, "SMS.txt");
        
        long t2 = System.currentTimeMillis();
        System.out.println("time   " + (t2 - t1));
    }
}
