package hackerrank.projecteuler.from051to075;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Digit factorial chains
 *
 * @author marckoch
 */
public class PE074 {

    private static final int[] facts = new int[10];

    static {
        initFactorials();
    }

    private static int factorial(int n) {
        int result = 1;

        while (n != 0) {
            result *= n;
            n -= 1;
        }

        return result;
    }

    private static int getDigitFactorialSum(int i) {
        int origI = i;
        if (i == 0) {
            return 1;
        }
        int digitSum = 0;
        //System.err.println("checking " + i);
        while (i > 0) {
            int lastDigit = (int) i % 10;
            //System.err.println("  lastDigit=" + lastDigit);
            digitSum += facts[lastDigit];
            i /= 10;
        }
        //System.err.printf("%s -> %s\n", origI, digitSum);
        return digitSum;
    }

    public static int findLoopLength(int n) {
        int origN = n;

        List<Integer> steps = new ArrayList<>();
        steps.add(n);

        while (true) {
            n = getDigitFactorialSum(n);
            if (steps.contains(n)) {
                break;
            }
            steps.add(n);
        }

        //System.err.println(origN + " > " + steps + " (->"+n+") len=" + steps.size());
        return steps.size();
    }

    private static void solveProjectEuler() {
        int count = 0;
        for (int n = 10; n < 1_000_000; n++) {
            int length = findLoopLength(n);
            if (length + 1 == 60) {
                count++;
            }
        }
        System.out.println(count);
    }

    // 33% on hackerrank
    private static void solveHackerrankSlow() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            int L = in.nextInt();

            List<Integer> matches = new ArrayList<>();
            for (int n = 0; n <= N; n++) {
                int length = findLoopLength(n);
                if (length == L) {
                    matches.add(n);
                }
                //System.err.printf("%s %s\n", n, length);
            }

            if (!matches.isEmpty()) {
                String line = matches
                        .stream()
                        .map(t -> String.valueOf(t))
                        .collect(Collectors.joining(" "));
                System.out.println(line);
            } else {
                System.out.println("-1");
            }
        }
    }

    // 100% on hackerrank
    public static void solveHackerrankPreCalc() {
        int LIMIT = 1_000_000;
        int[] loopLengths = new int[LIMIT + 1];

        for (int n = 0; n < loopLengths.length; n++) {
            int length = findLoopLength(n);
            loopLengths[n] = length;
        }
        //System.err.println(Arrays.toString(loopLengths));

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            int L = in.nextInt();

            List<Integer> matches = new ArrayList<>();
            for (int n = 0; n <= N; n++) {
                if (loopLengths[n] == L) {
                    matches.add(n);
                }
            }

            if (!matches.isEmpty()) {
                String line = matches
                        .stream()
                        .map(t -> String.valueOf(t))
                        .collect(Collectors.joining(" "));
                System.out.println(line);
            } else {
                System.out.println("-1");
            }
        }
    }

    public static void initFactorials() {
        facts[0] = 1;
        for (int i = 0; i < 10; i++) {
            facts[i] = factorial(i);
        }
    }

    public static void main(String[] args) {
        //System.err.println(Arrays.toString(facts));

        // solveProjectEuler();
        // solveHackerrankSlow();
        solveHackerrankPreCalc();
    }
}
