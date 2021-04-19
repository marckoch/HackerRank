package hackerrank.projecteuler.from076to100;

import toolbox.permutations.Combinations;

import java.util.List;

/**
 *
 */
public class PE090 {

    public static void solveProjectEuler() {
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int countValidCube = 0;

        List<List<Integer>> cubeCombis = Combinations.generateCombinationsNoRepAsList(digits, 6);

        for (List<Integer> cube1 : cubeCombis) {
            for (List<Integer> cube2 : cubeCombis) {
                boolean valid = checkCubes(cube1, cube2);
                if (valid) {
                    System.out.println("valid: " + cube1 + " " + cube2);
                    countValidCube++;
                }
            }
        }
        // divide by 2 because we counted double: cube1 and cube 2 <> cube2 and cube1
        System.out.println(countValidCube / 2);
    }

    // check if cube1 and cube2 can form all square numbers from 01 ... 81
    public static boolean checkCubes(List<Integer> cube1, List<Integer> cube2) {
        return canForm01(cube1, cube2) &&
                canForm04(cube1, cube2) &&
                canForm09(cube1, cube2) &&
                canForm16(cube1, cube2) &&
                canForm25(cube1, cube2) &&
                canForm36(cube1, cube2) &&
                canForm49(cube1, cube2) &&
                canForm64(cube1, cube2) &&
                canForm81(cube1, cube2);
    }

    public static boolean canForm01(List<Integer> cube1, List<Integer> cube2) {
        return ((cube1.contains(0) && cube2.contains(1)) ||
                (cube1.contains(1) && cube2.contains(0)));
    }

    public static boolean canForm04(List<Integer> cube1, List<Integer> cube2) {
        return ((cube1.contains(0) && cube2.contains(4)) ||
                (cube1.contains(4) && cube2.contains(0)));
    }

    public static boolean canForm09(List<Integer> cube1, List<Integer> cube2) {
        return ((cube1.contains(0) &&
                (cube2.contains(9) || cube2.contains(6)))
                ||
                ((cube1.contains(9) || cube1.contains(6)) &&
                        cube2.contains(0)));
    }

    public static boolean canForm16(List<Integer> cube1, List<Integer> cube2) {
        return ((cube1.contains(1) &&
                (cube2.contains(9) || cube2.contains(6)))
                ||
                ((cube1.contains(9) || cube1.contains(6)) &&
                        cube2.contains(1)));
    }

    public static boolean canForm25(List<Integer> cube1, List<Integer> cube2) {
        return ((cube1.contains(2) && cube2.contains(5)) ||
                (cube1.contains(5) && cube2.contains(2)));
    }

    public static boolean canForm36(List<Integer> cube1, List<Integer> cube2) {
        return ((cube1.contains(3) &&
                (cube2.contains(9) || cube2.contains(6)))
                ||
                ((cube1.contains(9) || cube1.contains(6)) &&
                        cube2.contains(3)));
    }

    public static boolean canForm49(List<Integer> cube1, List<Integer> cube2) {
        return ((cube1.contains(4) &&
                (cube2.contains(9) || cube2.contains(6)))
                ||
                ((cube1.contains(9) || cube1.contains(6)) &&
                        cube2.contains(4)));
    }

    public static boolean canForm64(List<Integer> cube1, List<Integer> cube2) {
        return ((cube1.contains(4) &&
                (cube2.contains(9) || cube2.contains(6)))
                ||
                ((cube1.contains(9) || cube1.contains(6)) &&
                        cube2.contains(4)));
    }

    public static boolean canForm81(List<Integer> cube1, List<Integer> cube2) {
        return ((cube1.contains(1) && cube2.contains(8)) ||
                (cube1.contains(8) && cube2.contains(1)));
    }

    public static void main(String[] args) {
        solveProjectEuler();
    }
}
