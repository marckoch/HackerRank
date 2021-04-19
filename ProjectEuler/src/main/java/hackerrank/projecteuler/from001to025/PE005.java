package hackerrank.projecteuler.from001to025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Smallest multiple
 * @author marckoch
 */
public class PE005 {
    public static List<Integer> primeFactors(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
    
    public static Map<Integer, Integer> getFrequencys(List<Integer> factors) {
        final Map<Integer, Integer> freq = new HashMap<>();
        //System.err.println(factors);
        for (int j=0; j<factors.size(); j++) {
            int f = factors.get(j);
            if (!freq.containsKey(f)) {
                freq.put(f,1);
            } else {
                freq.put(f,freq.get(f)+1);
            }
        }
        //System.err.println(freq);
        return freq;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            //System.err.println("checking " + n);
            
            Map<Integer, Integer> freqN = new HashMap<>();
            
            for (int i=2; i<=n; i++) {
                List<Integer> factors = primeFactors(i);
                Map<Integer, Integer> freq = getFrequencys(factors);
                //System.err.println(factors);
                //System.err.println(freq);
                
                for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                    if (freqN.containsKey(e.getKey())) {
                        int freqOfn = freqN.get(e.getKey());
                        if (freqOfn < e.getValue()) {
                            freqN.put(e.getKey(), e.getValue());
                        }
                    } else {
                        freqN.put(e.getKey(), e.getValue());
                    }
                }
            }
            //System.err.println(freqN);
            long result = 1;
            for (Map.Entry<Integer, Integer> e : freqN.entrySet()) {
                result = result * (long) Math.pow((long)e.getKey(), (long)e.getValue());
            }
            System.out.println(result);
        }
    }
}
