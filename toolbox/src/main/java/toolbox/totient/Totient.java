package toolbox.totient;

import java.util.Arrays;

/**
 *
 * @author marckoch
 */
public class Totient {
    private static int[] phi;
    //private static int[] max;
    
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
        for (int i = 1; i < n; i++) {
            System.err.println(String.format("Totient of %s is %s", i, phi[i]));
        }
        System.err.println(Arrays.toString(phi));
    }
    
    public static void fillMaxArray() {
        double currentMax = 0.0d;
        int indexOfCurrentMax = 0;

        for (int n = 2; n < phi.length; n++) {
            
            double x = (double) n / phi[n];
            
            if (Double.compare(currentMax, x) < 0) {
                currentMax = x;
                indexOfCurrentMax = n;
                System.err.println(String.format("new max %s at %s", currentMax, n));
            }
            phi[n] = indexOfCurrentMax;
        }

        //System.err.println(Arrays.toString(max));
    }
    
    public static void main(String[] args) {
        int N = 6000;
        phi = new int[N + 1];
        //max = new int[N + 1];
        
        computeTotient();
        
        fillMaxArray();
        
        System.out.println(phi[123]);
    }
}
