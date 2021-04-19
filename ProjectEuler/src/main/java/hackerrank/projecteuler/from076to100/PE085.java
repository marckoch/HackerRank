package hackerrank.projecteuler.from076to100;

import java.util.*;

/**
 * Counting rectangles
 *
 * @author marckoch
 */
public class PE085 {

    private static int generateTriangle(int n) {
        return n * (n + 1) / 2;
    }

    public static int solve(int target) {
        //System.err.println("solving for " + target);

        int closestNoOfRectangles = 0;
        int areaOfMin = 0;

        // in case of a rectangle of X * 1 the triangle will be about X^2,
        // so the other way round if the max no of rectangles is given
        // we can use sqrt(X) as a limit for x
        int limit = (int) Math.sqrt(target) + 1;
        for (int x = 1; x <= limit; x++) {

            int y = x;
            int noOfRectangles;

            do {

                int area = x * y;
                noOfRectangles = generateTriangle(x) * generateTriangle(y);

                if (Math.abs(noOfRectangles - target) < Math.abs(closestNoOfRectangles - target)) {
                    closestNoOfRectangles = noOfRectangles;
                    areaOfMin = area;
                    //System.err.println("setting new optimum to " + Math.abs(closestNoOfRectangles - target) + " for " + x + " " + y + " noOfRectangles " + noOfRectangles + " area " + area);
                }

                // hackerrank: prefer larger areas
                if (Math.abs(noOfRectangles - target) == Math.abs(closestNoOfRectangles - target) && areaOfMin < area) {
                    areaOfMin = area;
                    //System.err.println("setting new max area optimum to " + Math.abs(closestNoOfRectangles - target) + " for " + x + " " + y + " noOfRectangles " + noOfRectangles + " area " + area);
                }

                y++;
            } while (noOfRectangles < target);

            if (y == x + 1)
                break;
        }

        return areaOfMin;
    }

    public static void solveProjectEuler() {
        //System.out.println(solve(1_999_000));
        System.out.println(solve(2_000_000));
    }

    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int q = in.nextInt();
            System.out.println(solve(q));
        }
    }

    public static void main(String[] args) {
        solveHackerrank();
        //solveProjectEuler();
    }
}
