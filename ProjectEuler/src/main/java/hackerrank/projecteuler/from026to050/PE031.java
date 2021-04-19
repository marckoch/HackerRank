package hackerrank.projecteuler.from026to050;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Coin sums
 *
 * @author marckoch
 */
public class PE031 {

    public static int MOD = (int) Math.pow(10, 9) + 7;

    private static final int[] COINS = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
    
    // SLOW but solves Project Euler problem!
    public static int bruteForce(int target) {
        int ways = 0;

        for (int a = target; a >= 0; a -= 200) {
            for (int b = a; b >= 0; b -= 100) {
                for (int c = b; c >= 0; c -= 50) {
                    for (int d = c; d >= 0; d -= 20) {
                        for (int e = d; e >= 0; e -= 10) {
                            for (int f = e; f >= 0; f -= 5) {
                                for (int g = f; g >= 0; g -= 2) {
                                    ways++;
                                    ways = ways % MOD;
                                }
                            }
                        }
                    }
                }
            }
        }
        return ways;
    }

    public static int[] COUNT = new int[20 + 1];
    
    public static int build(int amount) {
        COUNT[0] = 1;
        for (int i = 0; i < COINS.length; i++) {
            for(int j = COINS[i]; j <= amount; j++) {
                COUNT[j] = COUNT[j] + COUNT[j - COINS[i]];
                COUNT[j] %= MOD;
            }
            System.err.println(COINS[i] + " " + Arrays.toString(COUNT));
        }
        return COUNT[amount];
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        build(100_000);
        
        int T = in.nextInt();
        while (T-- > 0) {
            int N = in.nextInt();
            
            System.out.println(COUNT[N]);
        }
    }
    
}
