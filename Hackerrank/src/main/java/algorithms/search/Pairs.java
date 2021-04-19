package algorithms.search;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author marckoch
 */
public class Pairs {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int K = in.nextInt();
            Set<Integer> A = new HashSet<>();
            Set<Integer> B = new HashSet<>();
            for (int i = 0; i < N; i++) {
                int j = in.nextInt();
                A.add(j);
                B.add(j + K);
            }
            System.err.println(A);
            System.err.println(B);
            A.retainAll(B);
            System.out.println(A.size());
        }
    }
}
