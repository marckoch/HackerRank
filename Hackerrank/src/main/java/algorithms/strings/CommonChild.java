package algorithms.strings;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author marckoch
 */
public class CommonChild {

    static String strip(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        Set<Character> uniqueChars = new TreeSet<>();
        for (char c : s2.toCharArray()) {
            uniqueChars.add(c);
        }

        for (char c : s1.toCharArray()) {
            if (uniqueChars.contains(c)) {
                res.append(c);
            }
        }
        //System.err.println(res);
        return res.toString();
    }

    //http://www.geeksforgeeks.org/longest-common-subsequence/
    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    static int lcs(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

        /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X[i - 1] == Y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[m][n];
    }

    static int commonChild(String s1, String s2) {
        String s1Stripped = strip(s1, s2);
        String s2Stripped = strip(s2, s1);

        char[] c1 = s1Stripped.toCharArray();
        char[] c2 = s2Stripped.toCharArray();

        return lcs(c1, c2, c1.length, c2.length);
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s1 = in.next();
            String s2 = in.next();
            //System.err.println(s1);
            //System.err.println(s2);
            int result = commonChild(s1, s2);
            System.out.println(result);
        }
    }
}
