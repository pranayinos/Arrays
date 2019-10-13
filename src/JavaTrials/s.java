package JavaTrials;//What will be the result of compiling and running the following Java program?

import java.util.*;

class TipTop
{
    static final Integer i1 = 1;
    final Integer i2 = 2;
    Integer i3 = 3;

    public static void main(String[] args)
    {
        System.out.print(countNonUnique(Arrays.asList(1,2,3,4,5,6,7,8)));

    }
    public static int countNonUnique(List<Integer> numbers) {
        // Write your code here
        Map<Integer, Integer> occuredMap = new HashMap();
        int countOfRepeated = 0;
        for(Integer number : numbers){
            Integer count = occuredMap.get(number);
            if(count != null){
                occuredMap.put(number, ++count);
            }
            else{
                occuredMap.put(number, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry :occuredMap.entrySet()){
            if(entry.getValue()>1) {
                countOfRepeated++;
            }
        }
    return countOfRepeated;
    }
}
