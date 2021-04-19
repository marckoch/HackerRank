package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class AppendAndDelete {

    static boolean check(String s, String t, int k) {

        int sLength = s.length();
        int tLength = t.length();

        // remove string 1 completely and create string 2 from scratch
        if (sLength + tLength <= k) {
            return true;
        }

        int shortestString = Math.min(sLength, tLength);
        int longestString = Math.max(sLength, tLength);
        //System.err.println(shortestString);
        //System.err.println(longestString);

        int i = 0;
        for (; i < shortestString; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
        }
        //System.err.println(i);

        int restShort = shortestString - i;
        int restLong = longestString - i;

        int noOps = restShort + restLong;
        if (noOps > k) {
            return false;
        }

        if (noOps == k) {
            return true;
        }

        if (((k - noOps) % 2) == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            String t = in.next();
            int k = in.nextInt();

            System.out.println(check(s, t, k) ? "Yes" : "No");
        }
    }
}
