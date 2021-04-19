package toolbox.characters;

import java.util.Arrays;

/**
 *
 * @author marckoch
 */
public class CharFrequency {
    // frequency of each char in a prefixSumArray for position 0 to N
    // first dimension is length of substring including given position
    // second dimension is alphabet
    static int[][] frequency(String s) {
        int N = s.length();
        char[] c = s.toCharArray();
        System.err.println(s);
        int[][] freq = new int[N + 1][26];
        for (int n = 0; n < N; n++) {
            freq[n + 1][c[n] - 'a']++;
        }
        //System.err.println("freq1" + Arrays.deepToString(freq));
        for (int n = 0; n < N; n++) {
            for (int j = 0; j < 26; j++) {
                freq[n + 1][j] += freq[n][j];
            }
        }
        //System.err.println("freq2" + Arrays.deepToString(freq));
        return freq;
    }
    
    public static void main(String[] args) {
        int[][] frequency = frequency("kwfhntsoeumhqqubqvclkgclymvdqpcpmisrxzsozmfguufttfvvyfbpjskgclheoiqozjvrspedtibjrfmymbczklhsglweoqpo");
        System.out.println(Arrays.deepToString(frequency));
        
        System.out.println("frequency of letter 'k' in a substring up to index 2 = " + frequency[2]['k' - 'a']);
        System.out.println("frequency of letter 'q' in a substring up to index 23 = " + frequency[23]['q' - 'a']);
        
        int[][] frequency2 = frequency("aabbcc");
        System.out.println(Arrays.deepToString(frequency2));
        
        System.out.println("frequency of letter 'd' in a substring up to index 6 = " + frequency2[6]['d' - 'a']);
        System.out.println("frequency of letter 'a' in a substring up to index 1 = " + frequency2[1]['a' - 'a']);
        System.out.println("frequency of letter 'a' in a substring up to index 2 = " + frequency2[2]['a' - 'a']);
        System.out.println("frequency of letter 'a' in a substring up to index 3 = " + frequency2[3]['a' - 'a']);
        System.out.println("frequency of letter 'b' in a substring up to index 1 = " + frequency2[1]['b' - 'a']);
        System.out.println("frequency of letter 'b' in a substring up to index 2 = " + frequency2[2]['b' - 'a']);
        System.out.println("frequency of letter 'b' in a substring up to index 3 = " + frequency2[3]['b' - 'a']);
    }
}

