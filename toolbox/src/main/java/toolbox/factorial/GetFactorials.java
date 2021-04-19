package toolbox.factorial;

import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author marckoch
 */
public class GetFactorials {

    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }

    private static long factWithMod(int n, long mod) {
        BigInteger result = BigInteger.ONE;
        BigInteger MOD = BigInteger.valueOf(mod);
        while (n > 1) {
            result = result.multiply(BigInteger.valueOf(n));
            result = result.mod(MOD);
            n--;
        }
        return result.longValue();
    }

    // http://codeforces.com/blog/entry/5457
    // inv[1] = 1;
    // for (int i=2; i<p; ++i)
    //      inv[i] = (p - (p/i) * inv[p%i] % p) % p;
    // http://e-maxx.ru/algo/reverse_element
    private static long[] getInverseMod(int n, long mod) {
        long[] invMod = new long[n + 1];
        invMod[1] = 1;
        for (int i = 2; i <= n; i++) {
            invMod[i] = (mod - (mod / i) * invMod[(int)mod % i] % mod) % mod;
        }
        return invMod;
    }
    
    // basic recursion: fact(N) = N * fact(N-1)
    private static long[] getFactorialsMod(int n, long mod) {
        long[] factsMod = new long[n + 1];
        factsMod[0] = 1;
        for (int i = 1; i <= n; i++) {
            factsMod[i] = factsMod[i - 1] * i % mod;
        }
        return factsMod;
    }

    // basic recursion: 1/fact(N) = 1/N * 1/fact(N-1)
    private static long[] getInverseFactorialsMod(int n, long mod) {
        long[] invs = getInverseMod(n, mod);
        long[] invFactsMod = new long[n + 1];
        invFactsMod[0] = 1;
        invFactsMod[1] = 1;
        for (int i = 2; i <= n; i++) {
            invFactsMod[i] = (invFactsMod[i-1] * invs[i]) % mod;
        }
        return invFactsMod;
    }

    public static void main(String[] args) {
        long mod = 10000007L;
        BigInteger MOD = BigInteger.valueOf(mod);

        System.out.println("factorial(25)=" + factorial(BigInteger.valueOf(253L)));
        System.out.println("factorial(25)=" + factorial(BigInteger.valueOf(253L)).mod(MOD));
        System.out.println("factWithMod(25)=" + factWithMod(253, mod));

        System.out.println("factorial(10)=" + factorial(BigInteger.valueOf(33L)));
        System.out.println("factorial(10)=" + factorial(BigInteger.valueOf(33L)).mod(MOD));
        System.out.println("factWithMod(10)=" + factWithMod(33, mod));

        System.out.println(Arrays.toString(getFactorialsMod(10, mod)));
        System.out.println(Arrays.toString(getInverseFactorialsMod(10, mod)));
        
        long[] factsMod = getFactorialsMod(100, mod);
        long[] invs = getInverseMod(100, mod);
        for (int i = 0; i < 100; i++) {
            System.err.printf("%s * %s == %s mod %s\n", i, invs[i], (invs[i] * i) % mod, mod);
        }

        long[] invFactsMod = getInverseFactorialsMod(100, mod);
        for (int i = 0; i < 100; i++) {
            System.err.printf("%s: %s! %s * %s == %s mod %s\n", i, i, factsMod[i], invFactsMod[i], (invFactsMod[i] * factsMod[i]) % mod, mod);
        }
    }
}
