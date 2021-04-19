package toolbox.radical;

import toolbox.primes.GetPrimeFactors;

import java.util.List;

public class Radical {

    public static long getRadical(long n) {
        List<Long> primeFactorsOptimized = GetPrimeFactors.getPrimeFactorsOptimized(n);
        return primeFactorsOptimized.stream().distinct().reduce(1L, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        System.out.println(getRadical(504));

        for (int i = 1; i < 11; i++) {
            System.out.println(i + " " + getRadical(i));
        }
    }
}
