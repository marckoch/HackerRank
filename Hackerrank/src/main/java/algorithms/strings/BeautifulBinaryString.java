package algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class BeautifulBinaryString {

    static int minSteps(int n, String B) {
        int steps = 0;
        int index = B.indexOf("010");
        while (index >= 0) {
            index = B.indexOf("010", index + 3);
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            String B = in.next();
            int result = minSteps(n, B);
            System.out.println(result);
        }
    }
}
