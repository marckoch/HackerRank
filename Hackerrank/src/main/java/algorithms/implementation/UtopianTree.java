package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class UtopianTree {

    public static void main(String[] args) {
        int[] height = new int[60];

        for (int i = 0; i < 60; i++) {
            if (i == 0) {
                height[i] = 0;
            } else if (i % 2 == 0) {
                height[i] = height[i - 1] * 2;
            } else if (i % 2 == 1) {
                height[i] = height[i - 1] + 1;
            }
        }
        System.err.println(Arrays.toString(height));

        try (Scanner in = new Scanner(System.in)) {
            int numberOfTests = in.nextInt();
            for (int i = 0; i < numberOfTests; i++) {
                int cycle = in.nextInt();
                System.out.println(height[cycle + 1]);
            }
        }
    }
}
