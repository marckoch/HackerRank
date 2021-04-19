package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MigratoryBirds {
    static int migratoryBirds(int n, int[] ar) {
        int[] counter = new int[5];
        for (int i=0; i<n; i++) {
            counter[ar[i]-1]++;
        }
        
        System.err.println(Arrays.toString(counter));
        
        int max=0;
        int maxIndex=0;
        for (int i=counter.length-1; i>=0; i--) {
            if (max <= counter[i]) {
                max = counter[i];
                maxIndex=i;
            }
        }
        
        return maxIndex+1;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            
            int[] ar = new int[n];
            for(int i = 0; i < n; i++){
                ar[i] = in.nextInt();
            }
            
            int result = migratoryBirds(n, ar);
            System.out.println(result);
        }
    }
}
