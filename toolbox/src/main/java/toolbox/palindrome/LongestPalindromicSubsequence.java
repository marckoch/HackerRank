package toolbox.palindrome;

/**
 * https://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {

    static void printMatrix(int[][] A, String delimiter) {
        for (int[] row : A) {
            String del = "";
            for (int c = 0; c < row.length; c++) {
                System.err.print(del + row[c]);
                del = delimiter;
            }
            System.err.println();
        }
    }

    // Returns the length of the longest palindromic subsequence in string
    static int lps(String string) {
        int N = string.length();
        int from, to, length;
        int L[][] = new int[N][N];  // Create a table to store results of subproblems

        // Strings of length 1 are palindrome of length 1
        for (from = 0; from < N; from++) {
            L[from][from] = 1;
        }

        // Build the table. Note that the lower diagonal values of table are
        // useless and not filled in the process. The values are filled in a
        // manner similar to Matrix Chain Multiplication DP solution (See
        // https://www.geeksforgeeks.org/archives/15553)
        for (length = 2; length <= N; length++) {
            for (from = 0; from < N - length + 1; from++) {
                to = from + length - 1;
                if (string.charAt(from) == string.charAt(to) && length == 2) {
                    L[from][to] = 2;
                } else if (string.charAt(from) == string.charAt(to)) {
                    L[from][to] = L[from + 1][to - 1] + 2;
                } else {
                    L[from][to] = Math.max(L[from][to - 1], L[from + 1][to]);
                }
            }
            //System.err.println("length " + length);
            //printMatrix(L, " ");
        }

        printMatrix(L, " ");
        return L[0][N - 1];
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        String seq = "GEEKSFORGEEKS";
        System.out.println("The length of the lps is " + lps(seq));
        
        //System.out.println("xxx " + lps("cbcaccbbccacacababcbaaaaccbbabbccacaaacbccbabbbbaacbaabbbbcabcbbcbbbabacccbaacaacaababbaacbbaabacaaaaababaaaabbaabcbcaccbbabcbbbbcbccaaccbabcbccbbccaaaacbcbbccaacaabbbcabcbbcabbcbcbccabcaaaabcababccccbbcbccacb"));
    }
}
