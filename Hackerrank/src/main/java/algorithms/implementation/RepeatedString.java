package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class RepeatedString {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            long n = in.nextLong();
            
            int countA = 0;
            for (char c : s.toCharArray()) {
                if ('a' == c) countA++;
            }
            long noRep = n / s.length();
            
            long totalCountOfA = noRep * countA;
            
            long mod = n % s.length();
            
            for (int i=0; i<mod; i++) {
                if ('a' == s.charAt(i)) totalCountOfA++;
            }
            System.out.println(totalCountOfA);
        }
    }
}
