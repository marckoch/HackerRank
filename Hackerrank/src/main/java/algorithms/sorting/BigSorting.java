package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class BigSorting {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            String[] unsorted = new String[n];
            for (int i = 0; i < n; i++) {
                unsorted[i] = in.next();
            }

            Arrays.sort(unsorted, (left, right) -> {
                int length1 = left.length();
                int length2 = right.length();

                if (length1 != length2) {
                    return length1 - length2;
                }

                return left.compareTo(right);
            });

            for (int i = 0; i < n; i++) {
                System.out.println(unsorted[i]);
            }
        }
    }
}
