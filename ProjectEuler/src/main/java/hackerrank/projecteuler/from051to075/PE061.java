package hackerrank.projecteuler.from051to075;

import toolbox.permutations.BuildIntPermutations;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Cyclical figurate numbers
 *
 * @author marckoch
 */
public class PE061 {
    private static Map<Integer, List<Integer>> numbers;

    private static int lastTwoDigits(int i) {
        return i % 100;
    }

    private static int firstTwoDigits(int i) {
        return i / 100;
    }

    private static int getNumber(int base, int n) {
        switch (base) {
            case 3:
                return n * (n + 1) / 2;
            case 4:
                return n * n;
            case 5:
                return n * (3 * n - 1) / 2;
            case 6:
                return n * (2 * n - 1);
            case 7:
                return n * (5 * n - 3) / 2;
            case 8:
                return n * (3 * n - 2);
            default:
                throw new IllegalStateException("wrong base " + base);
        }
    }

    private static void initNumbers() {
        numbers = new TreeMap<>();

        for (int base = 3; base <= 8; base++) {
            for (int i = 20; i < 200; i++) {
                int res = getNumber(base, i);
                if (res < 1000)
                    continue;
                else if (res > 9999)
                    continue;
                else {
                    int lastTwoDigits = lastTwoDigits(res);
                    if (lastTwoDigits < 10)
                        continue;

                    if (!numbers.containsKey(base)) {
                        numbers.put(base, new ArrayList<>());
                    }
                    numbers.get(base).add(res);
                }
            }
            List<Integer> n = numbers.get(base);
            System.err.println(n.size() + " numbers for base " + base + ": " + numbers.get(base));
        }
    }

    private static int processPermutation(int[] perm, Map<Integer, List<Integer>> numbers) {
        System.out.println("checking " + Arrays.toString(perm));

        Stack<Integer> chain = new Stack<>();

        return recurse(perm, 0, numbers, chain);
    }

    private static int recurse(int[] basePerm, int level, Map<Integer, List<Integer>> numbers, Stack<Integer> chain) {
        // we processed all bases, the chain is finished, now check if chain is closed
        if (level == basePerm.length) {
            if (firstTwoDigits(chain.get(0)) == lastTwoDigits(chain.get(chain.size() - 1))) {
                System.out.println(chain); // we have a winner!
                return chain.stream().mapToInt(x -> x).sum();
            }
            return 0;
        }

        int base = basePerm[level];

        level++;

        List<Integer> numbersOfNextBase = numbers.get(base);

        List<Integer> candidates = getCandidates(numbersOfNextBase, chain);

        // normal recursion (backtracking)
        for (Integer i : candidates) {
            chain.push(i);
            int result = recurse(basePerm, level, numbers, chain);
            if (result > 0) {
                return result;
            }
            chain.pop();
        }
        return 0;
    }

    private static List<Integer> getCandidates(List<Integer> numbersOfNextBase, Stack<Integer> chain) {
        if (chain.isEmpty()) {
            // chain is empty, all numbers are candidates, no restrictions!
            return numbersOfNextBase;
        } else {
            // chain is NOT empty, only numbers allowed whose first 2 digits match the last 2 digits of lastNumberInChain
            int lastNumberInChain = chain.get(chain.size() - 1);
            int lastDigits = lastTwoDigits(lastNumberInChain);
            return numbersOfNextBase.stream()
                    .filter(i -> firstTwoDigits(i) == lastDigits)
                    .collect(Collectors.toList());
        }
    }

    private static void solve(int[] bases) {
        initNumbers();

        List<int[]> perms = BuildIntPermutations.generateCyclicalPermutations(bases);
        for (int[] permutation : perms) {
            int result = processPermutation(permutation, numbers);
            if (result > 0) {
                System.out.println(result);
                return;
            }
        }
    }

    private static void solveProjectEuler() {
        int[] bases = {3, 4, 5, 6, 7, 8};
        solve(bases);
    }

    private static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        int[] bases = new int[T];
        for (int t = 0; t < T; t++) {
            bases[t] = in.nextInt();
        }
        solve(bases);
    }

    public static void main(String[] args) {
        solveProjectEuler();
    }
}
