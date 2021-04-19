package toolbox.sterling;

/**
 *
 * @author marckoch
 */
public class SterlingNumbers {
    private static final int MAX_K = 100;
    private static final long[][] STER_MOD = new long[MAX_K+1][MAX_K+1];
    
    private static void initSterling() {
        STER_MOD[1][1]=1;
        for (int i=2; i<=MAX_K; i++) {
            for (int j=1; j<=i; j++) {
                STER_MOD[i][j]=( STER_MOD[i-1][j-1]
                                + 
                                 (j * STER_MOD[i-1][j])
                               );
//                STER_MOD[i][j]=( STER_MOD[i-1][j-1]
//                                + 
//                                 (j * STER_MOD[i-1][j]) % MOD
//                               ) % MOD;                
            }
        }
        print(STER_MOD);
    }
    
    static void print(long[][] A) {
        for (int n = 0; n < A.length; n++) {
            for (int m = 0; m < A[0].length; m++) {
                System.err.print(A[n][m] + " ");
            }
            System.err.println();
        }
    }
    public static void main(String[] args) {
        initSterling();
    }
}
