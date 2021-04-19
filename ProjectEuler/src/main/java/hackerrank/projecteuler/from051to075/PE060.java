package hackerrank.projecteuler.from051to075;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import toolbox.primes.GeneratePrimes;

/**
 * Prime pair sets
 *
 * @author marckoch
 */
public class PE060 {

    private static final List<Integer> primesSum = new ArrayList<>();

    private static int[] primes;
    private static boolean[] isPrime;

    public static boolean[] isPrime(int max) {
        isPrime = new boolean[max + 1];
        for (int i = 0; i <= max; i++) {
            isPrime[i] = true;
        }

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
        System.err.println(isPrime.length);
        //System.err.println(Arrays.toString(isPrime));

        // Print all prime numbers
//        for (int i = 2; i <= max; i++) {
//            if (isPrime[i] == true) {
//                System.err.print(i + " ");
//            }
//        }
        return isPrime;
    }

    // merge two numbers, "append their digits"
    public static int merge(int a, int b) {
        // merge(12, 34) => 1234
        int shift = 10;
        while (shift <= b) {
            shift *= 10;
        }
        return a * shift + b;
    }

    static void processCombination(int[] data) {
//        for (int j = 0; j < data.length; j++) {
//            System.out.print(data[j] + " ");
//        }
//        System.out.println("");

        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] == 2 || data[i] == 5) {
                return;
            }
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] == 2 || data[j] == 5) {
                    return;
                }
                if (!isPrime[(int) merge(data[i], data[j])]) {
                    return;
                }
                if (!isPrime[(int) merge(data[j], data[i])]) {
                    return;
                }
            }
        }
        // System.err.println("OK!" + Arrays.toString(data));
        int count = 0;
        for (int i : data) {
            count += i;
        }
        primesSum.add(count);
    }

    /* 
    arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static void combinationUtil(int[] arr, int size, int index, int[] data, int i) {
        // Current combination is ready to be processed
        if (index == size) {
            processCombination(data);
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= arr.length) {
            return;
        }

        // current is included, put next at next location
        data[index] = arr[i];
        combinationUtil(arr, size, index + 1, data, i + 1);

        // current is excluded, replace it with next 
        // (Note that i+1 is passed, but index is not changed)
        combinationUtil(arr, size, index, data, i + 1);
    }

    // The main function that prints all combinations
    // of size r in arr[] of size n. This function 
    // mainly uses combinationUtil()
    static void generateCombinations(int arr[], int size) {
        // A temporary array to store all combination one by one
        int[] data = new int[size];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, size, 0, data, 0);
    }

    private static void solve(int N, int K) {
        isPrime(500_000_000);
        primes = GeneratePrimes.getPrimesArray(N);
        generateCombinations(primes, K);

        Collections.sort(primesSum);

        primesSum.forEach((item) -> {
            System.out.println(item);
        });
    }

    private static HashSet<Integer> makePairs(int a) {
        HashSet pairs = new HashSet();
        for (int b = a + 1; b < primes.length; b++) {
            if (isPrime2(merge(primes[a], primes[b])) && 
                isPrime2(merge(primes[b], primes[a]))) {
                pairs.add(primes[b]);
            }
        }
        //System.err.printf("makePairs(%s) %s pairs\n", a, pairs.size());
        return pairs;
    }

    private static void go() {
        int result = Integer.MAX_VALUE/20;
        //isPrime(result - 10);

        HashSet[] pairs = new HashSet[primes.length];

        for (int a = 1; a < primes.length; a++) {
            if (primes[a] * 5 >= result) {
                break;
            }
            if (pairs[a] == null) {
                pairs[a] = makePairs(a);
            }
            
            for (int b = a + 1; b < primes.length; b++) {
                //System.err.printf("%s %s\n", a, b);
                if (primes[a] + primes[b] * 4 >= result) {
                    break;
                }
                if (!pairs[a].contains(primes[b])) {
                    continue;
                }
                if (pairs[b] == null) {
                    pairs[b] = makePairs(b);
                }

                for (int c = b + 1; c < primes.length; c++) {
                    //System.err.printf("%s %s %s\n", a, b, c);
                    if (primes[a] + primes[b] + primes[c] * 3 >= result) {
                        //System.err.printf("%s %s %s exceeds result\n", a, b, c);
                        break;
                    }
                    if (!pairs[a].contains(primes[c])
                            || !pairs[b].contains(primes[c])) {
                        continue;
                    }
                    if (pairs[c] == null) {
                        pairs[c] = makePairs(c);
                    }

                    for (int d = c + 1; d < primes.length; d++) {
                        //System.err.printf("%s %s %s %s\n", a, b, c, d);
                        if (primes[a] + primes[b] + primes[c] + primes[d] * 2 >= result) {
                            //System.err.printf("%s %s %s %s exceeds result\n", a, b, c, d);
                            break;
                        }
                        if (!pairs[a].contains(primes[d])
                                || !pairs[b].contains(primes[d])
                                || !pairs[c].contains(primes[d])) {
                            continue;
                        }
                        if (pairs[d] == null) {
                            pairs[d] = makePairs(d);
                        }

                        for (int e = d + 1; e < primes.length; e++) {
                            //System.err.printf("%s %s %s %s %s\n", a, b, c, d, e);
                            if (primes[a] + primes[b] + primes[c] + primes[d] + primes[e] >= result) {
                                //System.err.printf("%s %s %s %s %s exceeds result\n", a, b, c, d, e);
                                break;
                            }
                            if (!pairs[a].contains(primes[e])
                                    || !pairs[b].contains(primes[e])
                                    || !pairs[c].contains(primes[e])
                                    || !pairs[d].contains(primes[e])) {
                                continue;
                            }

                            if (result > primes[a] + primes[b] + primes[c] + primes[d] + primes[e]) {
                                result = primes[a] + primes[b] + primes[c] + primes[d] + primes[e];
                            }

                            //System.err.println("huhu!");
                            System.out.printf("%s + %s + %s + %s + %s = %s\n", primes[a], primes[b], primes[c], primes[d], primes[e], result);
                            break;
                        }
                    }
                }
            }
        }
    }

    private static boolean isPrime2(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        if (n < 9) {
            return true;
        }
        if (n % 3 == 0) {
            return false;
        }
        if (n % 5 == 0) {
            return false;
        }

        int[] ar = new int[]{2, 3};
        for (int i = 0; i < ar.length; i++) {
            if (witness(ar[i], n)) {
                return false;
            }
        }
        return true;
    }

    private static boolean witness(int a, int n) {
        int t = 0;
        int u = n - 1;
        while ((u & 1) == 0) {
            t++;
            u >>= 1;
        }

        long xi1 = modularExp(a, u, n);
        long xi2;

        for (int i = 0; i < t; i++) {
            xi2 = xi1 * xi1 % n;
            if ((xi2 == 1) && (xi1 != 1) && (xi1 != (n - 1))) {
                return true;
            }
            xi1 = xi2;
        }
        if (xi1 != 1) {
            return true;
        }
        return false;
    }

    private static long modularExp(int a, int b, int n) {
        long d = 1;
        int k = 0;
        while ((b >> k) > 0) {
            k++;
        }

        for (int i = k - 1; i >= 0; i--) {
            d = d * d % n;
            if (((b >> i) & 1) > 0) {
                d = d * a % n;
            }
        }

        return d;
    }

    public static void test(String[] args) {
        solve(1000, 3);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
//        int K = in.nextInt();
//
//        solve(N, K);
        primes = GeneratePrimes.getNPrimes(N);
        go();
    }
}
