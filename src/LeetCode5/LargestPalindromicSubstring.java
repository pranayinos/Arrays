package LeetCode5;

/*
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
 */
public class LargestPalindromicSubstring {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "baabad";
        System.out.println(sol.longestPalindrome(input));
    }
}


class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return s;
        }
        int maxLen = 0;
        int palindromeStart = 0;
        int palindromeEnd = 0;
        for(int i = 0; i<s.length(); i++){
            int length = 1;
            int left = i-1;
            int right = i+1;

            while (left>=0 && right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    length=length+2;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if(maxLen<length){
                maxLen = length;
                palindromeStart=left+1;
                palindromeEnd=right-1;
            }
            length = 0;
            left = i;
            right = i+1;
            while (left>=0 && right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    length=length+2;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if(maxLen<length){
                maxLen = length;
                palindromeStart=left+1;
                palindromeEnd=right-1;
            }
        }
        return s.substring(palindromeStart, palindromeEnd+1);
    }
}