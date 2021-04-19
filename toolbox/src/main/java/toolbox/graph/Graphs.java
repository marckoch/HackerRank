package toolbox.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 */
public class Graphs {

    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int[][] matrix = {
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
                {0, 0, 12, 0},
                {0, 0, 0, 17},
                {12, 0, 0, 28},
                {0, 17, 28, 0}};

        //isConnectedGraph(matrix4);

        //findAllCycles(matrix);

        Map<List<Integer>, Integer> edges = getEdges(matrix);
        System.out.println(edges);
        List<Map.Entry<List<Integer>, Integer>> sortedEdges = getEdgesSorted(matrix);
        System.out.println(sortedEdges);
    }

    public static boolean isConnectedGraph(int[][] matrix) {
        // TODO we could/should short circuit the search by aborting when we find the first graph
        Map<Stack<Integer>, Integer> allPathsInGraph = findAllPathsInGraph(matrix);
        return !allPathsInGraph.isEmpty();
    }

    public static Map<Stack<Integer>, Integer> findAllPathsInGraph(int[][] matrix) {
        Map<Stack<Integer>, Integer> paths = new HashMap<>();
        // start from every node
        IntStream.range(0, matrix.length).forEach(
                i -> {
                    Stack<Integer> path = new Stack<>();
                    path.push(i);
                    traverseGraph(matrix, i, path, paths, 0);
                }
        );
        return paths;
    }

    public static boolean traverseGraph(int[][] matrix, int node, Stack<Integer> path, Map<Stack<Integer>, Integer> paths, int cost) {
        if (path.size() == matrix.length) {
            System.out.println("path found: " + path + " " + cost);
            Stack<Integer> copy = new Stack<>();
            copy.addAll(path);
            paths.put(copy, cost);
            return true;
        }
        // find nodes we can travel to
        List<Integer> candidates =
                IntStream.range(0, matrix.length)
                        .map(i -> (matrix[node][i] > 0) ? i : -1)
                        .filter(i -> i >= 0)
                        .boxed()
                        .collect(Collectors.toList());

        for (int cand : candidates) {
            if (!path.contains(cand)) {
                path.push(cand);
                cost += matrix[node][cand];
                traverseGraph(matrix, cand, path, paths, cost);
                path.pop();
                cost -= matrix[node][cand];
            }
        }
        return false;
    }

    public static List<Stack<Integer>> findAllCycles(int[][] matrix) {
        List<Stack<Integer>> cycles = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            Stack<Integer> path = new Stack<>();
            path.push(i);
            detectCycleRecursive(matrix, i, path, cycles);
        }

        //cycles.forEach(System.out::println);
        return cycles;
    }

    public static boolean detectCycleRecursive(int[][] matrix, int node, Stack<Integer> path, List<Stack<Integer>> cycles) {
        if (path.size() == matrix.length) {
            return false;
        }
        // find nodes we can travel to
        List<Integer> candidates =
                IntStream.range(0, matrix.length)
                        .map(i -> (matrix[node][i] > 0) ? i : -1)
                        .filter(i -> i >= 0)
                        .boxed()
                        .collect(Collectors.toList());

        for (int cand : candidates) {
            if (!path.contains(cand)) {
                path.push(cand);
                detectCycleRecursive(matrix, cand, path, cycles);
                path.pop();
            } else {
                if (path.indexOf(cand) < path.size() - 2) {
                    //System.out.println("cycle detected: " + path);
                    Stack<Integer> copy = new Stack<>();
                    copy.addAll(path);
                    copy.sort(Integer::compareTo);
                    if (!cycles.contains(copy)) {
                        cycles.add(copy);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static Map<List<Integer>, Integer> getEdges(int[][] matrix) {
        Map<List<Integer>, Integer> edge2cost = new HashMap<>();

        for (int row = 0; row < matrix.length; row++) {
            int[] rowArr = matrix[row];
            for (int col = 0; col < rowArr.length; col++) {
                int cost = matrix[row][col];
                if (cost > 0 && row < col) {
                    List<Integer> edge = new ArrayList<>();
                    edge.add(row);
                    edge.add(col);
                    edge2cost.put(edge, cost);
                }
            }
        }

        return edge2cost;
    }

    public static List<Map.Entry<List<Integer>, Integer>> getEdgesSorted(int[][] matrix) {
        Map<List<Integer>, Integer> edges = getEdges(matrix);
        return edges.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).collect(Collectors.toList());
    }

    public static int getNodeCount(int[][] matrix) {
        return matrix.length;
    }

    public static int getEdgeCount(int[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                int val = matrix[row][col];
                if (val > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long getWeight(int[][] matrix) {
        long count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                long weight = matrix[row][col];
                if (weight > 0) {
                    count += weight;
                }
            }
        }
        return count;
    }

    public static boolean isMinimalSpanningTree(int[][] matrix) {
        return (getNodeCount(matrix) == getEdgeCount(matrix) + 1);
    }
}
