package worldscodesprint12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class BreakingSticks {

    static long longestSequence(long[] a) {
        //  Return the length of the longest possible sequence of moves.
        long moves = 0L;
        for (int i = 0; i < a.length; i++) {
            moves += getMoves(a[i]);
        }
        return moves;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            long result = longestSequence(a);
            System.out.println(result);
        }
    }

    private static long getMoves(long n) {
        long origN=n;
        List<Long> primes = new ArrayList<>();

        for (long d = 2; d * d <= n; d++) {
            while (n % d == 0) {
                primes.add(d);
                n /= d;
            }
        }

        if (n > 1) {
            primes.add(n);
        }

        //System.err.println(primes);
        primes.sort((o1, o2) -> {
            return -Long.compare(o1,o2);
        });
        //System.err.println(primes);        
        
        long answer = 1;
        long curr = 1;

        for (long p : primes) {
            curr *= p;
            answer += curr;
        }
        System.err.println(String.format("getMoves(%s)=%s", origN, answer));
        return answer;
    }
}
