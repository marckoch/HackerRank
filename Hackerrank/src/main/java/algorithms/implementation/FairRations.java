package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class FairRations {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int B[] = new int[N];
            for (int i = 0; i < N; i++) {
                B[i] = in.nextInt();
            }

            solve(N, B);
        }
    }

    static void solve(int N, int[] B) {
        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            if (B[i] % 2 == 1) {
                B[i]++;
                B[i + 1]++;
                count += 2;
                //System.err.println(Arrays.toString(B));
                //System.err.println("" + i + " " + count);
            }
            if (i == N - 2 && (B[N - 1] % 2 == 1)) {
                count = -1;
            }
        }
        System.out.println(count < 0 ? "NO" : count);
    }
}
