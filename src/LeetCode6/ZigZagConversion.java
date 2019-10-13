package LeetCode6;

import java.nio.channels.Channel;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I


 */
public class ZigZagConversion {
    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        int numRows = 4;
        String output = "PINALSIGYAHRPI";
        Solution sol = new Solution();
        String result = sol.convert(input, numRows);
        if(result.equals(output))
        {
            System.out.println("Success");
        }
        System.out.println(result);
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if(s==null||s.length()==0||numRows<2){
            return s;
        }
        char[] chars=s.toCharArray();
        StringBuilder[] builders=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            builders[i]=new StringBuilder();
        }
        int temp1,temp2;
        for(int i=0,length=chars.length;i<length;i++){
            temp1=i/(numRows-1);
            temp2=i%(numRows-1);
            if(temp1%2==0){
                builders[temp2].append(chars[i]);
            }
            else{
                builders[numRows-temp2-1].append(chars[i]);
            }
        }
        StringBuilder res=new StringBuilder();
        for(StringBuilder temp:builders){
            res.append(temp);
        }
        return res.toString();
    }
    public String convertBad(String s, int numRows) {
        char [][] charRows = new char[numRows][s.length()];
        int i = 0, k = 0;
        int j = 0;
        for (; i<s.length();){
            for(; j<numRows; j++){
                charRows[j][k] = s.charAt(i);
                ++i;
                if(i>=s.length()){
                    break;
                }
            }
            j--;
            j--;
            for(; j>=0; j--){
                if(i>=s.length()){
                    break;
                }
                charRows[j][++k] = s.charAt(i);
                i++;
            }
            j++;
            j++;
            k++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(char[] c : charRows) {
            for (char c2 : c) {

                if(c2 != '\u0000'){
                    stringBuilder.append(c2);
                }
            }
        }
        return stringBuilder.toString();
    }

    void prettyPrinter(char [][] charRows){
        for(char[] c : charRows){
            for(char c2 : c ){
                System.out.print(c2 + " ");
            }
            System.out.println();
        }
    }
}
