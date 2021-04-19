package algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class TheTimeInWords {
    private static final Map<Integer, String> HOURS = new HashMap<>();
    static {
        HOURS.put(1, "one");
        HOURS.put(2, "two");
        HOURS.put(3, "three");
        HOURS.put(4, "four");
        HOURS.put(5, "five");
        HOURS.put(6, "six");
        HOURS.put(7, "seven");
        HOURS.put(8, "eight");
        HOURS.put(9, "nine");
        HOURS.put(10, "ten");
        HOURS.put(11, "eleven");
    }
    
    private static final Map<Integer, String> MINUTES = new HashMap<>();
    static {
        MINUTES.put(0, "o' clock");
        MINUTES.put(1, "one minute past");
        MINUTES.put(2, "two");
        MINUTES.put(3, "three");
        MINUTES.put(4, "four");
        MINUTES.put(5, "five");
        MINUTES.put(6, "six");
        MINUTES.put(7, "seven");
        MINUTES.put(8, "eight");
        MINUTES.put(9, "nine");
        MINUTES.put(10, "ten");
        MINUTES.put(11, "eleven");
        MINUTES.put(12, "twelve");
        MINUTES.put(13, "thirteen");
        MINUTES.put(14, "fourteen");
        MINUTES.put(16, "sixteen");
        MINUTES.put(17, "seventeen");
        MINUTES.put(18, "eighteen");
        MINUTES.put(19, "nineteen");
        MINUTES.put(20, "twenty");
        MINUTES.put(21, "twenty one");
        MINUTES.put(22, "twenty two");
        MINUTES.put(23, "twenty three");
        MINUTES.put(24, "twenty four");
        MINUTES.put(25, "twenty five");
        MINUTES.put(26, "twenty six");
        MINUTES.put(27, "twenty seven");
        MINUTES.put(28, "twenty eight");
        MINUTES.put(29, "twenty nine");
    }
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int h = in.nextInt();
            int m = in.nextInt();
            
            solve(m, h);
        }
    }

    static void solve(int m, int h) {
        String s="";
        if (m==0) {
            s = HOURS.get(h) + " o' clock";
        } else if (m==1) {
            s = "one minute to " + HOURS.get(h);
        } else if (m==15) {
            s = "quarter past " + HOURS.get(h);
        } else if (m>1 && m<30) {
            s = MINUTES.get(m) + " minutes past " + HOURS.get(h);
        } else if (m==30) {
            s = "half past " + HOURS.get(h);
        } else if (m==45) {
            s = "quarter to " + HOURS.get(h+1);
        } else if (m>30 && m<60) {
            s = MINUTES.get(60-m) + " minutes to " + HOURS.get(h+1);
        }
        System.out.println(s);
    }
}
