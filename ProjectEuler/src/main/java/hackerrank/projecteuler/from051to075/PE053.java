package hackerrank.projecteuler.from051to075;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Combinatoric selections
 * @author marckoch
 */
public class PE053 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long K = in.nextLong();
        
        int count=0;
        for (int n = 1; n <= N; n++) {
            BigInteger nCk = BigInteger.ONE;
            for (long k = 0; k <= n; k++) {
                nCk = nCk.multiply(BigInteger.valueOf(n-k)).divide(BigInteger.valueOf(k+1));
                // System.err.println("C("+n+"|"+k+")=" + nCk);
                if (nCk.compareTo(BigInteger.valueOf(K)) > 0)  {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
}
