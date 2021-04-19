package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * Sum square difference
 * @author marckoch
 */
public class PE006 {
    private static long getSum(int n) {
        return (n * (n+1))/2;
    }
    
    private static long getSumOfSquares(int n) {
        long sum=0;
        for (int i=1; i<=n; i++) {
            sum += (i*i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long sumN = getSum(n);
            System.out.println((sumN * sumN) -  getSumOfSquares(n)  );
        }
    }
}
