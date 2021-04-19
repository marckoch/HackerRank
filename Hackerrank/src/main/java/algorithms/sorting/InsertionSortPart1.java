package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class InsertionSortPart1 {

    public static void insertIntoSorted(int[] ar) {
        System.err.println(Arrays.toString(ar));
        int tmp = ar[ar.length - 1];

        int pos = ar.length - 1;
        while (pos >= 1 && ar[pos - 1] > tmp) {
            ar[pos] = ar[pos - 1];
            pos--;
            printArray(ar);
        }
        ar[pos] = tmp;
        printArray(ar);
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int s = in.nextInt();
            int[] ar = new int[s];
            for (int i = 0; i < s; i++) {
                ar[i] = in.nextInt();
            }
            insertIntoSorted(ar);
        }
    }

    private static void printArray(int[] ar) {
        String delimiter = "";
        for (int n : ar) {
            System.out.print(delimiter + n);
            delimiter = " ";
        }
        System.out.println("");
    }
}
