package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class DivisibleSumPairs {
    static int divisibleSumPairs(int n, int k, int[] ar) {
        // Complete this function
        int counter=0;
        for (int i=0; i<ar.length; i++) {
            for (int j=i+1; j<ar.length; j++) {
                if ( (ar[i] + ar[j]) % k == 0)
                    counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();
            
            int[] ar = new int[n];
            for(int i = 0; i < n; i++){
                ar[i] = in.nextInt();
            }
            
            int result = divisibleSumPairs(n, k, ar);
            System.out.println(result);
        }
    }
}
