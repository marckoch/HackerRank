package hackerrank.projecteuler.from101to125;

import java.util.Stack;

public class PE117 {
    static long[] cache;
    static int count = 0;

    // too slow to solve fieldLength=50!
    public static long fill(int fieldLength, Stack<Integer> path) {
        if (fieldLength < 1) {
            count++;
            if (count % 10_000_000 == 0) {
                System.out.println(path);
            }
            return 0;
        }
        for (int i = 1; i <= 4; i++) {
            if (i <= fieldLength) {
                path.push(i);
                fill(fieldLength - i, path);
                path.pop();
            }
        }
        return 0;
    }

    public static long fill2(int fieldLength, int blockLength) {
        long solution = 1;
        if (blockLength > fieldLength) {
            return solution;
        }

        if (cache[fieldLength] > 0) return cache[fieldLength];

        for (int start = 0; start <= fieldLength - blockLength; start++) {
            for (int len = blockLength; len <= Math.min(4, fieldLength - start); len++) { // len can be max 4
                solution += fill2(fieldLength - start - len, blockLength);  // no -1 here! no more gap like in PE114!
            }
        }
        cache[fieldLength] = solution;
        return solution;
    }

    public static void main(String[] args) {
        final int fieldLength = 50;

        // fill(fieldLength, new Stack<>());
        //System.out.println(count);

        cache = new long[fieldLength + 1];
        long solution = fill2(fieldLength, 2);
        System.out.println(solution);

    }
}
