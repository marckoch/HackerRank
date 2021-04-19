package toolbox.digits;

import java.util.Arrays;

/**
 *
 * @author marckoch
 */
public class InsertDigits {

    public static int countDigits(long number) {
        return String.valueOf(number).length();
    }

    private static long[] insert(long x, int insert) {
        int digits = countDigits(x);
        long[] result = new long[digits + 1];
        for (int i = 0; i <= digits; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(x));
            result[i] = Long.valueOf(sb.insert(i, String.valueOf(insert)).toString());
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(insert(123, 5)));

        for (int i = 1; i <= 9; i++) {
            long[] n = insert(1, i);

            for (int j = 0; j < n.length; j++) {
                long l = n[j];
                for (int k = 1; k <= 9; k++) {
                    if (i != k) {
                        long[] n2 = insert(l, k);
                        System.out.println(i + " " + j + " " + k + " " + Arrays.toString(n2));
                    }
                }

            }

        }
    }
}
