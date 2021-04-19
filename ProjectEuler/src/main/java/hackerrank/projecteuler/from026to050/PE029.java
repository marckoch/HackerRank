package hackerrank.projecteuler.from026to050;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Distinct powers
 *
 * @author marckoch
 */
public class PE029 {

    private static BitSet[] counters;

    private static boolean lowerDivisorExists(int b, int f, int n) {
        for (int c = 1; c < f; c++) {
            if (b % c == 0 && b / c <= n) {
                return true;
            }
        }
        return false;
    }

    public static void printBits(String prompt, BitSet b) {
        System.err.print(prompt + " ");
        for (int i = 0; i < b.length(); i++) {
            System.err.print(b.get(i) ? "1" : "0");
        }
        System.err.println();
    }

    public static long getAnswer(int n) {
        // BitSet for all a (N==1000000) will provoke memory error
        //for (int a = 2; a<=n; a++) {
        //counters[a] = new BitSet(n+1);
        //counters[a].set(2, n+1);
        //}

        //for (int a=2; a<=n; a++) {
        //   printBits("after init" , counters[a]);
        //}
        // we mark duplicates in a BitSet, which will only be created on demand
        // and only for numbers that are multiples of smaller a
        for (int a = 2; a * a <= n; a++) {
            int power = a * a; //power == i^f
            int limit = n;
            for (int f = 2; power <= n; f++) {
                for (int b = 2; b <= limit; b++) {
                    if (b % f == 0) {
                        int d = b / f;
                        if (d <= n && d >= 2 && lowerDivisorExists(b, f, n)) {
                            if (counters[power] == null) {
                                counters[power] = new BitSet(n + 1);
                            }
                            counters[power].set(d);
                        }
                    }
                }
                limit = n * f;
                power *= a;
            }
        }

        //for (int a=2; a<counters.length; a++) {
        //    printBits("after marking duplicates" , counters[a]);
        //}
        long sum = 0L;
        for (int a = 2; a <= n; a++) {
            if (counters[a] == null) {
                // no BitSet (e.g. for primes), no duplicats were marked, 
                // that means all n-1 numbers count!
                sum += (n - 1);
            } else {
                // all n-1 count minus all marked duplicates
                sum += (n - 1 - counters[a].cardinality());
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            counters = new BitSet[n + 1];
            System.out.println(getAnswer(n));
        }
    }
}
