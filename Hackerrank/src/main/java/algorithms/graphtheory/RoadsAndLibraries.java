package algorithms.graphtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class RoadsAndLibraries {

    private static ArrayList<Integer>[] cities;
    private static boolean[] visited;

    // depth first search
    private static int dfs(int startCity) {
        if (visited[startCity]) {
            return 0;
        }
        visited[startCity] = true;

        int noCitiesInComponent = 1;
        List<Integer> neighbors = cities[startCity];
        for (Integer n : neighbors) {
            noCitiesInComponent += dfs(n);
        }
        return noCitiesInComponent;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int Q = in.nextInt();
            while (Q-- > 0) {
                int noCities = in.nextInt();
                int noRoads = in.nextInt();
                long costLib = in.nextLong();
                long costRoad = in.nextLong();

                cities = (ArrayList<Integer>[]) new ArrayList[noCities + 1];
                for (int c = 1; c <= noCities; c++) {
                    cities[c] = new ArrayList<>();
                }
                visited = new boolean[noCities + 1];

                for (int a1 = 0; a1 < noRoads; a1++) {
                    int city1 = in.nextInt();
                    int city2 = in.nextInt();

                    cities[city1].add(city2);
                    cities[city2].add(city1);
                }

                if (costLib < costRoad) {
                    System.out.println(costLib * noCities);
                } else {
                    long cost = 0;
                    for (int c = 1; c <= noCities; c++) {
                        if (visited[c] == false) {
                            cost += costLib;
                            int noCitiesInComponent = dfs(c);
                            cost += (noCitiesInComponent - 1) * costRoad;
                        }
                    }

                    System.out.println(cost);
                }
            }
        }
    }
}
