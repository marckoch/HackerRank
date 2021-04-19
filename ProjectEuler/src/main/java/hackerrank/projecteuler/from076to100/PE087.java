package hackerrank.projecteuler.from076to100;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Prime power triples
 *
 * @author marckoch
 */
public class PE087 {

    public static int[] getPrimesArray(int maxPrime) {
        TreeSet<Integer> primes = new TreeSet<>();
        primes.add(2);
        for (int i = 3; i <= maxPrime; i += 2) {
            boolean factorFound = false;
            for (int p : primes) {
                if (p * p > i) {
                    break;
                }
                if (i % p == 0) {
                    factorFound = true;
                    break;
                }
            }
            if (!factorFound) {
                primes.add(i);
            }
        }

        //System.err.println("generated " + primes.size() + " primes");
        final int[] result = new int[primes.size()];
        int i = 0;
        for (Integer next : primes) {
            result[i++] = next;
        }
        return result;
    }

    public static boolean[] initArray(int N) {
        boolean[] match = new boolean[N + 1];

        BigInteger Nbi = BigInteger.valueOf(N);

        int maxPrimeNeeded = (int) Math.ceil(Math.sqrt(N));
        int[] primes = getPrimesArray(maxPrimeNeeded);

        for (int i = 0; i < primes.length; i++) {
            for (int j = 0; j < primes.length; j++) {
                for (int k = 0; k < primes.length; k++) {
                    BigInteger bi = BigInteger.valueOf(primes[i]).pow(2)
                            .add(BigInteger.valueOf(primes[j]).pow(3))
                            .add(BigInteger.valueOf(primes[k]).pow(4));
                    if (bi.compareTo(Nbi) < 0) {
                        match[bi.intValue()] = true;
                    } else {
                        break;
                    }
                }
            }
        }
        return match;
    }

    public static int[] initCountArray(int N) {
        boolean[] match = initArray(N);
        int[] count = new int[N + 1];
        int sum = 0;
        for (int i = 0; i < match.length; i++) {
            if (match[i]) {
                sum++;
            }
            count[i] = sum;
        }
        //System.err.println(Arrays.toString(count));
        return count;
    }

    public static long solve(int N) {
        int[] count = initCountArray(N);
        return count[N];
    }

    public static void solveHackerrank() {
        int MAX_N = 0;

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] tests = new int[T];
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            MAX_N = Math.max(MAX_N, N);
            tests[t] = N;
        }

        int[] count = initCountArray(MAX_N);

        for (int i = 0; i < T; i++) {
            System.out.println(count[tests[i]]);
        }
    }

    public static void solveProjectEuler() {
        System.out.println(solve(50_000_000));
    }

    public static void main(String[] args) {
        solveHackerrank();
        //System.out.println(solve(50));
        //System.out.println(solve(10_000_000));

        //solveProjectEuler();
    }
}
