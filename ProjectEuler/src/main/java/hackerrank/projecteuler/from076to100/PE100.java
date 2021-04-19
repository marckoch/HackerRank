package hackerrank.projecteuler.from076to100;

import java.util.Scanner;

/**
 */
public class PE100 {

    public static long solve(long N) {
        long b = 15;
        long n = 21;

        // https://www.alpertron.com.ar/QUAD.HTM
        // xn+1 = 3 ⁢xn + 2 ⁢yn - 2
        // yn+1 = 4 ⁢xn + 3 ⁢yn - 3
        while (n < N) {
            long bTmp = 3 * b + 2 * n - 2;
            long nTmp = 4 * b + 3 * n - 3;
            System.err.println(String.format("b=%,d n=%,d", bTmp, nTmp));

            b = bTmp;
            n = nTmp;
        }
        return b;
    }

    public static void solveProjectEuler() {
        System.out.println(solve(1_000_000_000_000L));
    }

    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
        }
    }

    public static void main(String[] args) {
        solveProjectEuler();
        //solveHackerrank();
    }
}
