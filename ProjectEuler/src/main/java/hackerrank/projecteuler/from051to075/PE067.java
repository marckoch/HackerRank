package hackerrank.projecteuler.from051to075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Maximum path sum II
 *
 * @author marckoch
 */
public class PE067 {

    public static long sum(long[][] numbers) {
        for (int row = numbers.length - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                numbers[row][col] += Math.max(numbers[row + 1][col], numbers[row + 1][col + 1]);
            }
        }

        for (long[] number : numbers) {
            System.err.println(Arrays.toString(number));
        }

        return numbers[0][0];
    }

    // solution for hackerrank
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for(int a0 = 0; a0 < t; a0++){
//            int rows = in.nextInt();
//            
//            int[][] numbers = new int[rows][rows];
//            
//            // read array
//            int rowCount=0;
//            for (int j=0; j<rows; j++) {
//                in.nextLine();
//                for (int k=0; k<=rowCount; k++) {
//                    int n = in.nextInt();
//                    numbers[rowCount][k] = n;
//                }
//                rowCount++;
//            }
//            
//            // print array
//            for (int[] number : numbers) {
//                System.err.println(Arrays.toString(number));
//            }
//
//            // find max sum
//            System.out.println(sum(numbers));
//        }
//    }
    
    public static long[][] readArrayFromFile(int dim, String fqn) throws IOException {
        long[][] array = new long[dim][dim];

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try (InputStream is = classloader.getResourceAsStream(fqn);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            int rowCount = 0;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                int wordCount = 0;
                for (String word : words) {
                    array[rowCount][wordCount++] = Integer.valueOf(word);
                }

                rowCount++;
            }
        }

        printArray(array);

        return array;
    }
    
    // solution for projecteuler.net problem
    public static void main(String[] args) throws IOException {

        long[][] numbers = readArrayFromFile(100, "hackerrank/projecteuler/from051to075/p067_triangle.txt");
        
        // find max sum
        System.out.println(sum(numbers));
    }

    static void printArray(long[][] A) {
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < A[0].length; c++) {
                System.err.print(A[r][c] + " \t");
            }
            System.err.println();
        }
    }
}
