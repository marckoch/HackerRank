package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class SequenceEquation {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] pInv = new int[n + 1];
            for (int x = 1; x <= n; x++) {
                int posX = in.nextInt();
                pInv[posX] = x;
            }
            //System.err.println(Arrays.toString(pInv));
            
            for (int x = 1; x <= n; x++) {
                int y = pInv[pInv[x]];
                System.out.println(y);
            }
        }
    }
}
