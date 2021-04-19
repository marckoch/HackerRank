package algorithms.sorting;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class CorrectnessAndTheLoopInvariant {

    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }

        printArray(A);
    }

    private static void printArray(int[] ar) {
        String delimiter = "";
        for (int n : ar) {
            System.out.print(delimiter + n);
            delimiter = " ";
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
            }
            insertionSort(ar);
        }
    }
}
