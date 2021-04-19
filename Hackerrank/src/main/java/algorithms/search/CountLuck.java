package algorithms.search;

import java.util.Scanner;

/**
 * maze, dfs, backtracking
 *
 * @author marckoch
 */
public class CountLuck {

    static int MAX_ROW;
    static int MAX_COL;
    static char[][] matrix;
    static int[][] visited;

    static void printMatrix(char[][] A, String delimiter) {
        for (int r = 0; r < A.length; r++) {
            String del = "";
            for (int c = 0; c < A[0].length; c++) {
                System.err.print(del + A[r][c]);
                del = delimiter;
            }
            System.err.println();
        }
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

    static class Cell {

        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean isFree() {
            return matrix[row][col] != 'X';
        }

        public boolean isStart() {
            return matrix[row][col] == 'M';
        }

        public boolean isEnd() {
            return matrix[row][col] == '*';
        }

        public boolean visited() {
            return visited[row][col] > 0;
        }

        public boolean isValidNextStep() {
            return isInside() && isFree() && !visited();
        }

        public boolean isInside() {
            return row >= 0 && row < MAX_ROW && col >= 0 && col < MAX_COL;
        }

        public char getVal() {
            return matrix[row][col];
        }

        @Override
        public String toString() {
            return "(" + row + "," + col + ')';
        }

        public static final Cell NULL = new Cell(-1, -1);
    }

    /* A recursive utility function to solve Maze problem 
      see RatMaze on geeksforgeeks.org
     */
    static boolean solveMaze(char[][] maze, Cell cell) {

        // always mark current cell as part of solution path
        // so calculation of next step will not step back on this cell
        // hint: maybe we could mark path in initial matrix?
        visited[cell.row][cell.col] = 1;

        if (cell.isEnd()) {
            return true;
        }

        // all possible next steps
        Cell right = new Cell(cell.row, cell.col + 1);
        Cell down = new Cell(cell.row + 1, cell.col);
        Cell left = new Cell(cell.row, cell.col - 1);
        Cell up = new Cell(cell.row - 1, cell.col);

        // if we have >= 2 next step that means we ask the wand
        // and put a '9' in the 'visited' matrix
        int validNextSteps = countValidNextSteps(right, down, left, up);
        if (validNextSteps >= 2) {
            visited[cell.row][cell.col] = 9;
        }

        // do next step but only if it is valid
        if (right.isValidNextStep() && solveMaze(maze, right)) {
            return true;
        }
        if (down.isValidNextStep() && solveMaze(maze, down)) {
            return true;
        }
        if (left.isValidNextStep() && solveMaze(maze, left)) {
            return true;
        }
        if (up.isValidNextStep() && solveMaze(maze, up)) {
            return true;
        }

        /* If none of the above steps work then BACKTRACK: 
                unmark x,y as part of solution path */
        visited[cell.row][cell.col] = 0;
        return false;
    }

    static int countValidNextSteps(Cell right, Cell down, Cell left, Cell up) {
        int possibleNextSteps = 0;
        if (right.isValidNextStep()) {
            possibleNextSteps++;
        }
        if (down.isValidNextStep()) {
            possibleNextSteps++;
        }
        if (left.isValidNextStep()) {
            possibleNextSteps++;
        }
        if (up.isValidNextStep()) {
            possibleNextSteps++;
        }
        return possibleNextSteps;
    }

    static String countLuck(int expectedGuesses) {
        //printMatrix(matrix, "");

        // this matrix is used to keep track of the visited path
        // steps are marked with '1', 
        // intersections where wand was asked with '9'
        visited = new int[MAX_ROW][MAX_COL];

        Cell start = findStartingCell();

        boolean endFound = solveMaze(matrix, start);
        if (!endFound) {
            // should not happen according to problem description
            return "no path found!";
        }
        //printMatrix(visited, "");

        int actualGuesses = countActualGuesses();

        //System.err.println("actual nrOfGuesses=" + actualGuesses);
        //System.err.println("expected nrOfGuesses=" + expectedGuesses);

        return actualGuesses == expectedGuesses ? "Impressed" : "Oops!";
    }

    // just count all the '9's in 'visited'
    static int countActualGuesses() {
        int actualGuesses = 0;
        for (int row = 0; row < MAX_ROW; row++) {
            for (int col = 0; col < MAX_COL; col++) {
                if (visited[row][col] == 9) {
                    actualGuesses++;
                }
            }
        }
        return actualGuesses;
    }

    static Cell findStartingCell() {
        Cell start = Cell.NULL;
        for (int row = 0; row < MAX_ROW; row++) {
            for (int col = 0; col < MAX_COL; col++) {
                if (matrix[row][col] == 'M') {
                    start = new Cell(row, col);
                    System.err.printf("starting at %s\n", start);
                    break;
                }
            }
        }
        return start;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            while (T-- > 0) {
                MAX_ROW = in.nextInt();
                MAX_COL = in.nextInt();
                matrix = new char[MAX_ROW][MAX_COL];
                for (int row = 0; row < MAX_ROW; row++) {
                    matrix[row] = in.next().toCharArray();
                }
                int expectedGuesses = in.nextInt();
                String result = countLuck(expectedGuesses);
                System.out.println(result);
            }
        }
    }
}
