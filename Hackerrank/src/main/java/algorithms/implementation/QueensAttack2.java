package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class QueensAttack2 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();
            int rQueen = in.nextInt();
            int cQueen = in.nextInt();

            // distance to edge
            int distN = n - rQueen;
            int distNE = n - Math.max(rQueen, cQueen);
            int distE = n - cQueen;
            int distSE = Math.min(n - cQueen, rQueen - 1);
            int distS = rQueen - 1;
            int distSW = Math.min(rQueen, cQueen) - 1;
            int distW = cQueen - 1;
            int distNW = Math.min(n - rQueen, cQueen - 1);

            System.err.println("N:" + distN + " NE:" + distNE + " E:" + distE + " SE:" + distSE + " S:"
                    + distS + " SW:" + distSW + " W:" + distW + " NW:" + distNW);

            for (int a0 = 0; a0 < k; a0++) {
                int rObstacle = in.nextInt();
                int cObstacle = in.nextInt();

                int dist = n;
                if (rObstacle > rQueen && cObstacle == cQueen) { // N
                    dist = rObstacle - rQueen - 1;
                    if (dist < distN) {
                        distN = dist;
                    }
                } else if (rObstacle < rQueen && cObstacle == cQueen) { // S
                    dist = rQueen - rObstacle - 1;
                    if (dist < distS) {
                        distS = dist;
                    }
                } else if (rObstacle == rQueen && cObstacle > cQueen) { // E
                    dist = cObstacle - cQueen - 1;
                    if (dist < distE) {
                        distE = dist;
                    }
                } else if (rObstacle == rQueen && cObstacle < cQueen) { // W
                    dist = cQueen - cObstacle - 1;
                    if (dist < distW) {
                        distW = dist;
                    }
                } else if (rObstacle > rQueen && cObstacle > cQueen && rObstacle - rQueen == cObstacle - cQueen) { // NE
                    dist = rObstacle - rQueen - 1;
                    if (dist < distNE) {
                        distNE = dist;
                    }
                } else if (rObstacle < rQueen && cObstacle > cQueen && rQueen - rObstacle == cObstacle - cQueen) { // SE
                    dist = rQueen - rObstacle - 1;
                    if (dist < distSE) {
                        distSE = dist;
                    }
                } else if (rObstacle < rQueen && cObstacle < cQueen && rQueen - rObstacle == cQueen - cObstacle) { // SW
                    dist = rQueen - rObstacle - 1;
                    if (dist < distSW) {
                        distSW = dist;
                    }
                } else if (rObstacle > rQueen && cObstacle < cQueen && rObstacle - rQueen == cQueen - cObstacle) { // NW
                    dist = rObstacle - rQueen - 1;
                    if (dist < distNW) {
                        distNW = dist;
                    }
                }
                System.err.println("N:" + distN + " NE:" + distNE + " E:" + distE + " SE:" + distSE + " S:"
                        + distS + " SW:" + distSW + " W:" + distW + " NW:" + distNW);
            }

            int count = distN + distNE + distE + distSE + distS + distSW + distW + distNW;
            System.out.println(count);
        }
    }
}
