package toolbox.primes;

import java.util.Arrays;

/**
 *
 * @author marckoch
 */
public class Sieve {

    // Sieve of Eratosthenes
    
    // here we count the distinct prime factors, we dont care how often
    // a prime is part of the number, 
    // e.g. p(8) = 2^3, we count 2 only once
    public static int[] countDistinctPrimeFactors(int max) {
        int[] countDistinctPrimeFactors = new int[max];

        for (int n = 2; n < max; n++) {
            // n is a prime?
            if (countDistinctPrimeFactors[n] == 0) {
                // then n and all multiples of n have n as one prime factor
                for (int i = n; i < max; i += n) {
                    countDistinctPrimeFactors[i]++;
                }
            }
        }
        //System.err.println(Arrays.toString(countDistinctPrimeFactors));
        return countDistinctPrimeFactors;
    }

    public static boolean[] isPrime(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= max; p++) {
            // p is a prime?
            if (isPrime[p]) {
                // then all multiples of p have p as one prime factor and are NO prime
                for (int i = p*2; i <= max; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        //System.err.println(Arrays.toString(isPrime));

        // Print all prime numbers
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                System.err.print(i + " ");
            }
        }
        System.err.print("\n");

        return isPrime;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countDistinctPrimeFactors(20)));

        System.out.println(Arrays.toString(isPrime(200)));
    }
}
