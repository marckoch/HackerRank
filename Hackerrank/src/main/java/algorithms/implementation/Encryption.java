package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class Encryption {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();

            s = s.replaceAll(" ", "");
            //System.err.println(s);

            int l = s.length();
            //System.err.println(l);

            int row = (int) Math.floor(Math.sqrt(l));
            //System.err.println(row);

            int col = (int) Math.ceil(Math.sqrt(l));
            //System.err.println(col);

            for (int r = 0; r < col; r++) {
                for (int c = r; c < l; c += col) {
                    System.out.print(s.charAt(c));
                }
                System.out.print(" ");
            }
        }
    }
}
