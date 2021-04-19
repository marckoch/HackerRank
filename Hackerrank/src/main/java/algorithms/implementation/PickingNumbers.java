package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class PickingNumbers {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            
            int maxCounter = 0;
            for (int i = 0; i < n; i++) {
                int counter = 1;
                for (int j = i + 1; j < n; j++) {
                    if (a[j] - a[i] <= 1) {
                        counter++;
                    } else {
                        break;
                    }
                }
                maxCounter = Math.max(maxCounter, counter);
            }
            System.out.println(maxCounter);
        }
    }
}
