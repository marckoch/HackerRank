package toolbox.arrays;

import java.util.Arrays;

/**
 *
 * @author marckoch
 */
public class IndexArray {

    public static int[] buildIndexArray(int[] array) {
        int[] indexArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            indexArray[array[i]] = i;
        }
        return indexArray;
    }

    // helper method
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        int[] indexArray = buildIndexArray(array);
        System.err.println("indexe    : " + Arrays.toString(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.err.println("array     : " + Arrays.toString(array));
        System.err.println("pos array : " + Arrays.toString(indexArray));

        swap(array, 2, 6);
        swap(indexArray, array[2], array[6]);
        System.err.println("after swapping pos 2 and 6:");
        System.err.println("indexe    : " + Arrays.toString(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.err.println("array     : " + Arrays.toString(array));
        System.err.println("pos array : " + Arrays.toString(indexArray));

        array = new int[]{6, 5, 4, 3, 2, 1, 0};
        indexArray = buildIndexArray(array);
        System.err.println();
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(indexArray));

        array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        indexArray = buildIndexArray(array);
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(indexArray));

    }
}
