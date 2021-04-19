package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class BeautifulDaysAtTheMovies {

    private static int reverse(int input) {
        int reversedNum = 0;
        while (input != 0) {
            reversedNum = reversedNum * 10 + input % 10;
            input = input / 10;
        }
        return reversedNum;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int from = in.nextInt();
            int to = in.nextInt();
            int divisor = in.nextInt();
            
            solve(from, to, divisor);
        }
    }

    static void solve(int from, int to, int divisor) {
        int countBeautifulDays = 0;
        for (int i = from; i <= to; i++) {
            if (Math.abs(i - reverse(i)) % divisor == 0) {
                countBeautifulDays++;
            }
        }
        System.out.println(countBeautifulDays);
    }
}
