package datastructures;

import java.util.Stack;

public class MonotoneStackTest {
    public static void main(String[] args) {
        int[] A = {5, 4, 5, 1, 3, 3, 8, 2};
        Stack<Integer> in_stk = new Stack<>();
        for(int i = 0; i < A.length; i++){
            while(!in_stk.empty() && in_stk.peek() >= A[i]){
                in_stk.pop();
            }
            in_stk.push(A[i]);
        }
        System.out.println(in_stk);
    }

}


