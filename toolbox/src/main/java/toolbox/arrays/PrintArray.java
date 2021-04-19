package toolbox.arrays;

/**
 *
 * @author marckoch
 */
public class PrintArray {

    private static void printArray(int[] ar) {
        String delimiter = "";
        for (int n : ar) {
            System.out.print(delimiter + n);
            delimiter = " ";
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        printArray(new int[]{1, 2, 3, 4, 5});
    }
}
