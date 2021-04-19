package toolbox.fraction;

import java.math.BigInteger;

/**
 *
 * @author marckoch
 */
public class Fractions {
    public static BigInteger[] expand(int add, BigInteger[] fraction) {
        BigInteger top = fraction[0];
        BigInteger bottom = fraction[1];

        return new BigInteger[]{bottom.multiply(BigInteger.valueOf(add)).add(top), bottom};
    }

    public static BigInteger[] divide(int n, BigInteger[] fraction) {
        BigInteger top = fraction[0];
        BigInteger bottom = fraction[1];
        return new BigInteger[]{bottom.multiply(BigInteger.valueOf(n)), top};
    }
    
    private static long gcd(long a, long b) {
        while (a != 0) {
            long c = a;
            a = b % a;
            b = c;
        }
        return b;
    }
        
    public static BigInteger[] simplify(BigInteger[] fraction) {
        BigInteger top = fraction[0];
        BigInteger bottom = fraction[1];
        long gcd = gcd(top.longValue(), bottom.longValue());
        return new BigInteger[]{top.divide(BigInteger.valueOf(gcd)), bottom.divide(BigInteger.valueOf(gcd))};
    }
}
