package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class SuperReducedString {

    static String superReducedString(String s) {
        if (s.length() == 0) {
            return "Empty String";
        }
        for (int i = 0; i + 1 < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return superReducedString(s.substring(0, i) + s.substring(i + 2));
            }
        }
        return s;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            String result = superReducedString(s);
            System.out.println(result);
        }
    }
}
