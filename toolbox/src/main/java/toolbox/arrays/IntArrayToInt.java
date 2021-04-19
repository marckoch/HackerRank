package toolbox.arrays;

public class IntArrayToInt {

    public static long convert(int[] array) {
        long result = 0L;
        for (int i = 0; i < array.length; i++) {
            result += array[i] * Math.pow(10, array.length - i - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convert(new int[] {1,2,3,4}));
        System.out.println(convert(new int[] {1,2,5,3,7,3,4}));
    }
}
