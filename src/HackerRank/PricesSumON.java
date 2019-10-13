package HackerRank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Result {

    /*
     * Complete the 'finalPrice' function below.
     *  5, 4, 5, 1, 3, 3, 8, 2
     * The function accepts INTEGER_ARRAY prices as parameter.
     */

    public static void finalPrice(List<Integer> prices) {
        // Write your code here
        List<Integer> discounts = new ArrayList<>(prices.size());
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices.get(i)){
                stack.pop();
            }
            if (!stack.isEmpty()){
                discounts.add(stack.peek());
            }
            else {
                if(i!=0)discounts.add(0);
            }
            stack.push(prices.get(i));
        }

        if(discounts.size()<prices.size()){
            discounts.add(0);
        }
        int total = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = prices.size()-1; i >= 0; i--) {

            total += prices.get(prices.size()-i-1) - discounts.get(i);
            if (discounts.get(i) == 0)
                sb.append(prices.size()-1-i).append(" ");
        }
        System.out.println(total);
        System.out.println(sb.toString());
    }
}

public class PricesSumON {
    public static void main(String[] args) throws IOException {
//        Result.finalPrice(Arrays.asList(2, 3, 1, 2, 4, 2));
//        Result.finalPrice(Arrays.asList(6, 5, 1, 3, 4, 6, 2));
//        Result.finalPrice(Arrays.asList(5, 4, 5, 1, 3, 3, 8, 2));
        Result.finalPrice(Arrays.asList(
                1,
                3,
                3,
                2,
                5));
    }
}
