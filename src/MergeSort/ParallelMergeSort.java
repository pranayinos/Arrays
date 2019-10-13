package MergeSort;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class ParallelMergeSort {
    public static int[] a;
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
    
    public static class  Thread1 extends Thread{
        int l,h;
        public Thread1(int l,int h) {
            this.l=l;
            this.h=h;
        }
        
        @Override
        public void run(){

            mergeSort(a, l, h);
            
        }
    
}

     public static void sort()throws Exception{
          a= loadArray("array.txt");
         Thread1 th1 = new Thread1(0,a.length/4);
         Thread1 th2 = new Thread1((a.length/4)+1,a.length/2);
         Thread1 th3 = new Thread1((a.length/2)+1,3*(a.length)/4);
         Thread1 th4 = new Thread1((3*(a.length)/4)+1,a.length-1);
//         Thread2 th2 = new Thread2();
        
         th1.start();
         th2.start();
         th3.start();
         th4.start();
         th1.join();
         th2.join();
         th3.join();
         th4.join();
         mergeInPlace(a,0, a.length/4, a.length/2);
         mergeInPlace(a,(a.length/2)+1, ((a.length-1)+((a.length/2)+1))/2, a.length-1);
         mergeInPlace(a,0,a.length/2, a.length-1);
         storeArray(a,"PMS.txt");
     }
     public static void main(String[] args)throws Exception{
        long t1 = System.currentTimeMillis();
         sort();
         
        long t2 = System.currentTimeMillis();
        System.out.println("time   " + (t2 - t1));
    }
}
