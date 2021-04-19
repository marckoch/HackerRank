package hackerrank.projecteuler.from076to100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Singular integer right triangles
 *
 * @author marckoch
 */
public class PE076 {

    private static final int MOD = (int) Math.pow(10, 9) + 7;
    private static final int LIMIT = 1000;
    private static final int[] COUNT = new int[LIMIT + 1];

    static {
        initCountArray();
    }

    private static void initCountArray() {
        COUNT[0] = 1;
        for (int i = 1; i < COUNT.length; i++) {
            for(int j = i; j <= LIMIT; j++) {
                COUNT[j] += COUNT[j - i];
                COUNT[j] %= MOD;
            }
            //System.err.println(i + " " + Arrays.toString(COUNT));
        }
        //System.err.println(Arrays.toString(COUNT));
    }
    
    public static int solveProjectEuler() {
        return COUNT[100];
    }

    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            // substract 1 because array contains 1 solution for { N }
            // but we shall divide in at least TWO partitions!
            System.out.println(COUNT[N]-1);
        }
    }

    public static void main(String[] args) {
        //System.out.println(solveProjectEuler());
        solveHackerrank();
    }
}
