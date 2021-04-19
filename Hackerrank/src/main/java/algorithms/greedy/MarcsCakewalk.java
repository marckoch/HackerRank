package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MarcsCakewalk {
     public static void main(String[] args) {
         try (Scanner in = new Scanner(System.in)) {
             int n = in.nextInt();
             int[] calories = new int[n];
             for(int i=0; i < n; i++){
                 calories[i] = in.nextInt();
             }
             
             solve(calories, n);
         }
    }

    static void solve(int[] calories, int n) {
        Arrays.sort(calories);
        long min=0;
        for (int i=0; i<n; i++) {
            min += (long) calories[n-1-i] * 1 << i;
        }
        System.out.println(min);
    }
}
