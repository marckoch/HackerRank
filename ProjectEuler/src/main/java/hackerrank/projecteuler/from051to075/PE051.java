package hackerrank.projecteuler.from051to075;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import toolbox.digits.CountDigits;

/**
 * Prime digit replacements
 *
 * @author marckoch
 */
public class PE051 {
    final static List<Integer> generatedPrimes = new ArrayList<>();
    static boolean[] isPrime;

    public static boolean[] isPrime(int max) {
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 0; i <= max; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= max; p++) {
            // p is a prime?
            if (isPrime[p]) {
                // then all multiples of p have p as one prime factor and are NO prime
                for (int i = p*2; i <= max; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        //System.err.println(Arrays.toString(isPrime));

        // Print all prime numbers
        for (int i = 2; i <= max; i++) {
            if (isPrime[i] == true) {
                System.err.print(i + " ");
            }
        }

        return isPrime;
    }
    
    /* 
    arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static void combinationUtil(int x, int[] arr, int r, int index, 
            int[] data, int i, int L) {
        
        if (generatedPrimes.size() == L) 
            return;
        
        // Current combination is ready to be processed
        if (index == r) {
            processCombination(x, data, L);
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= arr.length) {
            return;
        }

        // current is included, put next at next location
        data[index] = arr[i];
        combinationUtil(x, arr, r, index + 1, data, i + 1, L);

        // current is excluded, replace it with next (Note that
        // i+1 is passed, but index is not changed)
        combinationUtil(x, arr, r, index, data, i + 1, L);
    }
    
    static void processCombination(long initialNumber, int[] data, int L) {
        //System.err.println(Arrays.toString(data));

        // valid means: initialNumber is part of the generated numbers
        boolean valid=false;
        
        for (int i=0; i<10; i++) {
            int[] digits = digits(initialNumber);
            for (int x=0; x<data.length; x++) {
                digits[data[x]] = i;
            }
            // new number must not start with 0!
            if (digits[0]==0) 
                continue;

            int newNumber = (int) toLong(digits);
            if (newNumber == initialNumber) 
                valid=true;
            
            if (isPrime[newNumber]) {
                //System.err.println(newNumber + " is prime!");
                generatedPrimes.add(newNumber);
                
                if (generatedPrimes.size() >=L && valid) {
                    //System.err.printf("%s produces %s primes!\n", initialNumber, L);
                    return;
                }
            }
        }
        
        // we did not find a solution, so we clean up
        if (generatedPrimes.size() < L || !valid)
            generatedPrimes.clear();
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void generateCombinations(int x, int arr[], int r, int L) {
        // A temporary array to store all combination one by one
        int data[] = new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(x, arr, r, 0, data, 0, L);
    }

    public static void solve(int N, int K, int L) {
        int start = (int) Math.pow(10, N - 1);
        int end = start * 10 - 1;

        System.err.println(start + " " + end);

        isPrime = isPrime(end);
        
        int[] indexes = new int[N];
        for (int i=0; i<N; i++) {
            indexes[i]=N-i-1;
        }
        //System.err.println("indexe=" + Arrays.toString(indexes));

        for (int x = start; x <= end; x++) {
            if (isPrime[x]) {
                System.err.println("-- checking prime " + x);
                
                generateCombinations(x, indexes, K, L);
                
                if (generatedPrimes.size() == L) {
                    generatedPrimes.forEach((t) -> {
                        System.out.print(t + " ");
                    });
                    return;
                }
            }
        }
    }
    
    private static int[] digits(long i) {
        int cd = CountDigits.countDigits(i);
        int[] result = new int[cd];
        int index=0;
        while (i > 0) {
            int lastDigit = (int) i % 10;
            result[cd - 1 - index++] = lastDigit;
            i /= 10;
        }
        return result;
    }

    private static long toLong(int[] digits) {
        long result = 0L;
        for (int i=0; i<digits.length; i++) {
            result += digits[i];
            if (i<digits.length-1) 
                result *= 10;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int L = in.nextInt();

        solve(N, K, L);
    }
}
