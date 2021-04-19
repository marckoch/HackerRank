package hackerrank.projecteuler.from051to075;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Powerful digit sum
 * @author marckoch
 */
public class PE056 {
    private static long getDigitSum(BigInteger i) {
        BigInteger digitSum = BigInteger.ZERO;
        while (i.compareTo(BigInteger.ZERO) > 0) {
            BigInteger lastDigit = i.mod(BigInteger.TEN);
            digitSum = digitSum.add(lastDigit);
            i = i.divide(BigInteger.TEN);
        }
        return digitSum.longValue();
    }
    
    private static long getDigitSumString(BigInteger i) {
        long digitSum = 0;
        String s = i.toString();
        for (int j = 0; j < s.length(); j++) {
            digitSum += s.charAt(j) - '0';
        }
        return digitSum;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        long maxDigitSum=0;
        for (int A=1; A<N; A++) {
            
            int a=A;
            
            // multiples of ten will only add zeros to the result 
            // which will not affect the digitSum
            while (a%10==0) {
                a /= 10;
            }
            
            if (a==1) continue;
            
            for (int b=1; b<N; b++) {
                BigInteger result = BigInteger.valueOf(a).pow(b);
                long digitSum = getDigitSumString(result);
                //System.err.println(a + "^" + b + "=" + result + " >> " + digitSum);
                maxDigitSum = Math.max(maxDigitSum, digitSum);
            }
        }
        System.out.println(maxDigitSum);
    }
}
