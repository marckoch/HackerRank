package toolbox.permutations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 */
public class Combinations {

    static int count = 0;

    /*
    arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static void combinationUtil(int[] arr, int r, int index, int[] data, int i, List<int[]> combinations) {
        // Current combination is ready to be processed
        if (index == r) {
            combinations.add(Arrays.copyOf(data, data.length));
            //processCombination(data);
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= arr.length) {
            return;
        }

        // current is included, put next at next location
        data[index] = arr[i];
        combinationUtil(arr, r, index + 1, data, i + 1, combinations);

        // current is excluded, replace it with next (Note that
        // i+1 is passed, but index is not changed)
        combinationUtil(arr, r, index, data, i + 1, combinations);
    }

    static void processCombination(int[] data) {
        System.err.println(++count + " " + Arrays.toString(data));
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    public static List<int[]> generateCombinationsNoRep(int[] arr, int r) {
        // A temporary array to store all combination one by one
        int[] data = new int[r];

        int numberOfCombinations = binomialCoeffCalculated(arr.length, r).intValue();
        System.out.printf("we will have %s combinations\n", numberOfCombinations);

        List<int[]> combinations = new ArrayList<>();

        // Print all combination using temporary array 'data[]'
        combinationUtil(arr, r, 0, data, 0, combinations);

        return combinations;
    }

    public static List<List<Integer>> generateCombinationsNoRepAsList(int[] arr, int r) {
        List<int[]> intArrays = generateCombinationsNoRep(arr, r);
        return intArrays.stream()
                .map(Combinations::toIntList)
                .collect(Collectors.toList());
    }

    static List<Integer> toIntList(int[] intArr) {
        return Arrays.stream(intArr).boxed().collect(Collectors.toList());
    }

    // Returns value of Binomial Coefficient C(n, k)
    static BigInteger binomialCoeffCalculated(long n, long k) {
        BigInteger res = BigInteger.ONE;
        long origK = k;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k) {
            k = n - k;
        }

        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i) {
            res = res.multiply(BigInteger.valueOf(n - i))
                    .divide(BigInteger.valueOf(i + 1));
        }

        //System.err.println("C(" + n + ", " + origK + ")=" + res);
        return res;
    }

    // https://www.geeksforgeeks.org/print-all-combinations-of-given-length/
    // The method that prints all possible strings of length k.
    // It is mainly a wrapper over recursive function printAllKLengthRec()
    public static List<String> generateCombinationsWithRep(int[] set, int k) {
        int size = Math.round((float) Math.pow(set.length, k));
        System.err.println("creating ArrayList for " + size);
        List<String> result = new ArrayList<>(size);
        generateCombinationsWithRepRecursive(set, k, "", result);
        return result;
    }

    // The main recursive method to print all possible strings of length k
    private static void generateCombinationsWithRepRecursive(int[] set, int k, String collector, List<String> result) {

        // Base case: k is 0, add combination to result
        if (k == 0) {
            result.add(collector);
            return;
        }

        // One by one add all characters from set and recursively call for k equals to k-1
        for (int value : set) {
            // Next character of input added
            String newPrefix = collector + value;

            // k is decreased, because we have added a new character
            generateCombinationsWithRepRecursive(set, k - 1, newPrefix, result);
        }
    }

    public static List<String> generateDistinctCombinationsWithRep(int[] set, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateDistinctCombinationsWithRepRecursive(set, k, new ArrayList<>(), result);

        // sort internal arrays, [1,3,2] is same as [2,3,1], both sort to [1,2,3] and will be made distinct afterwards
        result.forEach(integers -> integers.sort((o1, o2) -> o1 - o2));

        return result.stream()
                .distinct()
                .map(Combinations::toString)
                .collect(Collectors.toList());
    }

    // input List<Integer> like {3,2,4,2}, result String "3242"
    private static String toString(List<Integer> integers) {
        return integers.stream().map(String::valueOf).collect(Collectors.joining());
    }

    // The main recursive method to print all possible strings of length k
    private static void generateDistinctCombinationsWithRepRecursive(int[] set, int k, List<Integer> collector, List<List<Integer>> result) {

        // Base case: k is 0, add combination to result
        if (k == 0) {
            result.add(collector);
            return;
        }

        // One by one add all characters from set and recursively call for k equals to k-1
        for (int value : set) {
            // Next character of input added
            //String newPrefix = collector + value;
            List<Integer> newCollector = new ArrayList<>(collector);
            newCollector.add(value);

            // k is decreased, because we have added a new character
            generateDistinctCombinationsWithRepRecursive(set, k - 1, newCollector, result);
        }
    }

    /*Driver function to check for above function*/
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int r = 3;

        List<int[]> combinations = generateCombinationsNoRep(arr, r);
        combinations.forEach(combi -> System.out.println(Arrays.toString(combi)));

        List<String> combinationsWR = generateCombinationsWithRep(arr, 3);
        System.out.println(combinationsWR);

        List<String> distCombinationsWR = generateDistinctCombinationsWithRep(arr, 3);
        System.out.println(distCombinationsWR);
    }
}
