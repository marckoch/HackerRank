package toolbox.kmp;

/**
 * https://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 *
 * @author marckoch
 */
public class KMPStringMatching {

    void kmpSearch(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int ixPat = 0;  // index for pat[]

        computeLPSArray(pattern, lps);

        int ixTxt = 0;  // index for txt[]
        while (ixTxt < N) {
            if (pattern.charAt(ixPat) == text.charAt(ixTxt)) {
                ixPat++;
                ixTxt++;
            }
            if (ixPat == M) {
                System.out.println("Found pattern at index " + (ixTxt - ixPat));
                ixPat = lps[ixPat - 1];
            } // mismatch after j matches
            else if (ixTxt < N && pattern.charAt(ixPat) != text.charAt(ixTxt)) {
                // Do not match lps[0..lps[j-1]] characters, they will match anyway
                if (ixPat != 0) {
                    ixPat = lps[ixPat - 1];
                } else {
                    ixTxt = ixTxt + 1;
                }
            }
        }
    }

    void computeLPSArray(String pattern, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar 
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    // Driver program to test above function
    public static void main(String args[]) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMPStringMatching().kmpSearch(pat, txt);
    }
}
