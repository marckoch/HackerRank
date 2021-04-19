package hackerrank.projecteuler.from026to050;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Reciprocal cycles
 * @author marckoch
 */
public class PE026 {
    public static int getCycleLength(int n) {
        int[] foundRemainders = new int[n+1];
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

        //System.err.println(n + " -> " + position);
        return position;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int[] cycleLength = new int[10001];
        
        int nWithMaxCycle=0;
        int lengthOfMaxCycle=0;
        for (int i=1; i<cycleLength.length; i++) {
            int length = getCycleLength(i);
            if (length > lengthOfMaxCycle) {
                lengthOfMaxCycle = length;
                nWithMaxCycle = i;
            }
            cycleLength[i] = nWithMaxCycle;
        }
        
        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            System.out.println(cycleLength[N-1]);
        }
    }
}
