package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class CountingSort2 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int[] freq = new int[100];
            for (int i = 0; i < N; i++) {
                freq[in.nextInt()]++;
            }
            System.err.println(Arrays.toString(freq));

            for (int i = 0; i < freq.length; i++) {
                for (int k = 0; k < freq[i]; k++) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
