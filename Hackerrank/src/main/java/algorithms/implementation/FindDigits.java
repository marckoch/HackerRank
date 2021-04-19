package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class FindDigits {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();

            for (int i = 0; i < q; i++) {
                int n = in.nextInt();
                String s = String.valueOf(n);
                int count = 0;
                for (int j = 0; j < s.length(); j++) {
                    int digit = Character.getNumericValue(s.charAt(j));
                    if (digit > 0) {
                        if (n % digit == 0) {
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }
        }
    }
}
