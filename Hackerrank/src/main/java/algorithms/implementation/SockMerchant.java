package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        int countPairs = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ar[i] != 0 && ar[i] == ar[j]) {
                    countPairs++;
                    ar[i] = 0;
                    ar[j] = 0;
                }
            }
        }
        return countPairs;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
            }
            
            int result = sockMerchant(n, ar);
            System.out.println(result);
        }
    }
}
