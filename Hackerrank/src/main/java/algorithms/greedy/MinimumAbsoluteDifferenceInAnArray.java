package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MinimumAbsoluteDifferenceInAnArray {

    static int minimumAbsoluteDifference(int n, int[] arr) {
        Arrays.sort(arr);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i + 1 < n; i++) {
            result = Math.min(result, Math.abs(arr[i] - arr[i + 1]));
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int result = minimumAbsoluteDifference(n, arr);
            System.out.println(result);
        }
    }
}
