package algorithms.greedy;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class LargestPermutation {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int K = in.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = in.nextInt();
            }

            solve(N, arr, K);
        }
    }

    // helper method
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void solve(int N, int[] arr, int nrOfSwaps) {

        // build positional array for faster lookup of position of desired number
        int[] posArray = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            posArray[arr[i]] = i;
        }

        for (int k = 0; k < N; k++) {
            //System.err.println(" checking arr["+k+"]=" + arr[k]);

            // N has to come first, than N-1, than .... N-k
            int target = N - k;

            // maximum is already in correct place, we can skip
            if (arr[k] == target) {
                continue;
            }

            // find index of TARGET
            int indexOfTarget = posArray[target];

            //System.err.println(" maximum " + arr[maxIndex] +" found at i=" + maxIndex);
            //System.err.println(" swapping arr[" + k + "]=" + arr[k] + " and arr[" + maxIndex + "]=" + arr[maxIndex]);
            // if element is found we swap them
            swap(posArray, arr[k], target);
            swap(arr, k, indexOfTarget);

            // each swap cost 1 unit, if all 'nrOfSwaps' are spend we are done
            nrOfSwaps--;
            if (nrOfSwaps == 0) {
                break;
            }
            //System.err.println(Arrays.toString(arr));
        }

        String delimiter = "";
        for (int i = 0; i < N; i++) {
            System.out.print(delimiter + arr[i]);
            delimiter = " ";
        }
    }
}
