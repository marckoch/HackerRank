package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class TheHurdleRace {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int maxJump = in.nextInt();
            int[] height = new int[n];
            
            int maxHeight = 0;
            for (int i = 0; i < n; i++) {
                height[i] = in.nextInt();
                maxHeight = Math.max(maxHeight, height[i]);
            }
            System.out.println(maxHeight > maxJump ? maxHeight - maxJump : 0);
        }
    }
}
