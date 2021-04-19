package hackerrank.projecteuler.from176to200;

import org.junit.Assert;
import toolbox.permutations.Combinations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author marckoch
 */
public class PE191 {

    // will not work for big numbers, because we cannot create 30 digit combinations like this (OutOfMemory)
    // solutions suggest using dynamic programming
    public static void solveProjectEuler() {
        List<String> rawCombis = Combinations.generateCombinationsWithRep(new int[]{0, 1, 2}, 15);

        List<String> strings = rawCombis.stream()
                .map(PE191::map)
                .collect(Collectors.toList());
        System.out.println(strings.size() + " initial combinations");

        List<String> filteredList = strings.stream()
                .filter(s -> {
                    boolean absent = s.contains("AAA");
                    if (absent) {
                        //System.out.println(s + " >> absent!");
                        return false;
                    } else {
                        //System.out.println(s);
                        return true;
                    }
                })
                .filter(
                        s -> {
                            boolean late = checkIfLateMoreThanOnce(s);
                            if (late) {
                                //System.out.println(s + " >> late!");
                                return false;
                            } else {
                                return true;
                            }
                        }
                )
                .collect(Collectors.toList());

        System.out.println(filteredList.size() + " price strings");
    }

    private static String map(String in) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            sb.append(map2(in.charAt(i)));
        }
        return sb.toString();
    }

    private static char map2(char x) {
        switch (x) {
            case '0':
                return 'O';
            case '1':
                return 'L';
            case '2':
                return 'A';
            default:
                throw new IllegalStateException("Unexpected value: " + x);
        }
    }

    private static boolean checkIfLateMoreThanOnce(String s) {
        int countLate = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                countLate++;
                if (countLate > 1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solveProjectEuler();
    }
}
