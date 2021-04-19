package hackerrank.projecteuler.from076to100;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


/**
 *
 */
public class PE098 {

    private static final char NULL_CHAR = '\u0000';

    private static final Map<Integer, List<String>> squaresByLength = new HashMap<>();

    private static List<Integer> squares = new ArrayList<>();

    public static List<String> readFile(final String filename) throws Exception {
        final Path path = Paths.get(PE098.class.getClassLoader().getResource(filename).toURI());
        final String oneAndOnlyLine = Files.readAllLines(path).get(0);
        return Arrays.stream(oneAndOnlyLine.split(","))
                .map(PE098::unquote)
                .collect(Collectors.toList());
    }

    // remove " from beginning and end
    private static String unquote(String w) {
        return w.substring(1, w.length() - 1);
    }

    public static void solveProjectEuler() throws Exception {
        final List<String> words = readFile("hackerrank/projecteuler/from076to100/p098_words.txt");

        final int maxLength = words.stream()
                .mapToInt(String::length)
                .max().orElse(0);

        System.out.println("maxlength=" + maxLength);

        Comparator<Map.Entry<String, List<String>>> descendingByValueLength = (o1, o2) -> o2.getValue().get(0).length() - o1.getValue().get(0).length();

        Map<String, List<String>> anagrams = words.stream()
                .collect(Collectors.groupingBy(s -> fingerPrint(s)))
                .entrySet().stream().filter(PE098::moreThanOneEntry)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        anagrams.entrySet().stream()
                .sorted(descendingByValueLength)
                .forEach(s -> System.out.println(s));

//        words.stream()
//                .sorted(Comparator.comparingInt(String::length).reversed())
//                .forEach(w -> System.out.println(w.length() + " " + w + " " + w.chars().distinct().count()));

//        words.stream()
//                .collect(Collectors.groupingBy(String::length))
//                .forEach((integer, s) -> System.out.println(integer + " " + s));

        //LongStream.rangeClosed(990_000, 1_000_000).map(i -> i*i).forEach(System.out::println);

        squaresByLength.putAll(
                LongStream.iterate(0, n -> n + 1)
                        .map(i -> i * i)
                        .mapToObj(String::valueOf)
                        .takeWhile(s -> s.length() < 10)
                        .collect(Collectors.groupingBy(String::length)));

        squaresByLength.forEach((integer, strings) -> System.out.println(integer + " " + strings.size() + " " + strings));

        anagrams.forEach((s, strings) -> processWord(strings));

        squares.stream().max(Comparator.comparingInt(o -> o)).ifPresent(System.out::println);
    }

    public static void processWord(List<String> anagrams) {
        anagrams.forEach(w -> {
                    String word = anagrams.get(0);
                    String partnerWord = anagrams.get(1);

                    List<char[]> mappings = findMappings(word);
                    for (char[] mapping : mappings) {
                        int partnerNumber = applyMapping(partnerWord, mapping);
                        if (squaresByLength.get(word.length()).contains(String.valueOf(partnerNumber))) {
                            System.out.println(partnerNumber + " is square: " + Math.round(Math.sqrt(partnerNumber)) + "^2");
                            squares.add(partnerNumber);
                            int number = applyMapping(word, mapping);
                            System.out.println(number + " is square: " + Math.round(Math.sqrt(number)) + "^2");
                            squares.add(number);
                        }
                    }
                }
        );
    }

    // try to match string to given number and find a mapping
    // if no mapping exists null is returned
    public static char[] getMapping(String str, String number) {
        char[] mapping = new char[10];

        for (int i = 0; i < number.length(); i++) {
            int digit = Character.getNumericValue(number.charAt(i));
            char char1 = str.charAt(i);
            if (mapping[digit] == NULL_CHAR) {
                mapping[digit] = char1;
            } else {
                //System.err.println(String.format("str=%s, number=%s: no mapping possible!", str, number));
                return null;
            }
        }

        //System.out.println(String.format("str=%s, square=%s (=%s^2): mapping=%s", str, number, Math.round(Math.sqrt(Integer.parseInt(number))), String.valueOf(mapping)));

        return mapping;
    }

    // for given string find all mappings that produce a square number of same length as the string
    // e.g. CARE -> 1296 with mapping A=2, C=1, R=9, E=6, mapping is given as char[] [,C,A,,,,E,,,R]
    // index of char in char[] defines the number char is mapped to!
    public static List<char[]> findMappings(String str) {
        List<String> squares = squaresByLength.get(str.length());
        List<char[]> mappings = new ArrayList<>();
        for (String square : squares) {
            char[] mapping = getMapping(str, square);
            if (mapping != null) {
                mappings.add(mapping);
            }
        }
        return mappings;
    }

    // apply given mapping to string and convert it to a number
    public static int applyMapping(String str, char[] mapping) {

        String result = str;
        for (int i = 0; i < mapping.length; i++) {
            if (mapping[i] != NULL_CHAR) {
                result = result.replace(mapping[i], Character.forDigit(i, 10));
            }
        }
        //System.out.println(String.format("applyMapping: str=%s with mapping=%s becomes %s", str, String.valueOf(mapping), result));
        return Integer.parseInt(result);
    }

    // return the chars sorted
    public static String fingerPrint(String input) {
        return new String(input.chars().sorted().toArray(), 0, input.length());
    }

    public static void main(String[] args) throws Exception {
        solveProjectEuler();
        //solveHackerrank();
    }

    private static boolean moreThanOneEntry(Map.Entry<String, List<String>> e) {
        return e.getValue().size() > 1;
    }
}
