package hackerrank.projecteuler.from051to075;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Square root convergents
 * @author marckoch
 */
public class PE057 {
    private static final BigInteger TWO = BigInteger.valueOf(2);
        
    public static int countDigits(BigInteger number) {
        return number.toString().length();
    }

    public static int getDigitCount(BigInteger number) {
        double factor = Math.log(2) / Math.log(10);
        int digitCount = (int) (factor * number.bitLength() + 1);
        if (BigInteger.TEN.pow(digitCount - 1).compareTo(number) > 0) {
            return digitCount - 1;
        }
        return digitCount;
    }

    private static BigInteger[] next(BigInteger[] fraction) {
        BigInteger top = fraction[0];
        BigInteger bottom = fraction[1];
        
        BigInteger[] next = new BigInteger[2];
        next[0] = top.add(bottom.multiply(TWO));
        next[1] = top.add(bottom);
        return next;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        BigInteger[] current = { BigInteger.valueOf(3), TWO };
        
        for (int n=1; n<=N; n++) {
            BigInteger top = current[0];
            BigInteger bottom = current[1];
            System.err.println(n + " " + current[0] + "/" + current[1] );
            if (getDigitCount(top) > getDigitCount(bottom)) {
                System.out.println(n);
            }
            current = next(current);
        }
    }
}
