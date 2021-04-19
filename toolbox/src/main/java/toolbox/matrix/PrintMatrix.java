package toolbox.matrix;

/**
 *
 * @author marckoch
 */
public class PrintMatrix {

    public static void printMatrix(int[][] A, String delimiter) {
        for (int[] row : A) {
            String del = "";
            for (int c = 0; c < row.length; c++) {
                System.err.print(del + row[c]);
                del = delimiter;
            }
            System.err.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{2,3,4};
        matrix[1] = new int[]{5,4,3};
        matrix[2] = new int[]{7,1,2};
        
        printMatrix(matrix, "\t");
        
    }
}
