package steppingstones;

/**
 *
 * @author marckoch
 */
public class SteppingStones {

    public static void main(String[] args) {
        for (int i = 1; i < 9; i++) {
            double sum = 0;
            int steps = 0;
            while (sum < i) {
                sum += (double) 1 / i;
                steps++;
            }
            System.out.println(i + " " + steps);
        }
    }
}
