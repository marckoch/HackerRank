package hackerrank.projecteuler.from076to100;

import java.util.Scanner;

/**
 */
public class PE094 {

    private static boolean isPerfectSquare(double input) {
        long closestRoot = (long) Math.sqrt(input);
        return input == closestRoot * closestRoot;
    }

    private static double getPerimeterOfMatchingTriangle(double x, double leg) {
        if (leg > 0) {
            double heightSq = leg * leg - x * x;
            if (heightSq > 0 && isPerfectSquare(heightSq)) {
                double perimeter = 2 * x + 2 * leg;
                System.err.println(String.format("match for base=%.0f leg=%.0f height=%.0f perimeter=%.0f area=%.0f", 2 * x, leg, Math.sqrt(heightSq), perimeter, (2 * x * Math.sqrt(heightSq) / 2)));
                return perimeter;
            }
        }
        return 0;
    }

    public static long solve(long N) {
        long result = 0;

        for (long base = 1; ; base++) {
            //System.err.println(String.format("base=%s perimeter=%s", base, perimeter));

            double x = (double) base / 2;

            double shortVersion = base - 1;
            double perimeter = getPerimeterOfMatchingTriangle(x, shortVersion);
            if (perimeter > 0) {
                if (perimeter > N) {
                    return result;
                }
                result += perimeter;
                System.err.println(result);
            }

            double longVersion = base + 1;
            perimeter = getPerimeterOfMatchingTriangle(x, longVersion);
            if (perimeter > 0) {
                if (perimeter > N) {
                    return result;
                }

                result += perimeter;
                System.err.println(result);
            }
        }

    }

    public static void solveProjectEuler() {
        System.out.println(solve(1_000_000_000));
    }

    // 66% TODO use mod 10000007 for large numbers!!
    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            System.out.println(solve(N));
        }
    }

    public static void main(String[] args) {
        //solveProjectEuler();
        solveHackerrank();
    }
}
