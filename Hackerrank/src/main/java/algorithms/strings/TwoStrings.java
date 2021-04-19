package algorithms.strings;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author marckoch
 */
public class TwoStrings {

    private static Set<Character> getUniqueChars(String s) {
        char[] c = s.toCharArray();
        Set<Character> chars = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            chars.add(c[i]);
        }
        return chars;
    }

    static String twoStrings(String s1, String s2) {
        Set<Character> set1 = getUniqueChars(s1);
        Set<Character> set2 = getUniqueChars(s2);
        set1.retainAll(set2);
        return !set1.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            for (int a0 = 0; a0 < q; a0++) {
                String s1 = in.next();
                String s2 = in.next();
                String result = twoStrings(s1, s2);
                System.out.println(result);
            }
        }
    }
}
