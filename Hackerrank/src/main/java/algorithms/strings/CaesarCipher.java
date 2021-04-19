package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class CaesarCipher {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            String s = in.next();
            int k = in.nextInt();

            solve(s, k);
        }
    }

    static void solve(String s, int k) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 'a' && c[i] <= 'z') {
                c[i] += k;
                while (c[i] > 'z') {
                    c[i] -= 26;
                }
            } else if (c[i] >= 'A' && c[i] <= 'Z') {
                c[i] += k;
                while (c[i] > 'Z') {
                    c[i] -= 26;
                }
            }
        }
        System.out.println(new String(c));
    }
}
