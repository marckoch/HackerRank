package algorithms.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class ShortPalindrome {

    static int mod = (int) Math.pow(10, 9) + 7;

    // naive solution, for nested loops :-(
    static int shortPalindromeNaive(String s) {
        //System.err.println("... " + s);
        int count = 0;
        for (int a = 0; a < s.length() - 3; a++) {
            char cA = s.charAt(a);
            for (int d = a + 3; d < s.length(); d++) {
                char cD = s.charAt(d);
                if (cA == cD) {
                    //System.err.printf("%s %s %s %s\n", a, cA, d, cD);
                    for (int b = a + 1; b < d - 1; b++) {
                        char cB = s.charAt(b);
                        for (int c = b + 1; c < d; c++) {
                            char cC = s.charAt(c);
                            if (cB == cC) {
                                //System.err.printf("palindrome found: %s %s %s %s %s %s %s %s\n", a, cA, b, cB, c, cC, d, cD);
                                count = (count + 1) % mod;
                            }
                        }
                    }
                }
            }
        }
        return count % mod;
    }

    // same as naive solution, 4 nested loops
    static int shortPalindromeNaive2(String s) {
        //System.err.println("... " + s);
        int count = 0;
        for (int a = 0; a < s.length() - 3; a++) {
            char cA = s.charAt(a);

            int d = a + 2;
            while ((d = s.indexOf(cA, d + 1)) >= 0) {

                for (int b = a + 1; b < d - 1; b++) {
                    char cB = s.charAt(b);

                    int c = b;
                    while ((c = s.indexOf(cB, c + 1)) >= 0 && c < d) {
                        //System.err.printf("palindrome found: %s %s %s %s %s %s %s %s\n", a, b, c, d, cA, cB, cB, cA);
                        count = (count + 1) % mod;
                    }
                }
            }
        }
        return count % mod;
    }

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

    static int shortPalindrome(String s) {
        int[] freq = new int[26];
        int[][] matrix = new int[26][26];
        int[] arr3 = new int[26];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int letter = (int) (s.charAt(i) - 'a');
            System.err.println("letter : " + (char) (letter + 'a'));

            ans += (arr3[letter] % mod);
            ans = ans % mod;

            for (int j = 0; j < 26; j++) {
                arr3[j] += (matrix[j][letter] % mod);
                arr3[j] = arr3[j] % mod;
            }

            for (int j = 0; j < 26; j++) {
                matrix[j][letter] += (freq[j] % mod);
                matrix[j][letter] = matrix[j][letter] % mod;
            }

            freq[letter]++;
            freq[letter] = freq[letter] % mod;

            System.err.println("freq");
            System.err.println(Arrays.toString(freq));
            System.err.println("arr2");
            printMatrix(matrix, " ");
            System.err.println("arr3");
            System.err.println(Arrays.toString(arr3));
            System.err.println("ans=" + ans);
        }
        return ans;
    }

    // https://www.hackerrank.com/rest/contests/world-codesprint-5/challenges/short-palindrome/hackers/AndreySiunov/download_solution
    public void solve(String str) {
        char[] s = str.toCharArray();
        long[] cnt = new long[26];
        long[][] d1 = new long[26][26];
        long[][] d2 = new long[26][26];
        long res = 0;
        for (char ch : s) {
            ch -= 'a';
            for (int i = 0; i < 26; i++) {
                res = (res + d2[ch][i]) % mod;
            }
            for (int i = 0; i < 26; i++) {
                d2[i][ch] = (d2[i][ch] + d1[i][ch]) % mod;
                d1[i][ch] = (d1[i][ch] + cnt[i]) % mod;
            }
            cnt[ch]++;
        }
        System.out.println(res);
    }

// other: https://www.hackerrank.com/rest/contests/world-codesprint-5/challenges/short-palindrome/hackers/haidangtran/download_solution
    public static void main2(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = br.readLine();
            br.close();
        } catch (Exception ex) {

        }
        long[] suffixCount = new long[26];
        long[][] suffixPairCount = new long[26][26];
        for (int i = line.length() - 1; i >= 0; --i) {
            int c = line.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                suffixPairCount[c][j] = (suffixPairCount[c][j] + suffixCount[j]) % mod;
            }
            suffixCount[c] = (suffixCount[c] + 1) % mod;
//			System.out.println(suffixPairCount[0][1]);
        }
        long[] prefixCount = new long[26];
        long[][] prefixPairCount = new long[26][26];
        long ret = 0;
        for (int i = 0; i < line.length(); ++i) {
            int c = line.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                long t = suffixCount[j];
                if (j == c) {
                    t--;
                }
                t %= mod;
                ret = (ret + (prefixPairCount[j][c] * t) % mod) % mod;
            }
//			System.out.println("i = " + i);
//			System.out.println("ret = " + ret);
//			System.out.println("pre = " + prefixPairCount[0][1]);
//			System.out.println("suf = " + suffixPairCount[0][1]);
//			System.out.println("+++");
            suffixCount[c] = (suffixCount[c] + mod - 1) % mod;
            for (int j = 0; j < 26; j++) {
                suffixPairCount[c][j] = (suffixPairCount[c][j] + mod - suffixCount[j]) % mod;
                prefixPairCount[j][c] = (prefixPairCount[j][c] + prefixCount[j]) % mod;
            }
            prefixCount[c] = (prefixCount[c] + 1) % mod;
        }
        System.out.println(ret);
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.next();
            int result = shortPalindrome(s);
            System.out.println(result);
        }
    }
}
