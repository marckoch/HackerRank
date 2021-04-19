package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class StringConstruction {

    static int stringConstruction(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a'] = 1;
        }

        int distinctChars = 0;
        for (int i = 0; i < freq.length; i++) {
            distinctChars += freq[i];
        }
        return distinctChars;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            for (int a0 = 0; a0 < q; a0++) {
                String s = in.next();
                int result = stringConstruction(s);
                System.out.println(result);
            }
        }
    }
}
