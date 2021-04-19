package hackerrank.projecteuler.from051to075;

import toolbox.permutations.BuildIntPermutations;
import toolbox.permutations.Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author marckoch
 */
public class PE068 {
    private static int DIMENSION;

    private static void solveProjectEuler(int[] numbers) {

        List<int[]> outernumbers = Combinations.generateCombinationsNoRep(numbers, DIMENSION);
        //outernumbers.forEach(ints -> System.out.println(Arrays.toString(ints)));

        List<int[]> outPerms = new ArrayList<>();
        outernumbers.forEach(i -> outPerms.addAll(BuildIntPermutations.generateCyclicalPermutations(i)));
        //outPerms.forEach(op -> System.out.println(Arrays.toString(op)));

        List<int[][]> winners = new ArrayList<>();

        outPerms.forEach(outer -> {
            int[] inner = remove(numbers, outer);
            processInnerAndOuter(outer, inner, winners);
        });

        winners.forEach(PE068::printRing);

        winners.forEach(s -> System.out.println(toString(s)));

        System.out.println(winners.stream().map(PE068::toString).sorted(Comparator.reverseOrder()).findFirst().get());
    }

    public static void processInnerAndOuter(int[] outer, int[] inner, List<int[][]> winners) {
        //System.out.println(Arrays.toString(outer) + " " + Arrays.toString(inner));

        List<int[]> innerPerm = BuildIntPermutations.generatePermutations(inner);

        innerPerm.forEach(innerNumberPerm -> {
            int[][] ring = fillRing(outer, innerNumberPerm);
            int sum = checkRing(ring);
            if (sum > 0) {
                winners.add(ring);
            }
        });
    }

    public static int[][] fillRing(int[] outer, int[] inner) {
        int[][] ring = new int[DIMENSION][3];
        for (int o = 0; o < outer.length; o++) {
            ring[o][0] = outer[o];

            ring[o][1] = inner[o];
            ring[o][2] = inner[(o + 1) % outer.length];
        }

        return ring;
    }

    public static int checkRing(int[][] ring) {
        int[] sums = new int[DIMENSION];

        for (int i = 0; i < DIMENSION; i++) {
            sums[i] = Arrays.stream(ring[i]).sum();
        }

        for (int i = 0; i < sums.length - 1; i++) {
            if (sums[i] != sums[i + 1]) {
                return 0;
            }
        }
        return sums[0];
    }

    public static int[] remove(int[] allNumbers, int[] remove) {
        List<Integer> all = Arrays.stream(allNumbers).boxed().collect(Collectors.toList());
        List<Integer> rem = Arrays.stream(remove).boxed().collect(Collectors.toList());
        all.removeAll(rem);
        return all.stream().mapToInt(x -> x).toArray();
    }

    public static void printRing(int[][] ring) {
        for (int i = 0; i < ring.length; i++) {
            System.out.print(Arrays.toString(ring[i]));
            if (i < ring.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("\n");
    }

    public static String toString(int[][] ring) {
        return Arrays.stream(ring)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        //DIMENSION = 3;
        //int[] numbers = {1, 2, 3, 4, 5, 6};

        //DIMENSION = 4;
        //int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};

        DIMENSION = 5;
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //DIMENSION = 6;
        //int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        solveProjectEuler(numbers);
    }
}
