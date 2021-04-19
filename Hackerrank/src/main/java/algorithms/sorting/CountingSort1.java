package algorithms.sorting;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class CountingSort1 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] freq = new int[100];
            for (int i = 0; i < n; i++) {
                freq[in.nextInt()]++;
            }
            //System.err.println(Arrays.toString(freq));
            for (int i = 0; i < freq.length; i++) {
                System.out.print(freq[i]);
                if (i < freq.length - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
