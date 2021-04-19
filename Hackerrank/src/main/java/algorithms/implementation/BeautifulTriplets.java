package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class BeautifulTriplets {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int d = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            System.err.println(Arrays.toString(array));

            solve(n, array, d);
        }
    }

    static void solve(int n, int[] array, int d) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int arrJ = array[i] + d;
            int j = Arrays.binarySearch(array, i + 1, n, arrJ);
            if (j < 0) {
                continue;
            }

            int arrK = array[i] + 2 * d;
            int k = Arrays.binarySearch(array, j + 1, n, arrK);
            if (k < 0) {
                continue;
            }

            // we found J and K
            count++;
        }
        System.out.println(count);
    }
}
