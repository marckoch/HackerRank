package toolbox.graph;

import java.util.List;
import java.util.Map;

public class MinimalSpanningTree {

    public static void findMST(int[][] matrix) {
        printMatrix(matrix, "\t");

        List<Map.Entry<List<Integer>, Integer>> edgesSorted = Graphs.getEdgesSorted(matrix);
        System.out.println("edges: " + edgesSorted.size());

        long weightBefore = Graphs.getWeight(matrix);

        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        solve(newMatrix, edgesSorted);

        printMatrix(newMatrix, "\t");

        long weightAfter = Graphs.getWeight(newMatrix);

        System.out.println("weight before=" + weightBefore + ", weightAfter=" + weightAfter + ", saving=" + (weightBefore - weightAfter));
    }

    // minimal spanning tree MST
    private static void solve(int[][] matrix, List<Map.Entry<List<Integer>, Integer>> edges) {
        while (!edges.isEmpty()) {
            Map.Entry<List<Integer>, Integer> cheapestEdge = edges.remove(0);

            List<Integer> edge = cheapestEdge.getKey();
            int from = edge.get(0);
            int to = edge.get(1);
            int cost = cheapestEdge.getValue();

            matrix[from][to] = cost;
            matrix[to][from] = cost;

            //System.out.println("adding edge " + from + "->" + to + " cost=" + cost);

            if (!Graphs.findAllCycles(matrix).isEmpty()) {
                //System.out.println("we created a cycle!");
                // undo and forget last added edge
                matrix[from][to] = 0;
                matrix[to][from] = 0;
            } else {
                if (Graphs.isMinimalSpanningTree(matrix)) {
                    System.out.println("we found a MST with no cycles!");
                }
            }
        }
    }

    public static void printMatrix(int[][] A, String delimiter) {
        System.out.println("-------");
        for (int[] row : A) {
            String del = "";
            for (int i : row) {
                System.out.print(del + i);
                del = delimiter;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {0, 16, 12, 21},
                {16, 0, 0, 17},
                {12, 0, 0, 28},
                {21, 17, 28, 0}};

        int[][] matrix2 = {
                {0, 16, 12},
                {16, 0, 0},
                {12, 0, 0}};

        int[][] matrix3 = {
                {0, 16, 12, 21, 0, 0, 0},
                {16, 0, 0, 17, 20, 0, 0},
                {12, 0, 0, 28, 0, 31, 0},
                {21, 17, 28, 0, 18, 19, 23},
                {0, 20, 0, 18, 0, 0, 11},
                {0, 0, 31, 19, 0, 0, 27},
                {0, 0, 0, 23, 11, 27, 0}};

        int[][] matrix4 = {
                {0, 16, 1, 1, 0, 0, 0},
                {16, 0, 0, 17, 20, 0, 0},
                {1, 0, 0, 28, 0, 31, 0},
                {1, 17, 28, 0, 18, 19, 23},
                {0, 20, 0, 18, 0, 0, 11},
                {0, 0, 31, 19, 0, 0, 27},
                {0, 0, 0, 23, 11, 27, 0}};

        findMST(matrix4);
    }
}
