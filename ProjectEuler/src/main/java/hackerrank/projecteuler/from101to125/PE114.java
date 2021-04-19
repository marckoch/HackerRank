package hackerrank.projecteuler.from101to125;

public class PE114 {
    final static int MIN_BLOCK_LENGTH = 2;
    static long[][] cache;
    static long[] cache2;

    public static void solveProjectEuler(int fieldLength) {
        cache = new long[fieldLength + 1][fieldLength + 1];

        long solution = fillField(fieldLength);
        solution++;  // when field is left empty
        System.out.println(solution);

        cache2 = new long[fieldLength + 1];
        solution = fill2(fieldLength, 2);
        System.out.println(solution);
    }

    public static long fillField(int fieldLength) {
        System.out.println("filling field " + fieldLength);
        long solution = 0;
        for (int i = MIN_BLOCK_LENGTH; i <= fieldLength; i++) {
            solution += fill(fieldLength, i);
        }
        return solution;
    }

    public static long fill(int fieldLength, int blocklength) {
        if (cache[fieldLength][blocklength] > 0) {
            return cache[fieldLength][blocklength];
        }
        System.out.println("placing block of length=" + blocklength + " on field of length=" + fieldLength);
        long count = 0;

        // block of length 'blocklength' wanders from 'start' to the right
        for (int start = 0; start <= fieldLength - blocklength; start++) {
            count++;

            // see if we can place more blocks to the right of current block
            int remainingFieldLength = fieldLength - start - blocklength - 1; // one space buffer
            count += fillField(remainingFieldLength);
        }

        cache[fieldLength][blocklength] = count;
        System.out.println("placing block of length=" + blocklength + " on field of length=" + fieldLength + " >> " + count);
        return count;
    }

    public static long fill2(int fieldLength, int blockLength) {
        long solution = 1;
        if (blockLength > fieldLength) {
            return solution;
        }

        if (cache2[fieldLength] > 0) return cache2[fieldLength];

        for (int start = 0; start <= fieldLength - blockLength; start++) {
            for (int len = blockLength; len <= fieldLength - start; len++) {
                solution += fill2(fieldLength - start - len - 1, blockLength); // -1 because of 1 free space betwwen blocks
            }
        }
        cache2[fieldLength] = solution;
        return solution;
    }

    public static void main(String[] args) {
        solveProjectEuler(5);
        //solveHackerrank();
    }
}
