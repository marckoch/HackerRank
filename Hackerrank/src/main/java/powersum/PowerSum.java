package powersum;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

// inverse modulo
// factorials
public class PowerSum {

    static Map<String, BigInteger> cacheBinomialCoeff = new HashMap<>();
    static Map<String, Long> cacheBinomialCoeffLong = new HashMap<>();
    static Map<String, BigInteger> cachePart1 = new HashMap<>();
    static Map<String, BigInteger> cachePart3 = new HashMap<>();

//    // Returns value of Binomial Coefficient C(n, k)
//    static long binomialCoeff(long n, long k) {
//        long res = 1;
//
//        // Since C(n, k) = C(n, n-k)
//        if (k > n - k) {
//            k = n - k;
//        }
//
//        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
//        for (int i = 0; i < k; ++i) {
//            res *= (n - i);
//            res /= (i + 1);
//        }
//
//        //System.err.println("C("+n + "," + k + " )=" + res);
//        return res;
//    }
    // Returns value of Binomial Coefficient C(n, k)
    static BigInteger binomialCoeffCalculated(long n, long k) {
        BigInteger res = BigInteger.ONE;
        long origK = k;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k) {
            k = n - k;
        }

        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; ++i) {
            res = res.multiply(BigInteger.valueOf(n - i))
                    .divide(BigInteger.valueOf(i + 1));
        }

        //System.err.println("C(" + n + ", " + origK + ")=" + res);
        return res;
    }

    static int modInv(long x, long mod) {
        for (int i = 1; i <= mod; i++) {
            if ((x * i) % mod == 1) {
                return i;
            }
        }
        return 1;
    }

    // Returns value of Binomial Coefficient C(n, k)
    static long binomialCoeffLongCalculated(long n, long k, long mod) {
        long res = 1L;
        long origK = k;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k) {
            k = n - k;
        }

        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (long i = 0; i < k; ++i) {
            res = res * (n - i);
            //res %= mod;
            res = res / (i + 1);
            //res = res * modInv(i + 1, mod);
            //res %= mod;
            //System.err.println(String.format("{%s} {%s} {%s} res={%s}", i, (n - i), (i + 1), res));
        }

        //System.err.println("C(" + n + ", " + origK + ")=" + res);
        return res % mod;
    }

    // Returns value of Binomial Coefficient C(n, k)
    static BigInteger binomialCoeffCached(long n, long k) {
        if (k > n - k) {
            k = n - k;
        }

        String key = String.valueOf(n + "_" + k);

        if (cacheBinomialCoeff.containsKey(key)) {
            //System.err.println("++++ cache hit!! " + key);
            return cacheBinomialCoeff.get(key);
        }

        String prevKeyK = String.valueOf((n - 1) + "_" + (k - 1));
        if (cacheBinomialCoeff.containsKey(prevKeyK)) {
            //System.err.println("++++ cache hit!! " + prevKeyK);
            BigInteger prev = cacheBinomialCoeff.get(prevKeyK);
            BigInteger res = prev
                    .multiply(BigInteger.valueOf(n))
                    .divide(BigInteger.valueOf(k));
            cacheBinomialCoeff.put(key, res);
            return res;
        }

//        String sucKeyK = String.valueOf((n+1) + "_" + (k+1));
//        if (cacheBinomialCoeff.containsKey(sucKeyK)) {
//            //System.err.println("++++ cache hit!! " + sucKeyK);
//            BigInteger prev = cacheBinomialCoeff.get(sucKeyK);
//            BigInteger res = prev
//                    .multiply(BigInteger.valueOf(k+1))
//                    .divide(BigInteger.valueOf(n+1));
//            cacheBinomialCoeff.put(key, res);
//            return res;
//        }  
        String prevKey = String.valueOf((n - 1) + "_" + k);
        if (cacheBinomialCoeff.containsKey(prevKey)) {
            // System.err.println("++++ cache hit prev !! " + prevKey);
            BigInteger prev = cacheBinomialCoeff.get(prevKey);
            BigInteger res = prev
                    .multiply(BigInteger.valueOf(n))
                    .divide(BigInteger.valueOf(n - k));
            cacheBinomialCoeff.put(key, res);
            return res;
        }

        String prevKey2 = String.valueOf(n + "_" + (k - 1));
        if (cacheBinomialCoeff.containsKey(prevKey2)) {
            // System.err.println("++++ cache hit prev !! " + prevKey2);
            BigInteger prev = cacheBinomialCoeff.get(prevKey2);
            BigInteger res = prev
                    .multiply(BigInteger.valueOf(n + 1 - k))
                    .divide(BigInteger.valueOf(k));
            cacheBinomialCoeff.put(key, res);
            return res;
        }

        cacheBinomialCoeff.put(key, binomialCoeffCalculated(n, k));
        return cacheBinomialCoeff.get(key);

    }

    // Returns value of Binomial Coefficient C(n, k)
    static long binomialCoeffCachedLong(long n, long k, long mod) {
        if (k > n - k) {
            k = n - k;
        }

        String key = String.valueOf(n + "_" + k);

        if (cacheBinomialCoeffLong.containsKey(key)) {
            //System.err.println("++++ cache hit!! " + key);
            return cacheBinomialCoeffLong.get(key);
        }

        String prevKeyK = String.valueOf((n - 1) + "_" + (k - 1));
        if (cacheBinomialCoeffLong.containsKey(prevKeyK)) {
            //System.err.println("++++ cache hit!! " + prevKeyK);
            long prev = cacheBinomialCoeffLong.get(prevKeyK);
            long res = prev * n;
            res %= mod;
            res /= k;
            res %= mod;
            cacheBinomialCoeffLong.put(key, res);
            return res;
        }

//        String sucKeyK = String.valueOf((n+1) + "_" + (k+1));
//        if (cacheBinomialCoeff.containsKey(sucKeyK)) {
//            //System.err.println("++++ cache hit!! " + sucKeyK);
//            BigInteger prev = cacheBinomialCoeff.get(sucKeyK);
//            BigInteger res = prev
//                    .multiply(BigInteger.valueOf(k+1))
//                    .divide(BigInteger.valueOf(n+1));
//            cacheBinomialCoeff.put(key, res);
//            return res;
//        }  
        String prevKey = String.valueOf((n - 1) + "_" + k);
        if (cacheBinomialCoeffLong.containsKey(prevKey)) {
            // System.err.println("++++ cache hit prev !! " + prevKey);
            long prev = cacheBinomialCoeffLong.get(prevKey);
            long res = prev * n;
            res %= mod;
            res /= n - k;
            res %= mod;
            cacheBinomialCoeffLong.put(key, res);
            return res;
        }

        String prevKey2 = String.valueOf(n + "_" + (k - 1));
        if (cacheBinomialCoeffLong.containsKey(prevKey2)) {
            // System.err.println("++++ cache hit prev !! " + prevKey2);
            long prev = cacheBinomialCoeffLong.get(prevKey2);
            long res = prev * n + 1 - k;
            res %= mod;
            res /= k;
            res %= mod;
            cacheBinomialCoeffLong.put(key, res);
            return res;
        }

        cacheBinomialCoeffLong.put(key, binomialCoeffLongCalculated(n, k, mod));
        return cacheBinomialCoeffLong.get(key);

    }

//    private static long powerSum(long n, int k) {
//        long sum = 0L;
//
//        for (int i = 1; i <= k; i++) {
//            for (int j = 0; j < i; j++) {
//                
//                long part1 = (long) Math.pow(i - j, k);
//                long part2 = binomialCoeff(n - i + k + 1, n-i);
//                long part3 = binomialCoeff(k+1, j);
//                
//                long res = part1 * part2 * part3;
//                
//                if (j%2==1) 
//                    res = -res;
//                
//                sum += res;
//            }
//        }
//
//        return sum;
//    }
    private static BigInteger powerSumBi(long n, int k) {
        BigInteger sum = BigInteger.ZERO;

        for (int i = 1; i <= k; i++) {
            BigInteger part2 = binomialCoeffCached(n - i + k + 1, n - i);
            for (int j = 0; j < i; j++) {

                BigInteger part1 = BigInteger.valueOf(i - j).pow(k);
                BigInteger part3 = binomialCoeffCached(k + 1, j);

                BigInteger res = part1.multiply(part2).multiply(part3);

                if (j % 2 == 1) {
                    res = res.negate();
                }

                sum = sum.add(res);
            }
        }

        return sum;
    }

    private static BigInteger powerSumBi(long n, int k, long mod) {
        long start = System.currentTimeMillis();

        BigInteger sum = BigInteger.ZERO;
        BigInteger K = BigInteger.valueOf(k);
        BigInteger MOD = BigInteger.valueOf(mod);

        for (int i = k; i > 0; i--) {
            //System.err.println(">> " + (n - i + k + 1) + " " + (k+1));
            BigInteger part2 = binomialCoeffCached(n - i + k + 1, k + 1).mod(MOD);

            //BigInteger newPart3 = BigInteger.ONE; // 301 over 0  (k+1 over j) ==> 1
            for (int j = 0; j < i; j++) {

                final String part1Key = String.valueOf((i - j) + "_" + K);
                BigInteger part1;
                if (!cachePart1.containsKey(part1Key)) {
                    part1 = BigInteger.valueOf(i - j).modPow(K, MOD);
                    cachePart1.put(part1Key, part1);
                } else {
                    //System.err.println("cache hit part1 " + part1Key);
                    part1 = cachePart1.get(part1Key);
                }
                //BigInteger part1 = BigInteger.valueOf(i - j).modPow(K, MOD);

                final String part3Key = String.valueOf(k + 1 + "_" + j);
                BigInteger part3;
                if (!cachePart3.containsKey(part3Key)) {
                    part3 = binomialCoeffCached(k + 1, j).mod(MOD);
                    cachePart3.put(part3Key, part3);
                } else {
                    //System.err.println("cache hit part3 " + part3Key);
                    part3 = cachePart3.get(part3Key);
                }
                // BigInteger part3 = binomialCoeffBi(k+1, j).mod(MOD);
                //newPart3 = newPart3.multiply(BigInteger.valueOf(k+1-j)).divide(BigInteger.valueOf(j+1)).mod(MOD);
                // System.err.println("newPart3=" + newPart3);

                BigInteger res = part1.multiply(part2).mod(MOD).multiply(part3).mod(MOD);

                if (j % 2 == 1) {
                    res = res.negate();
                }

                sum = sum.add(res).mod(MOD);
            }
        }

        System.out.println(String.format("powerSumBi(%s, %s, %s)=%s took %s", n, k, MOD, sum.mod(MOD), (System.currentTimeMillis() - start)));

        return sum.mod(MOD);
    }

    private static BigInteger powerSumNoCache(long n, int k, long mod) {
        long start = System.currentTimeMillis();
        BigInteger sum = BigInteger.ZERO;
        BigInteger K = BigInteger.valueOf(k);
        BigInteger MOD = BigInteger.valueOf(mod);

        for (int i = 1; i <= k; i++) {

            BigInteger part2 = binomialCoeffCalculated(n - i + k + 1, k + 1).mod(MOD);

            for (int j = 0; j < i; j++) {

                BigInteger part1 = BigInteger.valueOf(i - j).modPow(K, MOD);

                BigInteger part3 = binomialCoeffCalculated(k + 1, j).mod(MOD);

                BigInteger res = part1.multiply(part2).mod(MOD).multiply(part3).mod(MOD);

                if (j % 2 == 1) {
                    res = res.negate().mod(MOD);
                }

                sum = sum.add(res).mod(MOD);
            }
        }

        System.out.println(String.format("powerSumNoCache(%s, %s, %s)=%s took %s", n, k, MOD, sum.mod(MOD), (System.currentTimeMillis() - start)));

        return sum.mod(MOD);
    }

    private static BigInteger powerSumNew(long n, int k, long mod) {
        long start = System.currentTimeMillis();
        BigInteger sum = BigInteger.ZERO;
        BigInteger K = BigInteger.valueOf(k);
        BigInteger MOD = BigInteger.valueOf(mod);

        BigInteger part2;// = binomialCoeffCalculated(n, k+1).mod(MOD);

        for (int i = 1; i <= k; i++) {

            part2 = binomialCoeffCalculated(n - i + k + 1, k + 1).mod(MOD);
//            part2 = part2.multiply(BigInteger.valueOf(n+1+k-i))
//                    .divide(BigInteger.valueOf(n-k))
//                    .mod(MOD);

            for (int j = 0; j < i; j++) {

                BigInteger part1 = BigInteger.valueOf(i - j).modPow(K, MOD);

                BigInteger part3 = binomialCoeffCalculated(k + 1, j).mod(MOD);

                BigInteger res = part1.multiply(part2).mod(MOD).multiply(part3).mod(MOD);

                if (j % 2 == 1) {
                    res = res.negate();
                }

                sum = sum.add(res).mod(MOD);
            }
        }

        System.out.println(String.format("powerSumNew(%s, %s, %s)=%s took %s", n, k, MOD, sum.mod(MOD), (System.currentTimeMillis() - start)));

        return sum.mod(MOD);
    }

    static long modPow(long n, long k, long mod) {
        long res = 1L;
        for (int i = 1; i <= k; i++) {
            res *= n;
            res %= mod;
        }
        return res;
    }

    private static long powerSumLongNew(long n, int k, long mod) {
        long start = System.currentTimeMillis();
        long sum = 0L;

        for (int i = 1; i <= k; i++) {

            long part2 = binomialCoeffLongCalculated(n - i + k + 1, k + 1, mod);

            for (int j = 0; j < i; j++) {

                long part1 = modPow(i - j, k, mod);

                long part3 = binomialCoeffLongCalculated(k + 1, j, mod);

                long res = part1 * part2;
                res %= mod;
                res = res * part3;
                res %= mod;

                if (j % 2 == 1) {
                    res = -res;
                }
                if (res < 0) {
                    res += mod;
                }

                sum = sum + res;
                sum %= mod;
            }
        }

        System.out.println(String.format("powerSumLongNew(%s, %s, %s)=%s took %s", n, k, mod, sum, (System.currentTimeMillis() - start)));

        return sum;
    }

// extended Euclidean algorithm, see also en.wikipedia.org/wiki/Extended_Euclidean_algorithm
// simplified version of ExtendedGcd from problem 134
    static long modularInverse(long a, long modulo) {
        // pretty much the same code can be found on https://rosettacode.org/wiki/Modular_inverse

        long originalModulo = modulo;
        // note: s and t can be negative inside the loop
        long s = 0;
        long t = 1;
        while (a > 1) {
            long tmp = modulo;
            long quotient = a / modulo;
            modulo = a % modulo;
            a = tmp;

            long tmp2 = s;
            s = t - quotient * s;
            t = tmp2;
        }

        // avoid negative result
        return t < 0 ? t + originalModulo : t;
    }

    /* n chose m mod p */
 /* computed with the theorem of Lucas */
    static long modbinom(long n, long m, long mod) {
        long i, result, divisor, n_, m_;

        if (m == 0) {
            return 1;
        }

        /* check for the likely case that the result is zero */
        if (n < m) {
            return 0;
        }

        for (n_ = n, m_ = m; m_ > 0; n_ /= mod, m_ /= mod) {
            if (n_ % mod < m_ % mod) {
                return 0;
            }
        }

        for (result = 1; n >= mod || m >= mod; n /= mod, m /= mod) {
            result *= modbinom(n % mod, m % mod, mod);
            result %= mod;
        }

        /* avoid unnecessary computations */
        if (m > n - m) {
            m = n - m;
        }

        divisor = 1;
        for (i = 0; i < m; i++) {
            result *= n - i;
            result %= mod;

            divisor *= i + 1;
            divisor %= mod;
        }

        result *= modularInverse(divisor, mod);
        result %= mod;

        return result;
    }

    public static void main(String[] args) {
//        powerSumBi(10, 2, 1000000009L);
//        powerSumNoCache(10, 2, 1000000009L);
//        powerSumNew(10, 2, 1000000009L);
//        
//        powerSumBi(100000, 300, 1000000009L);
//        powerSumNoCache(100000, 300, 1000000009L);
//        powerSumNew(100000, 300, 1000000009L);
//        
//        powerSumBi(1000, 400, 1000000009L);
//        powerSumNoCache(1000, 400, 1000000009L);
//        powerSumNew(1000, 400, 1000000009L);
//        
//        powerSumBi(3, 400, 1000000009L);
//        powerSumNoCache(3, 400, 1000000009L);
//        powerSumNew(3, 400, 1000000009L);
//        
//        powerSumBi(1000, 2, 1000000009L);
//        powerSumNoCache(1000, 2, 1000000009L);
//        powerSumNew(1000, 2, 1000000009L);

        //powerSumBi(40, 20, 1000000009L);
        //powerSumNoCache(1000, 1000, 1000000009L);
        //powerSumNew(1000, 1000, 1000000009L);
        //powerSumNoCache(100, 100, 1000000009L);
        //powerSumNew(100, 100, 1000000009L);
        //powerSumBi(100, 100, 1000000009L);
        //powerSumLongNew(100, 100, 1000000009L);
        System.out.println("binomialCoeffCalculated(20, 5)=" + binomialCoeffCalculated(1000L, 500L));
        //System.out.println("binomialCoeffCalculated(20, 5, 1000L)=" + binomialCoeffCalculated(1000L, 500L).mod(BigInteger.valueOf(1000L)));
        System.out.println("binomialCoeffLongCalculated(20, 5, 1000L)=" + binomialCoeffLongCalculated(1000, 500, 1000L));

        System.out.println("modbinom(1000L, 500L, 1000L)=" + modbinom(1000L, 500L, 1000000009L));

        System.out.println(modPow(13, 13, 100009L));
    }
}
