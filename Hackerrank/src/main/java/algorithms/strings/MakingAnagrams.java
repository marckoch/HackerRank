package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MakingAnagrams {

    // char frequency of a string
    private static int[] freq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    static int makingAnagrams(String s1, String s2) {
        int[] freq1 = freq(s1);
        int[] freq2 = freq(s2);
        int deletions = 0;
        for (int i = 0; i < freq1.length; i++) {
            deletions += Math.abs(freq1[i] - freq2[i]);
        }
        return deletions;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s1 = in.next();
            String s2 = in.next();
            int result = makingAnagrams(s1, s2);
            System.out.println(result);
        }
    }
}
