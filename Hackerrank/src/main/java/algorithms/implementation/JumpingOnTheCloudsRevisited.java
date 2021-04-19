package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class JumpingOnTheCloudsRevisited {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();

            int c[] = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = in.nextInt();
            }

            int e = 100;
            int index = 0;
            while (true) {
                int newIndex = (index + k) % n;
                e -= 1;
                if (c[newIndex] == 1) {
                    e -= 2;
                }
                if (newIndex == 0) {
                    break;
                }
                index = newIndex;
            }
            System.out.println(e);
        }
    }
}
