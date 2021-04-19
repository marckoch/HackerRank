package algorithms.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MinimumLoss {

    // naive solution
    static long minimumLossNaive(long[] price) {
        // minimum loss means we are looking for the MAX negative number
        long max = Long.MIN_VALUE;
        for (int buy = 0; buy < price.length - 1; buy++) {
            for (int sell = buy + 1; sell < price.length; sell++) {

                long buyPrice = price[buy];
                long sellPrice = price[sell];
                if (sellPrice < buyPrice) {
                    //System.err.printf("%s %s\n", buyPrice, sellPrice);
                    max = Math.max(max, (sellPrice - buyPrice));
                }
            }
        }
        return -max;
    }

    // solution with map
    static long minimumLoss(long[] prices) {
        Map<Long, Integer> priceMap = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            priceMap.put(prices[i], i);
        }

        Arrays.sort(prices);

        long min = Long.MAX_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            long lowerPrice = prices[i];
            long higherPrice = prices[i + 1];
            int dayOfLowPrice = priceMap.get(lowerPrice);
            int dayOfHigherPrice = priceMap.get(higherPrice);
            if (dayOfLowPrice > dayOfHigherPrice) {
                min = Math.min(min, (higherPrice - lowerPrice));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            long[] prices = new long[n];
            for (int i = 0; i < n; i++) {
                prices[i] = in.nextLong();
            }
            long result = minimumLoss(prices);
            System.out.println(result);
        }
    }
}
