package hackerrank.projecteuler.from026to050;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Consecutive prime sum
 * @author marckoch
 */
public class PE050 {
    private static Set<Long> getPrimes(long maxPrime) {
        Set<Long> primes = new TreeSet<>();
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

        //System.err.println("generated " + primes.size() + " primes");
        return primes;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // read all testcases and determine maximaum N
        long maxN = 0;
        int T = in.nextInt();
        long[] testcase = new long[T];
        for (int t=0; t<T; t++) {
            long N = in.nextLong();
            maxN = Math.max(maxN, N);
            testcase[t]=N;
        }
            
        // initialize prime array once for all T testcases using the MAX N that fits for all testcases
        Set<Long> primes = getPrimes(maxN);
        Long[] primeArr = new Long[primes.size()];
        primeArr = primes.toArray(primeArr);

        //System.err.println("N=" + N + " primes.size()=" + primes.size() + " primeArr.length=" + primeArr.length);
        
        for (int t=0; t<T; t++) {
            long N = testcase[t];
            
            long maxPrime=0;
            int noOfSummandsOfMaxPrime=0;
            for (int i=0; i<primeArr.length; i++) {
                long p=primeArr[i];
                //System.err.println("p=" + p);
                
                // no need to check the rest we cannot find a new maximum
                // because all following primes are larger than p and we would
                // need at least noOfSummandsOfMaxPrime of them
                if (p + (noOfSummandsOfMaxPrime * p) > maxN) 
                    break;

                long sum=p;
                int countSummands=1;
                
                for (int j=i+1;j<primeArr.length; j++) {
                    long p2 = primeArr[j];
                    //System.err.println("  p2=" + p2);
                    sum += p2;
                    
                    if (sum>N) 
                        break;
                    
                    countSummands++;
                    if (primes.contains(sum)) {
                        if (countSummands > noOfSummandsOfMaxPrime) {
                            maxPrime = sum;
                            noOfSummandsOfMaxPrime = countSummands;
                        }
                    }
                }
            }
            System.out.println(maxPrime + " " + noOfSummandsOfMaxPrime);
        }
    }
}
