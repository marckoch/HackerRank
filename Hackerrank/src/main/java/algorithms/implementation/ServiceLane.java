package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class ServiceLane {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int T = in.nextInt();
            int width[] = new int[N];
            for (int i = 0; i < N; i++) {
                width[i] = in.nextInt();
            }
            while (T-- > 0) {
                int i = in.nextInt();
                int j = in.nextInt();

                int min = 5;
                for (int pos = i; pos <= j; pos++) {
                    min = Math.min(min, width[pos]);
                    if (min == 1) {
                        break;
                    }
                }
                System.out.println(min);
            }
        }
    }
}
