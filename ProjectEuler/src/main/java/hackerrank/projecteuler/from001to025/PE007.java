package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * 10001st prime
 * @author marckoch
 */
public class PE007 {
    private static final int SIZE = 10000;
    private static final int[] PRIMES = new int[SIZE];
    
    public static void main(String[] args) {

        // seed array with 10000 prime numbers
        int i=1;
        int index=0;
        while(index < SIZE) {
            i++;
            boolean factorFound=false;
            for(int p : PRIMES) {
                if (p!=0 && i % p == 0) {
                    factorFound=true;
                    break;
                }
            }
            if (!factorFound)
                PRIMES[index++] = i;
        }
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            // just get n-th prime from prime array
            System.out.println(PRIMES[n-1]);
        }
    }
}
