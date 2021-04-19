package hackerrank.projecteuler.from101to125;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PE120 {
    static long maxSum = 0;
    static List<String> maximums = new ArrayList<>();

    public static void main(String[] args) {

        for (int a = 4; a <= 4; a++) {
            long max = 0;
            int nForMax = 0;

            BigInteger bigA = BigInteger.valueOf(a);

            for (int n = 1; n <= a*a; n++) {
                BigInteger aMinus1 = BigInteger.valueOf(a - 1).pow(n);
                BigInteger aPlus1 = BigInteger.valueOf(a + 1).pow(n);

                //System.out.println(a + " " + n + " " + aMinus1.add(aPlus1));
                long mod = (aMinus1.add(aPlus1)).mod(bigA.multiply(bigA)).longValue();

                //System.out.println(a + " " + n + " " + mod);
                if (mod > max) {
                    max = mod;
                    nForMax = n;
                    maxSum += max;
                }
            }
            maximums.add("a=" + a + " max=" + max + " at n=" + nForMax);

            //System.out.println(" >> " + a + " " + nForMax + " " + max);
        }

        maximums.forEach(System.out::println);

        System.out.println(maxSum);

        int r = 0;
        for (int a = 3; a <= 1000; a++) {
            int max = 2*a*((a - 1) / 2);
            int max2 = a*(a - 1);
            System.out.println("a=" + a + " max=" + max + " max2=" + max2);
            r += max;
        }
        System.out.println(r);
    }

}
