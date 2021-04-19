package toolbox.digits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author marckoch
 */
public class GetDigits {
    public static int[] digits(long i) {
        int cd = CountDigits.countDigits(i);
        int[] result = new int[cd];
        int index=0;
        while (i > 0) {
            int lastDigit = (int) i % 10;
            result[cd - 1 - index++] = lastDigit;
            i /= 10;
        }
        return result;
    }

    public static int[] digits2(long i) {
        List<Integer> digits = new ArrayList<>();
        while (i > 0) {
            int lastDigit = (int) i % 10;
            digits.add(lastDigit);
            i /= 10;
        }
        return digits.stream().mapToInt(n -> n).toArray();
    }

    private static long toLong(int[] digits) {
        long result = 0L;
        for (int i=0; i<digits.length; i++) {
            result += digits[i];
            if (i<digits.length-1) 
                result *= 10;
        }
        return result;
    }
    
    private static int toInt(int[] digits) {
        int result = 0;
        for (int i=0; i<digits.length; i++) {
            result += digits[i];
            if (i<digits.length-1) 
                result *= 10;
        }
        return result;
    }
        
    public static void main(String[] args) {
        System.out.println(Arrays.toString(digits(1230)));
        System.out.println(Arrays.toString(digits(12002230)));
        
        System.out.println(toLong(digits(1234)));
    }
}
