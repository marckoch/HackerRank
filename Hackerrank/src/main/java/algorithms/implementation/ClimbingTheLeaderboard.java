package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author marckoch
 */
public class ClimbingTheLeaderboard {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            Integer[] scores = new Integer[n];
            Set<Integer> uniqueScores = new TreeSet<>((Integer i1, Integer i2) -> i2 - i1);

            for (int i = 0; i < n; i++) {
                scores[i] = in.nextInt();
                uniqueScores.add(scores[i]);
            }

            int m = in.nextInt();
            Integer[] alice = new Integer[m];
            for (int i = 0; i < m; i++) {
                alice[i] = in.nextInt();
            }

            System.err.println(Arrays.toString(scores));
            System.err.println(uniqueScores);

            Integer[] uniqSorArr = uniqueScores.toArray(new Integer[uniqueScores.size()]);
            for (int i = 0; i < m; i++) {
                int rankAlice = Arrays.binarySearch(uniqSorArr, alice[i], (Integer i1, Integer i2) -> i2 - i1);
                System.out.println(rankAlice < 0 ? -rankAlice : rankAlice + 1);

            }
        }
    }
}
