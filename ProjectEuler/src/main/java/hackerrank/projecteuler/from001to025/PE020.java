package hackerrank.projecteuler.from001to025;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Factorial digit sum
 * @author marckoch
 */
public class PE020 {
    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();

            BigInteger res = factorial(BigInteger.valueOf(n));
            
            long digitSum = 0L;
            String s = String.valueOf(res);
            for (Character c: s.toCharArray()) {
                digitSum += Character.getNumericValue(c);
            }
            System.out.println(digitSum);
        }
    }
}
