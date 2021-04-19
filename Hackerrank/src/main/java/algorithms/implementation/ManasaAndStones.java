package algorithms.implementation;

import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author marckoch
 */
public class ManasaAndStones {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            while (T-- > 0) {
                SortedSet<Integer> lastStones = new TreeSet<>();
                int n = in.nextInt();
                int a = in.nextInt();
                int b = in.nextInt();
                
                for (int noA=0; noA<=n-1; noA++) {
                    int last = (noA * a) + ((n - 1 - noA) * b);
                    // System.err.println("noA=" + noA + " noB=" + (n-1-noA) + " last="+last);
                    lastStones.add(last);
                }
                //System.out.println(lastStones);
                
                Iterator it = lastStones.iterator();
                while (it.hasNext()) {
                    System.out.print(it.next());
                    if (it.hasNext()) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
