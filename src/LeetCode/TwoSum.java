package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        LeetCode.Solution sol = new LeetCode.Solution();
        int [] arr = {5,5};
        Arrays.stream(sol.twoSum(arr, 10)).forEach(value -> System.out.print(value+" "));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] arr = new int[2];
        HashMap<Integer, Integer> integerHashMap = new HashMap<>(nums.length);
        for(int i = 0 ; i < nums.length; i++){
            int elementShortByTarget = target - nums[i];
            if(integerHashMap.containsKey(elementShortByTarget))
                return new int[] { integerHashMap.get(elementShortByTarget),i};
            integerHashMap.put(nums[i],i);
        }
        return arr;
    }
}
