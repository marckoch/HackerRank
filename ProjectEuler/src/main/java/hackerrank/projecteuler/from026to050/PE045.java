package hackerrank.projecteuler.from026to050;

import java.util.Scanner;

/**
 * Triangular, pentagonal, and hexagonal
 * @author marckoch
 */
public class PE045 {
   private static boolean isTriangular(long n) {
        double temp = (Math.sqrt(8.0 * n + 1.0) - 1.0) / 2.0;
        return temp == (int) temp;
    }

    private static boolean isPentagonal(long n) {
        double temp = (Math.sqrt(24.0 * n + 1.0) + 1.0) / 6.0;
        return temp == (int) temp;
    }

    private static boolean isHexagonal(long n) {
        double temp = (Math.sqrt(8.0 * n + 1.0) + 1.0) / 4.0;
        return temp == (int) temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        int a = in.nextInt();
        int b = in.nextInt();

        final long LIMIT = (long) Math.sqrt(N / 3);
        //System.err.println(LIMIT);
        
        for (long n=1; n<LIMIT; n++) {
            long pent = n * ( 3 * n - 1) / 2;
            //System.err.println("P("+n+")=" + pent);
            
            if (b==5) {
                if (isTriangular(pent)) {
                    System.out.println(pent);
                }
            } else { // b==6!
                if (isHexagonal(pent)) {
                    System.out.println(pent);
                }
            }
        }
    } 
}
