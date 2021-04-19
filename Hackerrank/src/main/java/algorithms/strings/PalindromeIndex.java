package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class PalindromeIndex {

    static int palindromeIndex(String s) {
        //System.err.println("checking " + s);
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length / 2; i++) {
            //System.err.println(i + " " + c[i] + " " + c[c.length-1-i]);
            if (c[i] != c[c.length - 1 - i]) {
                if (c[i + 1] == c[c.length - 1 - i] && c[i + 2] == c[c.length - 2 - i]) {
                    return i;
                } else if (c[i] == c[c.length - 2 - i] && c[i + 1] == c[c.length - 3 - i]) {
                    return c.length - 1 - i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            while (q-- > 0) {
                String s = in.next();
                int result = palindromeIndex(s);
                System.out.println(result);
            }
        }
    }
}
