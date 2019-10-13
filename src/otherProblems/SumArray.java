package otherProblems;

import java.util.Scanner;

public class SumArray {

    public static void main(String[] args) {
        //System.out.println("Sub-array with given sum in an unsorted array");
        Scanner inputScanner = new Scanner(System.in);
        int numberOfInputs = inputScanner.nextInt();
        int sizeOfArray;
        for(int i = numberOfInputs; i>0; i--){
            sizeOfArray = inputScanner.nextInt();
            int desiredSumValue = inputScanner.nextInt();
            int[] inputArray = scanInputArray(sizeOfArray, inputScanner);
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
        int n = inputArray.length-1;
        int j = 0;
        boolean found = false;
        while(i<n  && j<n){
            int tempSum = sum(inputArray, i, j);
            if(tempSum == desiredSumValue){
                System.out.println(i+1 + " "+ j+1);
                found = true;
                break;
            } else if(tempSum<desiredSumValue){
                j++;
            }else if(tempSum>desiredSumValue){
                i++;
            }
        }
        if(!found){
            System.out.println(-1);
        }
    }

    private static int sum(int[] inputArray, int startIndex, int endIndex){
        int sum = 0;
        for (int i=startIndex; i<endIndex; i++){
            sum= sum+inputArray[i];
        }
        return sum;
    }

}
