package hackerrank.projecteuler.from026to050;

import java.util.Scanner;

/**
 * Distinct primes factors
 * @author marckoch
 */
public class PE047 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        
        int[] countDistinctPrimeFactors = new int[N+K+1];
        
        for (int n=2; n<N+K; n++) {
            // n is a prime?
            if (countDistinctPrimeFactors[n]==0) {
                // then all multiples of n have n as one prime factor
                for (int i=n; i<N+K; i+=n) {
                    countDistinctPrimeFactors[i]++;
                }
            }
        }
        //System.err.println(Arrays.toString(countDistinctPrimeFactors));
        
        for (int n=K-1; n<N+K; n++) {
            switch (K) {
                case 2:
                    if (countDistinctPrimeFactors[n-1] == K &&
                        countDistinctPrimeFactors[n]   == K ) {
                        System.out.println(n-1);
                    }   break;
                case 3:
                    if (countDistinctPrimeFactors[n-2] == K &&
                        countDistinctPrimeFactors[n-1] == K &&
                        countDistinctPrimeFactors[n]   == K ) {
                        System.out.println(n-2);
                    }   break;
                case 4:
                    if (countDistinctPrimeFactors[n-3] == K &&
                        countDistinctPrimeFactors[n-2] == K &&
                        countDistinctPrimeFactors[n-1] == K &&
                        countDistinctPrimeFactors[n]   == K ) {
                        System.out.println(n-3);
                    }   break;
                default:
                    break;
            }
        }
    }
}
