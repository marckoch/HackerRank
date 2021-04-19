package hourrank.no24;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author marckoch
 */
public class MutualIndivisibility {

    private static Set<Integer> check(int a, int b, int x) {
        Set<Integer> result = new HashSet<>();
        for (int d = b; d >= a; d--) {
            boolean isDivisible = false;
            for (int test : result) {
                if (test % d == 0 || d % test == 0) {
                    isDivisible = true;
                    break;
                }

            }
            if (!isDivisible) {
                result.add(d);
            }

            //System.err.println(result);
            if (result.size() == x) {
                return result;
            }
        }

        return new HashSet<>();
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int a0 = 0; a0 < t; a0++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int x = in.nextInt();
                solve(a, b, x);
            }
        }
    }
    
    static void solve(int a, int b, int x) {
        int min = Math.min(b - a + 1, (b + 1) / 2);
        if (x > min) {
            System.out.println("-1");
        } else {
            Set<Integer> result = new HashSet<>();
            while (result.size() < x) {
                result.add(b--);
            }
            System.out.println(result.stream()
                    .map((t) -> String.valueOf(t))
                    .sorted((o1, o2) -> o2.compareTo(o1)) // sort descending
                    .collect(Collectors.joining(" ")));
        }
    }

    static void solve2(int a, int b, int x) {
        Set<Integer> result = check(a, b, x);
        System.err.println(result);
        if (result.size() < x) {
            System.out.println("-1");
        } else {
            System.out.println(result.stream()
                    .map((t) -> String.valueOf(t))
                    .sorted((o1, o2) -> o2.compareTo(o1)) // sort descending
                    .collect(Collectors.joining(" ")));
        }
    }
}
