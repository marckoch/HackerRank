package hackerrank.projecteuler.from026to050;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Pentagon numbers
 * @author marckoch
 */
public class PE044 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        
        long[] numbers = new long[N];
        for (int n=0; n<N; n++) {
            numbers[n] = (long)n * ( 3 * (long)n - 1) / 2;
        }
        // System.err.println(Arrays.toString(numbers));
        
        for (int n=K+1; n<N; n++) {
            long diff = numbers[n] - numbers[n-K];
            int diffIndex = Arrays.binarySearch(numbers, diff);
            if (diffIndex>0) {
                System.out.println(numbers[n]);
            } else {
                long sum  = numbers[n] + numbers[n-K];
                int sumIndex = Arrays.binarySearch(numbers, sum);
                if (sumIndex>0) {
                    System.out.println(numbers[n]);
                }
            }
        }
    }
}
