package toolbox.primes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author marckoch
 */
public class GetPrimeFactors {

    public static List<Long> getPrimeFactors(long number) {
        long n = number;
        List<Long> factors = new ArrayList<>();
        // i makes steps: 2,3,4,5,6,7,8,9,... which is suboptimal, iterating over primes would be better
        for (long i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

    public static List<Long> getPrimeFactorsOptimized(long number) {
        long n = number;
        List<Long> factors = new ArrayList<>();
        // i makes steps: 2, 3, 5, 7, 9, 11, ...
        for (long i = 2; i <= n / i; i+= (i==2 ? 1 : 2)) {
            System.out.println("i=" + i);
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        //System.err.println(number + " " + factors);
        return factors;
    }
        
    public static Set<Long> getDistinctPrimeFactors(long number) {
        return new TreeSet<>(getPrimeFactors(number));
    }

    public static Map<Long, Long> getFrequencysOfPrimeFactors(long number) {
        final List<Long> factors = getPrimeFactors(number);

        final Map<Long, Long> freq = new TreeMap<>();
        for (int j = 0; j < factors.size(); j++) {
            long f = factors.get(j);
            if (!freq.containsKey(f)) {
                freq.put(f, 1L);
            } else {
                freq.put(f, freq.get(f) + 1);
            }
        }
        return freq;
    }

    public static void main(String[] args) {
//        System.out.println("getPrimeFactors(46)=" + getPrimeFactors(46));
//        System.out.println("getPrimeFactors(100)=" + getPrimeFactors(100));
//        System.out.println("getDistinctPrimeFactors(100)=" + getDistinctPrimeFactors(100));
        
//        System.out.println("getDistinctPrimeFactors(17)=" + getDistinctPrimeFactors(17));

//        System.out.println("getPrimeFactors(10000)=" + getPrimeFactors(10000));
        System.out.println("getPrimeFactorsOptimized(10000)=" + getPrimeFactorsOptimized(100001));

//        System.out.println("getPrimeFactors(101010000)=" + getPrimeFactors(101010000));
//        System.out.println("getFrequencysOfPrimeFactors(101010000)=" + getFrequencysOfPrimeFactors(101010000));

//        System.out.println("getPrimeFactors(101010010)=" + getPrimeFactors(101010010));
//        System.out.println("getFrequencysOfPrimeFactors(101010010)=" + getFrequencysOfPrimeFactors(101010010));
    }
}
