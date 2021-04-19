package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        //System.err.println(Arrays.toString(prices));
        int count = 0;
        int i = 0;
        while (k >= 0 && k >= prices[i]) {
            k -= prices[i];
            i++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = in.nextInt();
            }
            int result = maximumToys(prices, k);
            System.out.println(result);
        }
    }
}
