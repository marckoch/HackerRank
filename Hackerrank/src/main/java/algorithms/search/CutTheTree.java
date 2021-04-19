package algorithms.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author marckoch
 */
public class CutTheTree {

    static class Graph {

        private final int[] vWeights;
        private int totalWeight;
        private final Set<Integer> weights = new HashSet<>();

        private final LinkedList<Integer>[] edges;

        Graph(int[] vWeights) {
            this.vWeights = vWeights;
            for (int vWeight : vWeights) {
                this.totalWeight += vWeight;
            }

            this.edges = new LinkedList[vWeights.length];
            for (int i = 0; i < edges.length; ++i) {
                edges[i] = new LinkedList();
            }
        }

        void addEdge(int v, int w) {
            edges[v].add(w);
            edges[w].add(v);
        }

        void removeEdge(int v, int w) {
            // cast to Object to call remove(Object) method!
            edges[v].remove((Object) w);
            edges[w].remove((Object) v);
        }

        int getTotalWeight() {
            return this.totalWeight;
        }

        int getWeightFromRoot() {
            return dfs(1, new HashSet<>());
        }

        int dfs(int vertex, Set<Integer> visited) {
            int weight = vWeights[vertex];
            visited.add(vertex);
            for (Integer neighbor : edges[vertex]) {
                if (!visited.contains(neighbor)) {
                    weight += dfs(neighbor, visited);
                }
            }
            weights.add(weight);
            return weight;
        }

        public Set<Integer> getWeights() {
            return this.weights;
        }

        void print() {
            System.err.println(Arrays.toString(vWeights));
            System.err.println(Arrays.toString(edges));
            for (int i = 0; i < edges.length; ++i) {
                System.err.println(i + " " + edges[i]);
            }
        }
    }

    static int cutTheTree(int[] data, int[][] edges) {
        Graph g = new Graph(data);
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            g.addEdge(edge[0], edge[1]);
        }

        //g.print();
        //System.err.println("weight " + g.getTotalWeight());
        System.err.println(g.getWeightFromRoot());
        //g.getWeightFromRoot();
        //System.err.println(g.getWeights());
        int minDiff = Integer.MAX_VALUE;

        for (int w : g.getWeights()) {
            int rest = g.getTotalWeight() - w;
            int diff = Math.abs(w - rest);
            minDiff = Math.min(minDiff, diff);
        }

        // this is too slow
//        for (int[] edge : edges) {
//            g.removeEdge(edge[0], edge[1]);
//            
//            int weight = g.getWeightFromRoot();
//            int rest = g.getTotalWeight() - weight;
//            int diff = Math.abs(weight - rest);
//            minDiff = Math.min(minDiff, diff);
//            
//            g.addEdge(edge[0], edge[1]);
//        }
        return minDiff;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();

            int[] data = new int[n + 1];
            for (int i = 0; i < n; i++) {
                data[i + 1] = in.nextInt();
            }

            int[][] edges = new int[n - 1][2];
            for (int r = 0; r < n - 1; r++) {
                for (int c = 0; c < 2; c++) {
                    edges[r][c] = in.nextInt();
                }
            }

            int result = cutTheTree(data, edges);
            System.out.println(result);
        }
    }
}
