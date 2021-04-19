package algorithms.bitmanipulation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class FlippingBits {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            long MAX_UNSIGNED_INT = (long) Math.pow(2, 32) - 1;
            
            int T = in.nextInt();
            for (int t = 0; t < T; t++) {
                long n = in.nextLong();
                
                System.out.println(MAX_UNSIGNED_INT - n);
            }
        }
    }
}
