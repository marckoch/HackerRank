package hackerrank.projecteuler.from001to025;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Lattice paths
 * @author marckoch
 */
public class PE015 {
    private static final BigInteger MOD = BigInteger.valueOf(1000000007);

    private static BigInteger factWithMod(int n) {
        BigInteger result = BigInteger.ONE;
        while (n > 1) {
            result = result.multiply(BigInteger.valueOf(n));
            result = result.mod(MOD);
            n--;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int n = in.nextInt();
            int m = in.nextInt();
            
            // System.err.println("checking n=" + n + " m=" + m);
            
            int max = Math.max(n,m);
            int min = Math.min(n,m);
            
            // System.err.println("checking max=" + max + " min=" + min);
            
            // (max + min)! / ( max! * min! )
            
            BigInteger top = BigInteger.ONE;
            int x = max + min;
            while (x > max) {
                top = top.multiply(BigInteger.valueOf(x));
                //top = top.mod(MOD);
                x--;
            }
            // System.err.println("top=" + top);
            
            BigInteger bottom = BigInteger.ONE;
            int y = min;
            while (y > 1) {
                bottom = bottom.multiply(BigInteger.valueOf(y));
                //bottom = bottom.mod(MOD);
                y--;
            }
            // System.err.println("bottom=" + bottom);
            
            System.out.println(top.divide(bottom).mod(MOD));
        }
    }
}
