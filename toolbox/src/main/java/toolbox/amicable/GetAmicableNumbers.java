package toolbox.amicable;

import java.util.Set;
import java.util.TreeSet;
import toolbox.divisors.SumOfDivisors;

/**
 *
 * @author marckoch
 */
public class GetAmicableNumbers {

    // two numbers a and b are amicable if
    //   sumOfDivisors(a) == b && sumOfDivisors(b) == a
    // e.g. 
    //   sumOfDivisors(220) = 1 + 2 + 4 + 5 + 10 + 11 + 20 + 22 + 44 + 55 + 110 = 284
    //   sumOfDivisors(284) = 1 + 2 + 4 + 71 142 = 220
    private static Set<Integer> buildListOfAmicable(int maxN) {
        Set<Integer> amicable = new TreeSet<>();
        for (int i = 1; i <= maxN; i++) {
            int j = SumOfDivisors.getSumOfDivisors(i);
            if (j != i && SumOfDivisors.getSumOfDivisors(j) == i) {
                amicable.add(i);
                amicable.add(j);
            }
        }
        return amicable;
    }

    public static void main(String[] args) {
        System.out.println("buildListOfAmicable(10000)=" + buildListOfAmicable(10_000));
        System.out.println(buildListOfAmicable(10_000).stream().mapToInt(i -> i).sum());
    }
}
