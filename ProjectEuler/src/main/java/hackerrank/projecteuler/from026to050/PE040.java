package hackerrank.projecteuler.from026to050;

import java.util.Scanner;

/**
 * Champernowne's constant
 * @author marckoch
 */
public class PE040 {
    private static int getDigit(long pos) {
        // first we check in which group of n-digit numbers we are
        // (1-9, 10-99, 100-999, ...)
        int digits = 1;
        long range = 9; 
        long first = 1; // first number in the range
        long skip = 0;
        
        while (skip + digits*range < pos) {
            skip += digits*range;  // skip everything from previous range
            digits++;    // from now one we have more digits
            range *= 10; 
            first *= 10;
        }
        
        //System.err.println("pos=" + pos + " is in range of " + range + " " + digits + "-digit numbers, starting from " + first + ", skipped digits=" + skip);
        
        // now we know we are in position posInRange within this range
        long posInRange = pos - skip;
        //System.err.println("  posInRange=" + posInRange);

        // now we check how many n-digit numbers we can skip
        int rest = (int) (posInRange % digits);
        long count = posInRange / digits;
        
        // if there is no rest modulo we must go back one number!
        if (rest==0) {
            count--;
            rest = digits;
        }
        //System.err.println("  rest=" + rest + " count=" + count);
        
        // we are in this n-digit number:
        long number = first + count;
        
        // ... and we are at position (rest-1)
        char c = String.valueOf(number).charAt(rest-1);
        //System.err.println("  of number " + number + " we take the digit in pos " + (rest-1) + " which is " + c);
        return Character.getNumericValue(c);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int T = in.nextInt();
        
        for (int t=0; t<T; t++) {
            
            long result = 1L;
            for (int i=1; i<=7; i++) {
                long pos = in.nextLong();
                result *= getDigit(pos);
            }
            System.out.println(result);
        }
    }
}
