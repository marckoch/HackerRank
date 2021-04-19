package hackerrank.projecteuler.from001to025;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Non-abundant sums
 * @author marckoch
 */
public class PE023 {
    private static boolean[] isAbundant;
    
    private static int getSumOfDivisors(int n) {
        if (n==1) return 0;
        
        int sum=0;
        for (int i=1; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {   
                sum +=i;
                if (i > 1 && i != (n/i)) {
                    sum += (n/i);
                }
            }
        }
        //System.err.println(" getSumOfDivisors(" + n + ")=" + sum);
        return sum;
    }
    
    // hackerrank solution
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
//        int[] testcase = new int[T];
//        int maxN = 0;
//        for (int t=0; t<T; t++) {
//            int n = in.nextInt();
//            testcase[t] = n;
//            maxN = Math.max(maxN, n);
//        }
//        
//        //System.err.println(Arrays.toString(testcase));
//        
//        isAbundant = new boolean[maxN+1];
//        for (int i=1; i<=maxN; i++) {
//            if (getSumOfDivisors(i) > i) {
//                //System.err.println(i + " is abundant");
//                isAbundant[i] = true;
//            }
//        }
//        
//        //System.err.println(Arrays.toString(isAbundant));
//        
//        for (int t=0; t<T; t++) {
//            int N = testcase[t];
//            boolean isPossible=false;
//            for (int n = 1; n<=N/2; n++) {
//                if (isAbundant[n] && isAbundant[N-n]) {
//                    //System.err.println(n + " " + (N-n) +" is possible");
//                    isPossible=true;
//                }
//            }
//            
//            System.out.println(isPossible ? "YES" : "NO");
//        }
//    }
    
    private static boolean isSumOfTwoAbundantNumbers(int number) {
        for (int n = 1; n <= number / 2; n++) {
            if (isAbundant[n] && isAbundant[number - n]) {
                //System.err.println(n + " " + (N-n) +" is possible");
                return true;
            }
        }
        return false;
    }
    
    // project euler solution
    public static void main(String[] args) {
        int maxN = 28123;
        
        //System.err.println(Arrays.toString(testcase));
        
        isAbundant = new boolean[maxN+1];
        for (int i=1; i<=maxN; i++) {
            if (getSumOfDivisors(i) > i) {
                //System.err.println(i + " is abundant");
                isAbundant[i] = true;
            }
        }
        
        // System.err.println(Arrays.toString(isAbundant));
        
        long sum=0L;
        for (int q=0; q<=maxN; q++) {
            if (!isSumOfTwoAbundantNumbers(q))
                sum += q;

        }
        System.out.println(sum);
    }
}
