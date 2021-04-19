package algorithms.strings;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author marckoch
 */
public class WeightedUniformStrings {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            char[] c = s.toCharArray();

            Set<Integer> weights = new TreeSet<>();

            char lastChar = '_';
            int counter = 0;
            for (int i = 0; i < c.length; i++) {
                System.err.println(c[i] + " " + (int) c[i]);

                counter += c[i] - 96;
                //System.err.println("adding " + counter);
                weights.add(counter);

                if (i == c.length - 1 || c[i] != c[i + 1]) {
                    //System.err.println("reseting counter to 0");
                    counter = 0;
                }
            }
            System.err.println(weights);

            int n = in.nextInt();
            while (n-- > 0) {
                int x = in.nextInt();
                System.out.println(weights.contains(x) ? "Yes" : "No");
            }
        }
    }
}
