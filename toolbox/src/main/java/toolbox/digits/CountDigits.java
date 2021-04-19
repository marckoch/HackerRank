package toolbox.digits;

import java.math.BigInteger;

/**
 *
 * @author marckoch
 */
public class CountDigits {
    
    public static int countDigits(long number) {
        return String.valueOf(number).length();
    }

    // SLOW 
    public static int countDigits(BigInteger number) {
        return number.toString().length();
    }
    
    // FAST
    public static int getDigitCount(BigInteger number) {
        double factor = Math.log(2) / Math.log(10);
        int digitCount = (int) (factor * number.bitLength() + 1);
        if (BigInteger.TEN.pow(digitCount - 1).compareTo(number) > 0) {
            return digitCount - 1;
        }
        return digitCount;
    }
    
    public static void main(String[] args) {
        System.out.println(countDigits(2323232345L));
    }
    
}
