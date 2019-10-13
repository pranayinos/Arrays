package LeetCode4;

/*
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
 */
public class MedianOf2Arrays {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num1 = {1,3};
        int[] num2 = {2,4};
        System.out.println(sol.findMedianSortedArrays(num1,num2));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthOfFirstArray = nums1.length;
        int lengthOfSecondArray = nums2.length;
        int sizeOfMergedArray = lengthOfFirstArray + lengthOfSecondArray;
        int[] mergedArray = new int[sizeOfMergedArray];
        for(int  i=0, j=0; i+j < sizeOfMergedArray; ){
            int temp, temp1, temp2;
            temp = 0;
            temp1 = i;
            temp2 = j;
            if(i<lengthOfFirstArray && j<lengthOfSecondArray){
                if(nums1[i] < nums2[j]) {
                    temp = nums1[i];
                    i++;
                } else {
                    temp = nums2[j];
                    j++;
                }
            } else if(i==lengthOfFirstArray){
                temp = nums2[j];
                j++;
            } else if (j==lengthOfSecondArray){
                temp = nums1[i];
                i++;
            }
            mergedArray[temp1+temp2] = temp;
        }
        double median;

        if(sizeOfMergedArray%2==0){

            median = (((double)(mergedArray[(sizeOfMergedArray/2)-1]+mergedArray[(sizeOfMergedArray/2)]))/2d);
        }else {
            median = mergedArray[sizeOfMergedArray/2];
        }
        return median;
    }
}
