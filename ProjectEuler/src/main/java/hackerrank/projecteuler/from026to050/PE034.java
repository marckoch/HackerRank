package hackerrank.projecteuler.from026to050;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Digit factorials
 * @author marckoch
 */
public class PE034 {
    private static final int[] facts = new int[10];
    private static int factorial(int n) {
        int result = 1;

        while (n != 0) {
            result *= n;
            n -= 1;
        }

        return result;
    }

    private static long getDigitFactorialSum(int i) {
        long digitSum=0;
        //System.err.println("checking " + i);
        while (i>0) {
            int lastDigit = i%10;
            //System.err.println("  lastDigit=" + lastDigit);
            digitSum += facts[lastDigit];
            i/=10;
        }
        return digitSum;
    }
    
    public static void solveProjectEuler() {
        long sum=0;
        for (int i=10; i<=1000000; i++) {
            long digitSum = getDigitFactorialSum(i);
            if (digitSum == i) {
                sum += i;
                System.err.println(i + " matches! sum=" + digitSum + " total=" + sum);
            }
        }
        System.out.println(sum);
    }
    
    public static void solveHackerrank(int N) {
        long sum=0;
        for (int i=10; i<=N; i++) {
            long digitSum = getDigitFactorialSum(i);
            if (digitSum % i == 0) {
                sum += i;
                System.err.println(i + " matches! sum=" + digitSum + " total=" + sum);
            }
        }
        System.out.println(sum);
    }
    
    public static void main(String[] args) {
        facts[0]=1;
        for (int i=1;i<10;i++) {
            facts[i] = factorial(i);
        }
        System.err.println(Arrays.toString(facts));
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        solveProjectEuler();
        //solveHackerrank(N);
    }
}
