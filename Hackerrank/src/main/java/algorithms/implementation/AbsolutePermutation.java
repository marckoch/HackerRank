package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class AbsolutePermutation {

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            while (T-- > 0) {
                int n = in.nextInt();
                int k = in.nextInt();

                solve(k, n);
            }
        }
    }

    static void solve(int k, int n) {
        if (k == 0) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = i + 1;
            }
            printArray(a);
        } else if (n % (2 * k) == 0) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = (i % (2 * k) < k) ? (i + 1) + k : (i + 1) - k;
            }
            printArray(a);
        } else {
            System.out.println(-1);
        }
    }
}
