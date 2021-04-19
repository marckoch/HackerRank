package hackerrank.projecteuler.from026to050;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Self powers
 * @author marckoch
 */
public class PE048 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        BigInteger MOD = BigInteger.valueOf(10000000000L);
            
        BigInteger result = BigInteger.ZERO;
        for (int i=1; i<=N; i++) {
            // multiples of 10^10 do not change the last 10 digits, so we can skip them
            if (i%10==0) continue;
            
            BigInteger I = BigInteger.valueOf(i);
            result = result.add(I.modPow(I, MOD)).mod(MOD);
        }
        System.out.println(result.mod(MOD));
    }
}
