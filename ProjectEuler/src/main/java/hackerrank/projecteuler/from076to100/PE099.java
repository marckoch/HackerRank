package hackerrank.projecteuler.from076to100;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 *
 */
public class PE099 {

    public static List<String> readFile(final String filename) throws Exception {
        final Path path = Paths.get(PE099.class.getClassLoader().getResource(filename).toURI());

        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.toList());
        }
    }

    /*
     * to compare two numbers a^b < x^y -> log (a^b) < log (x^y) -> b * log a < y * log x
     * */
    public static void solveProjectEuler() throws Exception {
        final List<String> strings = readFile("hackerrank/projecteuler/from076to100/p099_base_exp.txt");

        int lineNumber = 0;

        int maxLineNumber = 0;
        double maximum = 0.0d;

        for (String line : strings) {
            lineNumber++;
            System.err.println(lineNumber + " " + line);
            String[] parts = line.split(",");
            String base = parts[0];
            String exp = parts[1];

            double result = Integer.valueOf(exp) * Math.log(Double.valueOf(base));

            System.err.println(lineNumber + " " + line + " -> " + result);
            if (result > maximum) {
                maxLineNumber = lineNumber;
                maximum = result;
                System.err.println(MessageFormat.format("new maximum found in line {0}: {1}", maxLineNumber, maximum));
            }
        }
        System.out.println(MessageFormat.format("maximum found in line {0}: {1}", maxLineNumber, maximum));


    }

    public static void main(String[] args) throws Exception {
        solveProjectEuler();
        //solveHackerrank();
    }
}
