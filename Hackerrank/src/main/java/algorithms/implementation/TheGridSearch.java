package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class TheGridSearch {

    private static boolean search(String[] G, String[] P) {
        for (int row = 0; row + P.length <= G.length; row++) {
            int ix = -1;
            do {
                // search for first pattern row in grid (might occur more than once!)
                ix = G[row].indexOf(P[0], ix + 1);
                if (ix >= 0) {
                    // we found a match, now we must check the lower rows on the same starting index
                    int pRowMatching = 1;
                    for (int tempRow = 1; tempRow < P.length; tempRow++) {
                        if (P[tempRow].equals(G[row + tempRow].substring(ix, ix + P[tempRow].length()))) {
                            pRowMatching++;
                        } else {
                            break;
                        }
                    }
                    if (pRowMatching == P.length) {
                        return true;
                    }
                }
            } while (ix >= 0);
        }
        return false;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            while (T-- > 0) {

                int R = in.nextInt();
                int C = in.nextInt();
                String[] G = new String[R];
                for (int i = 0; i < R; i++) {
                    G[i] = in.next();
                }

                int r = in.nextInt();
                int c = in.nextInt();
                String[] P = new String[r];
                for (int i = 0; i < r; i++) {
                    P[i] = in.next();
                }

                System.out.println(search(G, P) ? "YES" : "NO");
            }
        }
    }
}
