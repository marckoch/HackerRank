package hackerrank.projecteuler.from126to150;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PE126 {

    public static int cover(int x, int y, int z, int layer) {
        return 2 * (x * y + y * z + z * x) + 4 * (x + y + z + layer - 2) * (layer - 1);
    }

    public static void main(String[] args) {
//        System.out.println(cover(1, 1, 1, 1));
//        System.out.println(cover(1, 1, 1, 2));
//        System.out.println(cover(3, 2, 1, 1));
//        System.out.println(cover(3, 2, 1, 2));
//        System.out.println(cover(5, 1, 1, 1));
//        System.out.println(cover(5, 1, 1, 2));

        Map<Integer, AtomicInteger> solutions = new HashMap<>();

        int cube_limit = 40000;  // just a guess :-(
//        int[] count = new int[cube_limit + 1];
        for (int x = 1; cover(x, x, x, 1) < cube_limit; x++) {
            for (int y = x; cover(x, y, y, 1) < cube_limit; y++) {
                for (int z = y; cover(x, y, z, 1) < cube_limit; z++) {
                    for (int n = 1; cover(x, y, z, n) < cube_limit; n++) {
                        int cubes = cover(x, y, z, n);
                        //System.out.println(x + " " + y + " " + z + " " + n + " >> " + cubes);
                        if (!solutions.containsKey(cubes)) {
                            solutions.put(cubes, new AtomicInteger(0));
                        }
                        solutions.get(cubes).getAndIncrement();
//                        count[cubes]++;
                    }
                }
            }
        }
//        System.out.println(solutions);
//        System.out.println(solutions.get(22L));
//        System.out.println(solutions.get(46L));
//        System.out.println(solutions.get(78L));
//        System.out.println(solutions.get(118L));
//        System.out.println(solutions.get(154L));

        for (int i = 2; i < solutions.size(); i++) {
            AtomicInteger val = solutions.get(i);
            if (val != null) {
                System.out.println(i + " " + val);
                if (val.intValue() == 1000) {
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(count));
    }
}
