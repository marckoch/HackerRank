package hackerrank.projecteuler.from076to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Passcode derivation
 *
 * @author marckoch
 */
public class PE079 {

    private static String solve(String[] logins) {
        Arrays.sort(logins);
        System.err.println(Arrays.toString(logins));

        List<Character> digits = new ArrayList<>();
        for (String login : logins) {
            for (char digit : login.toCharArray()) {
                if (!digits.contains(digit)) {
                    digits.add(digit);
                }
            }
        }

        System.err.println(digits);

        digits.sort((o1, o2) -> {
            for (String login : logins) {
                int index1 = login.indexOf(o1);
                int index2 = login.indexOf(o2);
                if (index1 >= 0 && index2 >= 0) {
                    System.err.println(o1 + " " + o2 + " " + (index1 - index2));
                    return index1 - index2;
                }
            }
            System.err.println(o1 + " " + o2 + " 0");
            return 0;
        });

        System.err.println(digits);
        StringBuilder sb = new StringBuilder();
        digits.forEach((t) -> {
            sb.append(t);
        });
        return sb.toString();
    }

    public static void solveProjecteuler() {
        String[] projectEulerLogins = {
            "319", "680", "180", "690", "129", "620", "762", "689", "762", "318",
            "368", "710", "720", "710", "629", "168", "160", "689", "716", "731",
            "736", "729", "316", "729", "729", "710", "769", "290", "719", "680",
            "318", "389", "162", "289", "162", "718", "729", "319", "790", "680",
            "890", "362", "319", "760", "316", "729", "380", "319", "728", "716"};
        System.out.println(solve(projectEulerLogins));
    }

    public static String solveHackerrankInternal(String[] logins) {
        Map<Character, Set<Character>> prev = new HashMap<>();
        for (String login : logins) {
            char[] chars = login.toCharArray();

            prev.putIfAbsent(chars[0], new HashSet<>());

            prev.putIfAbsent(chars[1], new HashSet<>());
            prev.get(chars[1]).add(chars[0]);

            prev.putIfAbsent(chars[2], new HashSet<>());
            prev.get(chars[2]).add(chars[1]);
            prev.get(chars[2]).add(chars[0]);
        }
        //System.err.println(prev);

        StringBuilder solution = new StringBuilder();

        while (!prev.isEmpty()) {
            // find lexographical smallest key from those with empty list
            Character nextCharacter = prev.keySet().stream().filter((t) -> {
                return prev.get(t).isEmpty();
            }).sorted( //(o1, o2) -> {return Character.compare(o1, o2);            }
                    ).findFirst().orElse(Character.MAX_VALUE);
            //System.err.println("found first: " + first);

            // nothing found?
            if (nextCharacter == Character.MAX_VALUE) {
                return "SMTH WRONG";
            }

            solution.append(nextCharacter);

            // delete first from prev map
            prev.remove(nextCharacter);
            // and from any value list in map
            for (Map.Entry<Character, Set<Character>> e : prev.entrySet()) {
                e.getValue().remove(nextCharacter);
            }
        }
        return solution.toString();
    }

    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String[] logins = new String[T];
        while (T-- > 0) {
            logins[logins.length - 1 - T] = in.next();
        }
        System.out.println(solveHackerrankInternal(logins));
    }

    public static void main(String[] args) {
        //solveProjecteuler();
        solveHackerrank();
    }
}
