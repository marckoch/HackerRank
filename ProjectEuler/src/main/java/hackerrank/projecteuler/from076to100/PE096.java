package hackerrank.projecteuler.from076to100;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 */
public class PE096 {
    private static final int BOARD_SIZE = 9;

    public static void solveProjectEuler() throws URISyntaxException, IOException {
        final String filename = "hackerrank/projecteuler/from076to100/p096_sudoku.txt";
        final Path path = Paths.get(PE096.class.getClassLoader().getResource(filename).toURI());
        List<String> lines = Files.readAllLines(path);

        Collection<List<String>> games = splitGames(lines);

        int sum =0;
        for (List<String> game : games) {
            int answer = solveGame(game);
            sum += answer;
            System.out.println(answer);
        }
        System.out.println(sum);
    }

    // read chunks of 10 lines, each 10 lines are one game (one header and 9 lines of board rows)
    private static Collection<List<String>> splitGames(List<String> lines) {
        int chunk = 10;
        AtomicInteger count = new AtomicInteger();
        return lines.stream()
                .collect(Collectors.groupingBy(it -> count.getAndIncrement() / chunk))
                .values();
    }

    // solve one game
    private static int solveGame(List<String> game) {
        int[][] board = parseGame(game);
        solveBoard(board);
        printBoard(board);
        return getWinningNumber(board);
    }

    // solve board, will be called recursively
    private static boolean solveBoard(int[][] board) {
        //printBoardSimple(board);
        if (isValid(board)) {
            System.out.println("found valid board!");
            return true;
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == 0) {
                    int[] candidates = getCandidates(board, row, col);
                    for (int n : candidates) {
                        board[row][col] = n;
                        boolean valid = solveBoard(board);
                        if (valid) {
                            return true;
                        }
                        board[row][col] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] parseGame(List<String> game) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        int i = 0;
        for (String line : game) {
            // ignore first line that contains the header
            if (line.startsWith("Grid")) {
                continue;
            }
            board[i++] = toIntArr(line);
        }
        printBoard(board);
        return board;
    }

    // convert String of 9 digits to int[]
    // e.g. "123456789" -> [1,2,3,4,5,6,7,8,9]
    public static int[] toIntArr(String line) {
        return line.chars()
                .map(i -> Character.digit(i, 10))
                .toArray();
    }

    // print the board, add lines to show quadrants
    private static void printBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            if (row > 0 && row % 3 == 0) {
                System.out.println("---+---+---");
            }
            for (int col = 0; col < board.length; col++) {
                if (col > 0 && col % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][col]);
            }
            System.out.print("\n");
        }
    }

    // print board in simple form, that means NO lines for quadrants
    private static void printBoardSimple(int[][] board) {
        System.out.println("----------");
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }

    // check if the board is valid, that means:
    // every row is valid, every column is valid and every quadrant is valid
    private static boolean isValid(int[][] board) {
        // check if each row is valid
        for (int[] rowArr : board) {
            if (!isValid(rowArr)) {
                return false;
            }
        }
        // check if each col is valid
        for (int i = 0; i < board.length; i++) {
            int[] colArr = extractCol(board, i);
            if (!isValid(colArr)) {
                return false;
            }
        }

        // check if each quadrant is valid
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                int[] qArr = extractQuadrant(board, row, col);
                if (!isValid(qArr)) {
                    return false;
                }
            }
        }
        return true;
    }

    // check if in given arr all numbers are set and distinct
    public static boolean isValid(int[] arr) {
        BitSet bs = new BitSet(9);
        for (int n : arr) {
            if (n == 0) {
                return false;
            }
            if (bs.get(n)) {
                // number already set in this arr >> arr invalid
                return false;
            }
            bs.set(n);
        }
        return true;
    }

    // extract column with index 'col' from given board (in each row the col-th number)
    public static int[] extractCol(int[][] board, int col) {
        int[] colArr = new int[board.length];
        for (int row = 0; row < board.length; row++) {
            int[] rowArr = board[row];
            colArr[row] = rowArr[col];
        }
        return colArr;
    }

    // extract the quadrant that contains inputRow and inputCol
    public static int[] extractQuadrant(int[][] board, int inputRow, int inputCol) {
        List<Integer> quadrant = new ArrayList<>();
        final int QUADRANT_SIZE = 3;

        int startRow = (inputRow / QUADRANT_SIZE) * QUADRANT_SIZE;
        int endRow = startRow + QUADRANT_SIZE;

        int startCol = (inputCol / QUADRANT_SIZE) * QUADRANT_SIZE;
        int endCol = startCol + QUADRANT_SIZE;

        //System.out.println("exQ: input:" + inputRow + "/" + inputCol + " row:" + startRow + "-" + endRow + " col:" + startCol + "-" + endCol);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if ((startRow <= row && row < endRow) &&
                        (startCol <= col && col < endCol)) {
                    quadrant.add(board[row][col]);
                }
            }
        }
        return quadrant.stream().mapToInt(x -> x).toArray();
    }

    // find candidates for position row/col in given board
    // finds all numbers that are NOT set in the same row, same col or same quadrant
    private static int[] getCandidates(int[][] board, int row, int col) {
        //System.out.println("checking candidates row=" + row + " col=" + col);
        int v = board[row][col];
        if (v > 0) {
            // already occupied!
            return new int[]{};
        }

        int[] rowArr = board[row];
        //System.out.println("row=" + Arrays.toString(rowArr));
        int[] colArr = extractCol(board, col);
        //System.out.println("col=" + Arrays.toString(colArr));
        int[] qArr = extractQuadrant(board, row, col);
        //System.out.println("qua=" + Arrays.toString(qArr));

        Set<Integer> numbersAlreadySet = new HashSet<>();

        for (int value : rowArr) {
            if (value > 0) {
                numbersAlreadySet.add(value);
            }
        }

        for (int value : colArr) {
            if (value > 0) {
                numbersAlreadySet.add(value);
            }
        }

        for (int value : qArr) {
            if (value > 0) {
                numbersAlreadySet.add(value);
            }
        }

        return IntStream.rangeClosed(1, 9).filter(i -> !numbersAlreadySet.contains(i)).toArray();
    }

    public static int getWinningNumber(int[][] board) {
        return 100 * board[0][0] + 10 * board[0][1] + board[0][2];
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        solveProjectEuler();

    }
}
