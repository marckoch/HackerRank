package hackerrank.projecteuler.from051to075;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class PE069 {

    private static int[] phi;
    //private static int[] max;
    
    // Computes and prints totien of all numbers
    // smaller than or equal to n.
    public static void computeTotient() {
        int n = phi.length-1;
        // Create and initialize an array to store
        // phi or totient values
        for (int i = 1; i <= n; i++) {
            phi[i] = i; // indicates not evaluated yet
        }                    // and initializes for product formula.

        // Compute other Phi values
        for (int p = 2; p <= n; p++) {
            // If phi[p] is not computed already,
            // then number p is prime
            if (phi[p] == p) {
                // Phi of a prime number p is
                // always equal to p-1.
                phi[p] = p - 1;

                // Update phi values of all
                // multiples of p
                for (int i = 2 * p; i <= n; i += p) {
                    // Add contribution of p to its
                    // multiple i by multiplying with
                    // (1 - 1/p)
                    phi[i] = (phi[i] / p) * (p - 1);
                }
            }
        }

        // Print precomputed phi values
        //for (int i = 1; i < n; i++) {
        //    System.err.println(String.format("Totient of %s is %s", i, phi[i]));
        //}
        //System.err.println(Arrays.toString(phi));
    }
    
    public static void fillMaxArray() {
        double currentMax = 0.0d;
        int indexOfCurrentMax = 0;

        for (int n = 2; n < phi.length; n++) {
            
            double x = (double) n / phi[n];
            
            if (Double.compare(currentMax, x) < 0) {
                currentMax = x;
                indexOfCurrentMax = n;
                System.err.println(String.format("new max %s at %s", currentMax, n));
            }
            phi[n] = indexOfCurrentMax;
        }

        //System.err.println(Arrays.toString(max));
    }
    
    public static void main2(String[] args) {
        int N = 600000000;
        phi = new int[N + 1];
        //max = new int[N + 1];
        
        computeTotient();
        
        fillMaxArray();
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int q = in.nextInt();
            System.out.println(phi[q-1]);
        }
    }
    
    public static long[] getFirstNPrimes(int N) {
        long[] primes = new long[N];
        int index = 0;

        primes[index++] = 2;
        for (int i = 3; i <= 100 * N; i += 2) {
            boolean factorFound = false;
            for (long p : primes) {
                if (p * p > i) {
                    break;
                }
                if (i % p == 0) {
                    factorFound = true;
                    break;
                }
            }
            if (!factorFound) {
                primes[index++] = i;
            }
            if (index >= N) {
                break;
            }
        }

        //System.err.println("generated " + primes.length + " primes");

        System.err.println(Arrays.toString(primes));
        return primes;
    }
    
    public static long findMax(long[] primes, BigInteger limit) {
        BigInteger result = BigInteger.ONE;
        int i = 0;

        while (result.multiply(BigInteger.valueOf(primes[i])).compareTo(limit) < 0) {
            result = result.multiply(BigInteger.valueOf(primes[i]));
            // System.err.println(i + " " + result);
            i++;
        }
        return result.longValue();
    }
    
    public static void main(String[] args) {
        long[] firstNPrimes = getFirstNPrimes(100);
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            BigInteger q = in.nextBigInteger();
            System.out.println(findMax(firstNPrimes, q));
        }
    }
}
