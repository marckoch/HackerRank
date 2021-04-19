package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class HackerRankInAString {

    private static boolean check(String s) {
        int ix = -1;
        ix = s.indexOf('h', ix + 1);
        if (ix < 0) {
            return false;
        }
        ix = s.indexOf('a', ix + 1);
        if (ix < 0) {
            return false;
        }
        ix = s.indexOf('c', ix + 1);
        if (ix < 0) {
            return false;
        }
        ix = s.indexOf('k', ix + 1);
        if (ix < 0) {
            return false;
        }
        ix = s.indexOf('e', ix + 1);
        if (ix < 0) {
            return false;
        }
        ix = s.indexOf('r', ix + 1);
        if (ix < 0) {
            return false;
        }
        ix = s.indexOf('r', ix + 1);
        if (ix < 0) {
            return false;
        }
        ix = s.indexOf('a', ix + 1);
        if (ix < 0) {
            return false;
        }
        ix = s.indexOf('n', ix + 1);
        if (ix < 0) {
            return false;
        }
        ix = s.indexOf('k', ix + 1);
        if (ix < 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int Q = in.nextInt();
            while (Q-- > 0) {
                String s = in.next();
                System.out.println(check(s) ? "YES" : "NO");
            }
        }
    }
}
