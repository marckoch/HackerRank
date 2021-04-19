package toolbox.pandigital;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author marckoch
 */
public class CheckIfPandigital {

    // number of length K is pandigital if every digit between 1 and K occurs once
    public static boolean isPandigital(long number) {
        String str = String.valueOf(number);
        
        if (str.contains("0")) {
            return false;
        }

        // checkif we only have unique chars and only those between 1 .. K(which is str.length)
        Set<Character> digits = new HashSet<>();
        for (Character c : str.toCharArray()) {
            if (Character.getNumericValue(c) > str.length()) {
                return false;
            }
            if (!digits.add(c)) {
                return false;
            }
        }
        // System.err.println(str + " is pandigital!");
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("isPandigital(1123456)=" + isPandigital(1123456));
        System.out.println("isPandigital(123456)=" + isPandigital(123456));
        System.out.println("isPandigital(7531246)=" + isPandigital(7531246));
    }
}
