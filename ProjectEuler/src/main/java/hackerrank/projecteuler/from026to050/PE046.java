package hackerrank.projecteuler.from026to050;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import toolbox.primes.GeneratePrimes;

/**
 * Goldbach's other conjecture
 * @author marckoch
 */
public class PE046 {

    private static Set<Integer> primes;
    
    private static void initPrimes(int maxPrime) {
        primes = new TreeSet<>();
        primes.add(2);
        for (int i=3; i<=maxPrime; i+=2) {
            boolean factorFound=false;
            for(int p : primes) {
                if (p*p>i) 
                    break;
                if (i % p == 0) {
                    factorFound=true;
                    break;
                }
            }
            if (!factorFound)
                primes.add(i);
        }

        //System.err.println(primes);
    }

    public static void main(String[] args) {
        initPrimes(500000);
        
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int t = 0; t < T; t++){
            int n = in.nextInt();
            
            int count=0;
            for (int i=0;i*i<n;i++) {
                int rest = n - 2 * i * i;
                if (primes.contains(rest)) {
                    //System.err.println(n + " = " + rest + " + 2 * " + i + "^2");
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    
    public static void main2(String[] args) {
        final int LIMIT = 10000;
        
        Set<Integer> primesSet = GeneratePrimes.getPrimes(LIMIT);
        for (int x=3; x<LIMIT; x+=2) { // number shall be odd x=3 -> x+=2
            
            // number shall be odd composite, that means NO prime
            if (primesSet.contains(x)) continue;
            
            boolean matchFound=false;
            
            for (int i=1;i*i<x;i++) {
                int rest = x - 2 * i * i;
                if (rest<=0) continue;
                if (primesSet.contains(rest)) {
                    //System.err.println(x + " == " + rest + " + 2 * " + i + "^2");
                    matchFound=true;
                    break;
                } else {
                    //System.err.println(x + " .. " + rest + "(not prime) + 2 * " + i + "^2");
                }
            }
            if (!matchFound) {
                System.out.println(x);
            }
        }
    }
}
