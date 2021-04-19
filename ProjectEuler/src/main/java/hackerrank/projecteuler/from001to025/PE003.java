package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * Largest prime factor
 * @author marckoch
 */
public class PE003 {
    private static long getLargestPrime(long n) {
        long max=0;
        for (long i=2; i*i<=n;i++) {
            while(n%i==0) {
                max=i;
                n /= i;
            }
        }      
        if (n>1) return n;
        return max;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long p = getLargestPrime(n);
            System.out.println(p);
        }
    }
}
