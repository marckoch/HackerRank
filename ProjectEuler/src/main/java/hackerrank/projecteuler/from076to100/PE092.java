package hackerrank.projecteuler.from076to100;

import toolbox.digits.CountDigits;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 */
public class PE092 {
    private static Set<Long> endingAt89 = new HashSet<>();
    private static Set<Long> endingAt1 = new HashSet<>();

    public static int countDigits(long number) {
        return String.valueOf(number).length();
    }

    private static int[] digits(long i) {
        int cd = countDigits(i);
        int[] result = new int[cd];
        int index = 0;
        while (i > 0) {
            int lastDigit = (int) i % 10;
            result[cd - 1 - index++] = lastDigit;
            i /= 10;
        }
        return result;
    }

    private static int getSumOfSquaredDigits(long x) {
        int[] digits = digits(x);
        return Arrays.stream(digits) //
                .map(operand -> operand * operand) //
                .sum();
    }

    public static boolean endsAt89(long n) {
        //System.err.println("checking " + n);
        if (endingAt89.contains(n))
            return true;
        if (endingAt1.contains(n))
            return false;

        long sum = getSumOfSquaredDigits(n);

        if (sum == 89) {
            endingAt89.add(n);
            return true;
        } else if (sum == 1) {
            endingAt1.add(n);
            return false;
        }
        boolean res = endsAt89(sum);
        if (res) {
            endingAt89.add(sum);
        } else {
            endingAt1.add(sum);
        }
        return res;
    }

    public static long solve(long N) {
        long result = 0;

        for (int i = 1; i < N; i++) {
            if (endsAt89(i))
                result++;
        }

        return result;
    }

    public static void solveProjectEuler() {
        System.out.println(solve(10_000_000));
    }

    // 37 %
    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(solve((long) Math.pow(10.0, N)));
    }

    public static void main(String[] args) {
        //solveProjectEuler();
        solveHackerrank();
    }
}
