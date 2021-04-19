package hackerrank.projecteuler.from101to125;

import toolbox.graph.MinimalSpanningTree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class PE107 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        solve();
    }

    private static void solve() throws IOException, URISyntaxException {
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

        int[][] matrix4 = readMatrixFromFile();

        int[][] matrix5 = {
                {0, 16, 1, 1, 0, 0, 0},
                {16, 0, 0, 17, 20, 0, 0},
                {1, 0, 0, 28, 0, 31, 0},
                {1, 17, 28, 0, 18, 19, 23},
                {0, 20, 0, 18, 0, 0, 11},
                {0, 0, 31, 19, 0, 0, 27},
                {0, 0, 0, 23, 11, 27, 0}};

        MinimalSpanningTree.findMST(matrix4);
    }

    public static int[][] readMatrixFromFile() throws IOException, URISyntaxException {
        final String filename = "hackerrank/projecteuler/from101to125/p107_network.txt";
        final Path path = Paths.get(PE107.class.getClassLoader().getResource(filename).toURI());
        List<String> lines = Files.readAllLines(path);
        return lines.stream().map(s -> s.split(",")).map(PE107::toIntArray).toArray(int[][]::new);
    }

    public static int[] toIntArray(String[] strings) {
        return Arrays.stream(strings).mapToInt(s -> s.equals("-") ? 0 : Integer.parseInt(s)).toArray();
    }
}
