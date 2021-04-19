package hackerrank.projecteuler.from351to400;

import toolbox.digits.GetDigits;
import toolbox.primes.CheckIfPrime;

import java.util.Arrays;

public class PE387 {

    public static void solveProjectEuler() {
        long sum = 0;
        for (int n = 0; n < 1_000_000_000; n++) {
            boolean isStrongRightTruncatablePrime = isStrongRightTruncatablePrime(n);
            //System.out.println(n + " " + isStrongRightTruncatablePrime);
            if (isStrongRightTruncatablePrime) {
                sum += n;
            }
        }
        System.out.println(sum);
    }

    private static boolean isHarshad(long n) {
        int[] digits = GetDigits.digits(n);
        long sum = sum(digits);
        return n % sum == 0;
    }

    private static boolean isStrongHarshad(long n) {
        if (n == 0) return false;
        int[] digits = GetDigits.digits(n);
        long sum = sum(digits);
        return n % sum == 0 && isPrime(n / sum);
    }

    private static boolean isRightTruncatableHarshad(long n) {
        while (n > 0) {
            boolean isHarshad = isHarshad(n);
            if (!isHarshad) return false;
            n /= 10;
        }
        return true;
    }

    private static boolean isPrime(long n) {
        return CheckIfPrime.isPrime(n);
    }

    private static boolean isStrongRightTruncatablePrime(long n) {
        return isPrime(n) && isStrongHarshad(n / 10) && isRightTruncatableHarshad(n / 10);
    }

    private static long sum(int[] a) {
        return Arrays.stream(a).sum();
    }

    public static void main(String[] args) {
        solveProjectEuler();

        System.out.println(isHarshad(201));
        System.out.println(isHarshad(20));
        System.out.println(isHarshad(2));

        System.out.println(isStrongHarshad(201));

        System.out.println(isRightTruncatableHarshad(201));

        System.out.println(isStrongRightTruncatablePrime(2011));
    }
}
