package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class GridChallenge {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            while (T-- > 0) {
                //System.err.println("t=" + t);
                int N = in.nextInt();
                //System.err.println("N=" + N);

                in.nextLine();

                boolean errorFound = false;
                char[][] array = new char[N][];
                for (int i = 0; i < N; i++) {
                    array[i] = in.nextLine().toCharArray();
                    Arrays.sort(array[i]);
                    //System.err.println(array);
                }

                for (int i = 1; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (array[i][j] < array[i - 1][j]) {
                            errorFound = true;
                        }
                    }
                }
                System.out.println(errorFound ? "NO" : "YES");
            }
        }
    }
}
