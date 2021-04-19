package hackerrank.projecteuler.from001to025;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Lexicographic permutations
 * @author marckoch
 */
public class PE024 {
    // https://medium.com/@aiswaryamathur/find-the-n-th-permutation-of-an-ordered-string-using-factorial-number-system-9c81e34ab0c8
    private static int[] toFactoradic(int n, int dimension) {
        int originalN = n;
        int[] res = new int[dimension];
        int div=1;
        while (n>0) {
            res[dimension-div] = n % div;
            
            n /= div;
            
            div++;
        }
        //System.err.println("toFactoradic(" + originalN + ")=" + Arrays.toString(res));
        return res;
    }
    
    private static String buildString(char[] seed, int[] nFact) {
        StringBuilder sb = new StringBuilder();
        
        // convert to List because in list remove is simpler
        List<Character> chars = new ArrayList<>();
        for (int i=0; i<seed.length; i++) {
            chars.add(seed[i]);
        }
        
        for (int i=0; i< nFact.length; i++) {
            sb.append(chars.get(nFact[i]));
            chars.remove(nFact[i]);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        char[] seed = "abcdefghijklm".toCharArray();
        
        for (int t=0; t<T; t++) {
            int n = in.nextInt();
            
            int[] nFact = toFactoradic(n-1, seed.length);
            //System.err.println(Arrays.toString(nFact));
            
            System.out.println(buildString(seed, nFact));
        }
    }
}
