package hackerrank.projecteuler.from151to175;

import java.util.Arrays;

public class PE156 {

    public static void main(String[] args) {
        final int LIMIT = 199981;
        //buildArray(LIMIT);

        long freq2 = countDigit(LIMIT, 1);
        System.out.println(freq2);
    }

    private static void buildArray(int LIMIT) {
        int[][] count = new int[LIMIT + 1][10];

        for (int i = 0; i <= LIMIT; i++) {
            int number = i;
            //System.out.println(number);
            while (number > 0) {
                int lastDigit = number % 10;

                for (int j = i; j <= LIMIT; j++) {
                    count[j][lastDigit]++;
                }

                number /= 10;
            }
        }

        for (int i = 0; i < LIMIT; i++) {
            System.out.println(i + " " + Arrays.toString(count[i]));
        }
    }

    public static long countDigit(int limit, int digit) {
        long count = 0;
        for (int i = 0; i <= limit; i++) {
            int number = i;
            //System.out.println(number);
            while (number > 0) {
                int lastDigit = number % 10;

                if (lastDigit == digit) count++;

                number /= 10;
            }
        }
        return count;
    }
}
