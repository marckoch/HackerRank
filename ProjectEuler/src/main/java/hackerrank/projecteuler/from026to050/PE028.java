package hackerrank.projecteuler.from026to050;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Number spiral diagonals
 * @author marckoch
 */
public class PE028 {
    private static long getDiagSum(long k) {
        // SUM(k) = (16*k^3 + 30k^2 + 26k )/3  +1
        BigInteger K = BigInteger.valueOf(k);
        BigInteger MOD = BigInteger.valueOf(1000000007);
        
        BigInteger res = BigInteger.valueOf(16).multiply(K.pow(3));
        res = res.add(BigInteger.valueOf(30).multiply(K.pow(2)));
        res = res.add(BigInteger.valueOf(26).multiply(K));
        res = res.divide(BigInteger.valueOf(3));
        res = res.add(BigInteger.ONE);
        return res.mod(MOD).longValue();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for (int t=0; t<T; t++) {
            long N = in.nextLong();
            long k = (N-1)/2;
            System.out.println(getDiagSum(k));
        }
    }
}
