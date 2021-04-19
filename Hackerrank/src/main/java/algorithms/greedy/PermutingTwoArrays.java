package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class PermutingTwoArrays {

    private static boolean check(int[] A, int[] B, int N, int K) {
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            if (A[i] + B[N - 1 - i] < K) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int Q = in.nextInt();
            while (Q-- > 0) {
                int N = in.nextInt();
                int K = in.nextInt();

                int[] A = new int[N];
                for (int i = 0; i < N; i++) {
                    A[i] = in.nextInt();
                }

                int[] B = new int[N];
                for (int i = 0; i < N; i++) {
                    B[i] = in.nextInt();
                }

                if (check(A, B, N, K)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
