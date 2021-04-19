package toolbox.gcd;

/**
 *
 * @author marckoch
 */
public class GreatestCommonDivisor {

    public static long gcd(long a, long b) {
        while (a != 0) {
            long c = a;
            a = b % a;
            b = c;
        }
        return b;
    }

    private static long gcdRecursive(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("gcd(20,10)=" + gcd(20, 10));
        System.out.println("gcd(21,10)=" + gcd(21, 10));
    }
}
