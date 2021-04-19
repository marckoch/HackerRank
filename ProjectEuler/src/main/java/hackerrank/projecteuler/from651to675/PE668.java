package hackerrank.projecteuler.from651to675;

import toolbox.primes.GeneratePrimes;
import toolbox.primes.Sieve;

import java.util.*;

public class PE668 {

    private static final long LIMIT = 10_000_000L;

    //private static long[] primesArray = GeneratePrimes.getPrimesArrayLong(LIMIT);
    private static long[] primesArray = GeneratePrimes.getPrimesArrayLong((long) (Math.sqrt(LIMIT)));
    private static boolean[] primesSieve = Sieve.isPrime((int) Math.sqrt(LIMIT));

    public static void solveProjectEuler() {
        long start = System.currentTimeMillis();
        //System.out.println(Arrays.toString(primesArray));

        int count = 0;
        for (long n = 1; n <= LIMIT; n++) {
            if (isSquareRootSmooth(n))
                count++;
        }
        System.out.println(count + " " + (System.currentTimeMillis() - start));
    }

    private static boolean isSquareRootSmooth(long n) {
        // a prime is NEVER square root smooth
//        if (isCachedPrime(n)) {
//            return false;
//        }

        long largestPrimeFactor = getLargestPrimeFactor(n);
        double sqrt = Math.sqrt(n);

        boolean isSquareRootSmooth = largestPrimeFactor < sqrt;
        //System.out.println(n + ": largestPrimeFactor=" + largestPrimeFactor + "\tsqrt=" + sqrt + "\tisSquareRootSmooth=" + isSquareRootSmooth);

        return isSquareRootSmooth;
    }

    public static long getLargestPrimeFactor(long n) {
        long max = 0;
        for (int i = 0; i < primesArray.length; i++) {
            long prime = primesArray[i];
            while (n % prime == 0) {
                max = prime;
                n /= prime;
            }

            if (n == 1) {
                return max;
            }

            if (isCachedPrime(n)) {
                return n;
            }
        }
        if (n > 1) {
            return n;
        }
        return max;
    }

    private static boolean isCachedPrime(long n) {
        //return Arrays.binarySearch(primesArray, n) > 0;
        if (n >= primesSieve.length) return false;
        return primesSieve[(int) n];
    }

    public static void main(String[] args) {
        //getLargestPrimeFactor(100);
        //isSquareRootSmooth(991);
        //solveProjectEuler();

        long start = System.currentTimeMillis();
        solve();
        System.out.println("solve took " + (System.currentTimeMillis() - start));

//        int[] maxDivisor = new int[12602];
//        Arrays.fill(maxDivisor, 1);
//        maxDivisor[2]=2;
//        maxDivisor[3]=3;
//        System.out.println(getLargestPrimeFactor(12601, maxDivisor));

        start = System.currentTimeMillis();
        solve2();
        System.out.println("solve2 took " + (System.currentTimeMillis() - start));
    }

    private static void solve() {
        int LIMIT = 10_000_000;

        Set<Integer> srsNumbers = new TreeSet<>();

        int[] maxDivisor = new int[LIMIT + 1];
        Arrays.fill(maxDivisor, 1);
        maxDivisor[2] = 2;
        maxDivisor[3] = 3;
        //System.out.println(Arrays.toString(maxDivisor));

        int count = 0;
        for (int n = 1; n <= LIMIT; n++) {
            long largestPrimeFactor = getLargestPrimeFactor(n, maxDivisor);
            maxDivisor[n] = (int) largestPrimeFactor;

            double sqrt = Math.sqrt(n);

            boolean isSquareRootSmooth = largestPrimeFactor < sqrt;
            if (isSquareRootSmooth) {
                srsNumbers.add(n);
                count++;
            }
            //System.out.println(n + " " + largestPrimeFactor + " " + isSquareRootSmooth);
        }

        System.out.println(count);
        //System.out.println(Arrays.toString(maxDivisor));
        //System.out.println(srsNumbers);
    }

    private static long getLargestPrimeFactor(int n, int[] maxDivisor) {
//        if (BigInteger.valueOf(n).isProbablePrime(1)) {
//            return n;
//        }
        int number = n;
        long max = 0;
        for (int i = 2; i * i <= number; i++) {
            while (n % i == 0) {
                n /= i;
                max = i;
            }
            if (maxDivisor[n] > 1) return maxDivisor[n];
        }
        if (n > 1) {
            return n;
        }
        return max;
    }

    private static void solve2() {
        int[] primesArray = GeneratePrimes.getPrimesArray((int) Math.sqrt(LIMIT));
        //System.out.println(Arrays.toString(primesArray));

        Set<Integer> numbers = new TreeSet<>();
        numbers.add(1);
        combinePrimes(1, primesArray, numbers, LIMIT, 1, new Stack<>());
        System.out.println(numbers.size());
        //System.out.println(numbers);
    }

    private static void combinePrimes(int currentNumber, int[] primes, Set<Integer> srsNumbers, long LIMIT, int maxPrime, Stack<Integer> factors) {
        int originalMaxPrime = maxPrime;
        for (int i = 0; i < primes.length; i++) {
            int prime = primes[i];
            if (prime < maxPrime) {
                continue;
            }

            if (prime > maxPrime) {
                maxPrime = prime;
            }

            currentNumber *= prime;
            factors.push(prime);
            //System.out.println(factors + " " + maxPrime + " " + currentNumber);
            if (currentNumber <= LIMIT) {
                if (currentNumber > maxPrime * maxPrime) {
                    srsNumbers.add(currentNumber);
                }
                combinePrimes(currentNumber, primes, srsNumbers, LIMIT, maxPrime, factors);
            }
            currentNumber /= prime;
            factors.pop();
            maxPrime = originalMaxPrime;
        }
    }
}
