package hackerrank.projecteuler.from101to125;

import java.math.BigInteger;

public class PE113 {

    public static void solveProjectEuler(int length) {
        BigInteger asc = countAscending(length, 0, 9); // has increasing and constant numbers (e.g. 66)
        asc = asc.subtract(BigInteger.ONE); // minus 1 because 00 is counted
        System.out.println(asc);

        // enddigit 1 because we can have numbers like 0032 (length 4, descending)
        BigInteger desc = countDescending(length, 9, 1);
        System.out.println(desc);

        // constant numbers like 6666 are counted in both methods
        // 9 1digit numbers, 9 2digit numbers, 9 3digit numbers, .... -> 9 ndigit numbers -> 9 * length
        long doubles = 9 * length;

        long result = asc.longValue() + desc.longValue() - doubles;
        System.out.println(result);
    }

    // count numbers with n digits that are descending, hint: lattice paths!
    // the first digit can also change! (startdigit 3, length 5 can produce number "45667")
    public static BigInteger countAscending(int length, int startDigit, int endDigit) {
        BigInteger count = binomialCoeffCalculated(endDigit - startDigit + length, length);
        return count;
    }

    public static BigInteger countDescending(int length, int startDigit, int endDigit) {
        BigInteger count = binomialCoeffCalculated(startDigit - endDigit + length, length);
        return count;
    }

    // Returns value of Binomial Coefficient C(n, k)
    static BigInteger binomialCoeffCalculated(long n, long k) {
        BigInteger res = BigInteger.ONE;
        long origK = k;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k) {
            k = n - k;
        }

        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i) {
            res = res.multiply(BigInteger.valueOf(n - i))
                    .divide(BigInteger.valueOf(i + 1));
        }

        System.err.println("C(" + n + ", " + origK + ")=" + res);
        return res;
    }

    public static void main(String[] args) {
        solveProjectEuler(3);

        solveProjectEuler(100);
    }
}
