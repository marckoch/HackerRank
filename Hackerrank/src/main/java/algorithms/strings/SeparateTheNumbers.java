package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class SeparateTheNumbers {

    private static long check(String s, int length) {
        //System.err.println("checking " + s);
        if (length >= s.length()) {
            return -1;
        }

        String beginning = s.substring(0, length);
        long i1 = Long.valueOf(beginning);
        long i = i1;
        //System.err.println("  beginning=" + beginning);

        String rest = s.substring(length);
        //System.err.println("  rest=" + rest);

        while (rest.startsWith(String.valueOf(i + 1))) {

            beginning = String.valueOf(i + 1);
            i = Long.valueOf(beginning);
            //System.err.println("  beginning=" + beginning);

            rest = rest.substring(beginning.length());
            //System.err.println("  rest=" + rest);

            if (rest.isEmpty()) {
                return i1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            while (q-- > 0) {
                String s = in.next();
                
                solve(s);
            }
        }
    }

    static void solve(String s) {
        long firstNumber = -1;
        int length = 1;
        while (firstNumber < 0 && length <= s.length() / 2) {
            firstNumber = check(s, length++);
        }
        System.out.println(firstNumber > 0 ? ("YES " + firstNumber) : "NO");
    }
}
