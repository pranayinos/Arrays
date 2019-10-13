import org.omg.CORBA.MARSHAL;

import java.util.*;

public class Amazon {
    /*
    Name: Pranay Kumar

    Given a set of integers, write three functions that work for the below three scenarios:
    Each function should return the output pair(s)
    Each function should return the output pair(s)
    Input Array: (-20, 4, -2, -4, 8, 6, 22, 10, -12)
    Function#1. find the pair(s) which gives sum equal to zero ; example output: (-4, 4)
    Function#2. find the pair(s) which gives non-zero sum whose distance is closest to 0; example output: (10, -12), (-2, 4), etc
    Function#3. find the pair(s) which gives sum whose distance is farthest from 0; example output: (-20, -12), (22, 10)

    Type functional production-ready code for the question in the comment in programming language of your choice.
    This platform does not let you compile or test the code.
    You can manually go through your code for the example test cases.
    No need to submit. You can close the window when you are done.

    */
    static class Pair {
        private final int left;
        private final int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }

        int sum() {
            return right + left;
        }

        @Override
        public String toString() {
            return "Pair{" + left + ", " + right + '}';
        }
    }

    public static List<Pair> zeroSumPair(List<Integer> input) {
        //Ignoring duplicate entries in the list
        List<Pair> result = new ArrayList(input.size() / 2);
        Set<Integer> inputSet = new HashSet(input.size());
        for (int i = 0; i < input.size(); i++) {
            int current = input.get(i);
            if (inputSet.contains(-1 * current)) {
                result.add(new Pair(current, -1 * current));
            } else {
                inputSet.add(current);
            }
        }
        return result;
    }



    public static List<Pair> closestToZeroSumPair(List<Integer> input) {
        List<Pair> result = new ArrayList(input.size() / 2);
        int minDistanceToZero = Integer.MAX_VALUE;
        for (int i = 0; i < input.size(); i++) {
            for (int j = i; j < input.size(); j++) {
                int currentDistance = Math.abs((input.get(i) + (input.get(j))));
                if (currentDistance != 0) {
                    if (currentDistance < minDistanceToZero) {
                        minDistanceToZero = currentDistance;
                        result.clear();
                        result.add(new Pair(input.get(i), input.get(j)));
                    } else if (currentDistance == minDistanceToZero) {
                        result.add(new Pair(input.get(i), input.get(j)));
                    }
                }
            }
        }
        return result;
    }

    public static List<Pair> closestToZeroSumPairOptimal(List<Integer> input) {
        Pair closest = relativeSumPair(input);
        return sumPairAbs(input, closest.sum());
    }



    public static List<Pair> farthestToZeroSumPair(List<Integer> input) {
        List<Pair> result = new ArrayList(input.size() / 2);
        int maxDistanceToZero = 0;
        for (int i = 0; i < input.size(); i++) {
            for (int j = i; j < input.size(); j++) {
                int currentDistance = Math.abs((input.get(i) + (input.get(j))));
                if (currentDistance > maxDistanceToZero) {
                    maxDistanceToZero = currentDistance;
                    result.clear();
                    result.add(new Pair(input.get(i), input.get(j)));
                } else if (currentDistance == maxDistanceToZero) {
                    result.add(new Pair(input.get(i), input.get(j)));
                }
            }
        }
        return result;
    }

//    public static List<Pair> farthestToZeroSumPairOptimal(List<Integer> input) {
//        Pair closest = relativeSumPairMax(input);
//        return sumPairAbs(input, closest.sum());
//    }

    public static List<Pair> SumPair(List<Integer> input, int sum) {
        List<Pair> result = new ArrayList(input.size() / 2);
        input.sort(Integer::compareTo);
        int i = 0, j = input.size()-1;
        while (i < j) {
            int currentSum = input.get(i) + input.get(j);
            if (currentSum < sum) {
                i++;
            } else if (currentSum > sum) {
                j--;
            } else {
                result.add(new Pair(input.get(i), input.get(j)));
                i++; j--;
            }
        }
        return result;
    }

    public static List<Pair> sumPairAbs(List<Integer> input, int sum) {
        List<Pair> result = new ArrayList(input.size() / 2);
        Set<Integer> inputSet = new HashSet(input.size());
        for (Integer anInput : input) {
            int current = anInput;
            if (inputSet.contains(Math.abs(sum - Math.abs(current)))) {
                result.add(new Pair(current, sum - current));
            } else {
                inputSet.add(current);
            }
        }
        return result;
    }

    private static Pair relativeSumPair(List<Integer> input) {
        input.sort(Integer::compareTo);
        int minDistanceToZero = Integer.MAX_VALUE;
        int i = 0, j = input.size()-1;
        Pair result = null;
        while (i < j) {
            int currentSum = input.get(i) + input.get(j);
            if (Math.abs(currentSum) < Math.abs(minDistanceToZero)) {
                result = new Pair(input.get(i), input.get(j));
                minDistanceToZero = currentSum;
            }
            if(currentSum>0){
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static List<Pair> relativeSumPairMax(List<Integer> input) {
        List<Pair> result = new ArrayList<>();
        input.sort(Integer::compareTo);
        int i=0, j=input.size()-1;
        int maxSum=0;
        while (i<j){
            Pair pair1 = new Pair(input.get(i), input.get(i+1));
            Pair pair2 = new Pair(input.get(j), input.get(j-1));
            if(Math.abs(pair1.sum()) < maxSum || Math.abs(pair2.sum()) < Math.abs(maxSum)){
                break;
            }
            if(Math.abs(pair1.sum()) < Math.abs(pair2.sum())){
                result.add(pair2);
                break;
            } else if(Math.abs(pair1.sum()) > Math.abs(pair2.sum())) {
                result.add(pair1);
                break;
            } else {
                result.add(pair1);
                result.add(pair2);
                maxSum = pair1.sum();
                i++; j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(SumPair(Arrays.asList(-20, 4, -2, -4, 8, 6, 22, 10, -12, 2), 0));
//        System.out.println(zeroSumPair(Arrays.asList(-20, 4, -2, -4, 8, 6, 22, 10, 2, -12)));
//        System.out.println(closestToZeroSumPairOptimal(Arrays.asList(-20, 4, -2, -4, 8, 6, 22, 10, -12)));
//        System.out.println(closestToZeroSumPair(Arrays.asList(-20, 4, -2, -4, 8, 6, 22, 10, -12)));
        System.out.println(relativeSumPairMax(Arrays.asList(-20, 4, -2, -4, 8, 6, 22, 10, -12)));
//        System.out.println(farthestToZeroSumPair(Arrays.asList(-20, 4, -2, -4, 8, 6, 22, 10, -12)));
    }
}
