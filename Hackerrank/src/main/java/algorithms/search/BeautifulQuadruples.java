package algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class BeautifulQuadruples {

    public static long solveNaive(int A, int B, int C, int D) {
        int[] input = {A, B, C, D};
        Arrays.sort(input);
        long result = 0;
        for (int a = 1; a <= input[0]; a++) {
            for (int b = a; b <= input[1]; b++) {
                int ab = a ^ b;
                for (int c = b; c <= input[2]; c++) {
                    for (int d = c; d <= input[3]; d++) {
                        //System.err.printf("%s %s %s %s\n", a, b, c, d);
                        int cd = c ^ d;
                        int res = ab ^ cd;
                        if (res != 0) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    static void printMatrix(int[][] A, String delimiter) {
        for (int r = 0; r < A.length; r++) {
            String del = "";
            for (int c = 0; c < A[0].length; c++) {
                System.err.print(del + A[r][c]);
                del = delimiter;
            }
            System.err.println();
        }
    }

    public static long solve(int[] input) {
        int A = input[0];
        int B = input[1];
        int C = input[2];
        int D = input[3];

        int MAX = D + 1;
        int XOR_MAX = 1; // next power of 2 greater than MAX
        while (XOR_MAX < MAX) {
            XOR_MAX = XOR_MAX << 1;
        }

        int[] totalB = new int[MAX + 1];
        //Count number of different pair {a,b} such that, a <= b and within limit
        for (int a = 1; a <= A; a++) {
            for (int b = a; b <= B; b++) {
                totalB[b]++;
            }
        }
        //System.err.println(Arrays.toString(totalB));
        
        //Create cumulative sum, such that, total[B] gives number of pair {a,b}, where b <= B
        for (int b = 1; b <= MAX; b++) {
            totalB[b] += totalB[b - 1];
        }
        //System.err.println(Arrays.toString(totalB));

        //Count number of pairs {a,b} whose xor value, a^b is x. Store it in cnt[b][x]
        int[][] countB = new int[MAX + 1][XOR_MAX + 1];
        for (int a = 1; a <= A; a++) {
            for (int b = a; b <= B; b++) {
                countB[b][a ^ b]++;
            }
        }
        //printMatrix(countB, " ");

        //Create cumulative array, so that, cnt[B][x] gives all pairs {a,b}, where b <= B and a^b = x.
        for (int i = 0; i <= XOR_MAX; i++) {
            for (int j = 1; j <= MAX; j++) {
                countB[j][i] += countB[j - 1][i];
            }
        }
        //printMatrix(countB, " ");

        long result = 0;
        
        //Simulate values of C and D
        for (int c = 1; c <= C; c++) {
            for (int d = c; d <= D; d++) {
                //For this pair, we get y = c ^ d
                int y = c ^ d;
            
                //Now, if a ^ b = y, then we will get 0.
                //What pairs {a,b} gives a^b = y, such that b <= i? cnt[i][y]
                //So, out of total[i] possible pairs, countB[i][y] gives 0
                result += (totalB[c] - countB[c][y]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            int D = in.nextInt();

            int[] input = {A, B, C, D};
            Arrays.sort(input);
            //System.err.println(Arrays.toString(input));

            System.out.println(solve(input));
        }
    }
}
