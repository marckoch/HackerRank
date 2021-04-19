package geeksforgeeks;

/**
 * @author marckoch
 */
public class GoldMiner {

    static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    static void printArray(int[][] A) {
        for (int n = 0; n < A.length; n++) {
            for (int m = 0; m < A[0].length; m++) {
                System.err.print(A[n][m] + " \t");
            }
            System.err.println();
        }
    }

    // Returns maximum amount of gold that can be collected
    // when journey started from first column and moves
    // allowed are right, right-up and right-down
    static int getMaxGold(int gold[][], int m, int n) {
        // Create a table for storing intermediate results
        // and initialize all cells to 0. The first row of
        // goldMineTable gives the maximum gold that the miner
        // can collect when starts that row
        int[][] goldTable = new int[m][n];

        for (int col = n - 1; col >= 0; col--) {
            for (int row = 0; row < m; row++) {
                // Gold collected on going to the cell on the right(->)
                int right = (col == n - 1) ? 0 : goldTable[row][col + 1];

                // Gold collected on going to the cell to right up (/)
                int right_up = (row == 0 || col == n - 1) ? 0
                        : goldTable[row - 1][col + 1];

                // Gold collected on going to the cell to right down (\)
                int right_down = (row == m - 1 || col == n - 1) ? 0
                        : goldTable[row + 1][col + 1];


                // Max gold collected from taking either of the
                // above 3 paths
                goldTable[row][col] = gold[row][col]
                        + max(right, right_up, right_down);

                System.err.println(String.format("col=%s row=%s max=%s", col, row, max(right, right_up, right_down)));
                printArray(goldTable);
            }
        }

        // The max amount of gold collected will be the max
        // value in first column of all rows
        int res = goldTable[0][0];
        for (int i = 1; i < m; i++) {
            res = Math.max(res, goldTable[i][0]);
        }

        findPath(gold, goldTable, res);

        return res;
    }

    // ugly way to find and print the path with the maximum sum we found above
    public static void findPath(int[][] gold, int[][] goldSum, int maximum) {
        int previousRow = 0;
        // in the first col of goldSum find the row of the maximum
        for (int i = 0; i < goldSum.length; i++) {
            if (goldSum[i][0] == maximum) {
                previousRow = i;
                System.out.print(gold[i][0] + " ");
                break;
            }
        }

        // now look in each following column in the upper right, right and lower row for the next maximum, rinse, repeat
        for (int col = 1; col < goldSum[0].length; col++) {
            int maxUpperRight = (previousRow >= 1) ? goldSum[previousRow - 1][col] : -1;
            int maxRight = goldSum[previousRow][col];
            int maxLowerRight = (previousRow < goldSum[0].length - 1) ? goldSum[previousRow + 1][col] : -1;

            int max = max(maxUpperRight, maxRight, maxLowerRight);

            int rowWithMaximum = -1;
            if (maxUpperRight == max) {
                rowWithMaximum = previousRow - 1;
            } else if (maxRight == max) {
                rowWithMaximum = previousRow;
            } else if (maxLowerRight == max) {
                rowWithMaximum = previousRow + 1;
            }

            previousRow = rowWithMaximum;

            System.out.print(gold[rowWithMaximum][col] + " ");
        }
    }

    static int getMinGold(int gold[][], int m, int n) {
        int[][] goldTable = new int[m][n];

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < m; row++) {
                if (col == 0) {
                    goldTable[row][col] = gold[row][col];
                } else {
                    int left = goldTable[row][col - 1];
                    int left_up = (row == 0) ? Integer.MAX_VALUE : goldTable[row - 1][col - 1];
                    int left_down = (row == m-1) ? Integer.MAX_VALUE : goldTable[row + 1][col - 1];

                    goldTable[row][col] = gold[row][col] + min(left, left_down, left_up);
                    System.err.println(String.format("col=%s row=%s gold=%s min=%s", col, row, goldTable[row][col], min(left, left_down, left_up)));
                }

                printArray(goldTable);
            }
        }

        int res = goldTable[0][n-1];
        for (int i = 1; i < m; i++) {
            res = Math.min(res, goldTable[i][n-1]);
        }

//        findPath(gold, goldTable, res);

        return res;
    }

    public static void main(String[] args) {
        int gold[][] = {
                {1, 3, 1, 5},
                {2, 12, 4, 1},
                {5, 4, 2, 3},
                {0, 6, 1, 2}
        };
        int m = 4, n = 4;
        //int result = getMaxGold(gold, m, n);
        int result = getMinGold(gold, m, n);
        System.out.println("gold=" + result);
    }
}
