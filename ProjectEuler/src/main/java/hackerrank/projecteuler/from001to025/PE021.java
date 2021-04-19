package hackerrank.projecteuler.from001to025;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Amicable numbers
 * @author marckoch
 */
public class PE021 {
    private static final int[] DIVISOR_SUM_CACHE = new int[320000];
    
    private static int getSumOfDivisors(int n) {
        if (n==1) return 0;
        if (DIVISOR_SUM_CACHE[n] > 0) 
            return DIVISOR_SUM_CACHE[n];
        
        int sum=0;
        for (int i=1; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {   
                sum +=i;
                if (i > 1 && i != (n/i)) {
                    sum += (n/i);
                }
            }
        }
        //System.err.println(" d(" + n + ")=" + sum);
        DIVISOR_SUM_CACHE[n] = sum;
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] testcase = new int[T];
        int maxN = 0;
        for (int t=0; t<T; t++) {
            int n = in.nextInt();
            testcase[t] = n;
            maxN = Math.max(maxN, n);
        }
        //System.err.println(Arrays.toString(testcase));
        
        Set<Integer> amicable = new TreeSet<>();
        for (int i=1; i<=maxN; i++) {
            int j = getSumOfDivisors(i);
            if (j != i && getSumOfDivisors(j) == i) {
                amicable.add(i);
                amicable.add(j);
            }
        }
        
        //System.err.println(amicable);
        
        for (int t=0; t<T; t++) {
            int sum=0;
            Iterator<Integer> it = amicable.iterator();
            while (it.hasNext()) {
                int n = it.next();
                if (n <= testcase[t]) {
                    sum += n;
                } else {
                    break;
                }
            }
            System.out.println(sum);
        }
    }
}
