package hackerrank.projecteuler.from026to050;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Prime permutations
 * @author marckoch
 */
public class PE049 {
    private static long[] digitFrequency;
    
    private static long digitFrequency(long x) {
        long result = 0;
        while (x > 0) {
            long digit = x % 10;

            int pos = 1;
            for (int i = 1; i <= digit; i++) {
                pos *= 10;
            }
            result += pos;

            x /= 10;
        }
        return result;
    }
    
    private static Set<Integer> getPrimes(int maxPrime) {
        Set<Integer> primes = new TreeSet<>();
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
        return primes;
    }
    
    private static boolean isPermutation(int a, int b) {
        return digitFrequency[a] == digitFrequency[b];
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        
        int noOfDigits = String.valueOf(N).length();
        int limit = (int)Math.pow(10, noOfDigits);
        //System.err.println(N + " " + noOfDigits + " " + limit);
        
        Set<Integer> primes = getPrimes(limit);
        
        digitFrequency = new long[limit];
        Map<Long, Integer> freq = new HashMap<>();

        for (int p : primes) {
            digitFrequency[p] = digitFrequency(p);
            if (freq.get(digitFrequency[p])==null) {
                freq.put(digitFrequency[p], 1);    
            } else {
                freq.put(digitFrequency[p], freq.get(digitFrequency[p]) + 1);    
            }                

        }
        //System.err.println(freq);
        
        for (int p : primes) {
            if (p>N) 
                break;
                        
            if (freq.get(digitFrequency[p])==null || freq.get(digitFrequency[p]) < K) 
                continue;
            
            if (K==3) {
                for (int diff=9; p+2*diff<limit; diff+=9) {
                    if (isPermutation(p, p+diff) &&
                        isPermutation(p, p+2*diff) &&
                        primes.contains(p+diff) && 
                        primes.contains(p+2*diff) ) {
                        //System.err.println("" + p + " " + (p+diff) + " " + (p+2*diff));
                        System.out.println("" + p + (p+diff) + (p+2*diff));
                    }
                }
            } else if (K==4) {
                for (int diff=9; p+3*diff<limit; diff+=9) {
                    if (isPermutation(p, p+diff) &&
                        isPermutation(p, p+2*diff) &&
                        isPermutation(p, p+3*diff) &&
                        primes.contains(p+diff) && 
                        primes.contains(p+2*diff) &&
                        primes.contains(p+3*diff) ) {
                        //System.err.println("" + p1 + " " + (p+diff) + " " + (p+2*diff) + " " + (p+3*diff));
                        System.out.println("" + p + (p+diff) + (p+2*diff) + (p+3*diff));
                    }
                }
            }

        }
        //System.err.println("done");
    }
}
