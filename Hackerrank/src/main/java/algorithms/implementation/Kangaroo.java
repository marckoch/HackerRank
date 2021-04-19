package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class Kangaroo {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if (x1 > x2 && v1 > v2) return "NO";
        if (x2 > x1 && v2 > v1) return "NO";
        
        int distance = x2-x1;
        while (true) {
            x1 += v1;
            x2 += v2;
            if (x1==x2) 
                return "YES";
            if ( (x2-x1) >= distance) return "NO"; // they are moving apart or staying in sync!
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int x1 = in.nextInt();
            int v1 = in.nextInt();
            int x2 = in.nextInt();
            int v2 = in.nextInt();
            String result = kangaroo(x1, v1, x2, v2);
            System.out.println(result);
        }
    }
}
