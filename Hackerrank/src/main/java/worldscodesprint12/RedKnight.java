package worldscodesprint12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class RedKnight {

    static String printShortestPath(int n, int row_start, int col_start, int row_end, int col_end) {
        //  Print the distance along with the sequence of moves.

        int countMoves = 0;
        List<String> moves = new ArrayList<>();

        while (row_start != row_end || col_start != col_end) {
            System.err.println("we are here " + row_start + " " + col_start);

            if (Math.abs(row_start - row_end) % 2 == 1) {
                return "Impossible";
            }
            if (col_start - col_end == 0 && Math.abs(row_start - row_end) % 4 > 0) {
                return "Impossible";
            }

            if (Math.abs(col_start - col_end) < 1 && Math.abs(row_start - row_end) < 1) {
                return "Impossible";
            }

            if (row_start > row_end && row_start >= 2) {
                // we have to go UP
                row_start -= 2;
                countMoves++;

                if (col_start >= col_end && col_start > 0) {
                    // we have to go LEFT
                    col_start -= 1;
                    moves.add("UL");
                } else {
                    // we have to go RIGHT
                    col_start += 1;
                    moves.add("UR");
                }
            } else if (row_start == row_end) {
                // we are on the same row
                if (Math.abs(col_start - col_end) % 2 == 0) {
                    int steps = (col_end - col_start) / 2;
                    if (steps > 0) {
                        for (int s = 0; s < steps; s++) {
                            moves.add("R");
                        }
                    } else {
                        steps = -steps;
                        for (int s = 0; s < steps; s++) {
                            moves.add("L");
                        }
                    }
                    countMoves += steps;
                    return countMoves + "\n" + sortMoves(moves);
                } else {
                    return "Impossible";
                }
            } else if (row_start < row_end) {
                // we have to go DOWN or RIGHT
                int stepsDown = (row_end - row_start) / 2;
                if (col_start < col_end - stepsDown) {
                    // first go RIGHT
                    col_start += 2;
                    countMoves++;
                    moves.add("R");
                } else {
                    row_start += 2;
                    if (row_start>n) return "Impossible";
                    countMoves++;

                    if (col_start <= col_end && col_start + 1 < n) {
                        // we have to go RIGHT
                        col_start += 1;
                        moves.add("LR");
                    } else {
                        // we have to go LEFT
                        col_start -= 1;
                        moves.add("LL");
                    }
                }
            } else {
                return "Impossible";
            }
        }

        return countMoves + "\n" + sortMoves(moves);
    }
    
    static String sortMoves(List<String> moves) {
//        final List<String> prio = new ArrayList<>();
//        prio.add("UL");
//        prio.add("UR");
//        prio.add("R");
//        prio.add("LR");
//        prio.add("LL");
//        prio.add("L");
//        moves.sort((o1, o2) -> {
//            return prio.indexOf(o1) - prio.indexOf(o2);
//        });
        StringBuilder sb = new StringBuilder();
        moves.forEach((t) -> {
            sb.append(t).append(" ");
        });
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int row_start = in.nextInt();
            int col_start = in.nextInt();
            int row_end = in.nextInt();
            int col_end = in.nextInt();
            System.out.println(printShortestPath(n, row_start, col_start, row_end, col_end));
        }
    }
}
