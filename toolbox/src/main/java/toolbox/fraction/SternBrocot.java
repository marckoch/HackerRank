package toolbox.fraction;

import java.util.Arrays;

/**
 *
 * @author marckoch
 */
public class SternBrocot {

    public static void findQ(int qTop, int qBottom, int limit) {
        int[] left = {0, 1};
        int[] right = {1, 1};
        
        while (left[1] + right[1] <= limit) {
            int[] med = new int[]{left[0] + right[0], left[1] + right[1]};
            
            if (med[0] * qBottom < qTop * med[1]) {
                left = med;
            } else {
                right = med;
                if (right[0] == qTop && right[1] == qBottom) {
                    break;
                }
            }
            //System.err.println(Arrays.toString(med) + " " + (double) med[0]/med[1]);
        }
        
        if (limit >= left[1] + right[1]) {
            int difference = limit - (left[1] + right[1]);
            int repeat = 1 + difference / right[1];
            left[0] += repeat * right[0];
            left[1] += repeat * right[1];
        }
        System.out.println(left[0] + " " + left[1]);
    }
    
    public static void main(String[] args) {
        findQ(3, 7, 8);
    }
}
