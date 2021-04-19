package hackerrank.projecteuler.from051to075;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Diophantine equation
 *
 * @author marckoch
 */
public class PE066 {

    public static int findMax(int max) {
        int result = 0;
        BigInteger maxX = BigInteger.ZERO;

        for (int D = 2; D <= max; D++) {
            //System.err.println("checking " + D);
            BigInteger limit = BigInteger.valueOf((long) Math.sqrt(D));

            BigInteger Dbi = BigInteger.valueOf(D);

            if (limit.multiply(limit).equals(Dbi)) {
                continue;
            }

            BigInteger m = BigInteger.ZERO;
            BigInteger d = BigInteger.ONE;
            BigInteger a = limit;

            BigInteger numm1 = BigInteger.ONE;
            BigInteger x = a;

            BigInteger denm1 = BigInteger.ZERO;
            BigInteger den = BigInteger.ONE;

            while (!x.multiply(x).subtract(den.multiply(den).multiply(Dbi)).equals(BigInteger.ONE)) {
                //System.err.println(String.format("%s %s %s", m, d, a));
                m = d.multiply(a).subtract(m);
                d = (Dbi.subtract(m.multiply(m))).divide(d);
                a = (limit.add(m)).divide(d);
                //System.err.println(String.format("%s %s %s", m, d, a));

                BigInteger numm2 = numm1;
                numm1 = x;
                BigInteger denm2 = denm1;
                denm1 = den;

                x = a.multiply(numm1).add(numm2);
                den = a.multiply(denm1).add(denm2);
            }

            if (x.compareTo(maxX)>0) {
                maxX = x;
                result = D;
                //System.err.println(maxX + " " + result);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(findMax(N));
    }
}
