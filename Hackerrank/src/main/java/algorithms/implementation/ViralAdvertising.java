package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class ViralAdvertising {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            
            int[] like = new int[n + 1];
            like[1] = 2;
            int sum = 2; // for day 1
            for (int day = 1; day < n; day++) {
                like[day + 1] = (int) Math.floor((like[day] * 3) / 2);
                sum += like[day + 1];
            }
            System.err.println(Arrays.toString(like));
            System.out.println(sum);
        }
    }
}
