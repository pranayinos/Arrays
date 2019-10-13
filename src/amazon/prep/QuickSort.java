package amazon.prep;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] input = {7, 4, 2, 8, 9, 1, 7};
//        Integer[] input = {9, 5, 2, 1, 6, 13, 8};
        Arrays.stream(input).forEach(value -> System.out.print(value+ " "));
        sort(input);
        System.out.println();
        Arrays.stream(input).forEach(value -> System.out.print(value+ " "));
    }

    public static void sort(Integer[] input) {
        mergeSort(input, 0, input.length-1);
    }

    public static void mergeSort(Integer[] arr, int l, int r) {
        if(l>=r){
            return;
        }
//        System.out.println("l= "+ l+ " r= "+ r);
        int partition = partition(arr, l, r);
        mergeSort(arr, l, partition-1);
        mergeSort(arr, partition+1, r);
    }

    public static int partition(Integer[] arr,  int l, int r) {
        Integer pivot = arr[l];
        Integer pivotIndex = l;
        int i=l+1, j=r;
        while (i<=j) {
            if(arr[i] > pivot && arr[j] <= pivot) {
                swap(arr, i, j);
                i++;j--;
            } else if(arr[i] < pivot) {
                i++;
            } else if(arr[j] > pivot) {
                j--;
            }
        }
        swap(arr, j, pivotIndex);
        return j;
    }

    private static void swap(Integer[] arr,  int l, int r) {
        Integer temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
