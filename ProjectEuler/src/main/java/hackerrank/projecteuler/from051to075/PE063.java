package hackerrank.projecteuler.from051to075;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Powerful digit counts
 * @author marckoch
 */
public class PE063 {
    public static int countDigits(BigInteger number) {
        return number.toString().length();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        int min = 2; //(int) Math.pow(10, 1.0 / N) + 1;
        // System.err.println(min);
        int max = 10;
        // System.err.println(max);
        
        for (int n=min; n<max; n++) {
            BigInteger result = BigInteger.valueOf(n).pow(N);
            if (countDigits(result) == N) {
                //System.err.println(n + "^" + N + "=" +result);
                System.out.println(result);
            }
        }
    }
}
