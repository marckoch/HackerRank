package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MaximumPerimeterTriangle {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] sides = new int[n];
            for (int i = 0; i < n; i++) {
                sides[i] = in.nextInt();
            }
            
            solve(sides, n);
        }
    }

    static void solve(int[] sides, int n) {
        Arrays.sort(sides);
        //System.err.println(Arrays.toString(sides));
        int a = n - 3;
        int b = n - 2;
        int c = n - 1;
        boolean found = false;
        while (a < b && a >= 0 && b < c && b >= 1) {
            if (sides[a] + sides[b] > sides[c]) {
                found = true;
                System.out.println(sides[a] + " " + sides[b] + " " + sides[c]);
                break;
            }
            a--;
            b--;
            c--;
        }
        if (!found) {
            System.out.println("-1");
        }
    }
}
