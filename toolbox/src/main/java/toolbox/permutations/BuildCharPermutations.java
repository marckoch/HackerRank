package toolbox.permutations;

import java.util.Arrays;

/**
 *
 * @author marckoch
 */
public class BuildCharPermutations {
    private static int count = 0;

    private static void processPermutation(char[] perm) {
        System.out.println(++count + " " + Arrays.toString(perm));
    }

    // build all permutations of given array
    private static void permutate(int index, char[] arr) {
        if (index == arr.length) {
            processPermutation(arr);
        } else {
            for (int i = index; i < arr.length; i++) {
                swap(arr, index, i);
                permutate(index + 1, arr);
                swap(arr, index, i);
            }
        }
    }

    // helper method used in building array permutations
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        char[] arr = "abcdef".toCharArray();

        permutate(0, arr);
    }
}
