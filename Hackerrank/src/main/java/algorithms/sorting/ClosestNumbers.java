package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class ClosestNumbers {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextInt();
            }
            Arrays.sort(A);
            //System.err.println(Arrays.toString(A));

            List<Integer> matches = new ArrayList<>();
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < N - 1; i++) {
                int diff = A[i + 1] - A[i];
                if (diff < minDiff) {
                    minDiff = diff;
                    matches.clear();
                    matches.add(A[i]);
                    matches.add(A[i + 1]);
                } else if (diff == minDiff) {
                    matches.add(A[i]);
                    matches.add(A[i + 1]);
                }
            }

            Collections.sort(matches);
            for (int i = 0; i < matches.size(); i++) {
                System.out.print(matches.get(i) + " ");
            }
        }
    }
}
