package hackerrank.projecteuler.from076to100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Coin partitions
 *
 * @author marckoch
 */
public class PE078 {

    private static int MOD;
    
    private static final int LIMIT = 60_000;

    private static long[] initCountArray() {
        
        final long[] COUNT = new long[LIMIT + 1];
        COUNT[0] = 1;
        for (int i = 1; i < COUNT.length; i++) {
            for (int j = i; j <= LIMIT; j++) {
                COUNT[j] += COUNT[j - i];
                COUNT[j] %= MOD;
            }
            //System.err.println(i + " " + Arrays.toString(COUNT));
        }
        System.err.println(Arrays.toString(COUNT));
        return COUNT;
    }

    public static long solveProjectEuler() {
        MOD = (int) Math.pow(10, 6);
        long[] partitions = initPartitionArrayPentagonal();
        for (int n = 0; n < partitions.length; n++) {
            if (partitions[n] == 0) return n;
        }
        return -1;
    }

    // too slow, gives 33%
    public static void solveHackerrankSlow() {
        MOD = (int) Math.pow(10, 9) + 7;
        long[] COUNT = initCountArray();

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            System.out.println(COUNT[N]);
        }
    }

    public static int pentagonal(int k) {
        return k * (3 * k - 1) / 2;
    }

    public static long getPartition(int n, long[] partition) {
        long sum = 0;
        
        // formula: https://en.wikipedia.org/wiki/Pentagonal_number_theorem#Relation_with_partitions
        // recurrence:
        // p(n) = SUM k  (-1) ^ (k-1) * p(n - pentagonal(k))
      
        for (int i = 0; i < partition.length; i++) {
            // generate alternating k: 0, +1, -1, +2, -2, ...
            int k = 1 + (i / 2);
            if (i % 2 == 1) {
                k = -k;
            }

            int pent_k = pentagonal(k);
            //System.err.printf("n=%s  i=%s k=%s pentagonal(%s)=%s\n", n, i, k, k, pent_k);

            // pentagonal(n - pent_k) would get negative index
            if (pent_k > n) {
                break;
            }

            // (-1) ^ (k-1) --> +1 for odd k, -1 for even k
            if (k % 2 == 0) {
                sum -= partition[n - pent_k]; // p(n - pentagonal(k))
            } else {
                sum += partition[n - pent_k]; // p(n - pentagonal(k))
            }
            
            // due to sum -= ... for even k sum could get negative
            if (sum < 0) 
                sum += MOD;

            sum = sum % MOD;
        }
        return sum;
    }

    // 100% on hackerrank!
    public static void solveHackerrankPentagonal() {
        MOD = (int) Math.pow(10, 9) + 7;
        long[] partitions = initPartitionArrayPentagonal();

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            System.out.println(partitions[N]);
        }
    }

    private static long[] initPartitionArrayPentagonal() {
        long[] partition = new long[LIMIT];
        partition[0] = 1; // base case

        for (int n = 1; n < partition.length; n++) {
            partition[n] = getPartition(n, partition);
        }

        System.err.println(Arrays.toString(partition));
        return partition;
    }

    public static void main(String[] args) {
        System.out.println(solveProjectEuler());
        //solveHackerrankSlow();
        //solveHackerrankPentagonal();
    }
}
