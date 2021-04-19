package hackerrank.projecteuler.from101to125;

import org.junit.Test;
import toolbox.primes.GeneratePrimes;

import java.math.BigInteger;

public class PE123 {

    public static void main(String[] args) {
        int n = 7037;

        long[] firstNPrimes = GeneratePrimes.getFirstNPrimes(n + 15_000);

        getMod(firstNPrimes, n);

        BigInteger tenTen = BigInteger.TEN.pow(10);

        // slow brute force solution :-(
        for (int i = n; i < firstNPrimes.length; i +=2) {
            BigInteger mod = getMod(firstNPrimes, i);
            if (mod.compareTo(tenTen) > 0) {
                System.out.println(" >> " + i);
                break;
            }
        }
    }

    public static BigInteger getMod(long[] primes, int n) {
        long nThPrime = getNthPrime(primes, n);

        BigInteger bigN = BigInteger.valueOf(nThPrime);
        BigInteger nMinus1 = BigInteger.valueOf(nThPrime - 1);
        BigInteger nPlus1 = BigInteger.valueOf(nThPrime + 1);

        BigInteger mod = nMinus1.pow(n).add(nPlus1.pow(n)).mod(bigN.pow(2));
        System.out.println(mod);
        return mod;
    }

    @Test
    public void test() {
        int n = 7037;

        long[] firstNPrimes = GeneratePrimes.getFirstNPrimes(n + 15_000);

        System.out.println(getNthPrime(firstNPrimes, 1));
        System.out.println(getNthPrime(firstNPrimes, 2));
        System.out.println(getNthPrime(firstNPrimes, 3));
        System.out.println(getNthPrime(firstNPrimes, 7037));
        System.out.println(getNthPrime(firstNPrimes, 21031));
        System.out.println(getNthPrime(firstNPrimes, 21033));
        System.out.println(getNthPrime(firstNPrimes, 21035));

        getMod(firstNPrimes, 7035);
        getMod(firstNPrimes, 7037);
        getMod(firstNPrimes, 21031);
        getMod(firstNPrimes, 21033);
        getMod(firstNPrimes, 21035);
    }

    public static long getNthPrime(long[] primes, int n) {
        return primes[n-1];
    }
}
