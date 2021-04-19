package algorithms.dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

    private static BigInteger next(BigInteger first, BigInteger second) {
        BigInteger third = first.add(second.pow(2));
        System.err.println("" + first + " " + second + " => " + third);
        return third;
    }

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            int t1 = in.nextInt();
            int t2 = in.nextInt();
            int n = in.nextInt();
            System.err.println("" + t1 + " " + t2 + " " + n);
            
            solve(t1, t2, n);
        }
    }

    static void solve(int t1, int t2, int n) {
        BigInteger first = BigInteger.valueOf(t1);
        BigInteger second = BigInteger.valueOf(t2);
        BigInteger third = null;

        for (int i = 0; i <= n - 3; i++) {
            third = next(first, second);

            first = second;
            second = third;
        }
        System.out.println(third);
    }
}
