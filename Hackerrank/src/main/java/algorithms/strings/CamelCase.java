package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class CamelCase {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            long count = 0L;
            for (Character c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    count++;
                }
            }
            System.out.println(count + 1);
        }
    }
}
