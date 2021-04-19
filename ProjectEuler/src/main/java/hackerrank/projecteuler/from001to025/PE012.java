package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * Highly divisible triangular number
 * @author marckoch
 */
public class PE012 {
    private static final int LIMIT = 1000000;
    private static final int[] DIV = new int[LIMIT+1];

    private static int generateTriangle(int n) {
        return n * (n+1) / 2;
    }
    
    private static int countDivisors(int n) {
        if (DIV[n] > 0) {
            return DIV[n];
        }
        
        int count=1;
        for (int i=2; i<=n; i++) {
            if (n % i == 0) {
                count++;
            }
        }        
        DIV[n] = count;
        return count;
    }
   
    public static long getTriangle(int limit) {
        int n=1;
        long numberOfDivisors = 0;
        long firstCoprime, secondCoprime;
        while (true) {
            if ( n % 2 == 0 ) {
                firstCoprime = countDivisors(n/2);
                secondCoprime = countDivisors(n+1);
            } else {
                firstCoprime = countDivisors(n);
                secondCoprime = countDivisors((n+1)/2);
            }           
            numberOfDivisors = firstCoprime * secondCoprime;
            if ( numberOfDivisors > limit ) {
                return generateTriangle(n);
            }       
            n++;
        }
    }

    
    public static void main(String[] args) {
        DIV[1]=1;
        DIV[2]=2;
        DIV[3]=2;
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            long triangle = getTriangle(n);
            System.out.println(triangle);
        }
    }
}
