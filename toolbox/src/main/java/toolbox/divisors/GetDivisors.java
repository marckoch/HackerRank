package toolbox.divisors;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author marckoch
 */
public class GetDivisors {
    public static Set<Integer> getDivisors(int n) {
        Set<Integer> divisors = new TreeSet<>();
        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                divisors.add(d);
                divisors.add(n / d);
            }
        }
        return divisors;
    }

    public static void main(String[] args) {
        System.out.println("getSumOfDivisors(10000)=" + getDivisors(10000));
        System.out.println("getSumOfDivisors(300)=" + getDivisors(300));
        System.out.println("getSumOfDivisors(300)=" + getDivisors(16));
    }
}
