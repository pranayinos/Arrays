package LeetCode3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters{
    /*
    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
     */
    public static void main(String[] args) {
        String input = "tmmzuxt";
        int output = 3;
        Solution sol = new Solution();
        int result = sol.lengthOfLongestSubstring(input);
        System.out.println(output==result);
        System.out.println(result);
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        int startIndex = 0;
        int maxLength = 0;
        for(int endIndex = 0 ; endIndex < chars.length; endIndex++ ){
            if(!characterIntegerMap.containsKey(chars[endIndex]) || characterIntegerMap.get(chars[endIndex]) < startIndex) {
                characterIntegerMap.put(chars[endIndex], endIndex);
                int currentLength = endIndex - startIndex + 1;
                maxLength = maxLength < currentLength ? currentLength : maxLength;
            } else {
                startIndex = characterIntegerMap.get(chars[endIndex]) + 1;
                characterIntegerMap.put(chars[endIndex], endIndex);
            }
        }
        return maxLength;
    }
}