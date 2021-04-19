package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class Anagram {

    static int[] freq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    static int anagram(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }

        int lenS1 = s.length() / 2;
        //System.err.println(lenS1);

        String s1 = s.substring(0, lenS1);
        String s2 = s.substring(lenS1);
        //System.err.println(s1);
        //System.err.println(s2);

        int[] freq1 = freq(s1);
        //System.err.println(Arrays.toString(freq1));
        int[] freq2 = freq(s2);
        //System.err.println(Arrays.toString(freq2));

        int changes = 0;
        for (int i = 0; i < freq1.length; i++) {
            changes += (freq1[i] > freq2[i] ? (freq1[i] - freq2[i]) : 0);
        }
        return changes;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            while (q-- > 0) {
                String s = in.next();
                int result = anagram(s);
                System.out.println(result);
            }
        }
    }
}
