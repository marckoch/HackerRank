package hackerrank.projecteuler.from026to050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Coded triangle numbers
 * @author marckoch
 */
public class PE042 {
    private static long getTriangleIndex(long n) {
        long guess = (long) Math.sqrt(2 * n);
        if (n == (guess * (guess+1) /2)) return guess;
        return -1;
    }
    
    // solution for hackerrank
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
//        for (int t=0; t<T; t++) {
//            long n = in.nextLong();
//            System.out.println(getTriangleIndex(n));
//        }
//    }
    
    private static int calcValue(String name) {
        int sum=0;
        for (char c : name.toCharArray()) {
            sum += Character.getNumericValue(c) - 9;
        }
        return sum;
    }
        
    // solution for projecteuler.net problem
    public static void main(String[] args) throws IOException {
        String[] words;
        
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        
        try (InputStream is = classloader.getResourceAsStream("hackerrank/projecteuler/from026to050/p042_words.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            //System.out.println(out.toString());   //Prints the string content read from input stream
            
            words = out.toString().replaceAll("\"", "").split(",");
        }
        
        int Q = words.length;
        System.err.println("WORDS=" + Q);
        
        int countTriangleWords = 0;
        for (int q=0; q<Q; q++) {
            String name = words[q];
            int val = calcValue(name);
            System.out.println(name + " " + val);
            if (getTriangleIndex(val) > 0) countTriangleWords++;
        }
        System.out.println(countTriangleWords);
    }
}
