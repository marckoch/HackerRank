package toolbox.permutations;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import toolbox.arrays.IntArrayToInt;

/**
 *
 * @author marckoch
 */
public class BuildIntPermutations2 {

    private static int count = 0;
    private static final Set<Long> PERMUTATIONS = new TreeSet<>();


    private static void processPermutation(int[] perm) {
        PERMUTATIONS.add(IntArrayToInt.convert(perm));
        System.out.println(++count + " " + Arrays.toString(perm));
    }

    // build all permutations of given array
    private static void permutate(int index, int[] arr) {
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
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        permutate(0, arr);

        Long[] permsArr = PERMUTATIONS.toArray(new Long[PERMUTATIONS.size()]);
        for (int i = 0; i + 1 < permsArr.length; i++) {
            Long p1 = permsArr[i];
            Long p2 = permsArr[i + 1];
            System.out.println(p1 + " " + p2 + " " + (p2 - p1) + " " + (p2 - p1) / 9);
        }
    }
}
