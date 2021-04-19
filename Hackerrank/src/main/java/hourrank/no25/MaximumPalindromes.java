package hourrank.no25;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MaximumPalindromes {

    static int mod = (int) Math.pow(10, 9) + 7;
    static long[] factMod;
    static long[] invFactMod;
    static int[][] freq;

    // http://codeforces.com/blog/entry/5457
    // inv[1] = 1;
    // for (int i=2; i<p; ++i)
    //      inv[i] = (p - (p/i) * inv[p%i] % p) % p;
    // http://e-maxx.ru/algo/reverse_element
    private static long[] getInverseMod(int n, long mod) {
        long[] invMod = new long[n + 1];
        invMod[1] = 1;
        for (int i = 2; i <= n; i++) {
            invMod[i] = (mod - (mod / i) * invMod[(int) mod % i] % mod) % mod;
        }
        return invMod;
    }

    private static long[] getFactorialsMod(int n, int mod) {
        long[] factsMod = new long[n + 1];
        factsMod[0] = 1;
        for (int i = 1; i <= n; i++) {
            factsMod[i] = factsMod[i - 1] * i % mod;
        }
        return factsMod;
    }

    private static long[] getInverseFactorialsMod(int n, long mod) {
        long[] invs = getInverseMod(n, mod);
        long[] invFactsMod = new long[n + 1];
        invFactsMod[0] = 1;
        invFactsMod[1] = 1;
        for (int i = 2; i <= n; i++) {
            invFactsMod[i] = (invFactsMod[i - 1] * invs[i]) % mod;
        }
        return invFactsMod;
    }

    static int[] freq(String s) {
        int[] lFreq = new int[26];
        for (char c : s.toCharArray()) {
            lFreq[c - 'a']++;
        }
        return lFreq;
    }

    static void initialize(String s) {
        // This function is called once before all queries.
        int N = s.length();
        factMod = getFactorialsMod(N + 1, mod);
        //System.err.println(Arrays.toString(factMod));
        invFactMod = getInverseFactorialsMod(N + 1, mod);
        //System.err.println(Arrays.toString(invFactMod));

        //System.err.println(s);
        char[] c = s.toCharArray();
        freq = new int[N + 1][26];
        for (int n = 0; n < N; n++) {
            freq[n + 1][c[n] - 'a']++;
        }
        //System.err.println("freq1" + Arrays.deepToString(freq));
        for (int n = 0; n < N; n++) {
            for (int j = 0; j < 26; j++) {
                freq[n + 1][j] += freq[n][j];
            }
        }
        //System.err.println("freq2" + Arrays.deepToString(freq));
    }

    static long answerQuery(String s, int l, int r) {
        //System.err.printf("s=%s l=%s r=%s\n", s, l, r);
        //String sub = s.substring(l - 1, r);
        //System.err.println("sub=" + sub);
        //int[] freq = freq(sub);
        //System.err.println(Arrays.toString(freq));
        //System.err.println(s);
        int[] freqL = freq[l - 1];
        //System.err.println("freq L " + Arrays.toString(freqL));
        int[] freqR = freq[r];
        //System.err.println("freq R " + Arrays.toString(freqR));
        int[] freqLtoR = new int[26];
        for (int i = 0; i < 26; i++) {
            freqLtoR[i] = freqR[i] - freqL[i];
        }
        //System.err.println("freq = " + Arrays.toString(freqLtoR));

        int countOdds = 0;
        int top = 0;
        long result = 1L;
        for (int i = 0; i < freqLtoR.length; i++) {
            if (freqLtoR[i] % 2 == 1) {
                countOdds++;
            }
            int ci = freqLtoR[i] / 2;
            top += ci;

            result = (result * invFactMod[ci]) % mod;
        }

        result = (result * Math.max(1, countOdds)) % mod;
        result = (result * factMod[top]) % mod;

        return result;
    }

//    public static BigInteger factorial(BigInteger n) {
//        BigInteger result = BigInteger.ONE;
//
//        while (!n.equals(BigInteger.ZERO)) {
//            result = result.multiply(n);
//            n = n.subtract(BigInteger.ONE);
//        }
//
//        return result;
//    }
    //
    // causes time out! too slow !!
//    static long calcWithBigInteger(int[] freq) {
//        int countOdds = 0;
//        BigInteger top = BigInteger.ZERO;
//        BigInteger bottom = BigInteger.ONE;
//        for (int i = 0; i < freq.length; i++) {
//            if (freq[i] % 2 == 1) {
//                countOdds++;
//            }
//            BigInteger ci = BigInteger.valueOf(freq[i] / 2);
//            top = top.add(ci);
//
//            bottom = bottom.multiply(factorial(ci));
//        }
//
//        BigInteger result = BigInteger.valueOf(Math.max(1, countOdds));
//        result = result.multiply(factorial(top));
//        result = result.divide(bottom);
//
//        //System.err.println("pals=" + pals);
//        return result.mod(BigInteger.valueOf(mod)).longValue();
//    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            initialize(s);
            int q = in.nextInt();
            while (q-- > 0) {
                int l = in.nextInt();
                int r = in.nextInt();
                long result = answerQuery(s, l, r);
                System.out.println(result);
            }
        }
    }
}
