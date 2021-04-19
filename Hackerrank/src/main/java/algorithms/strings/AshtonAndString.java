package algorithms.strings;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * TODO UNFINISHED!
 * @author marckoch
 */
public class AshtonAndString {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            while (T-- > 0) {
                String s = in.next();
                int k = in.nextInt();
                solve(s, k);
            }
        }
    }

    static void solve(String s, int k) {
        Set<String> substrings = new TreeSet<>();
        for (int i=0; i<s.length(); i++) {
            for (int j=i+1; j<=s.length(); j++) {
                //System.err.println(i + " " + j + " " + s.substring(i, j));
                substrings.add(s.substring(i, j));
            }
        }
        //System.err.println(substrings);
        
        char c = '\u0000';
        Iterator<String> it = substrings.iterator();
        while (it.hasNext()) {
            String substring = it.next();
            //System.err.println(substring);
            
            if (k>substring.length()) {
                k -= substring.length();
            } else {
                c = substring.charAt(k-1);
                break;
            }
        }
        System.out.println(c);
    }
}
