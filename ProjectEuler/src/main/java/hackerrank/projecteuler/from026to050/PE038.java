package hackerrank.projecteuler.from026to050;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Pandigital multiples
 * @author marckoch
 */
public class PE038 {
    private static boolean isPandigital(String str) {
        if (str.contains("0")) return false;
        
        // checkif we only have unique chars and only those between 1 .. K(which is str.length)
        Set<Character> digits = new HashSet<>();
        for (Character c : str.toCharArray()) {
            if (Character.getNumericValue(c) > str.length()) return false;
            if (!digits.add(c)) return false;
        }
        //System.err.println(str + " is pandigital!");
        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        
        for (int n=2; n<=N; n++) {

            // build the number by appending multiples of n
            StringBuilder sb = new StringBuilder();
            for (int i=1; i<=K; i++) {
                sb.append(n*i);
                if (sb.length() >= K) 
                    break;
            }
            
            if (sb.length()==K) {
                //System.err.println(n + " " + sb.toString());
                if (isPandigital(sb.toString())) {
                    //System.err.println(n + " " + sb.toString());
                    System.out.println(n);
                }
            }
        }
    }
}
