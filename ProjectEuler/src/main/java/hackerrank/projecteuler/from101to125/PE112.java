package hackerrank.projecteuler.from101to125;

import java.util.ArrayList;
import java.util.List;

public class PE112 {

    public static void solveProjectEuler() {
        final long LIMIT = 999;
        double expectedRatio = 0.90;
        int ratioHitAt = 0;

        int countInc = 0;
        int countDec = 0;
        int countDoubles = 0;
        int countBouncy = 0;

        List<Integer> inc = new ArrayList<>();
        List<Integer> dec = new ArrayList<>();

        for (int n = 1; n <= LIMIT; n++) {
            boolean hasIncDigits = hasIncreasingDigits(n);
            boolean hasDecDigits = hasDecreasingDigits(n);

            if (hasIncDigits) {
                countInc++;
                inc.add(n);
            }
            if (hasDecDigits) {
                countDec++;
                dec.add(n);
            }

            // account for 6666 or 3333333, those will be counted twice
            if (hasDecDigits && hasIncDigits) {
                countDoubles++;
            }

            if (!hasDecDigits && !hasIncDigits) {
                countBouncy++;
            }

            if (countBouncy >= expectedRatio * (n)) {
                ratioHitAt = n;
                System.out.println(String.format("ratio of %s hit at n=%s", expectedRatio, ratioHitAt));
                break;
            }
        }

        System.out.println("inc:    " + countInc);
        System.out.println("dec:    " + countDec);
        System.out.println("doubles " + countDoubles);
        System.out.println("nonbouncy:    " + (countInc + countDec - countDoubles));
        System.out.println("bouncy: " + countBouncy);
        System.out.println("sum: " + (countInc + countDec + countBouncy - countDoubles));
        System.out.println("%: " + ((double) countBouncy / (countInc + countDec + countBouncy)));

        System.out.println("inc: " + inc);
        System.out.println("dec: " + dec);
    }

    private static boolean hasIncreasingDigits(long number) {
        int[] digits = digits(number);
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] < digits[i - 1]) return false;
        }
        return true;
    }

    private static boolean hasDecreasingDigits(long number) {
        int[] digits = digits(number);
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] > digits[i - 1]) return false;
        }
        return true;
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

    public static int countDigits(long number) {
        return String.valueOf(number).length();
    }

    public static void main(String[] args) {
        System.out.println(hasIncreasingDigits(123));
        System.out.println(hasDecreasingDigits(123));
        System.out.println(hasIncreasingDigits(321));
        System.out.println(hasDecreasingDigits(321));

        System.out.println(hasIncreasingDigits(12321));
        System.out.println(hasDecreasingDigits(12321));

        solveProjectEuler();
        //solveHackerrank();
    }
}
