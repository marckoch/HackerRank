package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class LarrysArray {
    private static int countInversions(int[] arr) {
        int inv_count = 0;
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i+1; j < arr.length; j++)
            if (arr[i] > arr[j])
                inv_count++;
        return inv_count;
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            
            while (T-- > 0) {
                int n = in.nextInt();
                int[] a = new int[n];
                for (int j=0; j<n; j++) {
                    a[j] = in.nextInt();
                }
                
                int inv = countInversions(a);
                System.err.println(Arrays.toString(a) + " " + inv);
                
                System.out.println(inv % 2 == 0 ? "YES" : "NO");
            }
        }
    }
}
