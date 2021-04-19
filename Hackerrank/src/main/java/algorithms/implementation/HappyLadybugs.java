package algorithms.implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class HappyLadybugs {

    private static boolean allHappy(String b) {
        char[] bugs = b.toCharArray();
        System.err.println(Arrays.toString(bugs));

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : bugs) {
            if (!freq.containsKey(c)) {
                freq.put(c, 0);
            }
            freq.put(c, freq.get(c) + 1);
        }
        System.err.println(freq);

        // if we have one lonely bug we can't make her happy
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            if (e.getKey() != '_' && e.getValue() == 1) {
                return false;
            }
        }

        // we have no _ so everybugs must already match
        if (!freq.containsKey('_')) {
            for (int i = 0; i < b.length(); i++) {
                if (i > 0 && bugs[i] == bugs[i - 1]) { // i has matching neighbor to the left
                    continue;
                }
                if (i < b.length() - 1 && bugs[i] == bugs[i + 1]) { // i has matching neighbor to the right
                    continue;
                }
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int Q = in.nextInt();
            while (Q-- > 0) {
                int n = in.nextInt();
                String b = in.next();
                System.out.println(allHappy(b) ? "YES" : "NO");
            }
        }
    }
}
