package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class FindTheMedian {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }
            Arrays.sort(A);
            System.out.println(A[N / 2]);
        }
    }
}
