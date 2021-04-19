package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class ElectronicsShop {

    static int getMoneySpent(int[] keyboards, int[] drives, int s) {
        // Complete this function
        int maxSum = -1;
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                if (keyboards[i] + drives[j] <= s) {
                    maxSum = Math.max(maxSum, keyboards[i] + drives[j]);
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int s = in.nextInt();
            int n = in.nextInt();
            int m = in.nextInt();
            
            int[] keyboards = new int[n];
            for (int i = 0; i < n; i++) {
                keyboards[i] = in.nextInt();
            }
            
            int[] drives = new int[m];
            for (int i = 0; i < m; i++) {
                drives[i] = in.nextInt();
            }
            
            //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
            int moneySpent = getMoneySpent(keyboards, drives, s);
            System.out.println(moneySpent);
        }
    }
}
