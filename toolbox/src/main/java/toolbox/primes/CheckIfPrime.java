package toolbox.primes;

/**
 * @author marckoch
 */
public class CheckIfPrime {

    public static boolean checkIfPrime(long x) {
        if (x == 2) return true;
        if (x % 2 == 0) {
            return false;
        }
        for (long i = 3; i * i <= x; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("checkIfPrime(1000)=" + checkIfPrime(1000));
        System.out.println("checkIfPrime(1001)=" + checkIfPrime(1001));
        System.out.println("checkIfPrime(1117)=" + checkIfPrime(1117));

        System.out.println("isPrime(1000)=" + isPrime(1000));
        System.out.println("isPrime(1001)=" + isPrime(1001));
        System.out.println("isPrime(1117)=" + isPrime(1117));

        System.out.println("isPrime(Integer.MAX_VALUE)=" + isPrime(Integer.MAX_VALUE));
        System.out.println("isPrime(Long.MAX_VALUE)=" + isPrime(Long.MAX_VALUE));
    }
}
