package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class CatsAndAMouse {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            for (int a0 = 0; a0 < q; a0++) {
                int catA = in.nextInt();
                int catB = in.nextInt();
                int mouse = in.nextInt();
                
                int a = Math.abs(catA - mouse);
                int b = Math.abs(catB - mouse);
                
                if (a < b) {
                    System.out.println("Cat A");
                } else if (b < a) {
                    System.out.println("Cat B");
                } else {
                    System.out.println("Mouse C");
                }
            }
        }
    }
}
