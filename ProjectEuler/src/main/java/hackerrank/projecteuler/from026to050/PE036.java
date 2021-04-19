package hackerrank.projecteuler.from026to050;

import java.util.Scanner;

/**
 * Double-base palindromes
 * @author marckoch
 */
public class PE036 {
    private static boolean isPalindrome(int i, int radix) {
        String s = Integer.toString(i, radix);
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString(); 
        //System.err.println("checking " + i + " base " + radix + " " + s + " " + reverse);
        return s.equals(reverse);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        
        int sum=0;
        for (int i=1; i<N; i++) {
            if (isPalindrome(i,10) && isPalindrome(i,K)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
