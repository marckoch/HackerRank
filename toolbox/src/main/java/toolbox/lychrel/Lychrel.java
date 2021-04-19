package toolbox.lychrel;

import java.math.BigInteger;

/**
 *
 * @author marckoch
 */
public class Lychrel {
    public static BigInteger reverse(BigInteger number) {
        BigInteger result=BigInteger.ZERO;
        final BigInteger TEN = BigInteger.valueOf(10);
        while (number.longValue() > 0) {
            BigInteger lastDigit = number.mod(TEN);
            number = number.divide(TEN);
            result = result.multiply(TEN);
            result = result.add(lastDigit);
        }
        return result;
    }
    
    private static boolean isPalindrome(BigInteger i) {
        String s = i.toString();
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        return s.equals(reverse);
    }
    
    private static boolean isLychrel(BigInteger number) {
        BigInteger next = number;
        for (int step=0; step<=50; step++) {
            next = next.add(reverse(next));
            if (isPalindrome(next)) 
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int count=0;
        for (int i = 10; i < 10000; i++) {
            if (isLychrel(BigInteger.valueOf(i)))
                count++;
        }
        System.out.println(count);
    }
}
