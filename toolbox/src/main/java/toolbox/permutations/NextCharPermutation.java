package toolbox.permutations;

import java.util.Arrays;

/**
 *
 * @author marckoch
 */
public class NextCharPermutation {
     // https://www.programcreek.com/2014/06/leetcode-next-permutation-java/
    private static char[] nextPermutation(char[] chars) {
        if (chars == null || chars.length < 2) {
            return chars;
        }

        // 1) scan from right to left, find the first element that is less than its previous one.
        int p = 0;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] < chars[i + 1]) {
                p = i;
                break;
            }
        }

        // 2) scan from right to left, find the first element that is greater than p.
        int q = 0;
        for (int i = chars.length - 1; i > p; i--) {
            if (chars[i] > chars[p]) {
                q = i;
                break;
            }
        }

        if (p == 0 && q == 0) {
            //reverse(chars, 0, chars.length-1);
            return chars;
        }

        // 3) swap p and q
        char temp = chars[p];
        chars[p] = chars[q];
        chars[q] = temp;

        // 4) reverse elements [p+1, nums.length]
        if (p < chars.length - 1) {
            reverse(chars, p + 1, chars.length - 1);
            //Arrays.sort(chars, p+1, chars.length);
        }
        return chars;
    }

    // reverseArray ,  reverse array
    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
    
    public static void main(String[] args) {
        char[] ca = {'a', 'b', 'c'};
        System.out.println(Arrays.toString(ca) + " -> " + Arrays.toString(nextPermutation(ca)));
        
        char[] ca2 = {'a', 'a', 'b'};
        System.out.println(Arrays.toString(ca2) + " -> " + Arrays.toString(nextPermutation(ca2)));
    }
}
