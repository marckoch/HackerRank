package toolbox.modulo;

import java.util.Arrays;

/**
 *
 * @author marckoch
 */
public class ArrayOfModuloInverse {
    // http://codeforces.com/blog/entry/5457
    // inv[1] = 1;
    // for (int i=2; i<p; ++i)
    //      inv[i] = (p - (p/i) * inv[p%i] % p) % p;
    // http://e-maxx.ru/algo/reverse_element
    private static long[] getInverseMod(int n, long mod) {
        long[] invFactsMod = new long[n + 1];
        invFactsMod[1] = 1;
        for (int i = 2; i <= n; i++) {
            invFactsMod[i] = (mod - (mod / i) * invFactsMod[(int)mod % i] % mod) % mod;
        }
        return invFactsMod;
    }
    
    public static void main(String[] args) {
        final int MOD = (int) Math.pow(10, 9) + 7;
        
        long[] invs = getInverseMod(100, MOD);
        System.err.println(Arrays.toString(invs));
        
        for (int i = 0; i < invs.length; i++) {
            long inv = invs[i];
            // shows that i * inv(i) == 1 (mod MOD)
            System.err.println("i=" + i + " " + (inv * i) % MOD);
        }
    }
}
