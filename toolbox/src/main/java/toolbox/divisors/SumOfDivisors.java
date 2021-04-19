package toolbox.divisors;

import java.util.*;

/**
 * @author marckoch
 */
public class SumOfDivisors {
    private static final int[] DIVISOR_SUM_CACHE = new int[100_000_000];

    public static int getSumOfDivisors(int n) {
        if (n == 1) {
            return 0;
        }
        if (DIVISOR_SUM_CACHE[n] > 0) {
            return DIVISOR_SUM_CACHE[n];
        }

        int sum = 0;
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                if (i > 1 && i != (n / i)) {
                    sum += (n / i);
                }
            }
        }
        //System.err.println(" d(" + n + ")=" + sum);
        DIVISOR_SUM_CACHE[n] = sum;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("getSumOfDivisors(220)=" + getSumOfDivisors(220));
        System.out.println("getSumOfDivisors(284)=" + getSumOfDivisors(284));
        System.out.println("getSumOfDivisors(300)=" + getSumOfDivisors(300));
    }
}
