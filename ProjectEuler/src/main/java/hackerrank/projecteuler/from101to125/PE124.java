package hackerrank.projecteuler.from101to125;

import toolbox.primes.GetPrimeFactors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PE124 {

    public static long getRadical(long n) {
        List<Long> primeFactorsOptimized = GetPrimeFactors.getPrimeFactorsOptimized(n);
        return primeFactorsOptimized.stream().distinct().reduce(1L, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        List<long[]> collect = IntStream.rangeClosed(1, 100_000)
                .mapToObj(i -> new long[]{i, getRadical(i)})
                .sorted(PE124::compareE)
                .collect(Collectors.toList());
        collect.forEach(longs -> System.out.println(Arrays.toString(longs)));
        System.out.println(Arrays.toString(collect.get(10000 - 1))); // 0 is 1, etc... ;-)
    }

    public static int compareE(long[] a, long[] b) {
        int x = Long.compare(a[1], b[1]);
        if (x != 0) return x;
        return Long.compare(a[0], b[0]);
    }
}
