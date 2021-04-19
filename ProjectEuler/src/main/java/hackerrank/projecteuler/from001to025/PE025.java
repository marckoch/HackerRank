package hackerrank.projecteuler.from001to025;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * N-digit Fibonacci number
 * @author marckoch
 */
public class PE025 {
    private static final int DIM = 5001;
    private static final int[] minFibWithLength = new int[DIM];
    
    public static void buildFib() {
        BigInteger f0 = BigInteger.ZERO;
        BigInteger f1 = BigInteger.ONE;
        BigInteger fn = f1.add(f0);
        
        minFibWithLength[1] = 1;
            
        int n=2;
        
        int digits = 2;
        BigInteger powerOfTen = BigInteger.TEN;
        while (digits < DIM) {
            n++;
            f0 = f1;
            f1 = fn;
            fn = f1.add(f0);
            
            // Math.log10 seems to be too slow, so we keep track of
            // the number of digits ourselves!
            // int length = (int)(Math.log10(fn.doubleValue())+1);
            
            int length = fn.divide(powerOfTen).intValue();
            if (length > 0) {
                //System.err.println(n + " " + fn + " " + digits);

                if (minFibWithLength[digits] == 0) {
                    minFibWithLength[digits] = n;
                }
                
                powerOfTen = powerOfTen.multiply(BigInteger.TEN);
                digits++;
            }
        }
    }
    
    public static void main(String[] args) {
        buildFib();
        
        //System.err.println(Arrays.toString(minFibWithLength));
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            
            System.out.println(minFibWithLength[N]);
        }
    }
}
