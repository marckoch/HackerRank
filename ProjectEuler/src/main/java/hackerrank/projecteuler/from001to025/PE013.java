package hackerrank.projecteuler.from001to025;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Large sum
 * @author marckoch
 */
public class PE013 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
    
        BigInteger sum = BigInteger.ZERO;
    
        for(int a0 = 0; a0 < t; a0++){
            String n = in.next();
            BigInteger bi = new BigInteger(n);
            //System.err.println(bi);
            sum = sum.add(bi);
        }
        System.out.println(sum.toString().substring(0,10));
    }
}
