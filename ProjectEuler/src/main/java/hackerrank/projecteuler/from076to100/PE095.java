package hackerrank.projecteuler.from076to100;

import toolbox.divisors.SumOfDivisors;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class PE095 {

    private static int[] sumOfDivisors;
    private static Map<Integer, List<Integer>> chains = new HashMap<>();
    private static List<List<Integer>> cycles = new ArrayList<>();

    public static void solveProjectEuler(int limit) {
        init(limit);

        //System.out.println(sumOfDivisors[120]);
        //System.out.println(SumOfDivisors.getSumOfDivisors(120));
        //System.out.println("496: " + SumOfDivisors.getSumOfDivisors(496));
        //System.out.println(buildChain(120));
        //System.out.println(buildChain(220));
        //System.out.println(buildChain(284));
        System.out.println(buildChain(1184));
        //System.out.println(buildChain(12496));
        //System.out.println(buildChain(17384));

        for (int n = 0; n <= limit; n++) {
            List<Integer> chain = buildChain(n);
            //System.out.println(n + ": " + chain);
            chains.put(n, chain);
        }

        List<List<Integer>> validChains = chains.values().stream().filter(i -> !i.isEmpty() && i.get(i.size() - 1) > 1).collect(Collectors.toList());
        //System.out.println(validChains);

        Map<Integer, List<List<Integer>>> validChainsByLength = validChains.stream().collect(Collectors.groupingBy(List::size));
        //System.out.println(validChainsByLength);

        int maxLength = validChainsByLength.keySet().stream().mapToInt(i -> i).max().getAsInt();
        System.out.println("max validChainsByLength=" + maxLength);

        List<List<Integer>> maxValidChains = validChainsByLength.get(maxLength);
        System.out.println(maxValidChains.size() + " chains of maxlength found: " + maxValidChains);

        int minOfLongestValidChain = maxValidChains.get(0).stream().mapToInt(i -> i).min().getAsInt();
        System.out.println("min of longest valid chain=" + minOfLongestValidChain);

        // TODO: we detect each cycle multiple times, once for each number :-(
        Map<Integer, List<List<Integer>>> cyclesByLength = cycles.stream().collect(Collectors.groupingBy(List::size));
        //System.out.println(cyclesByLength);

        int maxCycleLength = cyclesByLength.keySet().stream().mapToInt(i -> i).max().getAsInt();
        //System.out.println(maxCycleLength);

        List<List<Integer>> cyclesWithMaxLength = cyclesByLength.get(maxCycleLength);
        //System.out.println(cyclesWithMaxLength.size() + " cycles with max length of " + maxCycleLength);

        // max cycle has length 28 and occurs 28 times, we just take the first one
        System.out.println(cyclesWithMaxLength.get(0).stream().mapToInt(i -> i).min().getAsInt());
    }

    public static List<Integer> buildChain(int n) {
        List<Integer> chain = new ArrayList<>();

        // exclude primes >> empty chain
        if (sumOfDivisors[n] == 1) {
            return chain;
        }

        chain.add(n);
        while (n > 1) {
            if (n > sumOfDivisors.length) {
                chain.add(-1);
                return chain;
            }
            n = sumOfDivisors[n];
            if (chain.get(0) == n) { // we have a cycle
                cycles.add(chain);
                break;
            } else if (chain.contains(n)) { // we have a 'normal' chain
                break;
            } else {
                chain.add(n);
            }
        }
        return chain;
    }

    public static void init(int limit) {
        sumOfDivisors = new int[limit + 1];
        for (int i = 0; i < limit; i++) {
            sumOfDivisors[i] = SumOfDivisors.getSumOfDivisors(i);
        }
        //System.out.println(Arrays.toString(sumOfDivisors));
    }

    public static void main(String[] args) {
        solveProjectEuler(1_000_000);
    }
}
