package algorithms.dynamicprogramming;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class SamAndSubstrings {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.nextLine();
            int n = s.length();
            final long MODULO = 1000000007L;

            long sum = 0L;
            long ones = 1L;

            for (int i = n - 1; i >= 0; i--) {
                Character c = s.charAt(i);
                sum = (sum + Character.getNumericValue(c) * ones * (i + 1)) % MODULO;
                ones = (ones * 10 + 1) % MODULO;
            }
            System.out.println(sum);
        }
    }
}
