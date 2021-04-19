package algorithms.bitmanipulation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class LonelyInteger {

    static int lonelyinteger(int[] a) {
        return Arrays.stream(a).reduce(0, (left, right) -> left ^ right);
//        int result = 0;
//        for (int i : a) {
//            result = result ^ i;
//        }
//        return result;
    }

    static int lonelyintegerOldSchool(int[] a) {
        Arrays.sort(a);
        int i = 0;
        while (i + 1 < a.length) {
            if (a[i] != a[i + 1]) {
                return a[i];
            } else {
                i += 2;
            }
        }
        return a[i];
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int result = lonelyinteger(a);
            System.out.println(result);
        }
    }
}
