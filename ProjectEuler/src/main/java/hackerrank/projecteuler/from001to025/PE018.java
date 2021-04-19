package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * Maximum path sum I
 *
 * @author marckoch
 */
public class PE018 {
    public static int sum(int x, int y, int[][] numbers) {
        if (x == numbers.length) return 0;

        int n = numbers[x][y];

        //System.err.println(x + " " + y + " " + n);

        int sumLeft = n + sum(x + 1, y, numbers);
        int sumRight = n + sum(x + 1, y + 1, numbers);

        return Math.max(sumLeft, sumRight);
    }

    public static void main(String[] args) {
        solvePE();
    }

    public static void solveHackerRank() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int rows = in.nextInt();
            //System.err.println(rows);

            int[][] numbers = new int[rows][rows];

            // read array
            int rowCount = 0;
            for (int j = 0; j < rows; j++) {
                in.nextLine();
                for (int k = 0; k <= rowCount; k++) {
                    int n = in.nextInt();
                    numbers[rowCount][k] = n;
                }
                rowCount++;
            }

            // print array
            //for (int r=0; r<numbers.length; r++) {
            //System.err.println(Arrays.toString(numbers[r]));
            //}

            // find max sum
            System.out.println(sum(0, 0, numbers));
        }
    }

    public static void solvePE() {
        int[][] triangle = {
                {75},
                {95, 64},
                {17, 47, 82},
                {18, 35, 87, 10},
                {20, 4, 82, 47, 65},
                {19, 1, 23, 75, 3, 34},
                {88, 2, 77, 73, 7, 63, 67},
                {99, 65, 4, 28, 6, 16, 70, 92},
                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
        };

        System.out.println(sum(0, 0, triangle));
    }
}
