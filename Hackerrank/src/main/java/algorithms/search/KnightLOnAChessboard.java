package algorithms.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class KnightLOnAChessboard {

    static class Cell {

        int row, col;
        int steps;

        static Cell NULL = new Cell(0, 0, -1);

        Cell(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    };

    static boolean isInside(int row, int col, int N) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }

    // BFS breadth first dearch
    static Cell findPath(int forward, int sideways, int[] knightPos, int[] targetPos, int N) {
        // all the movements the knight can make
        int[][] movements = new int[8][];
        movements[0] = new int[]{forward, sideways};
        movements[1] = new int[]{forward, -sideways};
        movements[2] = new int[]{sideways, forward};
        movements[3] = new int[]{sideways, -forward};
        movements[4] = new int[]{-forward, sideways};
        movements[5] = new int[]{-forward, -sideways};
        movements[6] = new int[]{-sideways, forward};
        movements[7] = new int[]{-sideways, -forward};

        final Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(knightPos[0], knightPos[1], 0));

        Cell currentCell;
        int row, col;

        boolean[][] visited = new boolean[N][N];

        while (!queue.isEmpty()) {
            currentCell = queue.poll();

            if (visited[currentCell.row][currentCell.col]) {
                continue;
            }
            visited[currentCell.row][currentCell.col] = true;

            //System.err.println("we are here " + t.row + " " + t.col);
            if (currentCell.row == targetPos[0] && currentCell.col == targetPos[1]) {
                return currentCell;
            }

            // loop reflects the priority
            for (int i = 0; i < movements.length; i++) {
                row = currentCell.row + movements[i][0];
                col = currentCell.col + movements[i][1];

                // only add valid cells that were not already visited
                if (isInside(row, col, N) && !visited[row][col]) {
                    Cell newCell = new Cell(row, col, currentCell.steps + 1);
                    queue.add(newCell);
                }
            }
        }
        // no solution found
        return Cell.NULL;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int startRow = 0;
            int startCol = 0;
            int endRow = N - 1;
            int endCol = N - 1;

            for (int forward = 1; forward < N; forward++) {
                String delimiter = "";
                for (int sideways = 1; sideways < N; sideways++) {
                    Cell result = findPath(forward, sideways, new int[]{startRow, startCol}, new int[]{endRow, endCol}, N);
                    System.out.print(delimiter + result.steps);
                    delimiter = " ";
                }
                System.out.println();
            }
        }
    }
}
