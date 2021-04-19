package hackerrank.projecteuler.from101to125;

import toolbox.permutations.BuildIntPermutations;
import toolbox.permutations.Combinations;
import toolbox.primes.CheckIfPrime;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PE111 {

    public static void solveProjectEuler() {
        //solveNumberOfDigits1(5);
        solveNumberOfDigits2(9);

        //solveForDigit(0, 2, 4);
    }

    public static void main(String[] args) {
        solveProjectEuler();
        //solveHackerrank();
    }

    // variante 1: generate primes first and then analyse and count primes
    // will not work for 10 digits numbers because we cannot generate primes that high
    // (because we use arrays and array index can only be int, which is too small for 10 digit numbers)
    private static void solveNumberOfDigits1(int numberOfDigits) {
        // smallest number with 'numberOfDigits' digits (numberOfDigits minus 1 is the number of zeros after '1')
        // numberOfDigits=4 -> 1000
        double minD = Math.pow(10, numberOfDigits - 1);
        long min = Double.valueOf(minD).longValue();

        // smallest number with 'numberOfDigits' digits plus 1 (numberOfDigits is the number of zeros after '1')
        // numberOfDigits=4 -> 10000
        // this will be our upper limit (exclusive): if numberOfDigits==3 we go from 100 <= x < 1000
        double maxD = Math.pow(10, numberOfDigits);
        long max = Double.valueOf(maxD).longValue();

        System.out.println("finding primes from " + min + " to " + max);

        //long[] primes = getPrimes(min, max);
        long[] primes = primesInRange(min, max);

        // for each prime we determine the digit frequency, e.g.
        // 101 -> [1, 2, 0, 0, 0, 0, 0, 0, 0, 0]   1 zero, 2 ones, other digits do not occur
        Map<Long, int[]> digitFrequency = Arrays.stream(primes)
                .boxed()
                .collect(Collectors.toMap(l -> l, PE111::digitFrequency));

        long totalSum = 0;
        for (int d = 0; d < 10; d++) {
            int maxForDigit = getM(digitFrequency, d);
            List<Long> n = getN(digitFrequency, d, maxForDigit);
            //System.out.println(n);
            long sum = n.stream().mapToLong(x -> x).sum();

            System.out.println(d + "\t" + maxForDigit + "\t" + n.size() + "\t" + sum);

            totalSum += sum;
        }
        System.out.println(totalSum);
    }

    // here we parse digit frequency array of all primes the find the maximum count for the given digit
    private static int getM(Map<Long, int[]> digitFrequency, int digit) {
        return digitFrequency.values().stream()
                .mapToInt(value -> value[digit])
                .max().orElse(0);
    }

    // here we find all primes that have the occurec of given digit at their maximum
    private static List<Long> getN(Map<Long, int[]> digitFrequency, int digit, int maxForDigit) {
        return digitFrequency.entrySet().stream()
                .filter(longEntry -> longEntry.getValue()[digit] == maxForDigit) // only entrys with maximum
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }

    public static long[] getPrimesArray(long maxPrime) {
        TreeSet<Long> primes = new TreeSet<>();
        primes.add(2L);
        for (long i = 3; i <= maxPrime; i += 2) {
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
                primes.add(i);
            }
        }

        System.err.println("generated " + primes.size() + " primes");

        return primes.stream().mapToLong(x -> x).toArray();
    }

    private static int[] digitFrequency(long number) {
        int[] result = new int[10];
        for (char c : Long.valueOf(number).toString().toCharArray()) {
            result[Character.getNumericValue(c)]++;
        }
        //System.err.println(number + " -> " + Arrays.toString(result));
        return result;
    }

    private static long[] getPrimes(long min, long max) {
        // this will get all primes from 1 to max
        long[] allPrimes = getPrimesArray(max);

        // but we don't need the primes < min
        long[] primes = Arrays.stream(allPrimes).filter(x -> x >= min).toArray();
        //System.out.println(Arrays.toString(primes));

        return primes;
    }


    // https://www.geeksforgeeks.org/segmented-sieve-print-primes-in-a-range/

    private static List<Integer> simpleSieve(int limit) {
        List<Integer> prime = new ArrayList<>();

        boolean[] mark = new boolean[limit + 1];

        for (int i = 2; i <= limit; ++i) {
            if (!mark[i]) {
                // If not marked yet, then its a prime
                prime.add(i);
                for (int j = i; j <= limit; j += i)
                    mark[j] = true;
            }
        }
        return prime;
    }

    // Finds all prime numbers in given range using segmented sieve
    private static long[] primesInRange(long low, long high) {
        System.out.println("finding primes from " + low + " to " + high);

        // Compute all primes smaller or equal to square root of high using simple sieve
        int limit = Double.valueOf(Math.floor(Math.sqrt(high)) + 1).intValue();
        List<Integer> prime = simpleSieve(limit);
        System.out.println("found " + prime.size() + " initial primes from sieve");

        System.out.println("high - low " + (high - low));
        if ((high - low) > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("will not work because we leave integer range!");
        }

        // Count of elements in given range
        int n = (int) (high - low + 1);

        // Declaring boolean only for [low, high]
        boolean[] mark = new boolean[n + 1];

        // Use the found primes by simpleSieve() to find primes in given range
        for (int i = 0; i < prime.size(); i++) {
            // Find the minimum number in [low..high] that is
            // a multiple of prime[i] (divisible by prime[i])
            int loLim = Double.valueOf(Math.floor(low / prime.get(i)) * prime.get(i)).intValue();
            if (loLim < low)
                loLim += prime.get(i);
            if (loLim == prime.get(i))
                loLim += prime.get(i);

            /*  Mark multiples of prime[i] in [low..high]:
            We are marking j - low for j, i.e. each number
            in range [low, high] is mapped to [0, high - low]
            so if range is [50, 100]  marking 50 corresponds
            to marking 0, marking 51 corresponds to 1 and
            so on. In this way we need to allocate space only
            for range  */
            for (int j = loLim; j <= high; j += prime.get(i))
                mark[(int) (j - low)] = true;
        }

        // Numbers which are not marked in range, are prime
        List<Long> resultPrimes = new ArrayList<>();
        for (long i = low; i <= high; i++) {
            if (!mark[(int) (i - low)]) {
                resultPrimes.add(i);
            }
        }
        return resultPrimes.stream().mapToLong(x -> x).toArray();
    }

    // variante 2: we generate numbers and check if they are prime
    private static void solveNumberOfDigits2(int numberOfDigits) {
        long totalSum = 0;
        for (int d = 0; d < 10; d++) {
            for (int repeat = numberOfDigits - 1; repeat >= 1 ; repeat--) {
                long sum = solveForDigit(d, repeat, numberOfDigits);
                if (sum >0) {
                    // we found primes!
                    System.out.println(d + "\t" + sum);
                    totalSum += sum;
                    break;
                }
            }
        }
        System.out.println(totalSum);
    }

    private static long solveForDigit(int digit, int repeat, int numberOfDigits) {
        int countOccurenceOfOtherDigits = numberOfDigits - repeat;

        System.out.println(String.format("checking %s digits: %s %ss and %s other digits (!=%s)", numberOfDigits, repeat, digit, countOccurenceOfOtherDigits, digit));

        int[] otherdigits = IntStream.rangeClosed(0, 9).filter(x -> x != digit).toArray();
        //System.out.println(Arrays.toString(otherdigits));

        // we need distinct combinations here, that means [1,3] is same as [3,1] and will only be given once as [1,3]
        List<String> otherDigitCombis = Combinations.generateDistinctCombinationsWithRep(otherdigits, countOccurenceOfOtherDigits);
        //System.out.println(otherDigitCombis);
        int[][] otherNumbers = otherDigitCombis.stream().map(PE111::toIntArray).toArray(int[][]::new);
        //Arrays.stream(otherNumbers).forEach(o -> System.out.println(Arrays.toString(o)));

        long sum = 0;

        for (int[] o : otherNumbers) {

            int[] allDigits = buildNumber(o, digit, numberOfDigits);
            System.out.println(">>" + Arrays.toString(allDigits));

            List<String> distinctPermutations = BuildIntPermutations.generatePermutationsAsStr(allDigits)
                    .stream()
                    .distinct()
                    .filter(s -> !s.startsWith("0"))
                    .filter(s -> !(s.endsWith("2") || s.endsWith("5") || s.endsWith("0")))
                    .sorted()
                    .collect(Collectors.toList());
            //System.out.println(distinctPermutations);

            for (String n : distinctPermutations) {
                if (n.charAt(0) == '0') continue;
                if (n.endsWith("2") || n.endsWith("5") || n.endsWith("0")) continue;

                long nAsLong = Long.parseLong(n);
                boolean isPrime = CheckIfPrime.isPrime(nAsLong);
                if (isPrime) {
                    sum += nAsLong;
                    System.out.println(nAsLong + " is prime! " + n);
                }
            }
        }

        return sum;
    }

    private static int[] buildNumber(int[] otherNumber, int digit, int numberOfDigits) {
        int[] allDigits = new int[numberOfDigits];
        Arrays.fill(allDigits, digit);
        System.arraycopy(otherNumber, 0, allDigits, 0, otherNumber.length);
        return allDigits;
    }

    // input string with only numbers, like "23432"
    // returns int[] with the numbers, e.g. [2,3,4,3,2]
    private static int[] toIntArray(String stringWithNumbers) {
        return Arrays.stream(stringWithNumbers.split(""))
                .map(Integer::parseInt)
                .mapToInt(x -> x)
                .toArray();
    }

}
