package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class Quicksort1Partition {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int[] ar = new int[N];
            for (int i = 0; i < N; i++) {
                ar[i] = in.nextInt();
            }

            int pivot = ar[0];
            List<Integer> left = new ArrayList<>(N);
            List<Integer> equal = new ArrayList<>(N);
            List<Integer> right = new ArrayList<>(N);

            for (int i = 0; i < N; i++) {
                if (ar[i] > pivot) {
                    right.add(ar[i]);
                } else if (ar[i] == pivot) {
                    equal.add(ar[i]);
                } else if (ar[i] < pivot) {
                    left.add(ar[i]);
                }
            }

            for (int i = 0; i < left.size(); i++) {
                System.out.print(left.get(i) + " ");
            }
            for (int i = 0; i < equal.size(); i++) {
                System.out.print(equal.get(i) + " ");
            }
            for (int i = 0; i < right.size(); i++) {
                System.out.print(right.get(i) + " ");
            }
        }
    }
}
