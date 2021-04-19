package worldscodesprint12;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author marckoch
 */
public class KnightMove {

    //  structure for storing a cell's data
    static class Cell {
        int x, y;
        int dis;

        Cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    };

    //  Utility method returns true if (x, y) lies inside Board
    static boolean isInside(int x, int y, int N) {
        if (x >= 1 && x <= N && y >= 1 && y <= N) {
            return true;
        }
        return false;
    }

    // Method returns minimum step to reach target position
    static int minStepToReachTarget(int knightPos[], int targetPos[], int N) {
        //  x and y direction, where a knight can move
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        //  queue for storing states of knight in board
        Queue<Cell> q = new LinkedList<>();

        //  push starting position of knight with 0 distance
        q.add(new Cell(knightPos[0], knightPos[1], 0));

        Cell t;
        int x, y;
        boolean[][] visit = new boolean[N + 1][N + 1];

        //  loop untill we have one element in queue
        while (!q.isEmpty()) {
            t = q.poll();
            if (visit[t.x][t.y]) 
                continue;
            visit[t.x][t.y] = true;

            // if current cell is equal to target cell,
            // return its distance
            if (t.x == targetPos[0] && t.y == targetPos[1]) {
                return t.dis;
            }

            //  loop for all reahable states
            for (int i = 0; i < 8; i++) {
                x = t.x + dx[i];
                y = t.y + dy[i];

                // If rechable state is not yet visited and
                // inside board, push that state into queue
                if (isInside(x, y, N) && !visit[x][y]) {
                    q.add(new Cell(x, y, t.dis + 1));
                }
            }
        }
        return 0;
    }

    // Driver code to test above methods
    public static void main(String[] args) {
        //  size of square board
        int N = 6;
        int[] knightPos= {4, 5};
        int[] targetPos= {1, 1};
        System.out.println(minStepToReachTarget(knightPos, targetPos, N));
        
        N = 201;
        knightPos = new int[] {200, 200};
        targetPos = new int[] {0, 0};
        System.out.println(minStepToReachTarget(knightPos, targetPos, N));
    }
}
