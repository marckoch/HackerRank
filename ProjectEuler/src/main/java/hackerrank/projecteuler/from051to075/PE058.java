package hackerrank.projecteuler.from051to075;

import java.util.Scanner;

/**
 * Spiral primes
 * @author marckoch
 */
public class PE058 {
    // we need a faster isPrime check here to solve case 8
    private static boolean isPrime(long n) {
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (long i = 6L; i * i <= n; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        long LIMIT = 100_000L;
        
        // acount for n=1
        long countPrimes = 0L;
        long countTotal = 1L;
        
        for (long n=3; n<LIMIT; n+=2) {
            
            long lowerRight = n * n;
            long lowerLeft = lowerRight - n + 1;
            long upperLeft = lowerLeft - n + 1;
            long upperRight = upperLeft - n + 1;
            
            //System.err.println("n=" + n + " " + lowerRight + " " + lowerLeft + " " + upperLeft + " " + upperRight);
            
            // lowerRight is always n*n, so NEVER a prime!
            // if (isPrime(lowerRight)) countPrimes++;
            
            if (isPrime(lowerLeft)) countPrimes++;
            if (isPrime(upperLeft)) countPrimes++;
            if (isPrime(upperRight)) countPrimes++;
            
            countTotal +=4;
            
            //double ratio = (double) countPrimes / countTotal;
            
            //System.err.println("n=" + n + " countPrimes=" + countPrimes + " countTotal=" + countTotal + " ratio=" + ratio);
            
            if ( countPrimes * 100 < N * countTotal ) {
                System.out.println(n);
                break;
            }
        }
    }
}
