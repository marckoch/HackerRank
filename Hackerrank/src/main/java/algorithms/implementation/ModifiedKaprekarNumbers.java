package algorithms.implementation;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author marckoch
 */
public class ModifiedKaprekarNumbers {

    private static boolean isKaprekar(long i) {
        long sq = i * i;

        String s = String.valueOf(sq);
        long n = s.length();

        // make sure right part is 1 longer if n is odd
        long d = (n / 2) + (n % 2 != 0 ? 1 : 0);
        //System.err.println("  d=" + d);

        String leftPart = s.substring(0, (int) (n - d));
        //System.err.println("  leftPart=" + leftPart);
        long left = leftPart.isEmpty() ? 0 : Integer.valueOf(leftPart);

        String rightPart = s.substring((int) (n - d), (int) n);
        //System.err.println("  rightPart=" + rightPart);
        long right = rightPart.isEmpty() ? 0 : Integer.valueOf(rightPart);

        //System.err.println("  sum=" + (left + right));
        return (left + right) == i;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            long from = in.nextLong();
            long to = in.nextLong();

            solve(from, to);
        }
    }

    static void solve(long from, long to) {
        Set<Long> numbers = new TreeSet<>();
        for (long i = from; i <= to; i++) {
            if (isKaprekar(i)) {
                numbers.add(i);
            }
        }
        
        if (numbers.isEmpty()) {
            System.out.println("INVALID RANGE");
        } else {
            Iterator it = numbers.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());
                if (it.hasNext()) {
                    System.out.print(" ");
                }
            }
        }
    }
}
