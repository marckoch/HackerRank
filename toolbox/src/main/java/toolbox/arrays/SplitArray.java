package toolbox.arrays;

public class SplitArray {
    public static int[][] split(int[] numbers, int index) {
        int[] left = new int[index];
        System.arraycopy(numbers, 0, left, 0, index);
        //System.out.println(Arrays.toString(left));

        int[] right = new int[numbers.length - index];
        System.arraycopy(numbers, index, right, 0, numbers.length - index);
        //System.out.println(Arrays.toString(right));

        return new int[][]{left, right};
    }
}
