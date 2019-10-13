package otherProblems;

import java.io.*;
import java.util.*;


public class ClosestSumOrDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        String[] inp = br.readLine().split(" ");
        for(int i=0;i<N;i++)
        {
            A[i] = Integer.parseInt(inp[i]);
        }
        int out_ = solve(N, A);
        wr.println(out_);

        wr.close();
        br.close();
    }
    static int solve(int N,int[] A){
        // Your code goes here
        int closest = Integer.MAX_VALUE;
        for(int element : A){
            int absVal = Math.abs(element);
            closest = closest > absVal ? absVal : closest;
        }
        return closest;
    }
}