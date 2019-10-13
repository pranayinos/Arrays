package amazon.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {
        int[] input = {9, 5, 2, 1, 6, 13, 8};
        Arrays.stream(input).forEach(value -> System.out.print(value+ " "));
        sort(input);
        System.out.println();
        Arrays.stream(input).forEach(value -> System.out.print(value+ " "));
        System.out.println();
        kLargest(input, 4).stream().forEach(integer -> System.out.print(integer + " "));
        System.out.println();
        kSmallest(input, 4).stream().forEach(integer -> System.out.print(integer + " "));
    }

    public static void sort(int[] input) {
        for(int i = 0; i<input.length-1; i++) {
            for(int j = 0; j<input.length-1-i; j++) {
                if(input[j] > input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
    }

    public static List<Integer> kLargest(int[] input, int k) {
        List<Integer> integers = new ArrayList<>(k);
        for(int i = 0; i<k; i++) {
            for(int j = 0; j<input.length-1-i; j++) {
                if(input[j] > input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
            integers.add(input[input.length-1-i]);
        }

        return integers;
    }

    public static List<Integer> kSmallest(int[] input, int k) {
        List<Integer> integers = new ArrayList<>(k);
        for(int i = 0; i<k; i++) {
            for(int j = 0; j<input.length-1-i; j++) {
                if(input[j] < input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
            integers.add(input[input.length-1-i]);
        }

        return integers;
    }
}
