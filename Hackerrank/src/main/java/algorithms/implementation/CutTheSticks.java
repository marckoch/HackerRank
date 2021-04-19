package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class CutTheSticks {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();

            int[] stick = new int[n];
            for (int i = 0; i < n; i++) {
                stick[i] = in.nextInt();
            }

            solve(stick, n);
        }
    }

    static void solve(int[] stick, int n) {
        Arrays.sort(stick);
        
        int cutoff = 0;
        int sticksCut = 0;
        //System.err.println("  " + cutoff + " " + sticksCut + " " + Arrays.toString(stick));
        for (int i = 0; i < n; i++) {
            // System.err.println(i + " " + cutoff + " " + Arrays.toString(stick));
            if (stick[i] > cutoff) {
                cutoff += (stick[i] - cutoff);
                sticksCut = n - i;
                System.out.println(sticksCut);
            }
            stick[i] = 0;
            //System.err.println("  " + cutoff + " " + sticksCut + " " + Arrays.toString(stick));
        }
    }
}
