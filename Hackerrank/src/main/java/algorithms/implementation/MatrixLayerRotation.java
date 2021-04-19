package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class MatrixLayerRotation {

    private static void printArray(int[][] a) {
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                System.out.print(a[r][c]);
                if (c < a[0].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static int[] calcCoord(int step, int lane, int rowLength, int colLength, int M, int N) {
        int row = 0;
        int col = 0;
        String laneName = null;
        if (step < (rowLength - 1)) {
            // point is on left column
            row = lane + step;
            col = lane;
            laneName = "left col";
        } else if (step < (rowLength - 1) + (colLength - 1)) {
            // point is on down row
            int tmpStep = step - (rowLength - 1); // adjust offset
            row = (M - 1) - lane;
            col = lane + tmpStep;
            laneName = "down row";
        } else if (step < 2 * (rowLength - 1) + (colLength - 1)) {
            // point is on right column
            int tmpStep = step - (rowLength - 1) - (colLength - 1); // adjust offset
            row = (M - 1) - lane - tmpStep;
            col = (N - 1) - lane;
            laneName = "right col";
        } else {
            // point is on upper row
            int tmpStep = step - 2 * (rowLength - 1) - (colLength - 1); // adjust offset
            row = lane;
            col = (N - 1) - lane - tmpStep;
            laneName = "up row";
        }
        System.err.println("  step=" + step + " row=" + row + " col=" + col + " " + laneName);
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int M = in.nextInt(); // lines
            int N = in.nextInt(); // cols
            int R = in.nextInt(); // rotations

            int last = -1;
            boolean elementsDiffer = false;

            int[][] array = new int[M][N];
            for (int r = 0; r < M; r++) {
                for (int c = 0; c < N; c++) {
                    array[r][c] = in.nextInt();
                    if (last > 0 && array[r][c] != last) {
                        elementsDiffer = true;
                    }
                    last = array[r][c];
                }
            }

            if (!elementsDiffer) {
                System.err.println("nothing to do, all elements are equal");
                printArray(array);
                return;
            }

            solve(M, N, R, array);
        }
    }

    static void solve(int M, int N, int R, int[][] array) {
        int[][] copy = new int[M][N];
        
        int lanes = Math.min(M, N) / 2;
        System.err.println("lanes=" + lanes);
        
        for (int lane = 0; lane < lanes; lane++) {
            int rowLength = M - (2 * lane);
            int colLength = N - (2 * lane);
            int laneLength = 2 * rowLength + 2 * colLength - 4;
            System.err.println("lane=" + lane
                    + " rowLength=" + rowLength + " colLength=" + colLength
                    + " laneLength=" + laneLength);
            
            int effRot = R % laneLength;
            //if (effRot == 0) {
            //    System.err.println("lane=" + lane + " nothing to rotate, laneLength=" + laneLength + " rotation=" + R);
            //    continue;
            //}
            
            for (int step = 0; step < laneLength; step++) {
                int[] coordFrom = calcCoord(step, lane, rowLength, colLength, M, N);
                int[] coordTo = (effRot == 0) ? coordFrom : calcCoord((step + effRot) % laneLength, lane, rowLength, colLength, M, N);
                copy[coordTo[0]][coordTo[1]] = array[coordFrom[0]][coordFrom[1]];
            }
        }
        
        printArray(copy);
    }
}
