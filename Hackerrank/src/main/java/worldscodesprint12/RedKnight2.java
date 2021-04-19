package worldscodesprint12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class RedKnight2 {
    static class Cell {
        int row, col;
        int steps;
        String moves="";

        Cell(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }

        @Override
        public String toString() {
            if (moves.isEmpty()) 
                return "Impossible";
            
            return steps + "\n" + moves.trim();
            //StringBuilder res = new StringBuilder().append(steps).append("\n");
            //moves.forEach(m -> {res.append(m).append(" ");});
            //return res.toString().trim();
        }
        
    };

    static boolean isInside(int row, int col, int N) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }
    
    static int distance(int[] knightPos, int[] targetPos) {
        return Math.abs(knightPos[0] - targetPos[0]) +
                Math.abs(knightPos[1] - targetPos[1]);
    }
    
    static double straightDistance(int[] knightPos, int[] targetPos) {
        return Math.sqrt(
                (knightPos[0] - targetPos[0]) * (knightPos[0] - targetPos[0]) 
                +
                (knightPos[1] - targetPos[1]) * (knightPos[1] - targetPos[1])
        );
    }
        
    static Cell findPath(int[] knightPos, int[] targetPos, int N) {
        int[] drow = {-2, -2, 0, 2, 2, 0};
        int[] dcol = {-1,  1, 2, 1, -1, -2};
        String[] moves = {"UL", "UR", "R", "LR", "LL", "L"};

        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(knightPos[0], knightPos[1], 0));

        Cell t;
        int row, col;
        
        boolean[][] visit = new boolean[N + 1][N + 1];
        //visit[knightPos[0]][knightPos[1]] = true;

        while (!q.isEmpty()) {
            t = q.poll();
            
            if (visit[t.row][t.col]) continue;
            visit[t.row][t.col] = true;
            
            System.err.println("we are here " + t.row + " " + t.col);

            if (t.row == targetPos[0] && t.col == targetPos[1]) {
                return t;
            }

            for (int i = 0; i < 6; i++) {
                double distanceNow = straightDistance(new int[]{t.row, t.col}, targetPos);
                row = t.row + drow[i];
                col = t.col + dcol[i];
                double distanceAfter = straightDistance(new int[]{row, col}, targetPos);

                if (isInside(row, col, N) && !visit[row][col] 
                        &&
                        distanceAfter<distanceNow
                        ) {
                    Cell newCell = new Cell(row, col, t.steps + 1);
                    newCell.moves = t.moves + moves[i] + " ";
                    //System.err.println("adding valid move " + moves[i]);
                    q.add(newCell);
                }
            }
            //System.err.println(q);
            System.err.println("queue.size=" + q.size());
            //q.forEach((cell) -> { System.out.println(cell.moves); });
            
        }
        return new Cell(0,0,0);
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int row_start = in.nextInt();
            int col_start = in.nextInt();
            int row_end = in.nextInt();
            int col_end = in.nextInt();
            Cell result = findPath(new int[] {row_start, col_start}, new int[]{row_end, col_end}, n );
            System.out.println(result.toString());
        }
    }
}
