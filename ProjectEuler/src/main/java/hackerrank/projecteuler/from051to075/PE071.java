package hackerrank.projecteuler.from051to075;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ordered fractions
 *
 * @author marckoch
 */
public class PE071 {

    private static long gcd(long a, long b) {
        while (a != 0) {
            long c = a;
            a = b % a;
            b = c;
        }
        return b;
    }

    // just fooling around, not valid for real solution because it is too slow
    public static void buildFractions() {
        int N = 8;

        for (int bottom = 1; bottom <= N; bottom++) {
            for (int top = 1; top < bottom; top++) {
                int[] fraction = {top, bottom};
                int gcd = (int) gcd(top, bottom);
                int[] simplifiedFraction = new int[]{top / gcd, bottom / gcd};
                System.err.println(Arrays.toString(fraction) + " > " + Arrays.toString(simplifiedFraction));
            }
        }
    }

    // 50% on hackerrank
    // good naive solution, but will needlessly continue to search for better 
    // solutions
    public static void findClosestFraction(int a, int b, long N) {
        // we start with the left most fraction 0/1
        long bestTop = 0;
        long bestBottom = 1;

        for (long q = N; q > 2; q--) {
            long p = (a * q - 1) / b;
            System.err.printf("%s/%s\n", p, q);
            if (p * bestBottom > bestTop * q) {
                bestTop = p;
                bestBottom = q;
                System.err.printf("found new best: %s/%s\n", bestTop, bestBottom );
            }
        }
        int gcd = (int) gcd(bestTop, bestBottom);
        System.out.printf("%s %s\n", bestTop / gcd, bestBottom / gcd);
    }

    // 50% on hackerrank
    public static void findClosestFractionWithLowerBound(int a, int b, long N) {
        long bestTop = 0;
        long bestBottom = 1;
        long lowerbound = 2;

        long q = N;
        while (q >= lowerbound) {

            long p = (a * q - 1) / b;
            // System.err.printf("%s/%s\n", p, q);
            if (p * bestBottom > bestTop * q) {
                bestTop = p;
                bestBottom = q;
                lowerbound = bestBottom / (a * bestBottom - b * bestTop);
                System.err.printf("found new best: %s/%s\n", bestTop, bestBottom );
                System.err.printf("new lowerbound=%s\n", lowerbound);
            }

            q--;
        }

        int gcd = (int) gcd(bestTop, bestBottom);
        System.out.printf("%s %s\n", bestTop / gcd, bestBottom / gcd);
    }

    // 100% on hackerrank, Stern Brocot Tree
    public static void findQ(int qTop, int qBottom, long limit) {
        long[] left = {0, 1};
        long[] right = {1, 1};
        
        while (left[1] + right[1] <= limit) {
            long[] med = new long[]{left[0] + right[0], left[1] + right[1]};
            
            if (med[0] * qBottom < qTop * med[1]) {
                left = med;
            } else {
                right = med;
                if (right[0] == qTop && right[1] == qBottom) {
                    break;
                }
            }
            //System.err.println(Arrays.toString(med) + " " + (double) med[0]/med[1]);
        }
        
        if (limit >= left[1] + right[1]) {
            long difference = limit - (left[1] + right[1]);
            long repeat = 1 + difference / right[1];
            left[0] += repeat * right[0];
            left[1] += repeat * right[1];
        }
        System.out.println(left[0] + " " + left[1]);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            long N = in.nextLong();

            findQ(a, b, N);
            
            //long start = System.nanoTime();
            //findClosestFraction(a, b, N);
            //System.err.printf("findClosestFraction(%s %s %s) took %s\n", a, b, N, (System.nanoTime() - start));

            //start = System.currentTimeMillis();
            //findClosestFractionWithLowerBound(a, b, N);
            //System.err.printf("findClosestFractionWithLowerBound(%s %s %s) took %s\n", a, b, N, (System.currentTimeMillis() - start));
        }
    }

}
