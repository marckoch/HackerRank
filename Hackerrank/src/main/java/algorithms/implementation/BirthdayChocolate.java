package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class BirthdayChocolate {

    static int solve(int noOfPieces, int[] s, int day, int month) {
        if (noOfPieces < month) {
            return 0;
        }

        int match = 0;
        for (int i = 0; i <= noOfPieces - month; i++) {
            int sum = 0;
            for (int j = i; j < i + month; j++) {
                sum += s[j];
            }
            if (sum == day) {
                match++;
            }
        }
        return match;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();

            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.nextInt();
            }

            int d = in.nextInt();
            int m = in.nextInt();
            int result = solve(n, s, d, m);
            System.out.println(result);
        }
    }
}
