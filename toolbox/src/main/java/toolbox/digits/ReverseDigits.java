package toolbox.digits;

import java.math.BigInteger;

/**
 *
 * @author marckoch
 */
public class ReverseDigits {
    public static long reverse(long number) {
        long result=0;
        while (number>0) {
            int lastDigit = (int)number % 10;
            number /= 10;
            result *=10;
            result += lastDigit;
        }
        return result;
    }
    
    public static BigInteger reverse(BigInteger number) {
        BigInteger result=BigInteger.ZERO;
        while (number.longValue() > 0) {
            BigInteger lastDigit = number.mod(BigInteger.TEN);
            number = number.divide(BigInteger.TEN);
            result = result.multiply(BigInteger.TEN);
            result = result.add(lastDigit);
        }
        return result;
    }
        
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(123456789L));
        
        System.out.println(reverse(BigInteger.valueOf(123L)));
    }
}
