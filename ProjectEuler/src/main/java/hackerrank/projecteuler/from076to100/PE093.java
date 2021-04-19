package hackerrank.projecteuler.from076to100;

import toolbox.permutations.BuildIntPermutations;
import toolbox.permutations.Combinations;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class PE093 {

    private static int maxChainLength;
    private static int[] combinationWithMaxChainLength;

    public static void solveProjectEuler() {
        List<int[]> combinations = Combinations.generateCombinationsNoRep(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4);
        //List<int[]> combinations = Combinations.generateCombinations(new int[]{1, 2, 5, 8}, 4);
        //List<int[]> combinations = Combinations.generateCombinations(new int[]{1, 2, 3, 7}, 4);

        //combinations.stream().limit(1).forEach(PE093::processCombination);
        combinations.forEach(PE093::processCombination);

        System.out.println("the winner is " + Arrays.toString(combinationWithMaxChainLength) + " with a chain of " + maxChainLength);
    }

    private static void processCombination(int[] combi) {
        //System.out.println(Arrays.toString(combi));
        List<int[]> permutations = BuildIntPermutations.generatePermutations(combi);

        Set<Double> numbers = new TreeSet<>();

        //permutations.stream().limit(1).forEach(p -> processNumber(toDoubleArray(p), numbers));
        permutations.forEach(p -> processNumber(toDoubleArray(p), numbers));

        //System.out.println(numbers);

        Set<Integer> validNumbers = numbers.stream()
                .filter(x -> x > 0)
                .filter(x -> x == Math.round(x))
                .map(Double::intValue)
                .collect(Collectors.toCollection(TreeSet::new));

        int chainLength = getChainLength(validNumbers);
        //System.out.println(Arrays.toString(combi) + " >> " + chainLength + " " + validNumbers.size() + " " + validNumbers);
        if (chainLength > maxChainLength) {
            maxChainLength = chainLength;
            combinationWithMaxChainLength = combi;
        }
    }

    private static int getChainLength(Collection<Integer> numbers) {
        int[] a = numbers.stream().mapToInt(x -> x).toArray();
        for (int i = 1; i < numbers.size(); i++) {
            if (a[i] != 1 + a[i - 1]) {
                return i;
            }
        }
        return numbers.size();
    }

    private static double[] toDoubleArray(int[] x) {
        return Arrays.stream(x).mapToDouble(value -> value).toArray();
    }

    private static void processNumber(double[] number, Set<Double> numbers) {
        // do every operation
        for (OPERATION o : OPERATION.values()) {
            // simulate brackets by first operating on first and second arg, then second and third, etc.
            for (int i = 0; i < number.length - 1; i++) {
                int x = i;
                int y = i + 1;
                double[] result = applyOperation(o, number, x, y);
                if (result.length == 1) {
                    numbers.add(result[0]);
                } else {
                    processNumber(result, numbers);
                }
            }
        }
    }

    private static double[] applyOperation(OPERATION op, double[] number, int x, int y) {
        double n1 = number[x];
        double n2 = number[y];

        double result;
        switch (op) {
            case PLUS:
                result = n1 + n2;
                break;
            case MINUS:
                result = n1 - n2;
                break;
            case MULT:
                result = n1 * n2;
                break;
            case DIV:
                result = n1 / n2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + op);
        }

        double[] newNumber = buildNewNumber(number, x, y, result);

        //String tab = "  ".repeat(4 - number.length);
        //System.out.printf("%s apply %s on %s (%s,%s) = %s  \n", tab, op, Arrays.toString(number), x, y, Arrays.toString(newNumber));

        return newNumber;
    }

    // create a new number based on number:
    // numbers in position x and y are placed with result:
    // [ <everything left of x>, number[x], number[y], <everything right of y> ]
    // [ <everything left of x>, result              , <everything right of y> ]
    // returns new array that is 1 shorter than input array 'number'
    private static double[] buildNewNumber(double[] number, int x, int y, double result) {
        double[] newNumber = new double[number.length - 1];
        //System.out.println(tab + " number=" + Arrays.toString(number));

        // first we copy all numbers left of x to new array
        System.arraycopy(number, 0, newNumber, 0, x);

        //System.out.println(tab + " newNumber=" + Arrays.toString(newNumber));

        // then we copy result of operation in new position x
        newNumber[x] = result;

        //System.out.println(tab + " newNumber=" + Arrays.toString(newNumber));

        // then we copy everything right of y in new array but one position pushed to left
        // because 2 numbers were reduced by operation to one result number, so everything right shift one left)
        System.arraycopy(number, y + 1, newNumber, y, number.length - y - 1);

        //System.out.println(tab + " newNumber=" + Arrays.toString(newNumber));

        return newNumber;
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
        solveProjectEuler();
        System.out.println("duration " + (double) (System.nanoTime() - start) / 1_000_000_000L + " seconds");
        //solveHackerrank();
    }

    enum OPERATION {
        PLUS("+"), MINUS("-"), MULT("*"), DIV("/");
        private String sign;

        OPERATION(String sign) {
            this.sign = sign;
        }

        @Override
        public String toString() {
            return sign;
        }
    }

    private static void testGetChainLength() {
        List<Integer> x = Arrays.asList(1, 2, 3, 4);
        System.out.println(x + " " + getChainLength(x));

        List<Integer> x2 = Arrays.asList(1, 2, 3, 4, 5, 9);
        System.out.println(x2 + " " + getChainLength(x2));
    }
}
