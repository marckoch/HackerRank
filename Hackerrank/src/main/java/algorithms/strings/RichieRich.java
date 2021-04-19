package algorithms.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author marckoch
 */
public class RichieRich {

    static String richieRich(String s, int n, int k) {
        // shortcut: if we can afford to change everything, we change everything to 9
        if (n == k) {
            char[] chars = new char[n];
            Arrays.fill(chars, '9');
            return new String(chars);
        }

        char[] front = new char[s.length() / 2];
        char[] back = new char[s.length() / 2];
        for (int i = 0; i < s.length() / 2; i++) {
            front[i] = s.charAt(i);
            back[i] = s.charAt(s.length() - 1 - i);
        }
        String middle = "";
        if (s.length() % 2 != 0) {
            middle = String.valueOf(s.charAt(s.length() / 2));
        }
        //System.err.println(Arrays.toString(front));
        //System.err.println(middle);
        //System.err.println(Arrays.toString(back));

        int noDifferences = 0;
        for (int i = 0; i < front.length; i++) {
            if (front[i] != back[i]) {
                noDifferences++;
            }
        }
        //System.err.println("noDifferences=" + noDifferences);
        //System.err.println("k=" + k);

        // we have more differences than we can afford to repair :-(
        if (noDifferences > k) {
            return "-1";
        }

        // we already have a palindrome
        if (noDifferences == 0 && k == 0) {
            return s;
        }

        // an even string cant be optimized with less than 2 changes
        if (noDifferences == 0 && s.length() % 2 == 0 && k < 2) {
            return s;
        }

        // remove all differences to form a palindrome
        for (int i = 0; i < front.length; i++) {
            if (noDifferences > 0) {
                if (front[i] != back[i]) {
                    if (k == noDifferences) {
                        // we just have enough changes k left to change ALL differences,
                        // so we set the smaller element to the maximum of both element
                        // this change costs one k
                        if (back[i] < front[i]) {
                            back[i] = front[i];
                        }
                        if (front[i] < back[i]) {
                            front[i] = back[i];
                        }
                        k--;
                    } else if (k > noDifferences) {
                        // we have more changes than we need to remove all differences
                        // so we can afford to set both to 9 (if needed)
                        if (front[i] < '9') {
                            front[i] = '9';
                            k--;
                        }
                        if (back[i] < '9') {
                            back[i] = '9';
                            k--;
                        }
                    }
                    noDifferences--;
                } else if (k >= noDifferences+2) {
                    // we have 2 more changes than we need to remove all differences
                    // so we can afford to set both to 9 (if needed)
                    if (front[i] < '9') {
                        front[i] = '9';
                        k--;
                    }
                    if (back[i] < '9') {
                        back[i] = '9';
                        k--;
                    }
                }
            }
        }
        //System.err.println("front:" + Arrays.toString(front));
        //System.err.println("back :" + Arrays.toString(back));
        //System.err.println("noDifferences=" + noDifferences);
        //System.err.println("k=" + k);

        // here we have no more differences but maybe some changes k left
        // so we try to set some chars in the beginning to 9
        for (int i = 0; i < front.length; i++) {
            if (k >= 2 && front[i] < '9') { // note: front[i]==back[i] < '9'
                front[i] = '9';
                k--;
                back[i] = '9';
                k--;
            }
        }

        // if we have an odd string and some k left over, we can change the middle to 9
        if (k >= 1 && !middle.isEmpty()) {
            if (middle.charAt(0) < '9') {
                middle = "9";
                k--;
            }
        }

        //System.err.println("at the end:");
        //System.err.println("noDifferences=" + noDifferences);
        //System.err.println("k=" + k);

        StringBuilder backReversed = new StringBuilder().append(back).reverse();
        return new StringBuilder()
                .append(front)
                .append(middle)
                .append(backReversed)
                .toString();
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();
            String result = richieRich(s, n, k);
            System.out.println(result);
        }
    }
}
