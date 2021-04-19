package algorithms.strings;

import java.util.Scanner;

/**
 * TODO UNFINISHED !!
 *
 * @author marckoch
 */
public class DeterminingDNAHealth {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            String[] genes = new String[N];
            for (int i = 0; i < N; i++) {
                genes[i] = in.next();
            }
            int[] health = new int[N];
            for (int i = 0; i < N; i++) {
                health[i] = in.nextInt();
            }
            int s = in.nextInt();

            long min = Long.MAX_VALUE;
            long max = 0;

            while (s-- > 0) {
                int first = in.nextInt();
                int last = in.nextInt();
                String d = in.next();

                long sum = 0;
                for (int pos = first; pos <= last; pos++) {
                    //System.err.println(first + " " + last);
                    //System.err.println(genes[pos]);

                    int ix = -1;
                    while ((ix = d.indexOf(genes[pos], ix + 1)) >= 0) {
                        //System.err.printf("gene %s found at %s\n", genes[pos], ix);
                        sum += health[pos];
                    }
                }

                min = Math.min(min, sum);
                max = Math.max(max, sum);
            }

            System.out.println(min + " " + max);
        }
    }
}
