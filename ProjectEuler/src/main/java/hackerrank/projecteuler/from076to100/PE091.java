package hackerrank.projecteuler.from076to100;

import java.util.Scanner;

/**
 */
public class PE091 {

    private static int gcd(int a, int b) {
        while (a != 0) {
            int c = a;
            a = b % a;
            b = c;
        }
        return b;
    }

    public static int solve(int N) {
        int result = 0;

        result += N * N; // for every triangle with right angle at 0/0
        result += N * N; // for every triangle with right angle on x-axis
        result += N * N; // for every triangle with right angle on y-axis

        // now check P wandering around in area (not on any axis)
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                int factor = gcd(x, y);
                result += Math.min(y * factor / x, (N - x) * factor / y) * 2;
            }
        }

        return result;
    }

    public static void solveProjectEuler() {
        System.out.println(solve(50));
    }


    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(solve(N));
    }

    public static void main(String[] args) {
        //solveProjectEuler();
        solveHackerrank();
    }
}
