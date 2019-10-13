package otherProblems;

import java.util.Scanner;

public class MissingPositiveNumber {
    public static void main(String[] args){
        System.out.println("Please input array length");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] ipArray=new int[length];
        for(int i=0; i<length; i++){
            ipArray[i]=scanner.nextInt();
        }
        StringBuffer  sb = new StringBuffer("goodl boy");
        sb.insert(6, "polls ");
        for(int i=0; i<length; i++){
            System.out.print(" "+ipArray[i]+" ");
        }
    }

//    private static int findMissingNumber(int[] ipArray){
//        for(int i=0; i<ipArray.length; i++){
//            if(ipArray[i]==i+1){
//
//            }else
//        }
//    }
}
