package hackerrank.projecteuler.from076to100;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Prime summations
 *
 * @author marckoch
 */
public class PE077 {

    private static final int LIMIT = 1000;
    private static final long[] COUNT = new long[LIMIT + 1];
    private static int[] PRIMES;

    static {
        initPrimes();
        initCountArray();
    }
    
    private static void initPrimes() {
        PRIMES = getPrimesArray(LIMIT);
    }

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
        final int[] primesArray = new int[primes.size()];
        int i=0;
        for (Integer next : primes) {
            primesArray[i++] = next;
        }
        //System.err.println(Arrays.toString(primesArray));
        return primesArray;
    }
    
    private static void initCountArray() {
        COUNT[0] = 1;
        for (int i = 0; i < PRIMES.length; i++) {
            for(int j = PRIMES[i]; j <= LIMIT; j++) {
                COUNT[j] = COUNT[j] + COUNT[j - PRIMES[i]];
            }
            //System.err.println(PRIMES[i] + " " + Arrays.toString(COUNT));
        }
        //System.err.println(Arrays.toString(COUNT));
    }
    
    public static long solveProjectEuler() {
        for (int i = 0; i < COUNT.length; i++) {
            //System.err.println(String.format("%s %s", i, COUNT[i]));
            if (COUNT[i]>5000) return i;
        }
        return 0;
    }

    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            System.out.println(COUNT[N]);
        }
    }

    public static void main(String[] args) {
        System.out.println(solveProjectEuler());
        //solveHackerrank();
    }
}
