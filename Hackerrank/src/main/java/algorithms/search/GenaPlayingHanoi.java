package algorithms.search;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author marckoch
 */
public class GenaPlayingHanoi {

    public static Stack[] toStack(int[] array) {
        Stack[] rods = new Stack[5];
        for (int i = 0; i < rods.length; i++) {
            rods[i] = new Stack();
        }
        //System.err.println(Arrays.toString(array));
        //System.err.println("stack  : " + Arrays.toString(rods));
        for (int i = array.length - 1; i >= 0; i--) {
            rods[array[i]].push(i);
        }
        System.err.println("stack  : " + Arrays.toString(rods));
        return rods;
    }

    public static Stack[] deepCopy(Stack[] source) {
        Stack[] result = new Stack[source.length];
        //Stack[] result = Arrays.copyOf(source, source.length);
        for (int i = 0; i < source.length; i++) {
            result[i] = (Stack) source[i].clone();
        }
        return result;
    }

    public static void shortenState(Stack[] state) {
        Arrays.sort(state, 2, state.length, (s1, s2) -> -(s1.size() - s2.size()));
    }

    public static int[] getTopDiscs(int numberOfDiscs, int state) {
        int[] topDiscs = new int[4];

        // high value 999 means empty rod
        Arrays.fill(topDiscs, 999);

        // go from biggest disc to smallest and fill rods 
        // small values will overwrite big values leaving only the smallest
        // top most disc on each rod
        for (int i = numberOfDiscs - 1; i >= 0; i--) {
            int rod = (state >> i * 2) & 0b11;
            topDiscs[rod] = i;
        }
        //System.err.println("state " + state + " " + Arrays.toString(topDiscs));
        return topDiscs;
    }

    public static int solveWithIntegers(int[] array) {
        int numberOfDiscs = array.length;
        int initialState = array2hash(array);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(initialState);

        int currentState;

        Map<Integer, Integer> stateAndMoves = new HashMap<>();
        stateAndMoves.put(initialState, 0);

        while (!queue.isEmpty()) {
            currentState = queue.poll();

            int numberOfMoves = stateAndMoves.getOrDefault(currentState, 0);
            
            // final state would be all discs on rod 0, hash would be 0
            if (currentState == 0) {
                return numberOfMoves;
            }

            int[] topDiscs = getTopDiscs(numberOfDiscs, currentState);

            // generate all the possible moves
            for (int to = 0; to < 4; to++) {
                for (int from = 0; from < 4; from++) {
                    if ((to != from) && (topDiscs[to] < topDiscs[from])) {
                        int newState = moveDisc(topDiscs, to, from, currentState);
                        if (!stateAndMoves.containsKey(newState)) {
                            stateAndMoves.put(newState, numberOfMoves + 1);
                            queue.add(newState);
                        }
                    }
                }
            }
        }

        throw new IllegalStateException("something wnet wrong :(");
    }

    static int moveDisc(int[] topDiscs, int to, int from, int currentState) {
        int mask = 0b11 << topDiscs[to] * 2;
        int targetRod = from << topDiscs[to] * 2;
        int newState = (currentState & ~mask) | targetRod;
        return newState;
    }

    public static int solve(int[] array) {

        int nrOfDiscs = array.length - 1;
        final int MOVES_INDEX = 0;
        Stack[] initialState = toStack(array);

        Queue<Stack[]> queue = new ArrayDeque<>();
        queue.add(initialState);

        Stack[] currentState;

        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            currentState = queue.poll();

            // TODO: shorten state here, sort rod 2,3,4 by biggest disc falling
            //System.err.println("before shortening: " + Arrays.toString(currentState));
            shortenState(currentState);
            //System.err.println("after shortening: " + Arrays.toString(currentState));

            // not nice but works :)
            // to check if state has already been seen we have to ignore element [0]
            // which stores our move counter!
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < currentState.length; i++) {
                sb.append(currentState[i].toString());
                sb.append("_");
            }
            String stringOfCurrentState = sb.toString();
            //String stringOfCurrentState = Arrays.toString(Arrays.copyOfRange(currentState, 1, currentState.length));
            if (visited.contains(stringOfCurrentState)) {
                //System.err.println("already seen, continue");
                continue;
            }
            visited.add(stringOfCurrentState);

            //System.err.println("checking state:" + stringOfCurrentState);
            //print(currentState);
            if (isFinalState(nrOfDiscs, currentState)) {
                //System.err.println("final state found!");
                System.err.println("total moves : " + visited.size());
                return (int) currentState[MOVES_INDEX].pop();
            }

            // 0 contains the moves until now
            int nrOfMoves = (int) currentState[MOVES_INDEX].pop();
            currentState[MOVES_INDEX].push(nrOfMoves + 1);

            // find all valid moves and add to queue
            // TODO  there can only be max 6 moves from here:
            // disc 1 will always be on top, it has three possible discs
            // next biggest top disc A has 2 (can go everywhere but not on 1) (A can be 2, but not if 2 is under 1)
            // next biggest top disc B has 1 (can go everywhere but not on 1 and not on A)
            // biggest top disc C can go nowhere because 1 A and B are all smaller
            // System.err.println("building next steps:");
            int[] topDisc = new int[5];
            for (int rod = 1; rod < 5; rod++) {
                topDisc[rod] = peekTopDisc(currentState, rod);
            }

            for (int fromRod = 1; fromRod < 5; fromRod++) {
                //int topDiscOnFromRod = peekTopDisc(currentState, fromRod);
                int topDiscOnFromRod = topDisc[fromRod];
                //System.err.printf("topDisc on from rod %s is %s\n", fromRod, topDiscOnFromRod);

                // ==0 means no disc on rod
                if (topDiscOnFromRod > 0) {
                    for (int targetRod = 1; targetRod < 5; targetRod++) {
                        if (fromRod != targetRod) {
                            //System.err.printf("trying to move %s from rod %s to rod %s\n", topDiscOnFromRod, fromRod, targetRod);
                            //int topDiscOnTargetRod = peekTopDisc(currentState, targetRod);
                            int topDiscOnTargetRod = topDisc[targetRod];
                            //System.err.printf("topDisc on target rod %s is %s\n", targetRod, topDiscOnTargetRod);
                            if (topDiscOnTargetRod == 0 || topDiscOnTargetRod > topDiscOnFromRod) {
                                //Stack[] nextStep = Arrays.copyOf(currentState, currentState.length);
                                Stack[] nextStep = deepCopy(currentState);
                                int disc = (int) nextStep[fromRod].pop();
                                nextStep[targetRod].push(disc);

                                queue.add(nextStep);
                            }
                        }
                    }

                }
            }
        }

        return 0;
    }

    public static int stateOfHanoiHash(int[] stateOfHanoi) {
        // Each rod number stateOfHanoi[i] is either 0, 1, 2 or 3,
        // meaning that the decimal value can be easily represented by 2 bits,
        // indeed 0 - 0b00, 1 - 0b01, 2 - 0b10, 3 - 0b11.
        // Now, the problem states N <= 10, so we need maximum 20 bits in order to
        // represent the entire stateOfHanoi[] array as an integer.
        // On the other hand, Java int type is 4 bytes = 32 bits, which is good enough
        // for the  purpose of this task.
        // Alternatively, we could have represented stateOfHanoi[] array as an integer base 4 or 10.
        int hash = 0;
        for (int i = 0; i < stateOfHanoi.length; i++) {
            hash |= stateOfHanoi[i] << i * 2;
            //System.err.println(i + " " + stateOfHanoi[i] + " hash " + hash + " " + Integer.toBinaryString(hash));
        }
        return hash;
    }

    public static int array2hash(int[] array) {
        // state is encoded into a single integer,
        // each rod takes 2 bits
        // rod 1 is bit 0-1
        // rod 2 is bit 2-3
        // ...
        int hash = 0;
        for (int i = 0; i < array.length; i++) {
            hash |= array[i] << i * 2;
            //System.err.println(i + " " + array[i] + " hash " + hash + " " + Integer.toBinaryString(hash));
        }
        //System.err.println(Arrays.toString(array) + " " + hash);
        return hash;
    }

    // final state has every disc on first rod (index 1!!)
    public static boolean isFinalState(int nrOfDiscs, Stack[] stack) {
        return stack[1].size() == nrOfDiscs;
    }

    public static void print(Stack[] rods) {
        System.err.println("stack  : " + Arrays.toString(rods));
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();

            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt()-1;
            }

            int result = solveWithIntegers(array);

            System.out.println(result);
        }
    }

    public static void mainFast(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();

            int[] stateOfHanoi = new int[n];
            for (int i = 0; i < n; i++) {
                // index 4 rods starting from zero: 0, 1, 2, 3
                stateOfHanoi[i] = in.nextInt() - 1;
            }
            int result = solveFast(stateOfHanoi);

            System.out.println(result);
        }
    }

    static int solveFast(int[] stateOfHanoi) {
        //https://github.com/dkoval/algopuzzles/blob/405c1ee9fa95f6b5ae5f76cd2da10caaa42ccdc1/hackerrank/src/main/java/com/github/dkoval/algopuzzles/hackerrank/contests/worldCodesprintApril/GenaPlayingHanoi.java
        int n = stateOfHanoi.length;
        int h = stateOfHanoiHash(stateOfHanoi);

        // Initial state of Tower of Hanoi game: all n disks reside on rod #0.
        // Note that stateOfHanoiHash({0, 0, ..., 0}) = 0, therefore we do not calculate the hash
        // for the initial state of Hanoi game.
        // There are possible 4^N states of the game in total.
        Map<Integer, Integer> moves = new HashMap<>();
        moves.put(0, 0);

        // bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int x = q.poll();
            // check if the target state of the game is reached
            int numOfMoves = moves.get(x);
            if (x == h) {
                System.err.println("moves.size=" + moves.size());
                return numOfMoves;
            }
            // take 4 topmost discs (discs are ordered by ascending size)
            // go through all the discs to handle 2 corner cases:
            // 1. - all of the discs are placed on the same rod,
            // 2. - some of the rods are not occupied at all
            int[] topmostDiscs = new int[4];
            // Integer.MAX_VALUE denotes an empty rod here, i.e. disc of any size can be placed on it
            Arrays.fill(topmostDiscs, Integer.MAX_VALUE);
            // go through the entire array to make sure the smallest discs are picked up
            for (int i = n - 1; i >= 0; i--) {
                int rod = (x >> i * 2) & 0b11;
                topmostDiscs[rod] = i;
            }
            // generate all the possible moves, taking into account the fact
            // that no disc may be placed on top of a smaller disc
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((i != j) && (topmostDiscs[i] < topmostDiscs[j])) {
                        // can take the topmost disc from rod j and move it to the top of rod i
                        int mask = 0b11 << topmostDiscs[i] * 2;
                        int targetRod = j << topmostDiscs[i] * 2;
                        // following updates the stateOfHanoi[] array represented by the hash x
                        int y = (x & ~mask) | targetRod;
                        if (!moves.containsKey(y)) {
                            moves.put(y, numOfMoves + 1);
                            q.add(y);
                        }
                    }
                }
            }
        }
        throw new IllegalStateException("Unexpected algorithm termination");
    }

    private static int peekTopDisc(Stack[] currentState, int rod) {
        if (currentState[rod].isEmpty()) {
            return 0;
        }
        return (int) currentState[rod].peek();
    }
}
