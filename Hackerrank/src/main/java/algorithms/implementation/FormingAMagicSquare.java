package algorithms.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author marckoch
 */
public class FormingAMagicSquare {

    // https://en.wikipedia.org/wiki/Magic_square#Method_for_constructing_a_magic_square_of_order_3
    static Integer[][] buildMagicSquare(int a, int b) {
        return new Integer[][]{
            {5 - b, 5 + (a + b), 5 - a},
            {5 - (a - b), 5, 5 + (a - b)},
            {5 + a, 5 - (a + b), 5 + b}
        };
    }

    // check if magic square is valid, that means each number from
    // 1 - 9 is there once
    // method buildMagicSquare can given some illegal combinations
    // (with negativ numbers or 0)
    static boolean isValidMagicSquare(Integer[][] array) {
        Set<Integer> numbers = new HashSet<>();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (array[r][c] < 1 || array[r][c] > 9) {
                    return false;
                }
                if (!numbers.add(array[r][c])) {
                    return false;
                }
            }
        }
        return true;
    }

    static List<Integer[][]> generateMagicSquares() {
        List<Integer[][]> magicSquares = new ArrayList<>();
        for (int a = -4; a < 5; a++) {
            for (int b = -4; b < 5; b++) {
                Integer[][] ms = buildMagicSquare(a, b);

                if (isValidMagicSquare(ms)) {
                    //System.err.printf("a=%s b=%s isMagic=%s\n", a, b, isValidMagicSquare(ms));
                    //Arrays.stream(ms).forEach((t) -> {
                    //    System.err.println(Arrays.toString(t));
                    //});
                    magicSquares.add(ms);
                }
            }
        }
        return magicSquares;
    }

    static int formingMagicSquare(int[][] s) {
        // build every valid magic square and compare the cost of converting
        // the given array into each magic square
        // find minimum cost of all these operations
        List<Integer[][]> magicSquares = generateMagicSquares();
        
        int minCost=Integer.MAX_VALUE;
        
        for (Integer[][] magicSquare : magicSquares) {
            int cost=0;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    cost += Math.abs(magicSquare[r][c] - s[r][c]);
                }
            }
            minCost = Math.min(minCost, cost);
        }
        
        return minCost;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int[][] s = new int[3][3];
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    s[r][c] = in.nextInt();
                }
            }
            
            int result = formingMagicSquare(s);
            System.out.println(result);
        }
    }
}
