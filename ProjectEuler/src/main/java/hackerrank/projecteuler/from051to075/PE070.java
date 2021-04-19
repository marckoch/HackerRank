package hackerrank.projecteuler.from051to075;

import java.util.Arrays;


/**
 * Totient permutation
 * @author marckoch
 */
public class PE070 {

    private static int[] phi;
    
    // Method to sort a string alphabetically
    public static String sortString(String inputString)
    {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();
         
        // sort tempArray
        Arrays.sort(tempArray);
         
        // return new sorted string
        return new String(tempArray);
    }
    
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
        int N = 10_000_000;
        //int N = 100;
        phi = new int[N + 1];
        
        computeTotient();
        
        double minimum = Double.MAX_VALUE;
        int nWithMinimum = 0;
        for (int n = 2; n < N; n++) {
            if (sortString(String.valueOf(n)).equals(sortString(String.valueOf(phi[n])))) {
                //System.out.println(n + " " + phi[n]);
                double d = (double) n / phi[n];
                if (Double.compare(d, minimum) < 0) {
                    minimum = d;
                    nWithMinimum = n;
                }
            }
        }
        System.out.println(nWithMinimum);
    }
    
}
