package toolbox.root;

import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_UP;
import java.math.BigInteger;
import java.math.MathContext;
import static java.math.RoundingMode.HALF_UP;

/**
 *
 * @author marckoch
 */
public class BigDecimalSqrt {

    // https://stackoverflow.com/questions/13649703/square-root-of-bigdecimal-in-java?noredirect=1&lq=1
    public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
        BigDecimal x0 = BigDecimal.ZERO;
        BigDecimal TWO = BigDecimal.valueOf(2);
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, SCALE, ROUND_HALF_UP);

        }
        return x1;
    }

    static BigDecimal sqrt2(BigDecimal n, int SCALE) {
        int scalePrecisionAdjuster = 10;
        BigDecimal t = BigDecimal.ZERO, r = new BigDecimal(Math.sqrt(n.doubleValue()));
        BigDecimal TWO = BigDecimal.valueOf(2);
        for (; !t.equals(r); r = n.divide(t, SCALE + scalePrecisionAdjuster, HALF_UP)
                .add(t)
                .divide(TWO, SCALE + scalePrecisionAdjuster, HALF_UP)) {
            t = r;
        }
        return new BigDecimal(r.toString().replaceAll(".{" + scalePrecisionAdjuster + "}$", ""));
    }

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
        System.out.println("ScaledD=" + scaledD);
        double dbl = scaledD.doubleValue();
        double sqrtDbl = Math.sqrt(dbl);
        BigDecimal a = new BigDecimal(sqrtDbl, mc);

        BigDecimal HALF = BigDecimal.ONE.divide(BigDecimal.ONE.add(BigDecimal.ONE));
        BigDecimal h = new BigDecimal("0", mc);
        // when to stop iterating? You start with ~15 digits of precision, and Newton-Ralphson is quadratic
        // in approximation speed, so in roundabout doubles the number of valid digits with each step.
        // This fmay be safer than testing a BigDecifmal against zero.
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

    public static void compare(int n, int precision) {
        long start = System.currentTimeMillis();
        System.out.println("algo1 " + sqrt(BigDecimal.valueOf(n), precision));
        System.err.println("algo1 took " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println("algo2 " + sqrt2(BigDecimal.valueOf(n), precision));
        System.err.println("algo2 took " + (System.currentTimeMillis() - start));
        
        start = System.currentTimeMillis();
        System.out.println("algo3 " + bigSqrt(BigDecimal.valueOf(n), new MathContext(precision)));
        System.err.println("algo3 took " + (System.currentTimeMillis() - start));
        
    }

    public static void main(String[] args) {
        //System.out.println(sqrt(BigDecimal.valueOf(2), 1000));
        //System.out.println(sqrt2(BigDecimal.valueOf(2), 1000));

        //compare(2, 100);
        
        compare(2, 1000);

        //compare(12345678, 1000);
    }
}
