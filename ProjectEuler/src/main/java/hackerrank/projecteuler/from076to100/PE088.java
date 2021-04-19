package hackerrank.projecteuler.from076to100;

import java.util.*;

/**
 * nayuki
 * https://github.com/nayuki/Project-Euler-solutions/blob/master/java/p088.java
 */
public class PE088 {
    /*
     * minSumProduct[k] is the smallest positive integer that can be written as both a sum and a product of the same collection of k positive integers.
     * For example, minSumProduct[3] = 6 because 6 == 1 + 2 + 3 == 1 * 2 * 3, and this is the minimum possible number for 3 terms.
     *
     * For all k >= 2:
     * - minSumProduct[k] > k because 1 + ... + 1 (with k terms) = k, which is the minimum sum of k positive integers,
     *   but the product is 1 which is unequal to k, so k is not a valid solution.
     * - minSumProduct[k] <= 2k because 1 + ... + 1 + 2 + k (with k terms in total) = (k - 2) + 2 + k = 2k. The product is 2k, which equals the sum.
     *   Since this is one achievable solution, the minimum solution must be no larger than this.
     * - Aside: minSumProduct[k] is not a prime number. Suppose minSumProduct[k] = p, where p is prime. Then p can only be factorized as p, p * 1, p * 1 * 1, etc.
     *   So whenever the factorization has more than one term, the sum exceeds p, which makes it unequal to the product.
     *
     * Therefore we need to consider all numbers from 2 to LIMIT*2 and factorize them in all possible ways to find all the relevant solutions.
     */
    static int[] minSumProduct;

    /*
     * Calculates all factorizations of the integer n >= 2 and updates smaller solutions into minSumProduct.
     * For example, 12 can be factorized as follows - and duplicates are eliminated by finding only non-increasing sequences of factors:
     * - 12 = 12. (1 term)
     * - 12 = 6 * 2 * 1 * 1 * 1 * 1 = 6 + 2 + 1 + 1 + 1 + 1. (6 terms)
     * - 12 = 4 * 3 * 1 * 1 * 1 * 1 * 1 = 4 + 3 + 1 + 1 + 1 + 1 + 1. (7 terms)
     * - 12 = 3 * 2 * 2 * 1 * 1 * 1 * 1 * 1 = 3 + 2 + 2 + 1 + 1 + 1 + 1 + 1. (8 terms)
     */
    private static void factorize(int n, int remain, int maxFactor, int sum, int terms) {
        if (remain == 1) {
            terms += n - sum;
            if (terms < minSumProduct.length && n < minSumProduct[terms])
                minSumProduct[terms] = n;
        } else {
            // Note: maxFactor <= remain
            for (int i = 2; i <= maxFactor; i++) {
                if (remain % i == 0) {
                    int factor = i;
                    factorize(n, remain / factor, Math.min(factor, maxFactor), sum + factor, terms + 1);
                }
            }
        }
    }

    public static void solve(final int N) {
        minSumProduct = new int[N + 1];
        Arrays.fill(minSumProduct, Integer.MAX_VALUE);

        for (int i = 2; i <= N * 2; i++)
            factorize(i, i, i, 0, 0);

        // System.err.println(Arrays.toString(minSumProduct));

        int sum = Arrays.stream(minSumProduct) //
                .skip(2) // we only add distinct numbers >= 2
                .distinct() // we only want distinct numbers
                .sum();
        System.out.println(sum);
    }

    public static void solveProjectEuler() {
        solve(12000);
    }

    // only 27% :-(
    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        solve(in.nextInt());
    }

    public static void main(String[] args) {
        //solveProjectEuler();
        solveHackerrank();
    }
}
