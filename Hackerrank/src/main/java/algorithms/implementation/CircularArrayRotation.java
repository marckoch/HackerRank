package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class CircularArrayRotation {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int noOperations = in.nextInt();
            int noQueries = in.nextInt();
            
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            for (int a0 = 0; a0 < noQueries; a0++) {
                int m = in.nextInt();
                m = (m - noOperations) % n;
                if (m < 0) {
                    m += n;
                }
                System.out.println(a[m]);
            }
        }
    }
}
