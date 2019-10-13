package HackerRank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ResultCalc {

    /*
     * Complete the 'finalPrice' function below.
     *
     * The function accepts INTEGER_ARRAY prices as parameter.
     */

    public static void finalPrice(List<Integer> prices) {
        // Write your code here
        List<Integer> listOfOriginalPricedItems = new ArrayList<>(prices.size());
        Integer total = 0;
        for(int i=0; i<prices.size(); i++){
            int amountToDiscount = -1;
            for(int j = i+1; j<prices.size(); j++){
                if(prices.get(i)>=prices.get(j)){
                    amountToDiscount = prices.get(j);
                    break;
                }
            }
            System.out.println(total+ " " );
            System.out.println(i + " "+ prices.get(i)+ " "+amountToDiscount +" " +(prices.get(i)-amountToDiscount));
            if(amountToDiscount >= 0){
                total += (prices.get(i)-amountToDiscount);
            } else {
                total +=prices.get(i);
                listOfOriginalPricedItems.add(i);
            }
        }
        System.out.println(total);
//
        for(Integer i : listOfOriginalPricedItems) {
            System.out.print(i+ " ");
        }
    }

}

public class PricesSumOOfN2 {
    public static void main(String[] args) throws IOException {
        ResultCalc.finalPrice(Arrays.asList(5, 4, 5, 1, 3, 3, 8, 2));
    }
}
