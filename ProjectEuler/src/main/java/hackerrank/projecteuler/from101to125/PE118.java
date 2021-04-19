package hackerrank.projecteuler.from101to125;


import toolbox.permutations.BuildIntPermutations;

import java.util.*;

public class PE118 {

    private static final Set<TreeSet<Integer>> solutions = new HashSet<>();

    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //int[] n = {1, 2, 3, 4, 5, 6};
        //int[] n = {1, 2, 3, 4};
        //int[] n = {2, 4, 5, 7};
        //int[] n = {1, 2, 3};

        List<int[]> perms = BuildIntPermutations.generatePermutations(n);


        for (int[] perm : perms) {
            //System.out.println(">> checking " + Arrays.toString(perm));
            checkNumber(perm, new Stack<>());
        }

        System.out.println(solutions);
        System.out.println(solutions.size());
    }

    public static boolean checkNumber(int[] nArr, Stack<Integer> stack) {
        if (nArr.length == 0) return false;

        for (int i = 0; i <= nArr.length; i++) {
            int[][] splitNumber = split(nArr, i);
            int[] leftArr = splitNumber[0];
            int[] rightArr = splitNumber[1];
            //System.out.println(Arrays.toString(leftArr) + " " + Arrays.toString(rightArr));

            int leftNr = toInt(leftArr);
            if (checkIfPrime(leftNr)) {
                stack.push(leftNr);
                //System.out.println(leftNr + " is prime, checking " + Arrays.toString(rightArr));
                if (rightArr.length == 0) {
                    System.out.println("    >> solution found: " + stack);
                    solutions.add(new TreeSet<>(stack));
                }
                checkNumber(rightArr, stack);
                stack.pop();
            }
        }
        return false;
    }

    private static int toInt(int[] digits) {
        int result = 0;
        for (int i = 0; i < digits.length; i++) {
            result += digits[i];
            if (i < digits.length - 1)
                result *= 10;
        }
        return result;
    }

    public static boolean checkIfPrime(long x) {
        if (x == 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) {
            return false;
        }
        for (long i = 3; i * i <= x; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[][] split(int[] numbers, int index) {
        int[] left = new int[index];
        System.arraycopy(numbers, 0, left, 0, index);
        //System.out.println(Arrays.toString(left));

        int[] right = new int[numbers.length - index];
        System.arraycopy(numbers, index, right, 0, numbers.length - index);
        //System.out.println(Arrays.toString(right));

        return new int[][]{left, right};
    }
}
