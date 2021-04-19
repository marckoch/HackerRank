package toolbox.primes;

import java.util.Arrays;
import java.util.TreeSet;

public class GeneratePrimes {

    public static TreeSet<Integer> getPrimes(long maxPrime) {
        TreeSet<Integer> primes = new TreeSet<>();
        primes.add(2);
        for (int i = 3; i <= maxPrime; i += 2) {
            boolean factorFound = false;
            for (int p : primes) {
                if (p * p > i) {
                    break;
                }
                if (i % p == 0) {
                    factorFound = true; // i is NOT a prime
                    break;
                }
            }
            if (!factorFound) { // i is prime!
                primes.add(i);
            }
        }

        System.err.println("generated " + primes.size() + " primes");
        return primes;
    }

    public static int[] getPrimesArray(long maxPrime) {
        TreeSet<Integer> primes = getPrimes(maxPrime);
        return primes.stream().mapToInt(x -> x).toArray();
    }

    public static long[] getPrimesArrayLong(long maxPrime) {
        TreeSet<Integer> primes = getPrimes(maxPrime);
        return primes.stream().mapToLong(x -> x).toArray();
    }

    public static int[] getNPrimes(int N) {
        TreeSet<Integer> primes = new TreeSet<>();
        primes.add(2);
        int countPrimes=1;
        for (int i = 3; i <= Integer.MAX_VALUE; i += 2) {
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
                countPrimes++;
                if (countPrimes >= N)
                    break;
            }
        }

        System.err.println("generated " + primes.size() + " primes");
        final int[] result = new int[primes.size()];
        int i=0;
        for (Integer next : primes) {
            result[i++] = next;
        }
        return result;
    }
    
    public static boolean[] getPrimesAsBooleanArray(int size) {
        boolean[] primes = new boolean[size];

        for (int i = 0; i < size; i++) {
            primes[i] = true;
        }

        primes[0] = false;
        primes[1] = false;
        primes[2] = true;

        for (int i = 3; i < size; i++) {
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    primes[i] = false;
                    break;
                }
            }
        }

        //System.err.println(Arrays.toString(prime));
        return primes;
    }

    public static long[] getFirstNPrimes(int N) {
        long[] primes = new long[N];
        int index = 0;

        primes[index++] = 2;
        for (int i = 3; i <= 100 * N; i += 2) {
            boolean factorFound = false;
            for (long p : primes) {
                if (p * p > i) {
                    break;
                }
                if (i % p == 0) {
                    factorFound = true;
                    break;
                }
            }
            if (!factorFound) {
                primes[index++] = i;
            }
            if (index >= N) {
                break;
            }
        }

        //System.err.println("generated " + primes.length + " primes");

        //System.err.println(Arrays.toString(primes));
        return primes;
    }

    public static void main(String[] args) {
        //System.out.println(getPrimes(10_000_000L));
        //Set<Integer> primes = getPrimes(100000000);

        //System.out.println(Arrays.toString(getPrimeArray(100000000)));
        // System.out.println(Arrays.toString(getFirstNPrimes(20)));
        
        System.out.println(Arrays.toString(getPrimesArray(20)));
        //getPrimeArray(10000000);

    }
}
