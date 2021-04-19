package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * Special Pythagorean triplet
 * @author marckoch
 */
public class PE009 {
    private static int getB(int N, int a) {
        return (N * (N - 2*a)) / (2 * (N - a));
    }
    
    private static boolean isPythagorean(int a, int b, int c) {
        return a*a + b*b == c*c;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            int maxProd = 1;
            for (int a=1; a<n/2; a++) {
                int b = getB(n, a);
                
                if (a>b) break;
                
                //System.err.println("n=" + n + ", a="+a + ",b="+b);
                int c = n-(a+b);
                if (isPythagorean(a, b, c)) {
                    //System.err.println("n=" + n + ", a="+a + ",b="+b+ ",c="+c+ " is match!");
                    maxProd = Math.max(maxProd, a*b*c);
                }
            }
            System.out.println(maxProd == 1 ? -1 : maxProd);
        }
    }
}
