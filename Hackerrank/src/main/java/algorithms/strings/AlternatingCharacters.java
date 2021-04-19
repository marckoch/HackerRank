package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        int result = 0;
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        while (index < sb.length() - 1) {
            if (sb.charAt(index) == sb.charAt(index + 1)) {
                sb.deleteCharAt(index + 1);
                result++;
            } else {
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while (q-- > 0) {
            String s = in.next();
            int result = alternatingCharacters(s);
            System.out.println(result);
        }
    }
}
