package algorithms.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class EmasSupercomputer {

    static class Cross implements Comparable<Cross> {

        int row;
        int col;
        int size; // length of the arm of the cross

        public Cross(int row, int col, int size) {
            this.row = row;
            this.col = col;
            this.size = size;
        }

        public int getLength() {
            return 1 + 2 * size;
        }

        public int getArea() {
            return 1 + 4 * size;
        }

        @Override
        public String toString() {
            return "Cross{" + "row=" + row + ", col=" + col + ", size=" + size + ", area=" + getArea() + "}";
        }

        @Override
        public int compareTo(Cross that) {
            // sort by size DESCENDING
            return -(this.size - that.size);
        }
    }

    private static void debPrintArray(char[][] a) {
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                System.err.print(a[r][c] == 'G' ? '.' : a[r][c]);
            }
            System.err.println();
        }
    }

    public static char[][] deepCopy(char[][] original) {
        if (original == null) {
            return null;
        }

        final char[][] result = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int R = in.nextInt(); // rows
            int C = in.nextInt(); // cols

            char[][] initialArray = new char[R][C];
            for (int r = 0; r < R; r++) {
                in.nextLine();
                char[] s = in.next().toCharArray();
                for (int c = 0; c < C; c++) {
                    initialArray[r][c] = s[c];
                }
            }
            debPrintArray(initialArray);

            solve(R, C, initialArray);
        }
    }

    static void solve(int R, int C, char[][] initialArray) {
        int maxSizeOfCross = Math.min(R, C);
        // if length is even we substract 1 because cross has odd length
        if (maxSizeOfCross % 2 == 0) {
            maxSizeOfCross--;
        }
        //System.err.println("maxLengthOfCross=" + maxLengthOfCross);

        List<Cross> listCrosses = new ArrayList<>();

        for (int size = maxSizeOfCross; size > 0; size -= 2) {
            //System.err.println("placing cross with size " + size);
            int armLength = size / 2;
            for (int row = armLength; row < R - armLength; row++) {
                for (int col = armLength; col < C - armLength; col++) {
                    if (isFree(initialArray, row, col, armLength)) {
                        //System.err.printf("cross of length %s can fit here (%s|%s)\n", size, row, col);
                        listCrosses.add(new Cross(row, col, armLength));
                    }
                }
            }
        }
        Collections.sort(listCrosses);
        System.err.println(listCrosses);

        // brute force method, just try all found crosses
        // place one cross and try to add each smaller one
        int maxArea = 0;
        for (int c1 = 0; c1 < listCrosses.size() - 1; c1++) {
            char[][] array = deepCopy(initialArray);

            Cross cross1 = listCrosses.get(c1);
            placeCross(array, cross1);
            //debPrintArray(array);

            for (int c2 = c1 + 1; c2 < listCrosses.size(); c2++) {
                Cross cross2 = listCrosses.get(c2);

                if (isFree(array, cross2)) {
                    placeCross(array, cross2);
                    //debPrintArray(array);
                    int area = cross1.getArea() * cross2.getArea();
                    if (area > maxArea) {
                        System.err.println("found new maximum!");
                        maxArea = area;
                        debPrintArray(array);
                    }
                    removeCross(array, cross2);
                }
            }
            removeCross(array, cross1);
        }
        System.out.println(maxArea);
    }

    // check if a cross of length can fit in position r/c in given array
    // that means at point (r/c) 'length' fields must be 
    // free above, left, right and down
    static boolean isFree(char[][] array, int r, int c, int armLength) {
        for (int row = r - armLength; row <= r + armLength; row++) {
            if (array[row][c] == 'B' || array[row][c] == 'C') {
                return false;
            }
        }
        for (int col = c - armLength; col <= c + armLength; col++) {
            if (array[r][col] == 'B' || array[r][col] == 'C') {
                return false;
            }
        }
        return true;
    }

    static boolean isFree(char[][] array, Cross cross) {
        return isFree(array, cross.row, cross.col, cross.size);
    }

    static void placeCross(char[][] array, int r, int c, int armLength) {
        for (int row = r - armLength; row <= r + armLength; row++) {
            array[row][c] = 'C';
        }
        for (int col = c - armLength; col <= c + armLength; col++) {
            array[r][col] = 'C';
        }
    }

    static void placeCross(char[][] array, Cross cross) {
        placeCross(array, cross.row, cross.col, cross.size);
    }

    static void removeCross(char[][] array, int r, int c, int armLength) {
        for (int row = r - armLength; row <= r + armLength; row++) {
            array[row][c] = '.';
        }
        for (int col = c - armLength; col <= c + armLength; col++) {
            array[r][col] = '.';
        }
    }

    static void removeCross(char[][] array, Cross cross) {
        removeCross(array, cross.row, cross.col, cross.size);
    }
}
