package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class JumpingOnTheClouds {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int c[] = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = in.nextInt();
            }

            int i = 0;
            int jumps = 0;
            while (true) {
                if (i == n - 1) {
                    break;
                }
                if (i < n - 2 && c[i + 2] == 0) {
                    jumps++;
                    i = i + 2;
                } else if (c[i + 1] == 0) {
                    jumps++;
                    i = i + 1;
                }
            }
            System.out.println(jumps);
        }
    }
}
