package toolbox.cycles;

/**
 *
 * @author marckoch
 */
public class ReciprocalCycles {

    // https://www.hackerrank.com/contests/projecteuler/challenges/euler026/problem
    
    public static int getCycleLength(int n) {
        int[] foundRemainders = new int[n + 1];
        int value = 1;
        int position = 0;

        while (foundRemainders[value] == 0 && value != 0) {
            foundRemainders[value] = position;
            value *= 10;
            value %= n;
            position++;

            //System.err.println("value=" + value);
            //System.err.println(Arrays.toString(foundRemainders));
        }

        System.err.println(n + " -> " + position);
        return position;
    }

    public static void main(String[] args) {
        System.out.println(getCycleLength(7) + " " + 1.0/7.0);
        System.out.println(getCycleLength(13) + " " + 1.0/13.0);
    }
}
