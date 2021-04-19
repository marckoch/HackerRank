package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class BetweenTwoSets {

    static int getTotalX(int[] a, int[] b) {
        int minX = a[a.length - 1];
        int maxX = b[0];
        int count = 0;

        for (int x = minX; x <= maxX; x++) {
            if (isMatchForA(x, a) && isMatchForB(x, b)) {
                //System.err.println("checking " + x + " is a match!");
                count++;
            }
        }

        return count;
    }

    static boolean isMatchForA(int x, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (x % a[i] != 0) {
                //System.err.println("checking " + x + " no match for a");
                return false;
            }
        }
        return true;
    }

    static boolean isMatchForB(int x, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (b[i] % x != 0) {
                //System.err.println("checking " + x + " no match for b");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();
            
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = in.nextInt();
            }
            
            int total = getTotalX(a, b);
            System.out.println(total);
        }
    }
}
