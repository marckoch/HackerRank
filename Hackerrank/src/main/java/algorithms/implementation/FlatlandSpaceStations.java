package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class FlatlandSpaceStations {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] c = new int[m];
            for (int i = 0; i < m; i++) {
                c[i] = in.nextInt();
            }
            
            solve(m, n, c);
        }
    }

    static void solve(int m, int n, int[] c) {
        if (m == n) {
            System.out.println(0);
        } else {
            Arrays.sort(c);
            
            int max = 0;
            for (int i = 0; i + 1 < m; i++) {
                max = Math.max(max, (c[i + 1] - c[i]) / 2);
            }
            max = Math.max(max, c[0]);
            max = Math.max(max, n - c[m - 1] - 1);
            System.out.println(max);
        }
    }
}
