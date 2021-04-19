package toolbox.primes;

import toolbox.divisors.GetDivisors;

/**
 *
 * @author marckoch
 */
public class CheckIfPrimeWithWitness {
    // wrong! does not work properly!!
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        if (n < 9) {
            return true;
        }
        if (n % 3 == 0) {
            return false;
        }
        if (n % 5 == 0) {
            return false;
        }

        int[] ar = new int[]{2, 3};
        for (int i = 0; i < ar.length; i++) {
            if (witness(ar[i], n)) {
                return false;
            }
        }
        return true;
    }

    private static boolean witness(int a, int n) {
        int t = 0;
        int u = n - 1;
        while ((u & 1) == 0) {
            t++;
            u >>= 1;
        }

        long xi1 = modularExp(a, u, n);
        long xi2;

        for (int i = 0; i < t; i++) {
            xi2 = xi1 * xi1 % n;
            if ((xi2 == 1) && (xi1 != 1) && (xi1 != (n - 1))) {
                return true;
            }
            xi1 = xi2;
        }
        if (xi1 != 1) {
            return true;
        }
        return false;
    }

    private static long modularExp(int a, int b, int n) {
        long d = 1;
        int k = 0;
        while ((b >> k) > 0) {
            k++;
        }

        for (int i = k - 1; i >= 0; i--) {
            d = d * d % n;
            if (((b >> i) & 1) > 0) {
                d = d * a % n;
            }
        }

        return d;
    }    
    
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(isPrime(1234567897));
        long end = System.nanoTime();
        System.out.println("took " + (end-start) + " nanos");

        // this shows that Witness prime check does not work properly!
        for (int i = 0; i < 100_000_000; i++) {
            boolean isPrime = CheckIfPrime.isPrime(i);
            boolean isPrime2 = CheckIfPrimeWithWitness.isPrime(i);
            if (isPrime != isPrime2) {
                System.err.println("error at i=" + i + " isPrime=" + isPrime + " isPrime2=" + isPrime2 + " sumOfDivisors=" + GetDivisors.getDivisors(i));

            }
        }
    }
}
