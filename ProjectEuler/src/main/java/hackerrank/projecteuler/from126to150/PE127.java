package hackerrank.projecteuler.from126to150;

import toolbox.gcd.GreatestCommonDivisor;
import toolbox.radical.Radical;

import java.util.Arrays;

public class PE127 {

    public static int LIMIT = 120000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = 0;

        // precalc all radicals to save method calls and calculate same thing again and again
        long[] radicals = new long[LIMIT + 1];
        Arrays.fill(radicals, 1);
        for (int i = 2; i < radicals.length; i++) {
            radicals[i] = Radical.getRadical(i);
        }

        //System.out.println(Arrays.toString(radicals));

        for (int a = 1; a < LIMIT / 2; a++) {
            for (int b = a + 1; a + b <= LIMIT; b++) {
                int c = a + b;
                // if gcd(a,b) == 1 >> gcd(a,c)==1 and gcd(b,c)==1
//                    if (GreatestCommonDivisor.gcd(b, c) > 1) {
//                        continue;
//                    }
//                    if (GreatestCommonDivisor.gcd(a, c) > 1) {
//                        continue;
//                    }

                long radical = radicals[a] * radicals[b] * radicals[c];
                if (radical < c) {
                    if (GreatestCommonDivisor.gcd(a, b) == 1) { // do this expensive calculation AFTER cheap array lookup of radicals!
                        //System.out.println(a + " " + b + " " + c + " winner!");
                        sum += c;
                    }
                }
            }
        }
        System.out.println(sum + " took " + (System.currentTimeMillis() - start));
    }
}
