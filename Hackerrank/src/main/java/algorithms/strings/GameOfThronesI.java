package algorithms.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class GameOfThronesI {

    static String gameOfThrones(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        System.err.println(Arrays.toString(freq));
        int countOdd = 0;
        for (int i : freq) {
            if (i % 2 != 0) {
                countOdd++;
            }
        }
        return countOdd < 2 ? "YES" : "NO";
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            String result = gameOfThrones(s);
            System.out.println(result);
        }
    }
}
