package algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class LuckBalance {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int K = in.nextInt();

            List<Integer> important = new ArrayList<>();

            int sum = 0;
            for (int i = 0; i < N; i++) {
                int L = in.nextInt();
                int T = in.nextInt();

                if (T > 0) {
                    important.add(L);
                }
                sum += L;
            }

            Collections.sort(important);

            for (int i = 0; i < important.size() - K; i++) {
                sum -= 2 * important.get(i);
            }

            System.out.println(sum);
        }
    }
}
