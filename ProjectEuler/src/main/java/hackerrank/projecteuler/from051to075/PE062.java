package hackerrank.projecteuler.from051to075;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Cubic permutations
 * @author marckoch
 */
public class PE062 {
    private static String digitsSorted(BigInteger bi) {
        char[] digits = bi.toString().toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        
        Map<String, Integer> countOfPermutations = new HashMap<>();
        Map<String, BigInteger> smallestPermutation = new HashMap<>();
        
        for (int n=1; n<N; n++) {
            BigInteger result = BigInteger.valueOf(n).pow(3);
            
            String digitFreq = digitsSorted(result);
            
            if (!countOfPermutations.containsKey(digitFreq)) {
                countOfPermutations.put(digitFreq, 1);
                smallestPermutation.put(digitFreq, result);
            } else {
                countOfPermutations.put(digitFreq, countOfPermutations.get(digitFreq) + 1);
            }
        }
        
        // System.err.println(countOfPermutations);
        // System.err.println(smallestPermutation);
        
        Set<BigInteger> smallestNumbers = new TreeSet<>();
        for (Map.Entry<String, Integer> me : countOfPermutations.entrySet()) {
            if (me.getValue() == K) {
                smallestNumbers.add(smallestPermutation.get(me.getKey()));
            }
        }
        for (BigInteger bi : smallestNumbers) {
            System.out.println(bi);
        }
    }
}
