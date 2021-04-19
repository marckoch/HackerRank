package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class PriyankaAndToys {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int[] toys = new int[N];
            for (int i = 0; i < N; i++) {
                toys[i] = in.nextInt();
            }

            solve(toys, N);
        }
    }

    static void solve(int[] toys, int N) {
        Arrays.sort(toys);
        System.err.println(Arrays.toString(toys));
        int count = 0;
        int lastPaidFor = -1;
        for (int i = 0; i < N; i++) {
            int current = toys[i];
            if (lastPaidFor == -1 || current > lastPaidFor + 4) {
                count++;
                lastPaidFor = current;
            }
        }
        System.out.println(count);
    }
}
