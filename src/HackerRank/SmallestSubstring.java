package HackerRank;

import java.io.*;
import java.util.*;


public class SmallestSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String S = br.readLine();

        int out_ = getSmallestSubString(S);
        wr.println(out_);

        wr.close();
        br.close();
    }

    static int getSmallestSubString(String S) {
        // Write your code here
        int distinctCharCount = 0;
        Map<Character, Boolean> charExistance = new HashMap<>();

        for(char c : S.toCharArray()){
            if(!charExistance.containsKey(c)){
                charExistance.put(c, true);
                distinctCharCount++;
            }
        }

        int start = 0;
        int min_len = Integer.MAX_VALUE;

        int count = 0;
        Map<Character, Integer> currentCount =  new HashMap<>();
        for (int j=0; j<S.length(); j++)
        {
            if(currentCount.containsKey(S.charAt(j))){
                currentCount.put(S.charAt(j), currentCount.get(S.charAt(j)) + 1);
            }

            if (currentCount.containsKey(S.charAt(j)) && currentCount.get(S.charAt(j)) == 1){
                count++;
            }

            if (count == distinctCharCount)
            {
                while (currentCount.get(S.charAt(start)) > 1) {
                    if (currentCount.get(S.charAt(start)) > 1){
                        currentCount.put(S.charAt(start), currentCount.get(S.charAt(start)) - 1);
                    }
                    start++;
                }

                int len_window = j - start + 1;
                if (min_len > len_window)
                {
                    min_len = len_window;
                }
            }
        }

        return min_len;
    }
}