package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class TaumAndBirthday {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int a0 = 0; a0 < t; a0++) {
                long b = in.nextLong();
                long w = in.nextLong();
                long pb = in.nextLong();
                long pw = in.nextLong();
                long conv = in.nextLong();

                long res = 0L;
                if (pb <= pw + conv && pw <= pb + conv) {
                    // conversion has no benefits
                    res = b * pb + w * pw;
                } else if (pb > pw + conv) {
                    // price of black is too high, so buying white and converting is cheaper
                    res = b * (pw + conv) + w * pw;
                } else if (pw > pb + conv) {
                    // price of white is too high, so buying black and converting is cheaper
                    res = b * pb + w * (pb + conv);
                }

                System.out.println(res);
            }
        }
    }
}
