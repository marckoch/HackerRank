package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class FunnyString {

    static String funnyString(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length() - 1; i++) {
            int diffS = Math.abs(s.charAt(i) - s.charAt(i + 1));
            int diffRev = Math.abs(rev.charAt(i) - rev.charAt(i + 1));
            if (diffS != diffRev) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            while (q-- > 0) {
                String s = in.next();
                String result = funnyString(s);
                System.out.println(result);
            }
        }
    }
}
