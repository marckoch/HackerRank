package algorithms.bitmanipulation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MaximizingXOR {

    static int maxXor(int left, int right) {
        int max = -1;
        for (int l = left; l <= right; l++) {
            for (int r = l; r <= right; r++) {
                int XOR = l ^ r;
                // find maximum
                if (XOR > max) {
                    max = XOR;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int res = maxXor(in.nextInt(), in.nextInt());
            System.out.println(res);
        }
    }
}
