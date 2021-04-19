package hackerrank.projecteuler.from101to125;

/**
 *
 */
public class PE108 {

    public static void main(String[] args) {
        solve(100);

//        for (int i = 1; i < 100; i++) {
//            System.out.println(i + " " + solve(i));
//        }
    }

    public static long solve(int n) {
        System.out.println("checking n=" + n);
        long solutions = 0;
        for (int a = 1; a <= n; a++) {
            if ((n * n) % a == 0) {
                int x = n + a;
                int b = (n * n / a);
                int y = n + b;
                System.out.printf("  " + n + " a=" + a + " b=" + b + " x=" + x + " y=" + y + "  1/%s+1/%s=1/%s\n", x, y, n);
                solutions++;
            }
        }
        return solutions;
    }

    public static long solveX(int n) {
        System.out.println("checking n=" + n);
        long solutions = 0;
        for (int x = n + 1; x <= 2 * n; x++) {
            if (x % (x - n) == 0) {
                int k = x / (x - n);
                int y = k * n;
                System.out.printf("  " + n + " x=" + x + " k=" + k + " y=" + y + "  1/%s+1/%s=1/%s\n", x, y, n);
                solutions++;
            }
        }
        return solutions;
    }
}
