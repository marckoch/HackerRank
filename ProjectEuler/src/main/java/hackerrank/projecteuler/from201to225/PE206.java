package hackerrank.projecteuler.from201to225;

import java.util.Arrays;

public class PE206 {

    // 1002290129674248100
    // 1_2_3_4_5_6_7_8_9_0
    public static void solveProjectEuler() throws Exception {
        for (long n = 0; n < 1_000_000_000L; n++) {
            //   System.out.println(n + ":" + weave(n));
            long newNumber = weave(n);
            long root = Math.round(Math.sqrt(newNumber));
            if (root * root == newNumber) {
                System.out.println("winner=" + (long)root + " " + newNumber + " root^2=" + ((long)root*root));
            }
        }
    }

    public static long weave(long input) {
        int[] digits = digits(input);
        //System.out.println(Arrays.toString(digits));
        int[] newnumber = new int[]{1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9, 0, 0};
        //System.out.println(Arrays.toString(newnumber));

        for (int i = digits.length-1, j=newnumber.length-2; i >=0; i--, j-=2) {
            newnumber[j] = digits[i];
        }

        return toLong(newnumber);
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

    private static long toLong(int[] digits) {
        long result = 0L;
        for (int i = 0; i < digits.length; i++) {
            result += digits[i];
            if (i < digits.length - 1)
                result *= 10;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        solveProjectEuler();
        //solveHackerrank();
    }
}
