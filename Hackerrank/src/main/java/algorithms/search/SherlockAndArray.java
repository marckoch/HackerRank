package algorithms.search;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class SherlockAndArray {

    static String solve(int[] a) {

        int left = 0;
        int right = a.length - 1;

        int leftSum = a[left];
        int rightSum = a[right];

        while (right - left > 2) {
            //System.err.println("left=" + left + " right=" + right + " leftSum=" + leftSum + " rightSum=" + rightSum);
            if (leftSum <= rightSum) {
                left++;
                leftSum += a[left];
            } else if (leftSum > rightSum) {
                right--;
                rightSum += a[right];
            }
        }

        boolean indexFound = leftSum == rightSum;
        return indexFound ? "YES" : "NO";
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            while (T-- > 0) {
                int n = in.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                }
                String result = solve(a);
                System.out.println(result);
            }
        }
    }
}
