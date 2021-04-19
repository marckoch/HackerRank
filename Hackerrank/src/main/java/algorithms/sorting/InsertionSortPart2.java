package algorithms.sorting;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class InsertionSortPart2 {

    public static void insertionSortPart2(int[] ar) {
        int posOfCharToInsert = 1;
        while (posOfCharToInsert < ar.length) {
            int tmp = ar[posOfCharToInsert];

            int pos = posOfCharToInsert;
            while (pos >= 1 && ar[pos - 1] > tmp) {
                ar[pos] = ar[pos - 1];
                pos--;
            }
            ar[pos] = tmp;
            printArray(ar);

            posOfCharToInsert++;
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int s = in.nextInt();
            int[] ar = new int[s];
            for (int i = 0; i < s; i++) {
                ar[i] = in.nextInt();
            }
            insertionSortPart2(ar);
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
