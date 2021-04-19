package toolbox.modulo;

/**
 * https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/
 */
public class ModuloInverse {

    // Function to find modular inverse of a under modulo m
    // Assumption: m is prime
    public static long modInverse(int a, int mod) {
        int g = gcd(a, mod);
        if (g != 1) {
            System.err.println("Inverse doesn't exist");
            return 0;
        } else {
            // If a and m are relatively prime, then modulo inverse
            // is a^(m-2) mode m
            return power(a, mod - 2, mod);
        }
    }

    // To compute x^y under modulo m
    static long power(int x, int y, int mod) {
        if (y == 0) {
            return 1;
        }
        long p = power(x, y / 2, mod) % mod;
        p = (p * p) % mod;

        return (y % 2 == 0) ? p : (x * p) % mod;
    }

    // Function to return gcd of a and b
    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        int a = 3, m = 11;
        System.out.printf("%s * %s == %s == %s mod %s\n", a, modInverse(a, m), (a * modInverse(a, m)), (a * modInverse(a, m)) % m, m);

        a = 7;
        System.out.printf("%s * %s == %s == %s mod %s\n", a, modInverse(a, m), (a * modInverse(a, m)), (a * modInverse(a, m)) % m, m);

        a = 17;
        System.out.printf("%s * %s == %s == %s mod %s\n", a, modInverse(a, m), (a * modInverse(a, m)), (a * modInverse(a, m)) % m, m);

        a = 100;
        m = (int) Math.pow(10, 9) + 7;
        System.out.printf("%s * %s == %s == %s mod %s\n", a, modInverse(a, m), (a * modInverse(a, m)), (a * modInverse(a, m)) % m, m);
    }
}
