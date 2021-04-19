package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class OrganizingContainersOfBalls {

    // sum in each col and sum in each row
    // sort both sum lists, they have to match
    static String solve(int N, int[][] array) {
        long[] rowSums = new long[N];
        long[] colSums = new long[N];
        for (int c = 0; c < N; c++) {
            for (int r = 0; r < N; r++) {
                rowSums[r] += array[r][c];
                colSums[c] += array[r][c];
            }
        }
        //System.err.println("row=" + Arrays.toString(rowSums));
        //System.err.println("col=" + Arrays.toString(colSums));

        Arrays.sort(rowSums);
        Arrays.sort(colSums);

        for (int i = 0; i < N; i++) {
            if (rowSums[i] != colSums[i]) {
                return "Impossible";
            }
        }
        return "Possible";
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int Q = in.nextInt();
            while (Q-- > 0) {
                int N = in.nextInt();
                int[][] M = new int[N][N];
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        M[r][c] = in.nextInt();
                    }
                }
                System.out.println(solve(N, M));
            }
        }
    }
}
