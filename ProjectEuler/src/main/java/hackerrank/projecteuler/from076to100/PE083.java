package hackerrank.projecteuler.from076to100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Path sum: four ways
 *
 * @author marckoch
 */
public class PE083 {

    static class Cell implements Comparable<Cell> {

        int row, col;
        long cost;

        static Cell NULL = new Cell(0, 0, 0);

        Cell(int row, int col, long cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Cell o) {
            return Long.compare(this.cost, o.cost);
        }
    };

    // BFS solution
    public static long solveBFS(long[][] array) {
        int N = array.length;

        //printArray(array);

        // PriorityQueue has smallest element in the front 
        // (according to defined order, see Cell.compare(...)
        Queue<Cell> queue = new PriorityQueue<>();
        // seed starting point: top left cell
        queue.add(new Cell(0, 0, array[0][0]));

        Cell cell;

        boolean[][] visited = new boolean[N][N];

        while (!queue.isEmpty()) {
            cell = queue.poll();

            if (visited[cell.row][cell.col]) {
                continue;
            }
            visited[cell.row][cell.col] = true;

            //System.err.printf("we are here %s %s %s\n", cell.row, cell.col, cell.cost);

            // we are at the finish: bottom right cell
            if (cell.row == N - 1 && cell.col == N - 1) {
                return cell.cost;
            }

            // one step left
            if (cell.col > 0) {
                Cell stepLeft = new Cell(cell.row, cell.col - 1, cell.cost + array[cell.row][cell.col - 1]);
                queue.add(stepLeft);
            }

            // one step right
            if (cell.col + 1 < N) {
                Cell stepRight = new Cell(cell.row, cell.col + 1, cell.cost + array[cell.row][cell.col + 1]);
                queue.add(stepRight);
            }

            // one step down
            if (cell.row + 1 < N) {
                Cell stepDown = new Cell(cell.row + 1, cell.col, cell.cost + array[cell.row + 1][cell.col]);
                queue.add(stepDown);
            }

            // one step up
            if (cell.row > 0) {
                Cell stepUp = new Cell(cell.row - 1, cell.col, cell.cost + array[cell.row - 1][cell.col]);
                queue.add(stepUp);
            }
        }

        return 0;
    }

    static void printArray(long[][] A) {
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                System.err.print(A[r][c] + " \t");
            }
            System.err.println();
        }
    }

    public static long[][] readArrayFromStdIn() {
        Scanner in = new Scanner(System.in);

        // read array with Scanner
        int N = in.nextInt();
        long[][] array = new long[N][N];
        for (int row = 0; row < N; row++) {
            array[row] = new long[N];
            for (int col = 0; col < N; col++) {
                array[row][col] = in.nextInt();
            }
        }
        //printArray(array);
        return array;
    }

    public static long[][] readArrayFromFile(int dim, String fqn) throws IOException {
        long[][] array = new long[dim][dim];

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try (InputStream is = classloader.getResourceAsStream(fqn);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            int rowCount = 0;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                int wordCount = 0;
                for (String word : words) {
                    array[rowCount][wordCount++] = Integer.valueOf(word);
                }

                rowCount++;
            }
        }

        // printArray(array);
        return array;
    }

    public static void solveProjectEuler() throws IOException {
        long[][] array = readArrayFromFile(80, "hackerrank/projecteuler/from076to100/p083_matrix.txt");
        System.out.println(solveBFS(array));

    }

    public static void solveHackerrank() {
        long[][] array = readArrayFromStdIn();
        System.out.println(solveBFS(array));
    }

    public static void main(String[] args) throws IOException {
        solveHackerrank();
        //solveProjectEuler();
    }
}
