package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class EqualizeTheArray {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();

            int[] a = new int[n];
            int[] freq = new int[101];
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                a[i] = x;
                freq[x]++;
            }

            Arrays.sort(freq);

            int max = freq[freq.length - 1];
            System.out.println(n - max);
        }
    }
}
