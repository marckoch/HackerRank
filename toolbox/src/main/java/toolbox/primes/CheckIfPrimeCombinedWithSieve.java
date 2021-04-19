package toolbox.primes;

import java.util.TreeSet;

/**
 *
 * @author marckoch
 */
public class CheckIfPrimeCombinedWithSieve {

    public static boolean checkIfPrime(long x, TreeSet<Integer> smallPrimes) {
        for (int p : smallPrimes) {
            if (p < x && x % p == 0) {
                //System.err.println(x + "%" + p + "==0!");
                return false;
            }
        }
        
        for (long i = smallPrimes.last() + 2; i * i <= x; i += 2) {
            if (x % i == 0) {
                //System.err.println(x + "%" + i + "==0!");
                return false;
            }
        }

        //System.err.println(x + " is prime!");
        return true;
    }
    
    public static void main(String[] args) {
        final TreeSet<Integer> smallPrimes = GeneratePrimes.getPrimes(10000);
        
        System.out.println("checkIfPrime(17)=" + checkIfPrime(17, smallPrimes));
        System.out.println("checkIfPrime(1000)=" + checkIfPrime(1000, smallPrimes));
        System.out.println("checkIfPrime(1001)=" + checkIfPrime(1001, smallPrimes));
        System.out.println("checkIfPrime(1117)=" + checkIfPrime(1117, smallPrimes));
    }
}
