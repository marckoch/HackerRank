package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class InsertionSortAdvancedAnalysis {

    private static int[] BIT;

    // http://www.geeksforgeeks.org/count-inversions-array-set-3-using-bit/ 
    private static long get(int i) {
        long sum = 0L;
        int j = i;
        while (j > 0) {
            sum += BIT[j];
            //System.err.println("get(" + j + ")=" + sum);
            j -= (j & -j);
        }
        return sum;
    }

    private static void put(int i, int val) {
        int j = i;
        while (j < BIT.length) {
            BIT[j] += val;
            //System.err.println("put(" + i + ")=" + val);
            j += (j & -j);
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            for (int t = 0; t < T; t++) {
                int N = in.nextInt();
                int[] A = new int[N];

                // fill array and find maximum element
                int maxA = 1;
                for (int i = 0; i < N; i++) {
                    A[i] = in.nextInt();
                    maxA = Math.max(maxA, A[i]);
                }

                // Create a BIT with size equal to maxElement+1 (Extra
                // one is used so that elements can be directly be
                // used as index)
                BIT = new int[maxA + 1];

                //System.err.println(t + " " + Arrays.toString(A));
                long invCount = 0L;

                // Traverse all elements from right.
                for (int i = N - 1; i >= 0; i--) {
                    // Get count of elements smaller than arr[i]
                    invCount += get(A[i] - 1);
                    //System.err.println(t + " after get " + Arrays.toString(BIT));
                    // Add current element to BIT
                    put(A[i], 1);
                    //System.err.println(t + " after put " + Arrays.toString(BIT));
                }
                //System.err.println(t + " " + Arrays.toString(BIT));
                System.out.println(invCount);
            }
        }
    }
}
