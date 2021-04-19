package hackerrank.projecteuler.from101to125;

public class PE115 {
    static long[] cache2;

    public static long fill2(int fieldLength, int blockLength) {
        long solution = 1;
        if (blockLength > fieldLength) {
            return solution;
        }

        if (cache2[fieldLength] > 0) {
            return cache2[fieldLength];
        }

        for (int start = 0; start <= fieldLength - blockLength; start++) {
            for (int len = blockLength; len <= fieldLength - start; len++) {
                solution += fill2(fieldLength - start - len - 1, blockLength);
            }
        }
        cache2[fieldLength] = solution;
        return solution;
    }

    public static void main(String[] args) {
        cache2 = new long[50 + 10000 + 1];
        System.out.println(fill2(167, 50));
        System.out.println(fill2(168, 50));
        for (int i = 0; i < 10000; i++) {

            long n = fill2(i + 50, 50);
            if (n > 1_000_000) {
                System.out.println(i);
                break;
            }
        }
    }
}
