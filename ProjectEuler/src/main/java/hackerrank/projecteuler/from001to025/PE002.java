package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * Even Fibonacci numbers
 *
 * @author marckoch
 */
public class PE002 {
    public static long getSum(long limit) {
        long f1 = 1;
        long f0 = 0;
        long fn = f1 + f0;
        long sum = 0;
        while (fn < limit) {
            if (fn % 2 == 0) {
                sum += fn;
            }
            f0 = f1;
            f1 = fn;
            fn = f1 + f0;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            System.out.println(getSum(n));
        }
    }
}
