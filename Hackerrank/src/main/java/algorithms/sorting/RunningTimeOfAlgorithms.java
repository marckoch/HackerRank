package algorithms.sorting;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class RunningTimeOfAlgorithms {

    public static void insertIntoSorted(int[] ar) {
        printArray(ar);
        int shifts = 0;
        int posOfCharToInsert = 1;
        while (posOfCharToInsert < ar.length) {
            int tmp = ar[posOfCharToInsert];

            int pos = posOfCharToInsert;
            while (pos >= 1 && ar[pos - 1] > tmp) {
                ar[pos] = ar[pos - 1];
                shifts++;
                pos--;
            }
            ar[pos] = tmp;

            printArray(ar);
            
            posOfCharToInsert++;
        }

        System.out.println(shifts);
    }

    private static void printArray(int[] ar) {
        String delimiter = "";
        for (int n : ar) {
            System.err.print(delimiter + n);
            delimiter = " ";
        }
        System.err.println("");
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
}
