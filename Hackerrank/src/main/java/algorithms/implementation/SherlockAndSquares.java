package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class SherlockAndSquares {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            
            for (int i = 0; i < q; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                
                int sqA = (int) Math.ceil(Math.sqrt(a));
                int sqB = (int) Math.floor(Math.sqrt(b));
                
                System.out.println(sqB - sqA + 1);
            }
        }
    }
}
