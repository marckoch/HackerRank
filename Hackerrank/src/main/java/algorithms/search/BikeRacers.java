package algorithms.search;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class BikeRacers {

    static void printMatrix(long[][] A, String delimiter) {
        for (int r = 0; r < A.length; r++) {
            String del = "";
            for (int c = 0; c < A[0].length; c++) {
                System.err.print(del + A[r][c]);
                del = delimiter;
            }
            System.err.println();
        }
    }

    public static long sqDist(int[] p1, int[] p2) {
        int d0 = Math.abs(p2[0] - p1[0]);
        int d1 = Math.abs(p2[1] - p1[1]);
        //return d0 * d0 + d1 * d1;
        return BigInteger.valueOf(d0).pow(2).add(BigInteger.valueOf(d1).pow(2)).longValue();
    }

    public static long solve(int[][] drivers, int[][] bikes, int K) {
        int NR_DRIVERS = drivers.length;
        int NR_BIKES = bikes.length;

        long[][] distance = new long[NR_DRIVERS][NR_BIKES];
        for (int driver = 0; driver < NR_DRIVERS; driver++) {
            for (int bike = 0; bike < NR_BIKES; bike++) {
                long dist = sqDist(drivers[driver], bikes[bike]);
                distance[driver][bike] = dist;
            }
        }
        printMatrix(distance, " ");

        long kthMin = Long.MAX_VALUE;
        for (int k = 0; k < K; k++) {
            long min = Long.MAX_VALUE;
            int[] minCoord = {-1, -1};
            
            // find minimal value in matrix
            for (int driver = 0; driver < NR_DRIVERS; driver++) {
                for (int bike = 0; bike < NR_BIKES; bike++) {
                    double dist = distance[driver][bike];
                    if (dist < min) {
                        min = (long) dist;
                        minCoord = new int[]{driver, bike};
                    }
                }
            }
            //System.err.printf("min %s found at %s\n", min, Arrays.toString(minCoord));

            if (k == K - 1) {
                kthMin = min;
                break;
            }
            
            // prepare next step, "remove" found solution from matrix
            // by setting row and column to MAX
            for (int driver = 0; driver < NR_DRIVERS; driver++) {
                distance[driver][minCoord[1]] = Long.MAX_VALUE;
            }
            for (int bike = 0; bike < NR_BIKES; bike++) {
                distance[bike][minCoord[0]] = Long.MAX_VALUE;
            }
            //printMatrix(distance, " ");
        }

        return kthMin;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int M = in.nextInt();
            int K = in.nextInt();

            int[][] bikers = new int[N][2];
            for (int n = 0; n < N; n++) {
                bikers[n][0] = in.nextInt();
                bikers[n][1] = in.nextInt();
            }

            int[][] bikes = new int[M][2];
            for (int m = 0; m < M; m++) {
                bikes[m][0] = in.nextInt();
                bikes[m][1] = in.nextInt();
            }

            //System.err.println(Arrays.deepToString(bikers));
            //System.err.println(Arrays.deepToString(bikes));

            System.out.println(solve(bikers, bikes, K));
        }
    }
}
