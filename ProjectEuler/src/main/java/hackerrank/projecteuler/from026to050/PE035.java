package hackerrank.projecteuler.from026to050;

import java.util.Scanner;

/**
 * Circular primes
 * @author marckoch
 */
public class PE035 {
    private static boolean[] prime;
    private static boolean[] isCircular;
    
    private static boolean checkIfCircular(int i) {
        if (i<2) {
            return false;
        }
        
        String iAsString = String.valueOf(i);
        
        int length = iAsString.length();
        //System.err.println("  length=" + length);
        
        // a number with more than 1 digit containing one of these will have a circulation
        // where this digit is at the end and than the number is 
        // guaranteed to be NO prime
        if (length > 1 && 
            (iAsString.contains("2") ||
             iAsString.contains("4") ||
             iAsString.contains("6") ||
             iAsString.contains("8") ||
             iAsString.contains("5") )
           ) {
            return false;
        }

        // we start with i and build circulations based on it
        int circulatedNumber=i;
        int multipleOfTen = (int)Math.pow(10, length-1);
        for (int l=0; l<length; l++) {
            int lastDigit = circulatedNumber % 10;
            
            // construct next circular permutation
            int temp = circulatedNumber - lastDigit;
            temp /= 10;
            temp += lastDigit * multipleOfTen;
            
            //System.err.println(l + " " + temp);
            if (!prime[temp]) {
                //System.err.println(temp + " is not a prime so " + i + " is discarded!");
                return false;
            }
            
            circulatedNumber = temp;
        }
        //System.err.println(i + " and all its circulations are primes!");
        return true;
    }
        
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        prime = new boolean[N];
        isCircular = new boolean[N];
        
        // seed primes array
        for (int i=0; i<prime.length; i++) {prime[i]=true;}
        prime[1]=true;
        for(int i=3;i<prime.length;i++) {
            for(int j=2; j*j<=i; j++) {
                if(i%j==0) {
                    prime[i]=false;
                    break;
                }
            }
        }
        //System.err.println(Arrays.toString(prime));

        for (int i=0; i<N; i++) {
            if (prime[i]) {
                if (!isCircular[i] && checkIfCircular(i)) {
                    isCircular[i]= true;
                }
            }
        }
        //System.err.println(Arrays.toString(isCircular));
        
        int sum=0;
        for (int i=0; i<N; i++) {
            if (isCircular[i]) 
                sum += i;
        }
        System.out.println(sum);
    }
}
