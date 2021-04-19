package algorithms.strings;

import java.util.Scanner;

/**
 * TODO UNFINISHED!
 * @author marckoch
 */
public class MorganAndAString {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            while (T-- > 0) {
                String s1 = in.next();
                String s2 = in.next();
                
                char[] res = new char[s1.length() + s2.length()];
                char[] c1 = s1.toCharArray();
                char[] c2 = s2.toCharArray();
                
                int pos = 0;
                int pos1 = 0;
                int pos2 = 0;
                while (pos < res.length) {
                    if (pos1 == c1.length) { // string1 is exhausted, use string 2
                        res[pos] = c2[pos2];
                        pos2++;
                    } else if (pos2 == c2.length) { // string2 is exhausted, use string 1
                        res[pos] = c1[pos1];
                        pos1++;
                    } else if (c1[pos1] == c2[pos2]) {
                        //System.err.println(pos1 + " " + pos2);
                        int k = 1;
                        while (pos1 + k < c1.length && pos2 + k < c2.length) {
                            if (pos1 + k == c1.length - 1) {
                                res[pos] = c1[pos1];
                                pos1++;
                            } else if (pos2 + k == c2.length - 1) {
                                res[pos] = c2[pos2];
                                pos2++;
                            } else if (c1[pos1 + k] < c2[pos2 + k]) {
                                res[pos] = c1[pos1];
                                pos1++;
                            } else if (c1[pos1 + k] > c2[pos2 + k]) {
                                res[pos] = c2[pos2];
                                pos2++;
                            } else {
                                k++;
                            }
                        }
                    } else if (c1[pos1] < c2[pos2]) {
                        res[pos] = c1[pos1];
                        pos1++;
                    } else if (c1[pos1] > c2[pos2]) {
                        res[pos] = c2[pos2];
                        pos2++;
                    }
                    pos++;
                }
                System.out.println(res);
            }
        }
    }
}
