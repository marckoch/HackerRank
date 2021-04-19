package toolbox.palindrome;

/**
 *
 * @author marckoch
 */
public class Palindrome {

    public static boolean isPalindrome(int i, int radix) {
        String s = Integer.toString(i, radix);
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        return s.equals(reverse);
    }
    
    public static void main(String[] args) {
        System.out.println("isPalindrome(12321, 10) = " + isPalindrome(12321, 10));
        System.out.println("isPalindrome(585, 2) = " + isPalindrome(585, 2));
    }
}
