package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class TheLoveLetterMystery {

    static int theLoveLetterMystery(String s) {
        int ops = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            char front = s.charAt(i);
            char back = s.charAt(s.length() - 1 - i);
            //System.err.println(front + " " + back);
            ops += Math.abs(front - back);
        }
        return ops;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while (q-- > 0) {
            String s = in.next();
            int result = theLoveLetterMystery(s);
            System.out.println(result);
        }
    }
}
