package algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class NonDivisibleSubset {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int K = in.nextInt();

            Map<Integer, Integer> modFreq = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int n = in.nextInt();
                int div = n / K;
                int rest = n % K;
                //System.err.println(n + " / " + K + " = " + div + " R " + rest);
                if (!modFreq.containsKey(rest)) {
                    modFreq.put(rest, 0);
                }
                modFreq.put(rest, modFreq.get(rest) + 1);
            }

            //System.err.println(modFreq);
            // from numbers with remainder 0 we can choose at most one
            int max = modFreq.containsKey(0) ? 1 : 0;

            // if K is even (e.g. 6), from numbers with remainder K/2 we can choose at most one
            if (K % 2 == 0) {
                max += modFreq.containsKey(K / 2) ? 1 : 0;
            }

            // for each pair of i and j(==K-i) choose that which has the most frequent values
            for (int i = 1; i <= K / 2 && i < K - i; i++) {
                int freq_i = modFreq.containsKey(i) ? modFreq.get(i) : 0;
                //System.err.println(i + " " + freq_i);

                int freq_j = modFreq.containsKey(K - i) ? modFreq.get(K - i) : 0;
                //System.err.println((K-i) + " " + freq_j);

                max += Math.max(freq_i, freq_j);
            }
            System.out.println(max);
        }

    }
}
