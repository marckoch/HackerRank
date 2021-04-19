package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class DesignerPDFViewer {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int[] h = new int[26];
            for (int i = 0; i < 26; i++) {
                h[i] = in.nextInt();
            }
            
            String word = in.next();
            int maxHeight = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int heightOfC = h[c - 'a'];
                maxHeight = Math.max(maxHeight, heightOfC);
            }
            System.out.println(word.length() * maxHeight);
        }
    }
}
