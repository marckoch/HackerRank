package hackerrank.projecteuler.from026to050;

import java.util.Scanner;

/**
 * Digit Nth powers
 * @author marckoch
 */
public class PE030 {
    private static final int[] DIGIT_POWERS = new int[10];
    
    private static int getDigitSum(int i, int N) {
        int digitSum=0;
        //System.err.println("checking " + i);
        while (i>0) {
            int lastDigit = i%10;
            //System.err.println("  lastDigit=" + lastDigit);
            digitSum += DIGIT_POWERS[lastDigit];
            
            i/=10;
        }
        //System.err.println("   digitSum=" + digitSum);
        return digitSum;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int limit = 7 * (int)Math.pow(9, N);
        //System.err.println("N=" + N + " limit=" + limit);

        for (int i=0; i<10; i++) {
            DIGIT_POWERS[i] = (int) Math.pow(i, N);
        }
        //System.err.println(Arrays.toString(digitPowers));
        
        int sum=0;
        for (int i=2; i<limit; i++) {
            if (i == getDigitSum(i, N)) {
                //System.err.println(i + " is a match!");
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
