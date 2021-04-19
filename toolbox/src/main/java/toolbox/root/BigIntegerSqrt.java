package toolbox.root;

import java.math.BigInteger;

/**
 *
 * @author marckoch
 */
public class BigIntegerSqrt {

    public static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = n.shiftRight(5).add(BigInteger.valueOf(8));
        while (b.compareTo(a) >= 0) {
            BigInteger mid = a.add(b).shiftRight(1);
            if (mid.multiply(mid).compareTo(n) > 0) {
                b = mid.subtract(BigInteger.ONE);
            } else {
                a = mid.add(BigInteger.ONE);
            }
        }
        return a.subtract(BigInteger.ONE);
    }
    
    

    private static BigInteger squareroot(int n, int digits) {
        BigInteger limit = BigInteger.TEN.pow(digits + 1);
        BigInteger FIVE = BigInteger.valueOf(5);
        BigInteger ONE_HUNDRED = BigInteger.valueOf(100);

        BigInteger a = BigInteger.valueOf(5 * n);
        BigInteger b = FIVE;

        while (b.compareTo(limit) < 0) {
            if (a.compareTo(b) >= 0) {
                a = a.subtract(b);
                b = b.add(BigInteger.TEN);
            } else {
                a = a.multiply(ONE_HUNDRED);
                b = b.divide(BigInteger.TEN).multiply(ONE_HUNDRED).add(FIVE);
            }
        }

        return b.divide(ONE_HUNDRED);
    }

    public static void main(String[] args) {
        System.out.println(sqrt(BigInteger.valueOf(16)));
        System.out.println(sqrt(BigInteger.valueOf(36)));
        
        System.out.println(squareroot(167, 20));
        System.out.println(squareroot(36, 20));
        System.out.println(squareroot(144, 20));
    }
}
