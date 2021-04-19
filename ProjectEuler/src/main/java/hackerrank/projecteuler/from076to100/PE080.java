package hackerrank.projecteuler.from076to100;

import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_UP;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Scanner;

/**
 * Square root digital expansion
 *
 * @author marckoch
 */
public class PE080 {

    // https://stackoverflow.com/questions/13649703/square-root-of-bigdecimal-in-java?noredirect=1&lq=1
    public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
        BigDecimal x0 = BigDecimal.ZERO;
        BigDecimal TWO = BigDecimal.valueOf(2);
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            
//            x1 = A.divide(x0, SCALE, ROUND_HALF_UP);
//            x1 = x1.add(x0);
//            x1 = x1.divide(TWO, SCALE, ROUND_HALF_UP);
            x1 = A.divide(x0, SCALE, ROUND_HALF_UP).add(x0).divide(TWO, SCALE, ROUND_HALF_UP);
        }
        return x1;
    }

    // https://stackoverflow.com/questions/13649703/square-root-of-bigdecimal-in-java
    public static BigDecimal bigSqrt(BigDecimal d, MathContext mc) {
        // 1. Make sure argument is non-negative and treat Argument 0
        int sign = d.signum();
        if (sign == -1) {
            throw new ArithmeticException("Invalid (negative) argument of sqrt: " + d);
        } else if (sign == 0) {
            return BigDecimal.ZERO;
        }
        // 2. Scaling:
        // factorize d = scaledD * scaleFactorD 
        //             = scaledD * (sqrtApproxD * sqrtApproxD)
        // such that scalefactorD is easy to take the square root
        // you use scale and bitlength for this, and if odd add or subtract a one
        BigInteger bigI = d.unscaledValue();
        int bigS = d.scale();
        int bigL = bigI.bitLength();
        BigInteger scaleFactorI;
        BigInteger sqrtApproxI;
        if ((bigL % 2 == 0)) {
            scaleFactorI = BigInteger.ONE.shiftLeft(bigL);
            sqrtApproxI = BigInteger.ONE.shiftLeft(bigL / 2);
        } else {
            scaleFactorI = BigInteger.ONE.shiftLeft(bigL - 1);
            sqrtApproxI = BigInteger.ONE.shiftLeft((bigL - 1) / 2);
        }
        BigDecimal scaleFactorD;
        BigDecimal sqrtApproxD;
        if ((bigS % 2 == 0)) {
            scaleFactorD = new BigDecimal(scaleFactorI, bigS);
            sqrtApproxD = new BigDecimal(sqrtApproxI, bigS / 2);
        } else {
            scaleFactorD = new BigDecimal(scaleFactorI, bigS + 1);
            sqrtApproxD = new BigDecimal(sqrtApproxI, (bigS + 1) / 2);
        }
        BigDecimal scaledD = d.divide(scaleFactorD);

        // 3. This is the core algorithm:
        //    Newton-Ralpson for scaledD : In case of f(x)=sqrt(x),
        //    Heron's Method or Babylonian Method are other names for the same thing.
        //    Since this is scaled we can be sure that scaledD.doubleValue() works 
        //    for the start value of the iteration without overflow or underflow
        System.err.println("ScaledD=" + scaledD);
        double dbl = scaledD.doubleValue();
        double sqrtDbl = Math.sqrt(dbl);
        BigDecimal a = new BigDecimal(sqrtDbl, mc);

        BigDecimal HALF = BigDecimal.ONE.divide(BigDecimal.ONE.add(BigDecimal.ONE));
        BigDecimal h = new BigDecimal("0", mc);
        // when to stop iterating? You start with ~15 digits of precision, and Newton-Ralphson is quadratic
        // in approximation speed, so in roundabout doubles the number of valid digits with each step.
        // This may be safer than testing a BigDecimal against zero.
        int prec = mc.getPrecision();
        int start = 15;
        do {
            h = scaledD.divide(a, mc);
            a = a.add(h).multiply(HALF);
            start *= 2;
        } while (start <= prec);
        // 3. Return rescaled answer. sqrt(d)= sqrt(scaledD)*sqrtApproxD :          
        return (a.multiply(sqrtApproxD));
    }

    // too slow !!
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
    
    // this one is the fastest!
    private static long getDecimalDigitSumString(BigDecimal i, int numberOfDigits) {
        long digitSum = 0;
        String s = i.toString();
        int start = 0;
        while (numberOfDigits > 0) {
            char c = s.charAt(start++);
            if (c != '.') { // count every digit before or after decimal point EXCEPT decimal point!
                digitSum += c - '0';
                numberOfDigits--;
            }
        }
        return digitSum;
    }
    
    private static long getDecimalDigitSumString(BigInteger i, int numberOfDigits) {
        long digitSum = 0;
        String s = i.toString();
        int start = 0;
        while (numberOfDigits > 0) {
            char c = s.charAt(start++);
            if (c != '.') { // count every digit before or after decimal point EXCEPT decimal point!
                digitSum += c - '0';
                numberOfDigits--;
            }
        }
        return digitSum;
    }

    public static long solve(int N, int numberOfDigits) {
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (int n = 1; n <= N; n++) {

            // skip square numbers
            int root = (int) Math.sqrt(n);
            if (root * root == n) {
                continue;
            }

            //long digitSum = getDecimalDigitSumString(bigSqrt(BigDecimal.valueOf(n), new MathContext(numberOfDigits + 5)), numberOfDigits);
            long digitSum = getDecimalDigitSumString(sqrt(BigDecimal.valueOf(n), numberOfDigits + 5), numberOfDigits);
            //long digitSum = getDecimalDigitSumString(squareroot(n, numberOfDigits), numberOfDigits);
            sum += digitSum;
        }
        System.err.println("took " + (System.currentTimeMillis()- start));
        return sum;
    }
    
    public static void solveProjectEuler() {
        System.out.println(solve(100, 100));
    }
    
    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int NUMBER_OF_DIGITS = in.nextInt();
        System.out.println(solve(N, NUMBER_OF_DIGITS));
    }

    public static void main(String[] args) {
        //solveProjectEuler();
        solveHackerrank();
    }
}
