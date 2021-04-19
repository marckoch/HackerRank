package hackerrank.projecteuler.from051to075;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Permuted multiples
 *
 * @author marckoch
 */
public class PE052 {

    private static int digitFrequency(long x) {
        int result = 0;
        while (x > 0) {
            long digit = x % 10;

            int pos = 1;
            for (int i = 1; i <= digit; i++) {
                pos *= 10;
            }
            result += pos;

            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        for (int i = 125873; i < N; i++) {
            int df = digitFrequency(i);

            List<Integer> numbers = new ArrayList<>();
            numbers.add(i);
            for (int k = 2; k <= K; k++) {
                int dfK = digitFrequency(k * i);
                if (dfK == df) {
                    numbers.add(k * i);
                } else {
                    numbers.clear();
                    break;
                }
            }
            if (numbers.size() > 1) {
                String line = numbers
                        .stream()
                        .map(t -> String.valueOf(t))
                        .collect(Collectors.joining(" "));
                System.out.println(line);
            }
        }
    }
}
