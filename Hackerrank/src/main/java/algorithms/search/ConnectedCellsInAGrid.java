package algorithms.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * maze
 * @author marckoch
 */
public class ConnectedCellsInAGrid {

    static int MAX_ROW;
    static int MAX_COL;
    static int[][] matrix;
    static boolean[][] visited;

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

    static class Cell {

        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        public boolean isInside() {
            return row >= 0 && row < MAX_ROW && col >= 0 && col < MAX_COL;
        }
        
        public int getValue() {
            return matrix[row][col];
        }
    }

    // depth first search
    private static int dfs(Cell cell) {
        if (visited[cell.row][cell.col]) {
            return 0;
        }
        visited[cell.row][cell.col] = true;

        int nrOfCellsInRegion = matrix[cell.row][cell.col];

        List<Cell> neighbors = new ArrayList<>();

        // build and check all potential 8 neighbors
        // add neighbor to list if neighbor is valid
        checkNeighbor(neighbors, new Cell(cell.row, cell.col + 1));
        checkNeighbor(neighbors, new Cell(cell.row, cell.col - 1));

        checkNeighbor(neighbors, new Cell(cell.row + 1, cell.col + 1));
        checkNeighbor(neighbors, new Cell(cell.row + 1, cell.col));
        checkNeighbor(neighbors, new Cell(cell.row + 1, cell.col - 1));

        checkNeighbor(neighbors, new Cell(cell.row - 1, cell.col + 1));
        checkNeighbor(neighbors, new Cell(cell.row - 1, cell.col));
        checkNeighbor(neighbors, new Cell(cell.row - 1, cell.col - 1));

        for (Cell n : neighbors) {
            nrOfCellsInRegion += dfs(n);
        }
        return nrOfCellsInRegion;
    }

    static void checkNeighbor(List<Cell> list, Cell neighbor) {
        if (neighbor.isInside() && neighbor.getValue() > 0) {
            list.add(neighbor);
        }
    }

    static int connectedCell(int[][] matrix) {
        //printMatrix(matrix, " ");

        visited = new boolean[MAX_ROW][MAX_COL];

        int maxSize = 0;

        for (int row = 0; row < MAX_ROW; row++) {
            for (int col = 0; col < MAX_COL; col++) {
                if (matrix[row][col] > 0 && !visited[row][col]) {
                    int size = dfs(new Cell(row, col));
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            MAX_ROW = in.nextInt();
            MAX_COL = in.nextInt();
            matrix = new int[MAX_ROW][MAX_COL];
            for (int row = 0; row < MAX_ROW; row++) {
                for (int col = 0; col < MAX_COL; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }
            int result = connectedCell(matrix);
            System.out.println(result);
        }
    }
}
