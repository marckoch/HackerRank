package algorithms.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class SherlockAndAnagrams {

    private static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        //System.err.println("   " + s1 + " " + s2 + " true");
        return true;
    }

    static int sherlockAndAnagrams(String s) {
        //System.err.println("s=" + s);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub1 = s.substring(i, j);
                //System.err.println(" sub1=" + sub1);
                for (int k = i + 1; k + sub1.length() <= s.length(); k++) {
                    String sub2 = s.substring(k, k + sub1.length());
                    //System.err.println(" sub2=" + sub2);
                    if (isAnagram(sub1, sub2)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            while (q-- > 0) {
                String s = in.next();
                int result = sherlockAndAnagrams(s);
                System.out.println(result);
            }
        }
    }
}
