package algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO UNFINISHED!!
 * @author marckoch
 */
public class GridlandProvinces {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int PROV = in.nextInt();
            while (PROV-- > 0) {
                int N = in.nextInt();
                String s1 = in.next();
                String s2 = in.next();
                //System.err.println(s1);
                //System.err.println(s2);
                solve(s1, s2, N);
            }
        }
    }

    static void solve(String s1, String s2, int N) {
        Set<String> tours = new HashSet<>();
        
        String clockwise1 = s1 + new StringBuilder(s2).reverse().toString();
        //System.err.println(clockwise1);
        for (int i=0; i<clockwise1.length(); i++) {
            String tour = clockwise1.substring(i) + clockwise1.substring(0, i);
            //System.err.println(tour);
            tours.add(tour);
        }
        
        String counterClockwise1 = s2 + new StringBuilder(s1).reverse().toString();
        //System.err.println(counterClockwise1);
        for (int i=0; i<counterClockwise1.length(); i++) {
            String tour = counterClockwise1.substring(i) + counterClockwise1.substring(0, i);
            //System.err.println(tour);
            tours.add(tour);
        }
        
        // snake 1 (top left going down)
        StringBuilder snake1 = new StringBuilder();
        for (int i=0; i<N; i++) {
            if (i % 2 == 0) {
                snake1.append(s1.charAt(i));
                snake1.append(s2.charAt(i));
            } else if (i % 2 == 1) {
                snake1.append(s2.charAt(i));
                snake1.append(s1.charAt(i));
            }
            //System.err.println(i + " " + snake1.toString());
        }
        //System.err.println(snake1.toString());
        tours.add(snake1.toString());
        
        // snake 2 (bottom left going down)
        StringBuilder snake2 = new StringBuilder();
        for (int i=0; i<N; i++) {
            if (i % 2 == 0) {
                snake2.append(s2.charAt(i));
                snake2.append(s1.charAt(i));
            } else if (i % 2 == 1) {
                snake2.append(s1.charAt(i));
                snake2.append(s2.charAt(i));
            }
            //System.err.println(i + " " + snake2.toString());
        }
        //System.err.println(snake2.toString());
        tours.add(snake2.toString());
        
        // snake 3 (top right going down)
        StringBuilder snake3 = new StringBuilder();
        for (int i=N-1; i>=0; i--) {
            if (i % 2 == 0) {
                snake3.append(s1.charAt(i));
                snake3.append(s2.charAt(i));
            } else if (i % 2 == 1) {
                snake3.append(s2.charAt(i));
                snake3.append(s1.charAt(i));
            }
            //System.err.println(i + " " + snake3.toString());
        }
        //System.err.println(snake3.toString());
        tours.add(snake3.toString());
        
        // snake 4 (bottom right going up)
        StringBuilder snake4 = new StringBuilder();
        for (int i=N-1; i>=0; i--) {
            if (i % 2 == 0) {
                snake4.append(s2.charAt(i));
                snake4.append(s1.charAt(i));
            } else if (i % 2 == 1) {
                snake4.append(s1.charAt(i));
                snake4.append(s2.charAt(i));
            }
            //System.err.println(i + " " + snake4.toString());
        }
        //System.err.println(snake4.toString());
        tours.add(snake4.toString());
        
        //System.err.println(tours);
        System.out.println(tours.size());
    }
}
