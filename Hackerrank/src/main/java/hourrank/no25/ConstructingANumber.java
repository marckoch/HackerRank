package hourrank.no25;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class ConstructingANumber {

    private static long getDigitSum(long i) {
        long digitSum = 0;
        while (i > 0) {
            long lastDigit = i % 10;
            digitSum += lastDigit;
            i /= 10;
        }
        return digitSum;
    }

    static String canConstruct(int[] a) {
        long digitSum = 0L;
        for (int i = 0; i < a.length; i++) {
            digitSum += getDigitSum(a[i]);
        }
        return digitSum % 3 == 0 ? "Yes" : "No";
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int a0 = 0; a0 < t; a0++) {
                int n = in.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                }
                String result = canConstruct(a);
                System.out.println(result);
            }
        }
    }
}
