package algorithms.greedy;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class SherlockAndTheBeast {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            while (T-- > 0) {
                int nrOfDigits = in.nextInt();
                //System.err.println("checking " + n);

                StringBuilder result = new StringBuilder("-1");

                // looking for maximum number that means i 5s follow by (n-i) 3s
                
                for (int nrOfFives = nrOfDigits; nrOfFives >= 0; nrOfFives -= 5) {
                    int nrOfThrees = nrOfDigits - nrOfFives;
                    if (nrOfFives % 3 == 0 && nrOfThrees % 5 == 0) {
                        result = new StringBuilder();

                        for (int j = 0; j < nrOfFives; j++) {
                            result.append("5");
                        }
                        for (int j = 0; j < nrOfThrees; j++) {
                            result.append("3");
                        }
                        break;
                    }
                }
                System.out.println(result.toString());
            }
        }
    }
}
