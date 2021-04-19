package hackerrank.projecteuler.from101to125;

public class PE116 {
    static long[][] cache;

    public static long fill(int fieldLength, int blockLength) {
        if (blockLength > fieldLength) {
            return 0;
        } else if (blockLength == fieldLength) {
            return 1;
        }

        if (cache[fieldLength][blockLength] > 0) {
            return cache[fieldLength][blockLength];
        }

        long solution = 0;
        for (int start = 0; start <= fieldLength - blockLength; start++) {
            solution++; // one block and nothing else

            // plus filling up the space to the right
            solution += fill(fieldLength - start - blockLength, blockLength);
        }
        cache[fieldLength][blockLength] = solution;
        return solution;
    }

    public static void main(String[] args) {

        final int fieldLength = 50;

        cache = new long[fieldLength + 1][5];

        long red = fill(fieldLength, 2);
        System.out.println(red);

        long green = fill(fieldLength, 3);
        System.out.println(green);

        long blue = fill(fieldLength, 4);
        System.out.println(blue);

        long sum = red + green + blue;
        System.out.println(sum);
    }
}
