package algorithms.strings;

import java.util.Scanner;

/**
 * TODO Unfinished
 *
 * @author marckoch
 */
public class SaveHumanity {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            while (T-- > 0) {
                String p = in.next();
                String v = in.next();

                solve(p, v);
            }
        }
    }

    static void solve(String p, String v) {
        StringBuilder matchingIndexes = new StringBuilder(p.length());

        for (int j = 0; j <= (p.length() - v.length()); j++) {
            int mismatches = 0;
            for (int k = 0; k < v.length(); k++) {
                if (p.charAt(j + k) != v.charAt(k)) {
                    mismatches++;
                    //System.err.println(j + " " + k + " " + mismatches);
                }
                if (mismatches > 1) {
                    break;
                }
            }
            if (mismatches < 2) {
                matchingIndexes.append(j).append(" ");
            }
        }

        if (matchingIndexes.length() == 0) {
            System.out.println("No Match!");
        } else {
            System.out.println(matchingIndexes.deleteCharAt(matchingIndexes.length() - 1).toString());
        }
    }
}
