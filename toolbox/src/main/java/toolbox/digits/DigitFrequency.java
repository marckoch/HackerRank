package toolbox.digits;

import java.math.BigInteger;
import java.util.Arrays;

public class DigitFrequency {

    // ATTENTION: only works if a digit does NOT occur more than 10 times!
    private static int digitFrequency(long x) {
        int result = 0;
        while (x > 0) {
            long digit = x % 10;

            int pos = 1;
            for (int i = 1; i <= digit; i++) {
                pos *= 10;
            }
            result += pos;

            x /= 10;
        }
        return result;
    }

    private static int[] digitFrequency(BigInteger number) {
        int[] result = new int[10];
        for (char c : number.toString().toCharArray()) {
            result[Character.getNumericValue(c)]++;
        }
        System.err.println(number.toString() + " -> " + Arrays.toString(result));
        return result;
    }
        
    private static String digitFrequencyString(BigInteger number) {
        int[] frequency = digitFrequency(number);
        StringBuilder sb = new StringBuilder();
        for (int f : frequency) {
            sb.append(f).append("_");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    private static String digitsSorted(BigInteger bi) {
        char[] digits = bi.toString().toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
        
    public static void main(String[] args) {
        System.out.println("digitFrequency(1234567890)=" + digitFrequency(1234567890));
        
        System.out.println("digitFrequency(3334)=" + digitFrequency(3334));
        System.out.println("digitFrequency(3333333333333L)=" + digitFrequency(3333333333333L));
        
        System.out.println("digitFrequency(3333333333333L)=" + Arrays.toString(digitFrequency(BigInteger.valueOf(3333333333333L))));
        
        System.out.println("digitFrequency(100_000 ^ 3)=" + Arrays.toString(digitFrequency(BigInteger.valueOf(100_000-1).pow(3))));

        System.out.println("digitFrequencyString(100_000 ^ 3)=" + digitFrequencyString(BigInteger.valueOf(100_000-1).pow(3)));

        System.out.println("digitFrequency(22322457)=" + digitFrequency(22322457));
    }
}
