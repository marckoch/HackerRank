package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class Pangrams {

    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.nextLine().toLowerCase();
            solve(s);
        }
    }

    static void solve(String s) {
        //System.err.println(s);
        boolean letterMissing = false;
        for (char c = 'a'; c <= 'z'; c++) {
            if (s.indexOf(c) < 0) {
                letterMissing = true;
                break;
            }
        }
        System.out.println((letterMissing ? "not " : "") + "pangram");
    }
}
