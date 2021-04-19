package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class BreakingTheRecords {

    static int[] getRecord(int[] s) {
        int minScore = s[0];
        int maxScore = s[0];

        int countMinBroken = 0;
        int countMaxBroken = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i] > maxScore) {
                countMaxBroken++;
            }
            maxScore = Math.max(maxScore, s[i]);

            if (s[i] < minScore) {
                countMinBroken++;
            }
            minScore = Math.min(minScore, s[i]);
        }

        return new int[]{countMaxBroken, countMinBroken};
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.nextInt();
            }
            
            int[] result = getRecord(s);
            String separator = "", delimiter = " ";
            for (Integer val : result) {
                System.out.print(separator + val);
                separator = delimiter;
            }
            System.out.println("");
        }
    }
}
