package toolbox.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author marckoch
 */
public class BuildIntPermutations {
    private static int count = 0;

    private static void processPermutation(int[] perm) {
        System.out.println(++count + " " + Arrays.toString(perm));
    }

    // build all permutations of given array
    private static void buildPermutation(int index, int k, int[] arr, List<int[]> permutations) {
        if (index == k) {
            permutations.add(Arrays.copyOf(arr, k));
            //processPermutation(arr);
        } else {
            for (int i = index; i < arr.length; i++) {
                swap(arr, index, i);
                buildPermutation(index + 1, k, arr, permutations);
                swap(arr, index, i);
            }
        }
    }

    // helper method used in building array permutations
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static List<int[]> generatePermutations(int[] number) {
        return generatePermutations(number, number.length);
    }

    public static List<int[]> generatePermutations(int[] number, int k) {
        if (k > number.length) {
            throw new IllegalArgumentException("we cannot select " + k + " elements from a list of " + number.length);
        }
        List<int[]> permutations = new ArrayList<>();

        long start = System.currentTimeMillis();

        buildPermutation(0, k, number, permutations);

        System.err.println("created " + permutations.size() + " permutations for " + Arrays.toString(number) + " in millis: " + (System.currentTimeMillis() - start));

        return permutations;
    }

    private static void buildCyclicalPermutation(int index, int anker, int[] arr, List<int[]> permutations) {
        if (index == arr.length) {
            int[] newArr = new int[arr.length + 1];
            newArr[0] = anker;
            System.arraycopy(arr, 0, newArr, 1, arr.length);
            permutations.add(newArr);
            //processPermutation(arr);
        } else {
            for (int i = index; i < arr.length; i++) {
                swap(arr, index, i);
                buildCyclicalPermutation(index + 1, anker, arr, permutations);
                swap(arr, index, i);
            }
        }
    }

    public static List<int[]> generateCyclicalPermutations(int[] number) {
        long start = System.currentTimeMillis();

        List<int[]> permutations = new ArrayList<>();

        // anker is the first number, it will be always fix, only the rest is permutated
        int anker = number[0];
        int[] rest = Arrays.copyOfRange(number, 1, number.length);

        buildCyclicalPermutation(0, anker, rest, permutations);

        System.err.println("created " + permutations.size() + " cyclical permutations for " + Arrays.toString(number) + " in millis: " + (System.currentTimeMillis() - start));

        return permutations;
    }

    private static String toString(int[] arr) {
        //return Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining());
        StringJoiner sj = new StringJoiner("");
        Arrays.stream(arr).forEach(x -> sj.add(String.valueOf(x)));
        return sj.toString();
    }

    private static void permutateAsStr(int index, int[] arr, List<String> permutations) {
        if (index == arr.length) {
            permutations.add(toString(arr));
            //processPermutation(arr);
        } else {
            for (int i = index; i < arr.length; i++) {
                swap(arr, index, i);
                permutateAsStr(index + 1, arr, permutations);
                swap(arr, index, i);
            }
        }
    }

    public static List<String> generatePermutationsAsStr(int[] number) {
        int size = factorial(number.length);
        long start = System.currentTimeMillis();
        List<String> permutations = new ArrayList<>(size);
        permutateAsStr(0, number, permutations);
        System.err.println("created " + permutations.size() + " permutations for " + Arrays.toString(number) + " in millis: " + (System.currentTimeMillis() - start));
        return permutations;
    }

    private static int factorial(int n) {
        int result = 1;
        while (n > 1) {
            result *= n;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        List<int[]> permutationsOfAllNumbers = generatePermutations(arr, arr.length);
        permutationsOfAllNumbers.forEach(p -> System.out.println(Arrays.toString(p)));

        List<int[]> permutationsOf2Numbers = generatePermutations(arr, 2);
        permutationsOf2Numbers.forEach(p -> System.out.println(Arrays.toString(p)));

        //List<int[]> cycPermutations = generateCyclicalPermutations(arr);
        //cycPermutations.forEach(p -> System.out.println(Arrays.toString(p)));

        //System.out.println(generatePermutationsAsStr(arr));
    }
}
