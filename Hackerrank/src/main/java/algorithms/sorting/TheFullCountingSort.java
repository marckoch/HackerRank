package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class TheFullCountingSort {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            StringBuilder[] txts = new StringBuilder[100];
            for (int i = 0; i < 100; i++) {
                txts[i] = new StringBuilder();
            }

            for (int i = 0; i < N; i++) {
                int index = in.nextInt();
                String txt = in.next();
                txts[index].append(i < N / 2 ? "-" : txt).append(" ");
                System.err.println(Arrays.toString(txts));
            }

            for (StringBuilder txt : txts) {
                System.out.print(txt);
            }
        }
    }
}
