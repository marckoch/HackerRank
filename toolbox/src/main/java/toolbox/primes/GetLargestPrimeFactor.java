package toolbox.primes;

public class GetLargestPrimeFactor {

    public static long getLargestPrimeFactor(long n) {
        long max = 0;
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                max = i;
                n /= i;
            }
            if (n == 1) {
                return max;
            }
        }
        if (n > 1) {
            return n;
        }
        return max;
    }

    // https://www.geeksforgeeks.org/java-program-for-find-largest-prime-factor-of-a-number/
    // function to find largest prime factor
    static long maxPrimeFactors(long n) {
        // Initialize the maximum prime factor variable with the lowest one
        long maxPrime = -1;

        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            maxPrime = 2;

            // equivalent to n /= 2
            n >>= 1;
        }

        // n must be odd at this point, thus skip the even numbers
        // and iterate only for odd integers
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n = n / i;
            }
        }

        // This condition is to handle
        // the case when n is a prime
        // number greater than 2
        if (n > 2)
            maxPrime = n;

        return maxPrime;

    }

    public static void main (String[]args){
            System.out.println("getLargestPrimeFactor(100)=" + getLargestPrimeFactor(100));
            System.out.println("getLargestPrimeFactor(101)=" + getLargestPrimeFactor(101));
            System.out.println("getLargestPrimeFactor(101)=" + getLargestPrimeFactor(25698751364526L));
            System.out.println("getLargestPrimeFactor(101)=" + maxPrimeFactors(25698751364526L));
        }
    }
