package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MinimumDistances {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int A[] = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt();
            }

            solve(n, A);
        }
    }

    static void solve(int n, int[] A) {
        int min = n + 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < Math.min(i + min, n); j++) {
                if (A[i] == A[j]) {
                    min = Math.min(min, j - i);
                }
            }
        }
        if (min == n + 1) {
            min = -1;
        }
        System.out.println(min);
    }
}
