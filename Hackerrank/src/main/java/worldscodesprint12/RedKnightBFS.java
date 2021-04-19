package worldscodesprint12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class RedKnightBFS {

    static class Cell {

        int row, col;
        int steps;
        String moves = "";

        static Cell NULL = new Cell(0, 0, 0);

        Cell(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }

        @Override
        public String toString() {
            if (moves.isEmpty()) {
                return "Impossible";
            }
            return steps + "\n" + moves.trim();
        }

    };

    static boolean isInside(int row, int col, int N) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }

    static Cell findPath(int[] knightPos, int[] targetPos, int N) {
        // order reflects the priority of the moves
        int[] drow = {-2, -2, 0, 2, 2, 0};
        int[] dcol = {-1, 1, 2, 1, -1, -2};
        String[] moves = {"UL", "UR", "R", "LR", "LL", "L"};

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
            for (int i = 0; i < 6; i++) {
                row = currentCell.row + drow[i];
                col = currentCell.col + dcol[i];

                // only add valid cells that were not already visited
                if (isInside(row, col, N) && !visited[row][col]) {
                    Cell newCell = new Cell(row, col, currentCell.steps + 1);
                    newCell.moves = currentCell.moves + moves[i] + " ";
                    queue.add(newCell);
                }
            }
            //System.err.println(q);
            //System.err.println("queue.size=" + q.size());
            //q.forEach((cell) -> { System.out.println(cell.moves); });

        }
        // no solution found
        return Cell.NULL;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int row_start = in.nextInt();
            int col_start = in.nextInt();
            int row_end = in.nextInt();
            int col_end = in.nextInt();

            Cell result = findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);

            System.out.println(result.steps);
        }
    }
}
