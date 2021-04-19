package hackerrank.projecteuler.from001to025;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Number to Words
 * @author marckoch
 */
public class PE017 {
    private static final Map<Integer, String> MAP = new HashMap<>();
    static {
        MAP.put(1, "One");
        MAP.put(2, "Two");
        MAP.put(3, "Three");
        MAP.put(4, "Four");
        MAP.put(5, "Five");
        MAP.put(6, "Six");
        MAP.put(7, "Seven");
        MAP.put(8, "Eight");
        MAP.put(9, "Nine");
        MAP.put(10, "Ten");
        MAP.put(11, "Eleven");
        MAP.put(12, "Twelve");
        MAP.put(13, "Thirteen");
        MAP.put(14, "Fourteen");
        MAP.put(15, "Fifteen");
        MAP.put(16, "Sixteen");
        MAP.put(17, "Seventeen");
        MAP.put(18, "Eighteen");
        MAP.put(19, "Nineteen");
        MAP.put(20, "Twenty");
        MAP.put(30, "Thirty");
        MAP.put(40, "Forty");
        MAP.put(50, "Fifty");
        MAP.put(60, "Sixty");
        MAP.put(70, "Seventy");
        MAP.put(80, "Eighty");
        MAP.put(90, "Ninety");
    }
    
    private static void addBelowThousand(StringBuilder sb, int n, int group) {
        if (n==0) 
            return;
        
        StringBuilder temp = new StringBuilder();
        
        // work the hundreds
        int h = n / 100;
        if (h > 0) {
            temp.append(MAP.get(h)).append(" Hundred ");
            n -= h*100;
        }

        // work the tens and singles
        temp.append(" and ");
        if (MAP.containsKey(n)) {
            temp.append(MAP.get(n));
        } else {
            // nothing found in map so we construct it by appending tens and singles
            int tens = n / 10;
            int singles = n - tens*10;

            if (tens > 0) {
                temp.append(MAP.get(tens*10));
                n -= tens*10;
            }                

            if (singles > 0) {
                temp.append(" ").append(MAP.get(singles));
                n -= singles;
            }
        }

        switch (group) {
            case 0: break;
            case 3: temp.append(" Thousand "); break;
            case 6: temp.append(" Million ");  break;
            case 9: temp.append(" Billion ");  break;
            case 12: temp.append(" Trillion ");  break;
        }
        
        sb.insert(0, temp);
    }
    
    private static String convert(long n) {
        StringBuilder sb = new StringBuilder();

        // we consume n from the back and work our way forward

        // indicates if we are at thousand(3), million(6), etc.
        // or: number of zeros left
        int group=0;
        while (n>0) {
            int belowThousand = (int)(n % 1000L);
            addBelowThousand(sb, belowThousand, group);
            
            // we remove what we have just processed/consumed above
            // e.g. n will be changed from 1234567 to 1234
            n = n - belowThousand;
            n = n / 1000;
            
            if (n > 0) {
                group += 3;
            }
        }
        
        return sb.toString().trim();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    
        int T = in.nextInt();
        
        for (int t=0; t<T; t++) {
            long n = in.nextLong();
            System.out.println(convert(n));
        }
    }
    
//    public static void main(String[] args) {
//        
//        long sum=0L;
//        for (int t=1; t<=1000; t++) {
//            
//            String s = convert(t);
//            sum += s.replaceAll(" ", "").length();
//        }
//        System.out.println(sum);
//    }
}
