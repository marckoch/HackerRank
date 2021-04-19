package hackerrank.projecteuler.from076to100;

import java.util.Scanner;
import java.util.function.IntFunction;

/**
 * Cuboid route
 *
 * @author marckoch
 */
public class PE086 {

    // stupid brute force approach, just count combinations, super slow but correct
    // three loops --> bad!
    public static int solveBruteForce(int maxX) {
        int matches = 0;
        // we assume x is longest side, y always < x and z < y (because we ignore rotation)
        for (int x = 1; x <= maxX; x++) {
            for (int y = 1; y <= x; y++) {
                for (int z = 1; z <= y; z++) {
                    // shortest route is reached if we square the sum of the two lowest
                    int sum = x * x + (y + z) * (y + z);

                    double root = Math.sqrt(sum);
                    if (root == Math.floor(root)) {
                        //System.err.println("" + x + "^2 + (" + y + "+" + z + ")^2 == " + (int) root + "^2  == " + sum);
                        matches++;
                    }
                }
            }
        }
        return matches;
    }

    // still too slow for Hackerrank
    public static int solveSmarter(int maxX) {
        int matches = 0;
        for (int x = 1; x <= maxX; x++) {
            for (int yPlusZ = 3; yPlusZ <= 2 * x; yPlusZ++) {
                // shortest route is reached if we square the sum of the two lowest
                int sum = x * x + yPlusZ * yPlusZ;

                double root = Math.sqrt(sum);
                if (root == Math.floor(root)) {
                    if (yPlusZ <= x) {
                        matches += yPlusZ / 2;
                    } else
                        matches += 1 + (x - (yPlusZ + 1) / 2);
                }
            }
        }
        return matches;
    }

    public static void solveProjectEuler() {
        System.out.println(solveBruteForce(1817));
        System.out.println(solveBruteForce(1818));
    }

    public static void solveHackerrank(final IntFunction<Integer> f) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int q = in.nextInt();
            System.out.println(f.apply(q));
        }
    }

    public static void main(String[] args) {
        //solveHackerrank(PE086::solveBruteForce);
        solveHackerrank(PE086::solveSmarter);
        //solveProjectEuler();
    }
}
