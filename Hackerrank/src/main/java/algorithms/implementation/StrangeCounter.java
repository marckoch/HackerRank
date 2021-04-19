package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class StrangeCounter {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            long t = in.nextLong();
            
            long rem = 3;
            while (t > rem) {
                t -= rem;
                rem *= 2;
            }
            
            System.out.println(rem-t+1);
        }
    }
}
