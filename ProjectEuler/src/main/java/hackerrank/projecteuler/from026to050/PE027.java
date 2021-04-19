package hackerrank.projecteuler.from026to050;

import java.util.Scanner;

/**
 * Quadratic primes
 * @author marckoch
 */
public class PE027 {
    private static final int LIMIT = 1000001;
    private static final boolean[] PRIME = new boolean[LIMIT];
    
    private static int calc(int a, int b, int n) {
        return (n + a) * n + b;
    }
    
    private static int getMaxLength(int a, int b) {
        int n=0;
        int p=0;
        do {
            p = calc(a, b, n);
            //System.err.println("calc(" + a + "," + b + ", n=" + n + ")=" + p);
            n++;
        } while (PRIME[Math.abs(p)]);
        return n;
    }
    
    public static void main(String[] args) {
        
        for (int i=0; i<LIMIT; i++) {PRIME[i]=true;}
        PRIME[1]=false;
        for(int i=3;i<LIMIT;i++) {
            for(int j=2; j*j<=i; j++) {
                if(i%j==0) {
                    PRIME[i]=false;
                    break;
                }
            }
        }
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int maxLength = 0;
        int maxA = 0;
        int maxB = 0;
        for (int a=-n; a<n; a++) {
            for (int b=-n; b<n; b++) {
                int len = getMaxLength(a, b);
                //System.err.println("len(" + a + "," + b + ")=" + len);
                if (len > maxLength) {
                    maxLength = len;
                    maxA = a;
                    maxB = b;
                }
            }   
        }
        System.out.println(maxA + " " + maxB);
    }
}
