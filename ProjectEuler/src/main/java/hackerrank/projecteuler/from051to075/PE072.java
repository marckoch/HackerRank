package hackerrank.projecteuler.from051to075;

import java.util.Scanner;


/**
 * Counting fractions
 * @author marckoch
 */
public class PE072 {

    private static int[] phi;
    private static long[] F;
    
    // Computes and prints totien of all numbers
    // smaller than or equal to n.
    public static void computeTotient() {
        int n = phi.length-1;
        // Create and initialize an array to store
        // phi or totient values
        for (int i = 1; i <= n; i++) {
            phi[i] = i; // indicates not evaluated yet
        }                    // and initializes for product formula.

        // Compute other Phi values
        for (int p = 2; p <= n; p++) {
            // If phi[p] is not computed already,
            // then number p is prime
            if (phi[p] == p) {
                // Phi of a prime number p is
                // always equal to p-1.
                phi[p] = p - 1;

                // Update phi values of all
                // multiples of p
                for (int i = 2 * p; i <= n; i += p) {
                    // Add contribution of p to its
                    // multiple i by multiplying with
                    // (1 - 1/p)
                    phi[i] = (phi[i] / p) * (p - 1);
                }
            }
        }

        // Print precomputed phi values
        //for (int i = 1; i < n; i++) {
        //    System.err.println(String.format("Totient of %s is %s", i, phi[i]));
        //}
        //System.err.println(Arrays.toString(phi));
    }
    
    public static void main(String[] args) {
        int N = 1_000_000;
        phi = new int[N + 1];
        F = new long[N + 1];
        F[1] = 2;
        
        computeTotient();
        
        // https://en.wikipedia.org/wiki/Farey_sequence#Sequence_length_and_index_of_a_fraction
        for (int i = 2; i < F.length-1; i++) {
            F[i+1] = F[i] + phi[i+1];
        }
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        while (T-- > 0) {
            System.out.println(F[in.nextInt()] + 1);
        }
    }
    
}
