package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * Longest Collatz sequence
 * @author marckoch
 */
public class PE014 {
    private static final int MAX_N = 5000000;
    
    // to boost performance we store values
    private static final long[] LENGTHS = new long[MAX_N+1];
    private static final long[] MAX_AT = new long[MAX_N+1];
    
    private static long next(long n) {
        //System.err.println(n);
        if (n==1) return 1;
        if (n%2 ==0) return n/2;
        else return 3*n + 1;
    }
    
    private static long findLength(long n) {
        //System.err.println("findLength("+n+")");
        
        // things outside cache range will be calculated on the fly
        if (n>MAX_N) {
            long nextStep = next(n);
            long lengthFromNextstep = findLength(nextStep);
            return 1 + lengthFromNextstep;
        }
        
        // within cache range we might cache to improve performance
        if (LENGTHS[(int)n]==0) {
            long nextStep = next(n);
            long lengthFromNextStep = findLength(nextStep);
            LENGTHS[(int)n] = 1 + lengthFromNextStep;
            //System.err.println("findLength("+n+") fill cache with " + lengths[n]);
        }
        //System.err.println("findLength("+n+") read from cache: " + lengths[n]);
        return LENGTHS[(int)n];
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        LENGTHS[1]=1;
        
        long maxLength=0;
        long startOfMaxLength=0;
        
        for (int i=1; i<MAX_N; i++) {
            long length = findLength(i);
            if (length >= maxLength) {
                maxLength=length;
                startOfMaxLength=i;
            }
            MAX_AT[i]=startOfMaxLength;
            
            //System.err.println(i + "=" + length + " " + maxAt[i]);
        }

        
        for (int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();

            System.out.println(MAX_AT[n]);
        }
    }
}
