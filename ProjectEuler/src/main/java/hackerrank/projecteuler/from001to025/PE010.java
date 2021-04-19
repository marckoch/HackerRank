package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * Summation of primes
 * @author marckoch
 */
public class PE010 {
    private static final int LIMIT = 1000001;
    private static final boolean[] PRIME = new boolean[LIMIT];
    private static final long[] SUM = new long[LIMIT];
    
    public static void main(String[] args) {

        for (int i=0; i<LIMIT; i++) {PRIME[i]=true;}
        
        SUM[1]=0;
        SUM[2]=2;

        PRIME[1]=false;
        PRIME[2]=true;
        
        for(int i=3;i<LIMIT;i++) {
            for(int j=2; j*j<=i; j++) {
                if(i%j==0) {
                    PRIME[i]=false;
                    break;
                }
            }
        }
        
        //System.err.println(Arrays.toString(prime));
        
        for(int i=3;i<LIMIT;i++) {
            if(PRIME[i])
                SUM[i]=SUM[i-1] + (long)i;
            else
                SUM[i]=SUM[i-1];
        }

        //System.err.println(Arrays.toString(sum));

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            System.out.println(SUM[n]);
        }
    }
}
