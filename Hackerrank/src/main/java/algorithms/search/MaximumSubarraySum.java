package algorithms.search;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author marckoch
 */
public class MaximumSubarraySum {

    static long maximumSumNaive(long[] array, long mod) {
        //System.err.println(Arrays.toString(array));

        int N = array.length;

        long[] prefixSum = new long[N];
        prefixSum[0] = array[0] % mod;
        for (int i = 1; i < N; i++) {
            prefixSum[i] = (prefixSum[i - 1] + (array[i] % mod)) % mod;
        }
        //System.err.println(Arrays.toString(prefixSum));

        //Arrays.sort(prefixSum);
        long result = 0;
        for (int from = 0; from < N - 1; from++) {
            result = Math.max(result, prefixSum[from]); // this is the sum from the beginning!

            for (int to = from + 1; to < N; to++) {
                long sum = prefixSum[to] - prefixSum[from];
                sum += mod;
                sum %= mod;
                //System.err.printf("%s %s %s %s\n", from, to, (prefixSum[to] - prefixSum[from]), sum);
                result = Math.max(result, sum);
            }
        }
        return result;
    }

    static long maximumSum(long[] array, long mod) {
        int N = array.length;
        long result = 0;

        TreeSet<Long> prefix = new TreeSet<>();

        long currentSum = 0;
        for (int i = 0; i < N; i++) {
            currentSum = (currentSum + array[i] % mod) % mod;
            SortedSet<Long> tail = prefix.tailSet(currentSum + 1);
            Iterator<Long> iterator = tail.iterator();
            if (iterator.hasNext()) {
                result = Math.max(result, (currentSum - iterator.next() + mod) % mod);
            }
            result = Math.max(result, currentSum);
            prefix.add(currentSum);
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            while (q-- > 0) {
                int n = in.nextInt();
                long m = in.nextLong();

                long[] array = new long[n];
                for (int i = 0; i < n; i++) {
                    array[i] = in.nextLong();
                }
                long result = maximumSum(array, m);
                System.out.println(result);
            }
        }
    }
}
