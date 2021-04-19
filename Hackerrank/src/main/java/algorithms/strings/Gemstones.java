package algorithms.strings;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author marckoch
 */
public class Gemstones {
    static int gemstones(String[] arr){
        Set<Character> firstChars = new TreeSet<>();
        for (int i = 0; i < arr[0].length(); i++)
            firstChars.add(arr[0].charAt(i));
        System.err.println(firstChars);
        if (arr.length==1) return firstChars.size();
        
        int result = 0;
        
        Iterator<Character> it = firstChars.iterator();
        outer: while (it.hasNext()) {
            Character c = it.next();
            for (int i=1; i<arr.length; i++) {
                int ix = arr[i].indexOf(c);
                if (ix < 0) {
                    break outer;
                }
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            String[] arr = new String[n];
            for(int i = 0; i < n; i++){
                arr[i] = in.next();
            }
            int result = gemstones(arr);
            System.out.println(result);
        }
    }
}
