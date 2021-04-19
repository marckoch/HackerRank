package hackerrank.projecteuler.from051to075;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Lychrel numbers
 * @author marckoch
 */
public class PE055 {
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

    private static BigInteger findPalindrome(BigInteger number) {
        if (isPalindrome(number)) {
            return number;
        }
        
        BigInteger next = number;
        for (int step=0; step<=50; step++) {
            next = next.add(reverse(next));
            //System.err.println("  p(" + number + ",step=" + step + ")=" + next);
            if (isPalindrome(next)) 
                return next;
        }
        return BigInteger.ZERO;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        BigInteger[] finalPalindromes = new BigInteger[N+1];
        Map<BigInteger, Integer> freq = new TreeMap<>();
        
        BigInteger mostFreqPalindrome = BigInteger.ONE;
        int freqOfMostFreqPalindrome = 1;

        for (int n=10; n<=N; n++) {
            BigInteger p = findPalindrome(BigInteger.valueOf(n));
            if (p == BigInteger.ZERO) {
                continue;
            }
            finalPalindromes[n]=p;
            
            if (freq.get(p) == null) {
                freq.put(p, 1);
            } else {
                int f = freq.get(p);
                freq.put(p, f + 1);
                
                if (f+1>freqOfMostFreqPalindrome) {
                    freqOfMostFreqPalindrome=f+1;
                    mostFreqPalindrome=p;
                }
            }
            
        }
        System.err.println(Arrays.toString(finalPalindromes));
        System.err.println(freq);
        System.out.println(mostFreqPalindrome + " " + freqOfMostFreqPalindrome);
    }
}
