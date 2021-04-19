package algorithms.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class SherlockAndTheValidString {

    static String isValid(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        System.err.println(Arrays.toString(freq));
        Arrays.sort(freq);
        System.err.println(Arrays.toString(freq));

        // one char is there once too often, 
        // if we remove it we can make the string valid
        if ((freq[freq.length - 1] - freq[freq.length - 2]) == 1) {
            return "YES";
        }

        int countOnes = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                countOnes++;
            }
        }
        // one char is there exactly once, 
        // if we remove it we can make the string valid
        if (countOnes == 1) {
            return "YES";
        }

        int f = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                if (f == 0) {
                    f = freq[i];
                }
                if (f != freq[i]) {
                    return "NO";
                }
            }
        }
        if (f > 1) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            String result = isValid(s);
            System.out.println(result);
        }
    }
}
