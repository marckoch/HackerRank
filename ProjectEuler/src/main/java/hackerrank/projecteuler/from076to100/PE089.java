package hackerrank.projecteuler.from076to100;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 */
public class PE089 {

    // we need a structure ordered by value, not key (>> use basic Object[][])
    // the order is important! "IX" should match before "I"!!
    static Object[][] ROMAN_PREFIXES = {
            {"M", 1000},
            {"CM", 900},
            {"D", 500},
            {"CD", 400},
            {"C", 100},
            {"XC", 90},
            {"L", 50},
            {"XL", 40},
            {"X", 10},
            {"IX", 9},
            {"V", 5},
            {"IV", 4},
            {"I", 1}
    };


    public static List<String> readFile(final String filename) throws Exception {
        final Path path = Paths.get(PE089.class.getClassLoader().getResource(filename).toURI());

        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.toList());
        }
    }

    public static void solveProjectEuler() throws Exception {
        final List<String> strings = readFile("hackerrank/projecteuler/from076to100/p089_roman.txt");

        //strings.forEach(s -> System.err.println(s + " = " + roman2int(s)));

        int saved=0;
        for (String line : strings) {
            int n = roman2int(line);

            String optimizedString = int2roman(n);

            saved += (line.length() - optimizedString.length());
        }
        System.out.println(saved);
    }

    public static int roman2int(final String roman) {
        String remaining = roman;
        int sum = 0;

        while (!remaining.isEmpty()) {
            for (Object[] prefix2value : ROMAN_PREFIXES) {
                final String prefix = (String) prefix2value[0];
                if (remaining.startsWith(prefix)) {
                    final int value = (int) prefix2value[1];
                    sum += value;
                    remaining = remaining.substring(prefix.length());
                }
            }
        }
        return sum;
    }

    public static String int2roman(int number) {
        final StringBuilder sb = new StringBuilder();

        outer:
        while (number > 0) {
            for (Object[] prefix2value : ROMAN_PREFIXES) {
                final int value = (int) prefix2value[1];
                if (number >= value) {
                    number -= value;
                    final String prefix = (String) prefix2value[0];
                    sb.append(prefix);
                    continue outer;
                }
            }
        }
        return sb.toString();
    }

    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            final String line = in.next();
            int n = roman2int(line);

            String optimizedString = int2roman(n);
            System.out.println(optimizedString);
        }
    }

    public static void main(String[] args) throws Exception {
        //solveProjectEuler();
        solveHackerrank();
    }
}
