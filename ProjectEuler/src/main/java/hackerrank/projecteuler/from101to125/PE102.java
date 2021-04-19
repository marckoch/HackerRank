package hackerrank.projecteuler.from101to125;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class PE102 {

    public static List<String> readFile(final String filename) throws Exception {
        final Path path = Paths.get(PE102.class.getClassLoader().getResource(filename).toURI());

        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.toList());
        }
    }

    public static void solveProjectEuler() throws Exception {
        List<String> lines = readFile("hackerrank/projecteuler/from101to125/p102_triangles.txt");

        final int[] origin = new int[]{0, 0};

        int countHits = 0;

        for (final String line : lines) {
            String[] numbers = line.split(",");

            int[] pointA = point(numbers[0], numbers[1]);
            int[] pointB = point(numbers[2], numbers[3]);
            int[] pointC = point(numbers[4], numbers[5]);

//            System.out.println(Arrays.toString(pointA));
//            System.out.println(Arrays.toString(pointB));
//            System.out.println(Arrays.toString(pointC));

            int bigTriangle = calculateDoubleTriangleArea(pointA, pointB, pointC);

            int triangle1 = calculateDoubleTriangleArea(pointA, pointB, origin);
            int triangle2 = calculateDoubleTriangleArea(pointB, pointC, origin);
            int triangle3 = calculateDoubleTriangleArea(pointC, pointA, origin);

            if (triangle1 + triangle2 + triangle3 == bigTriangle) {
                System.err.println("line matches: " + line);
                countHits++;
            }
        }
        System.out.println("lines matching: " + countHits);
    }

    //https://www.mathopenref.com/coordtrianglearea.html
    // return 2 * area to keep integers and avoid floating point arithmetic
    private static int calculateDoubleTriangleArea(int[] pointA, int[] pointB, int[] pointC) {
        return Math.abs(
                x(pointA) * (y(pointB) - y(pointC)) //
                        + x(pointB) * (y(pointC) - y(pointA)) //
                        + x(pointC) * (y(pointA) - y(pointB))
        );
    }

    private static int x(int[] point) {
        return point[0];
    }

    private static int y(int[] point) {
        return point[1];
    }

    private static int[] point(String x, String y) {
        return new int[]{Integer.parseInt(x), Integer.parseInt(y)};
    }

    public static void main(String[] args) throws Exception {
        solveProjectEuler();
        //solveHackerrank();
    }
}
