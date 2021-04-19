package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * Largest product in a grid
 * @author marckoch
 */
public class PE011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        for(int grid_i=0; grid_i < 20; grid_i++){
            for(int grid_j=0; grid_j < 20; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        
        int maxProd=1;
        for(int x=0; x < 20; x++){
            for(int y=0; y < 20; y++){
                //System.err.println("x=" + x + " y=" + y + " value=" + grid[x][y]);
                if (y<17) {
                    int horizontalProd = grid[x][y] * grid[x][y+1] * grid[x][y+2] * grid[x][y+3];
                    maxProd = Math.max(maxProd, horizontalProd);
                    //System.err.println("horProd " + grid[x][y] + " " + grid[x][y+1] + " " + grid[x][y+2] + " " + grid[x][y+3] + " " + horizontalProd);
                }
                if (x<17) {
                    int verticalProduct = grid[x][y] * grid[x+1][y] * grid[x+2][y] * grid[x+3][y];
                    maxProd = Math.max(maxProd, verticalProduct);
                    //System.err.println("verProd " + grid[x][y] + " " + grid[x+1][y] + " " + grid[x+2][y] + " " + grid[x+3][y] + " " + verticalProduct);
                }
                if (x<17 && y<17) {
                    int diagonalProduct = grid[x][y] * grid[x+1][y+1] * grid[x+2][y+2] * grid[x+3][y+3];
                    maxProd = Math.max(maxProd, diagonalProduct);
                    //System.err.println("diagProd " + grid[x][y] + " " + grid[x+1][y+1] + " " + grid[x+2][y+2] + " " + grid[x+3][y+3] + " " + diagonalProduct);
                }
                if (x<17 && y>2) {
                    int diagonalProduct = grid[x][y] * grid[x+1][y-1] * grid[x+2][y-2] * grid[x+3][y-3];
                    maxProd = Math.max(maxProd, diagonalProduct);
                    //System.err.println("diagProd " + grid[x][y] + " " + grid[x+1][y-1] + " " + grid[x+2][y-2] + " " + grid[x+3][y-3] + " " + diagonalProduct);
                }                
            }
        }
        System.out.println(maxProd);
    }
}
