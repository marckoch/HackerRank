package hackerrank.projecteuler.from351to400;

import toolbox.primes.CheckIfPrime;

public class PE357 {

    public static void solveProjectEuler() {
        long sum = 1; // count for n=1

        // odd number can never match because 1 is always divisor, so sum is always even and divisible by 2
        for (int n = 2; n <= 100_000_000; n+=2) {
            boolean matches = checkNumber(n);
            if (matches) {
                System.out.println(">> adding " + n);
                sum += n;
            }
        }
        System.out.println(sum);
    }

    private static boolean checkNumber(int n) {
        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                int divisorSum = d + n / d;

                boolean divisorSumIsPrime = CheckIfPrime.isPrime(divisorSum);

                //System.out.println(n + ": divisor " + d + " divisorSum=" + divisorSum + " isPrime=" + divisorSumIsPrime);
                if (!divisorSumIsPrime) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Problem 357: 1739023853137
        // CheckIfPrime.isPrime(divisorSum); >> 1739023853137

        solveProjectEuler();
    }
}
