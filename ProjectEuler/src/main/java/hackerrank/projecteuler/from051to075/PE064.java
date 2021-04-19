package hackerrank.projecteuler.from051to075;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Odd period square roots
 * @author marckoch
 */
public class PE064 {
    public static int getPeriodLength(int n) {
        int m0 = 0;
        int d0 = 1;
        int a0 = (int) Math.sqrt(n);
        if (a0*a0==n) return 0; // n was a square
        
        Integer[] current = {m0, d0, a0};
        Set<String> steps = new HashSet<>();
        while (true) {
            if (!steps.add(Arrays.toString(current)))
                break;
            current = next(n, current);
        }
        
        return steps.size() - 1;
    }
    
    // see wiki:
    // https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Continued_fraction_expansion
    public static Integer[] next(int n, Integer[] mda) {
        int m = mda[0];
        int d = mda[1];
        int a = mda[2];
        
        int mN = d * a - m;
        int dN = (n - mN * mN) / d;
        int aN = (int) Math.floor( (Math.sqrt(n) + mN) / dN );
        
        Integer[] res = new Integer[]{mN, dN, aN};
        System.err.println(Arrays.toString(mda) + "->" + Arrays.toString(res));
        return res;
    }
    
    public static int count(int number) {
        int count=0;
        for (int i=1; i<=number; i++) {
            if(getPeriodLength(i) % 2 ==1) 
                count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        System.out.println(count(N));
    }
}
