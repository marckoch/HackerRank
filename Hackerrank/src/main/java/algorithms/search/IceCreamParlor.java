package algorithms.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class IceCreamParlor {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            while (T-- > 0) {
                int m = in.nextInt();
                int n = in.nextInt();
                int[] cost = new int[n];
                for (int i = 0; i < n; i++) {
                    cost[i] = in.nextInt();

                }
                //System.err.println(Arrays.toString(cost));
                solve(cost, m);
            }
        }
    }

    static void solve(int[] cost, int m) {
        Map<Integer, Integer> costMap = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            int first = cost[i];
            int second = m - first;
            if (costMap.containsKey(second)) {
                int posSecond = costMap.get(second);
                //System.err.println("i=" + i + " first=" + first + " second=" + second + " posSecond=" + posSecond);
                System.out.println(posSecond + " " + (i + 1));
                break;
            } else {
                costMap.put(first, i + 1);
            }
        }
    }
}
