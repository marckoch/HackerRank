package weekofcode35.matrixland;

/**
 *
 * @author marckoch
 */
public class MatrixLand {

    static int max(int a, int b, int c) {
        int maxAB = Math.max(a, b);
        return Math.max(maxAB, c);
    }

    static void print(int[][] A) {
        for (int n = 0; n < A.length; n++) {
            for (int m = 0; m < A[0].length; m++) {
                System.err.print(A[n][m] + " \t");
            }
            System.err.println();
        }
    }

    static int matrixLand(int[][] A, int R, int C) {
        int[][] sum = new int[R][C];

        for (int r = R - 1; r >= 0; r--) {
            for (int c = 0; c < C; c++) {
                int down = (r == R - 1) ? 0 : sum[r + 1][c];
                int left = (c == 0) ? 0 : sum[r][c - 1];
                int right = (c == C - 1) ? 0 : sum[r][c + 1];

                System.err.printf("%s %s left=%s down=%s right=%s max=%s\n", r, c, left, down, right, max( down, right, left));
                sum[r][c] = A[r][c] + max(down, right, left);
                print(sum);
            }
        }
        return sum[R - 1][C - 1];
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int R = in.nextInt();
//        int C = in.nextInt();
//        int[][] A = new int[R][C];
//        for (int r = 0; r < R; r++) {
//            for (int c = 0; c < C; c++) {
//                A[r][c] = in.nextInt();
//            }
//        }

        int R = 4;
        int C = 5;
        int[][] A = {
            {1, 2, 3, -1, -2},
            {-5, -8, -1, 2, -150},
            {1, 2, 3, -250, 100},
            {1, 1, 1, 1, 20}
        };
        print(A);
        
        int result = matrixLand(A, R, C);

        System.out.println(result);

        // in.close();
    }
}
