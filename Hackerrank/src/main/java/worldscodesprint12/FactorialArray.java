package worldscodesprint12;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class FactorialArray {

    private static int[] A;
    private static long[] Afacts;

    private static long[] factorialsMod;

    private static final long mod = 1_000_000_000L;

    private static long fact(int x) {
        if (x >= 40) {
            return 0;
        }
        return factorialsMod[x];
    }

    private static void addOne(int from, int to) {
        for (int i = from; i <= to; i++) {
            A[i - 1] += 1;
            Afacts[i - 1] = fact(A[i - 1]);
        }
    }

    private static void printSum(int from, int to) {
        long sum = 0L;
        for (int i = from; i <= to; i++){
            sum += Afacts[i-1] % mod;
            sum %= mod;
        }
        System.out.println(sum);
    }

    private static void set(int i, int newVal) {
        A[i - 1] = newVal;
        Afacts[i - 1] = fact(A[i - 1]);
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();
            
            factorialsMod = new long[40];
            factorialsMod[0] = 1;
            factorialsMod[1] = 1;
            for (int i = 1; i < factorialsMod.length; i++) {
                factorialsMod[i] = (factorialsMod[i - 1] * i) % mod;
            }
            System.err.println(Arrays.toString(factorialsMod));
            
            A = new int[n];
            Afacts = new long[n];
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt();
                Afacts[i] = fact(A[i]);
            }
            //System.err.println("init" + Arrays.toString(A));
            
            for (int a0 = 0; a0 < m; a0++) {
                int op = in.nextInt();
                int a = in.nextInt();
                int b = in.nextInt();
                
                //System.err.printf("%s %s %s\n", op, a, b);
                switch (op) {
                    case 1:
                        addOne(a, b);
                        break;
                    case 2:
                        printSum(a, b);
                        break;
                    case 3:
                        set(a, b);
                        break;
                }
                //System.err.println(Arrays.toString(A));
            }
        }
    }
}
