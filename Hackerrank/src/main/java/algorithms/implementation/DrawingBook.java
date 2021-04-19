package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class DrawingBook {

    static int solve(int n, int p) {
        return Math.min(p / 2, n / 2 - p / 2);
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int p = in.nextInt();
            int result = solve(n, p);
            System.out.println(result);
        }
    }
}
