package algorithms.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class BearAndSteadyGene {
    private static boolean isSteady(Map<Character, Integer> freq, int expectedFreq) {
        for (int f : freq.values()) {
            if (f > expectedFreq) 
                return false;
        }
        return true;
    }

    static int check(String gene) {
        //System.err.println(gene);
        
        // the frequency distribution of the whole gene
        Map<Character, Integer> freq = new HashMap<>();
        freq.put('A', 0);
        freq.put('C', 0);
        freq.put('G', 0);
        freq.put('T', 0);
        for (char c : gene.toCharArray()) {
            freq.put(c, freq.get(c) + 1);
        }
        //System.err.println("                  " + freq);
        
        int expFreq = gene.length() / 4;
        int left = 0, right = 0, min = Integer.MAX_VALUE;
        while (right < gene.length() - 1){
            // move right one step to the right and remove char from freq map
            char rightChar = gene.charAt(right);
            right++;
            freq.put(rightChar, freq.get(rightChar) - 1);
            //System.err.println("pushing right " + left + " " + right + " " + freq + " " + min);
            
            while (isSteady(freq, expFreq)) {
                min = Math.min(min, right - left);
                
                // move left one step to the right and add char from freq map
                char leftChar = gene.charAt(left);
                left++;
                freq.put(leftChar, freq.get(leftChar) + 1);
                //System.err.println("pushing left  " + left + " " + right + " " + freq + " " + min);
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            String gene = in.next();
            System.out.println(check(gene));
        }
    }
}
