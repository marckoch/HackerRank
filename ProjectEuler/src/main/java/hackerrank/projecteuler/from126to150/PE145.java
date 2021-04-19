package hackerrank.projecteuler.from126to150;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PE145 {

    public static void solveProjectEuler() throws Exception {
        final long LIMIT = 1_000_000_000;

        int count = 0;

        for (long i = 1; i < LIMIT; i++) {
            // leading zero not allowed!
            if (i % 10 == 0) {
                continue;
            }

            long reverse = reverse(i);
            long sum = i + reverse;
            boolean hasOnlyOddDigits = hasOnlyOddDigits(sum);
            if (hasOnlyOddDigits) {
                //System.out.println(String.format("%s + %s = %s -> %s", i, reverse, sum, hasOnlyOddDigits));
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean hasOnlyOddDigits(long number) {
        while (number > 0) {
            int lastdigit = (int)number % 10;
            if (lastdigit % 2 == 0) {
                return false;
            }
            number = number / 10;
        }
        return true;
    }

    private static long reverse(long number) {
        long result=0;
        while (number>0) {
            int lastDigit = (int)number % 10;
            number /= 10;
            result *=10;
            result += lastDigit;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        solveProjectEuler();
        //solveHackerrank();
    }
}
