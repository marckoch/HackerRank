package hackerrank.projecteuler.from051to075;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Convergents of e
 *
 * @author marckoch
 */
public class PE065 {

    public static int getConvergenceNumber(int n) {
        if (n % 3 == 0) {
            return 2 * n / 3;
        }
        return 1;
    }

    public static long[] expand(int add, long[] fraction) {
        long top = fraction[0];
        long bottom = fraction[1];

        return new long[]{bottom * add + top, bottom};
    }

    public static BigInteger[] expand(int add, BigInteger[] fraction) {
        BigInteger top = fraction[0];
        BigInteger bottom = fraction[1];

        return new BigInteger[]{bottom.multiply(BigInteger.valueOf(add)).add(top), bottom};
    }

    public static long[] invert(long[] fraction) {
        long top = fraction[0];
        long bottom = fraction[1];
        return new long[]{bottom, top};
    }

    public static BigInteger[] invert(BigInteger[] fraction) {
        BigInteger top = fraction[0];
        BigInteger bottom = fraction[1];
        return new BigInteger[]{bottom, top};
    }

    public static long[] getConvergent(int n) {
        if (n==1) 
            return new long[] {2, 1};
        
        long[] current = {1, getConvergenceNumber(n)};
        //System.err.println(" " + Arrays.toString(current));

        for (int i = n - 1; i > 1; i--) {
            current = expand(getConvergenceNumber(i), current);
            current = invert(current);
            //System.err.println(i + " " + Arrays.toString(current));
        }
        current = expand(2, current);
        return current;
    }

    public static BigInteger[] getConvergentBI(int n) {
        if (n==1) 
            return new BigInteger[] {BigInteger.valueOf(2), BigInteger.ONE};
        
        BigInteger[] current = {BigInteger.ONE, BigInteger.valueOf(getConvergenceNumber(n))};
        System.err.println(" " + Arrays.toString(current));

        for (int i = n - 1; i > 1; i--) {
            current = expand(getConvergenceNumber(i), current);
            current = invert(current);
            System.err.println(i + " " + Arrays.toString(current));
        }
        current = expand(2, current);
        return current;
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
    
    public static long getDigitSumOfTop(int n) {
        BigInteger[] result = getConvergentBI(n);
        BigInteger top = result[0];
        return getDigitSumString(top);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(getDigitSumOfTop(N));
    }
}
