package algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class HackerlandRadioTransmitters {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
            }

            solve(x, k);
        }
    }

    static void solve(int[] x, int reach) {
        Arrays.sort(x);
        int N = x.length;
        //System.err.println(Arrays.toString(x));

        int transmitterCount = 0;
        int i = 0;
        while (i < N) {
            transmitterCount++;

            // now try to improve position of transmitter
            int endOfReach = x[i] + reach;
            // move transmitter as far to the right as possible
            while (i < N && x[i] <= endOfReach) {
                i++;
            }
            // here we place the transmitter at x[--i] and have new reach to the right
            endOfReach = x[--i] + reach;
            //System.err.println("  transmitter[" + transmitterCount + "]" + x[i]);
            // now skip the houses to the right that are covered
            while (i < N && x[i] <= endOfReach) {
                i++;
            }
        }
        System.out.println(transmitterCount);
    }
}
