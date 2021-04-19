package toolbox.sets;

import java.util.Arrays;

public class Sets {
    // take input array and produce every combination of subsets
    // each element can be in result or not >> 2 ^ n sets
    // we do this by "overlaying" a bit representation over the array:
    // '1' indicates element is in set, '0' indicates element is NOT in set
    //
    // e.g. number 13 == 1101 >> combined with input array [x1,x2,3,x4] >> x1, x2, 0, x4 is in result array
    public static void buildSets(int[] array) {
        int n = (int) Math.pow(2, array.length);
        for (int i = 0; i < n; i++) {
            int[] newArr = buildArray(array, i);
            System.out.println(i + " " + Integer.toString(i, 2) + " " + Arrays.toString(newArr));
        }
    }

    public static int[] buildArray(int[] array, int x) {
        int len = array.length;
        int[] newArr = new int[len];
        for (int j = 0; j < len; j++) {
            if ((x & 1) == 1) {
                newArr[j] = array[j];
            }
            x >>= 1;
        }
        return newArr;
    }

    // return the binary representation of the given int as int[]
    // e.g. 13 -> 1101 -> [1,1,0,1]
    public static int[] buildBitArray(int n) {
        return Integer.toBinaryString(n)
                .chars()
                .map(x -> x - '0')
                .toArray();
    }


    public static void main(String[] args) {
        buildSets(new int[]{2, 3, 4, 5});

        System.out.println(Arrays.toString(buildBitArray(13)));

        int[] ints = buildBitArray(1331);
        System.out.println(Arrays.toString(ints));

        int[][] arrays = {
                {1, 2, 3},
                {11, 22, 33, 44, 55},
                {111, 222, 333}
        };

        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = 0; j < arrays[1].length; j++) {
                for (int k = 0; k < arrays[2].length; k++) {
                    System.out.println(arrays[0][i] + " " + arrays[1][j] + " " + arrays[2][k]);
                }
            }
        }
    }
}
