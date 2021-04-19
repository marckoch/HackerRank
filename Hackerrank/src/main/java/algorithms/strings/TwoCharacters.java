package algorithms.strings;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author marckoch
 */
public class TwoCharacters {
    private static Set<Character> getUniqueChars(String s) {
        char[] c = s.toCharArray();
        Set<Character> chars = new TreeSet<>();
        for (int i=0; i<s.length(); i++) {
            chars.add(c[i]);
        }
        return chars;
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int len = in.nextInt();
            String s = in.next();
            
            solve(s);
        }
    }

    static void solve(String s) {
        int maxLength=0;
        
        Set<Character> chars = getUniqueChars(s);
        Character[] arr = chars.toArray(new Character[chars.size()]);
        //System.err.println(Arrays.toString(arr));
        
        for (int one=0; one<arr.length; one++) {
            for (int two=one+1; two<arr.length; two++) {
                //System.err.println("" + arr[one] + " " + arr[two]);
                
                char expected = Character.MIN_VALUE;
                int length=0;
                for (int i=0; i<s.length(); i++) {
                    char c = s.charAt(i);
                    //System.err.println("  " + c);
                    if (c == arr[one]) {
                        if (expected != Character.MIN_VALUE && expected != arr[one]) {
                            length=0;
                            break;
                        } else {
                            expected=arr[two];
                            length++;
                        }
                    } else if (c == arr[two]) {
                        if (expected != Character.MIN_VALUE && expected != arr[two]) {
                            length=0;
                            break;
                        } else {
                            expected=arr[one];
                            length++;
                        }
                    }
                }
                //System.err.println("" + arr[one] + " " + arr[two] + " l=" + length);
                maxLength = Math.max(maxLength, length);
            }
        }
        System.out.println(maxLength);
    }
}
