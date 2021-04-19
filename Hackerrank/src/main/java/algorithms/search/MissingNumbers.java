package algorithms.search;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MissingNumbers {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }

            int M = in.nextInt();
            int[] B = new int[M];
            int minB = 20_000;
            int maxB = 0;
            for (int i = 0; i < M; i++) {
                B[i] = in.nextInt();
                minB = Math.min(minB, B[i]);
                maxB = Math.max(maxB, B[i]);
            }

            int[] freqA = new int[maxB - minB + 1];
            int[] freqB = new int[maxB - minB + 1];

            for (int i = 0; i < M; i++) {
                if (i < N) {
                    freqA[A[i] - minB]++;
                }
                freqB[B[i] - minB]++;
            }

            //System.err.println(Arrays.toString(freqA));
            //System.err.println(Arrays.toString(freqB));
            String delimiter = "";
            for (int i = minB; i < maxB + 1; i++) {
                if (freqA[i - minB] < freqB[i - minB]) {
                    System.out.print(delimiter + i);
                    delimiter = " ";
                }
            }
            System.out.println();
        }
    }
}
