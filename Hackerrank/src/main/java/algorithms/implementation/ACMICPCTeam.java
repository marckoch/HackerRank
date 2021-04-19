package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class ACMICPCTeam {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int people = in.nextInt();
            int topics = in.nextInt();
            String ts = null;
            int[][] arr = new int[people][topics];
            for (int p = 0; p < people; p++) {
                ts = in.next();
                for (int t = 0; t < topics; t++) {
                    arr[p][t] = Character.getNumericValue(ts.charAt(t));
                }
            }

            solve(people, topics, arr);
        }
    }

    static void solve(int people, int topics, int[][] arr) {
        int maxNoOfTopics = 0;
        int maxNoOfTeams = 0;
        for (int p1 = 0; p1 < people; p1++) {
            for (int p2 = p1 + 1; p2 < people; p2++) {
                int topicSum = 0;
                for (int t = 0; t < topics; t++) {
                    topicSum += (arr[p1][t] | arr[p2][t]);
                }

                if (topicSum > maxNoOfTopics) {
                    maxNoOfTopics = topicSum;
                    maxNoOfTeams = 1;
                } else if (topicSum == maxNoOfTopics) {
                    maxNoOfTeams++;
                }
            }
        }
        System.out.println(maxNoOfTopics);
        System.out.println(maxNoOfTeams);
    }
}
