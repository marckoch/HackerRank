package hackerrank.projecteuler.from076to100;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PE084 {
    private static final int DIM = 40;
    private static final int DICE_SIZE = 6;
    private static final int ROUNDS = 10_000_000;
    private static final Random random = new Random(System.currentTimeMillis());

    // some important fields:
    private static final int POS_GO = 0;
    private static final int POS_R1 = 5;
    private static final int POS_R2 = POS_R1 + 10;
    private static final int POS_R3 = POS_R2 + 10;
    private static final int POS_R4 = POS_R3 + 10;
    private static final int POS_JAIL = 10;
    private static final int POS_C1 = POS_JAIL + 1;
    private static final int POS_FREE_PARKING = 20;
    private static final int POS_E3 = POS_FREE_PARKING + 4;
    private static final int POS_H2 = 39;
    private static final int POS_U1 = POS_JAIL + 2;
    private static final int POS_U2 = POS_R3 + 3;
    private static final int POS_GO2JAIL = 30;
    private static final int POS_CH1 = 7;
    private static final int POS_CH2 = 22;
    private static final int POS_CH3 = 36;

    private static final String[] boardFields = {"GO", "A1", "CC1", "A2", "T1", "R1", "B1", "CH1", "B2", "B3",
            "JAIL", "C1", "U1", "C2", "C3", "R2", "D1", "CC2", "D2", "D3",
            "FP", "E1", "CH2", "E2", "E3", "R3", "F1", "F2", "U2", "F3",
            "G2J", "G1", "G2", "CC3", "G3", "R4", "CH3", "H1", "T2", "H2"};

    public static void solveProjectEuler() {
        int[] board = new int[DIM];
        int pos = 0;
        board[pos]++;

        System.out.println(Arrays.toString(board));

        for (int i = 0; i < ROUNDS; i++) {
            int dice1 = rollDice();
            int dice2 = rollDice();

            pos = (pos + dice1 + dice2) % DIM;

            if (boardFields[pos].startsWith("CC")) {
                pos = determineNewPosFromCommunityCard(pos);
            } else if (boardFields[pos].startsWith("CH")) {
                pos = determineNewPosFromChanceCard(pos);
            } else if (pos == POS_GO2JAIL) {
                pos = POS_JAIL;
            }
            board[pos]++;
        }

        System.out.println(Arrays.toString(board));

        Map<Integer, String> fields =
                IntStream.range(0, board.length)
                        .mapToObj(i -> Map.entry(board[i], String.format("%02d", i))) // map to Map.Entry
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        //System.out.println(fields);

        List<Map.Entry<Integer, String>> collect =
                fields.entrySet().stream()
                        .sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey()))
                        .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static int rollDice() {
        return random.nextInt(DICE_SIZE) + 1;
    }

    private static int drawCommunityCard() {
        return random.nextInt(16);
    }

    private static int drawChanceCard() {
        return random.nextInt(16);
    }

    private static int determineNewPosFromCommunityCard(int pos) {
        int card = drawCommunityCard();
        switch (card) {
            case 0:
                return POS_GO;
            case 1:
                return POS_JAIL;
            default:
                return pos; // other card, no change in pos
        }
    }

    private static int determineNewPosFromChanceCard(int pos) {
        int card = drawChanceCard();
        switch (card) {
            case 0:
                return POS_GO;
            case 1:
                return POS_JAIL;
            case 2:
                return POS_C1;
            case 3:
                return POS_E3;
            case 4:
                return POS_H2;
            case 5:
                return POS_R1;
            case 6: // go to next R
            case 7: // go to next R
                switch (boardFields[pos]) {
                    case "CH1":
                        return POS_R2;
                    case "CH2":
                        return POS_R3;
                    case "CH3":
                        return POS_R1;
                }
            case 8: // go to next U
                switch (boardFields[pos]) {
                    case "CH1":
                    case "CH3":
                        return POS_U1;
                    case "CH2":
                        return POS_U2;
                }
            case 9:
                pos = (pos - 3) % DIM;
            default:
                return pos; // other card, no change in pos
        }
    }

    public static void main(String[] args) {
        solveProjectEuler();
    }
}
