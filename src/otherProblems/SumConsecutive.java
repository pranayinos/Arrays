package otherProblems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class SumConsecutive {


        // Complete the countSubSequence function below.
        static int countSubSequence(List<Integer> inputSeq, int targetSum) {

            int count = 0;
            int j = 0;
            int tempSum = 0;
            int i = 0;
            while(j<inputSeq.size()){
                int lastNumInSum = inputSeq.get(j);
                if(i<(inputSeq.size())){
                    tempSum += inputSeq.get(i);
                    System.out.println("i "+i + "| lastNumInSum " + lastNumInSum + "| tempSum " + tempSum + "| j " + j  );
                    i++;
                }else{
                    j++;
                }
                if(tempSum == targetSum) {
                    count++;
                    tempSum = tempSum - lastNumInSum;
                    j++;
                } else if(tempSum > targetSum){
                    tempSum = tempSum - lastNumInSum;
                    j++;
                }
            }
            return count;

        }

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int inputSeqCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> inputSeqTemp = new ArrayList<>();

            IntStream.range(0, inputSeqCount).forEach(i -> {
                try {
                    inputSeqTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            List<Integer> inputSeq = inputSeqTemp.stream()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            int targetSum = Integer.parseInt(bufferedReader.readLine().trim());

            int res = countSubSequence(inputSeq, targetSum);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }

}
