package algorithms.implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class ExtraLongFactorials {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            BigInteger fact = BigInteger.ONE;
            for (int i = n; i > 1; i--) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            System.out.println(fact);
        }
    }
}
