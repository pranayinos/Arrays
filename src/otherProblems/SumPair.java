package otherProblems;

import java.util.Scanner;

public class SumPair {

    public static void main(String[] args) {
        //System.out.println("Pair with given sum in a sorted array");
        Scanner inputScanner = new Scanner(System.in);
        int numberOfInputs = inputScanner.nextInt();
        int sizeOfArray;
        for(int i = numberOfInputs; i>0; i--){
            sizeOfArray = inputScanner.nextInt();
            int[] inputArray = scanInputArray(sizeOfArray, inputScanner);
            int desiredSumValue = inputScanner.nextInt();
            findSumPair(desiredSumValue, inputArray);
        }
    }

    private static int[] scanInputArray(int sizeOfArray, Scanner inputScanner){
        int[] inputArray = new int[sizeOfArray];
        for(int i = 0; i<sizeOfArray; i++){
            inputArray[i] = inputScanner.nextInt();
        }
        return inputArray;
    }

    private static void findSumPair(int desiredSumValue, int[] inputArray){
        int i = 0;
        int j = inputArray.length-1;
        boolean found = false;
        while (i<j) {
            int tempSum = inputArray[i] + inputArray[j];
            if (tempSum == desiredSumValue) {
                System.out.println(inputArray[i] + " " + inputArray[j] + " " + desiredSumValue);
                found = true;
                i++;
                j--;
            } else if (tempSum > desiredSumValue) {
                j--;
            } else if (tempSum < desiredSumValue) {
                i++;
            }
        }
        if(!found){
            System.out.println(-1);
        }
    }

//    private static int binarySearch(int elementToFind, int[] inputArray){
//        int sizeOfArray = inputArray.length;
//        if(sizeOfArray==0 || inputArray[0] > elementToFind || inputArray[sizeOfArray-1] < elementToFind ){
//            return;
//        }
//    }

}
