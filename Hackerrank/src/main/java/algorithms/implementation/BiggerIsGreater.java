package algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author marckoch
 */
public class BiggerIsGreater {

    // https://www.programcreek.com/2014/06/leetcode-next-permutation-java/
    private static void nextPermutation(char[] chars) {
        if (chars == null || chars.length < 2) {
            return;
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
            return;
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

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(in.readLine());
            String line = "";
            char[] c = null;
            for (int i = 0; i < num; i++) {
                line = in.readLine();
                c = line.toCharArray();
                
                nextPermutation(c);
                
                if (new String(c).equals(line)) {
                    System.out.println("no answer");
                } else {
                    System.out.println(c);
                }
            }
        }
    }
}
