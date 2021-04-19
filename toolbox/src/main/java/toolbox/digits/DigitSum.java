package toolbox.digits;

import java.math.BigInteger;

/**
 *
 * @author marckoch
 */
public class DigitSum {

    private static long getDigitSum(long i) {
        long digitSum = 0;
        while (i > 0) {
            long lastDigit = i % 10;
            digitSum += lastDigit;
            i /= 10;
        }
        return digitSum;
    }
    
    // slow because of many method calls!
    private static long getDigitSum(BigInteger i) {
        BigInteger digitSum = BigInteger.ZERO;
        while (i.compareTo(BigInteger.ZERO) > 0) {
            BigInteger lastDigit = i.mod(BigInteger.TEN);
            digitSum = digitSum.add(lastDigit);
            i = i.divide(BigInteger.TEN);
        }
        return digitSum.longValue();
    }
    
    // this one is the fastest!
    private static long getDigitSumString(BigInteger i) {
        long digitSum = 0;
        String s = i.toString();
        for (int j = 0; j < s.length(); j++) {
            digitSum += s.charAt(j) - '0';
        }
        return digitSum;
    }
      
    // this one is the fastest!
    private static long getDigitSumString(String s) {
        long digitSum = 0;
        for (int j = 0; j < s.length(); j++) {
            digitSum += s.charAt(j) - '0';
        }
        return digitSum;
    }

    private static int digitSum(BigInteger bi) {
        return bi
                .toString()
                .chars()
                .map(i -> Character.digit(i, 10))
                .sum();
    }
    
    public static void main(String[] args) {
        System.out.println("getDigitSum(123)=" + getDigitSum(123));
        System.out.println("getDigitSum(1234567898765432)=" + getDigitSum(1234567898765432L));
        
        System.out.println("getDigitSum(33223344)=" + getDigitSum(BigInteger.valueOf(33223344)));
        System.out.println("getDigitSum(33223344)=" + digitSum(BigInteger.valueOf(33223344)));
        
        System.out.println("getDigitSum(100^100)=" + getDigitSum(BigInteger.valueOf(199).pow(199)));

        System.out.println("getDigitSum(100^100)=" + getDigitSumString(BigInteger.valueOf(199).pow(199)));
        
        System.out.println("getDigitSum(100^100)=" + digitSum(BigInteger.valueOf(199).pow(199)));
        
    }
}
