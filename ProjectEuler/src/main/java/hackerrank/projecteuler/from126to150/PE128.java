package hackerrank.projecteuler.from126to150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PE128 {
    private static List<Long> numbersWith3Primes = new ArrayList<>();
    private static boolean[] isPrime = isPrime(1_000_000);

    public static void main(String[] args) {
        long n = 1;
        for (int ring = 0; ring < 80_000; ring++) {
//            System.out.println("ring " + ring + " (" + (ring * 6) + " zahlen)");
            for (long i = 0; i < ring * 6; i++) {
                n++;
                if (i == 0) {
                    {
                        long number = n;
                        long top = number + 6 * ring;
                        long lowerRight = top - 1;
                        long topRight = lowerRight + 6 * (ring + 1);
                        long below = number - 6 * (ring - 1);
                        long lowerLeft = number + 1;
                        long topLeft = top + 1;

                        analyseNumber(number, top, topRight, lowerRight, below, lowerLeft, topLeft);
                    }
                    {
                        long number = n + (ring * 6) - 1;

                        long top = number + 6 * (ring + 1);
                        long topRight = top - 1;
                        long lowerRight = number - 1;
                        long below = number - 6 * ring;
                        long lowerLeft = below + 1 - 6 * (ring - 1);
                        long topLeft = below + 1;

                        analyseNumber(number, top, topRight, lowerRight, below, lowerLeft, topLeft);
                    }

                }
            }
            if (numbersWith3Primes.size() > 2000) break;
        }
        System.out.println(numbersWith3Primes.size());
        System.out.println(numbersWith3Primes.get(1999));
    }

    private static void analyseNumber(long number, long top, long topRight, long lowerRight, long below, long lowerLeft, long topLeft) {
//        System.out.println("   " + number + ": " + top + " " + topRight + " " + lowerRight + " " + below + " " + lowerLeft + " " + topLeft);

        int diff2Top = (int) Math.abs(top - number);
        int diff2TopRight = (int) Math.abs(topRight - number);
        int diff2LowerRight = (int) Math.abs(lowerRight - number);
        int diff2Below = (int) Math.abs(below - number);
        int diff2LowerLeft = (int) Math.abs(lowerLeft - number);
        int diff2TopLeft = (int) Math.abs(topLeft - number);

        int countPrimes = 0;
        if (isPrime[diff2Top]) countPrimes++;
        if (isPrime[diff2TopRight]) countPrimes++;
        if (isPrime[diff2LowerRight]) countPrimes++;
        if (isPrime[diff2Below]) countPrimes++;
        if (isPrime[diff2LowerLeft]) countPrimes++;
        if (isPrime[diff2TopLeft]) countPrimes++;
        if (countPrimes == 3) {
            System.out.println("   " + number + ": " + top + " " + topRight + " " + lowerRight + " " + below + " " + lowerLeft + " " + topLeft);
            numbersWith3Primes.add(number);
        }

//        System.out.println("   " + number + ": " + diff2Top + " " + diff2TopRight + " " + diff2LowerRight +
//                " " + diff2Below + " " + diff2LowerLeft + " " + diff2TopLeft + "  primes:" + countPrimes);
    }

    public static boolean[] isPrime(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= max; p++) {
            // p is a prime?
            if (isPrime[p]) {
                // then all multiples of p have p as one prime factor and are NO prime
                for (int i = p * 2; i <= max; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        //System.err.println(Arrays.toString(isPrime));

        // Print all prime numbers
//        for (int i = 2; i <= max; i++) {
//            if (isPrime[i]) {
//                System.err.print(i + " ");
//            }
//        }
//        System.err.print("\n");

        return isPrime;
    }
}
