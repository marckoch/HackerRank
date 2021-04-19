package hackerrank.projecteuler.from001to025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Names scores
 * @author marckoch
 */
public class PE022 {
    private static int calcValue(String name) {
        int sum=0;
        for (char c : name.toCharArray()) {
            sum += Character.getNumericValue(c) - 9;
        }
        return sum;
    }

    // solution for hackerranks implementation pf project euelr problem
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        in.nextLine();
//        String[] names = new String[N];
//        for (int i=0; i<N; i++) {
//            names[i] = in.nextLine();
//        }
//        //System.err.println(Arrays.toString(names));
//        Arrays.sort(names);
//        //System.err.println(Arrays.toString(names));
//        
//        int Q = in.nextInt();
//        in.nextLine();
//        
//        System.err.println(Q);
//        for (int q=0; q<Q; q++) {
//            String name = in.nextLine();
//            //System.err.println(name);
//            int index = Arrays.binarySearch(names, name)+1;
//            int val = calcValue(name);
//            System.out.println(index * val);
//        }
//    }
    
    // solution for projecteuler.net problem
    public static void main(String[] args) throws IOException {
        String[] names;
        
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        
        try (InputStream is = classloader.getResourceAsStream("hackerrank/projecteuler/from001to025/p022_names.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            //System.out.println(out.toString());   //Prints the string content read from input stream
            
            names = out.toString().replaceAll("\"", "").split(",");
        }
        
        //System.err.println(Arrays.toString(names));
        Arrays.sort(names);
        //System.err.println(Arrays.toString(names));
        
        int Q = names.length;
        System.err.println("NAMES=" + Q);
        
        long sum=0L;
        for (int q=0; q<Q; q++) {
            String name = names[q];
            //System.err.println(name);
            int index = Arrays.binarySearch(names, name)+1;
            int val = calcValue(name);
            //System.out.println(index * val);
            sum += (index * val);
        }
        System.out.println(sum);
    }
}
