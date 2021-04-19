package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class CavityMap {
    private static int depth(String[] grid, int r, int c) {        
        int depth = Character.getNumericValue(grid[r].charAt(c));
        //System.err.println(r + " " + c + " " + depth);
        return depth;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            String[] grid = new String[n];
            for(int i=0; i < n; i++){
                grid[i] = in.next();
            }
            solve(n, grid);
        }
    }

    static void solve(int n, String[] grid) {
        for (int r=1; r<n-1; r++) {
            for (int c=1; c<n-1; c++) {
                int depth = depth(grid, r, c);
                //System.err.println(r + " " + c + " " + depth);
                
                if (depth(grid, r-1, c) < depth &&
                        depth(grid, r+1, c) < depth &&
                        depth(grid, r, c-1) < depth &&
                        depth(grid, r, c+1) < depth) {
                    //System.err.println(r + " " + c + " is a cave");
                    grid[r] = grid[r].substring(0, c) + "X" + grid[r].substring(c+1);
                }
            }
        }
        for (int r=0; r<n; r++) {
            System.out.println(grid[r]);
        }
    }
}
