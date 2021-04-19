package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MarsExploration {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String S = in.next();
            //System.err.println(S);
            solve(S);
        }
        //System.err.println(S);
        //System.err.println(S);
    }

    static void solve(String S) {
        int noOfSOSs = S.length() / 3;
        //System.err.println("noOfSOSs=" + noOfSOSs);
        
        int count = 0;
        for (int i = 0; i < noOfSOSs; i++) {
            String msg = S.substring(i * 3, i * 3 + 3);
            //System.err.println(msg);
            if (msg.charAt(0) != 'S') {
                count++;
            }
            if (msg.charAt(1) != 'O') {
                count++;
            }
            if (msg.charAt(2) != 'S') {
                count++;
            }
        }
        System.out.println(count);
    }
}
