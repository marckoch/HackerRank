package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class BonAppetit {

    static int bonAppetit(int n, int k, int bCharged, int[] ar) {
        // Complete this function
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i != k) {
                sum += ar[i];
            }
        }
        int bActual = sum / 2;
        return bCharged - bActual;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
            }

            int b = in.nextInt();
            int result = bonAppetit(n, k, b, ar);
            System.out.println(result == 0 ? "Bon Appetit" : "" + result);
        }
    }
}
