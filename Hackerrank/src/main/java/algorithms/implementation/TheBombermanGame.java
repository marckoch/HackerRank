package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class TheBombermanGame {

    private static void debPrintArray(char[][] a) {
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                System.err.print(a[r][c]);
            }
            System.err.println();
        }
    }

    private static void printArray(char[][] a) {
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                System.out.print(a[r][c]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int R = in.nextInt(); // rows
            int C = in.nextInt(); // cols
            int N = in.nextInt(); // seconds

            // we have 4 states, after the initial state it
            // oscilates between A and B
            char[][] initialArray = new char[R][C];
            char[][] fullArray = new char[R][C];
            char[][] arrayA = new char[R][C];
            char[][] arrayB = new char[R][C];
            for (int r = 0; r < R; r++) {
                in.nextLine();
                char[] s = in.next().toCharArray();
                for (int c = 0; c < C; c++) {
                    initialArray[r][c] = s[c];
                    fullArray[r][c] = 'O';
                    arrayA[r][c] = 'O';
                    arrayB[r][c] = 'O';
                }
            }

            // arrayA is created based on initialArray
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (initialArray[r][c] == 'O') {
                        // the surrounding fields will become empty
                        if (r - 1 >= 0 && initialArray[r - 1][c] != 1) {
                            arrayA[r - 1][c] = '.';
                        }
                        if (c - 1 >= 0 && initialArray[r][c - 1] != 1) {
                            arrayA[r][c - 1] = '.';
                        }
                        if (r + 1 < R && initialArray[r + 1][c] != 1) {
                            arrayA[r + 1][c] = '.';
                        }
                        if (c + 1 < C && initialArray[r][c + 1] != 1) {
                            arrayA[r][c + 1] = '.';
                        }
                        // and the field with the bomb itself
                        arrayA[r][c] = '.';
                    }
                }
            }

            // arrayB is created based on arrayB
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (arrayA[r][c] == 'O') {
                        // the surrounding fields will become empty
                        if (r - 1 >= 0 && arrayA[r - 1][c] != 1) {
                            arrayB[r - 1][c] = '.';
                        }
                        if (c - 1 >= 0 && arrayA[r][c - 1] != 1) {
                            arrayB[r][c - 1] = '.';
                        }
                        if (r + 1 < R && arrayA[r + 1][c] != 1) {
                            arrayB[r + 1][c] = '.';
                        }
                        if (c + 1 < C && arrayA[r][c + 1] != 1) {
                            arrayB[r][c + 1] = '.';
                        }
                        // and the field with the bomb itself
                        arrayB[r][c] = '.';
                    }
                }
            }

            //debPrintArray(initialArray);
            //debPrintArray(fullArray);
            //debPrintArray(arrayA);
            //debPrintArray(arrayB);
            if (N <= 1) {
                printArray(initialArray);
            } else if (N % 2 == 0) {
                printArray(fullArray);
            } else if ((N + 1) % 4 == 0) {
                printArray(arrayA);
            } else if ((N - 1) % 4 == 0) {
                printArray(arrayB);
            }
        }
    }
}
