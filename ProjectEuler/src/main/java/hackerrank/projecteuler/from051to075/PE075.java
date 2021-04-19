package hackerrank.projecteuler.from051to075;

import java.util.Scanner;

/**
 * Singular integer right triangles
 *
 * @author marckoch
 */
public class PE075 {

    private static final int LIMIT = 5_000_000;
    private static final int[] COUNT = new int[LIMIT + 1];

    static {
        initCountArray();
        fillSumArray();
    }

    private static int gcd(int a, int b) {
        while (a != 0) {
            int c = a;
            a = b % a;
            b = c;
        }
        return b;
    }

    private static void initCountArray() {
        // https://en.wikipedia.org/wiki/Tree_of_primitive_Pythagorean_triples#Alternative_methods_of_generating_the_tree
        for (int m = 1; 2 * m * m <= LIMIT; m++) {
            for (int n = 1; n < m; n++) {

                if (m % 2 == 1 && n % 2 == 1) // not both odd!
                {
                    continue;
                }
                if (gcd(m, n) > 1) {
                    continue;
                }

                // a = m*m - n*n
                // b = 2*m*n
                // c = m*m + n*n
                // --> a+b+c = p = 2*m*(m+n)
                int p = 2 * m * (m + n);

                // when a^2+b^2 == c^2  then is  (k*a)^2 + (k*b)^2 = (k*c)^2 --> perimeter is k*p
                for (int k = 1; k * p <= LIMIT; k++) {
//                    int a = m * m - n * n;
//                    int b = 2 * m * n;
//                    int c = m * m + n * n;
//                    System.err.printf("%s %s (%s %s %s) p=%s marking %s\n", m, n, a, b, c, p, (k * p));
                    COUNT[k * p]++;
                }
            }
        }

        //System.err.println(Arrays.toString(COUNT));
    }

    // reuse COUNT array to save space
    private static void fillSumArray() {
        int sum=0;
        for (int n = 0; n < LIMIT; n++) {
            if (COUNT[n] == 1) 
                sum += 1;
            COUNT[n]=sum;
        }
        //System.err.println(Arrays.toString(COUNT));
    }
    
    public static int solveProjectEuler() {
        return COUNT[1_500_000];
    }

    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            System.out.println(COUNT[N]);
        }
    }

    public static void main(String[] args) {
        //System.out.println(solveProjectEuler());
        solveHackerrank();
    }
}
