package hackerrank.projecteuler.from026to050;

import java.util.Scanner;

/**
 * Truncatable primes
 * @author marckoch
 */
public class PE037 {
    private static boolean[] prime;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        prime = new boolean[N];
        prime[2] = true;
        prime[3] = true;
        prime[5] = true;
        prime[7] = true;
        
        int sum =0;
        
        for(int i=11; i<N; i+=2) {
            prime[i]=true;
            for(int j=2; j*j<=i; j++) {
                if(i%j==0) {
                    prime[i]=false;
                    break;
                }
            }
            
            if (!prime[i])
                continue;
            
            // check if right digits can be removed and leave prime
            int lastDigitRemoved=i;
            while (lastDigitRemoved>0 && prime[lastDigitRemoved]) {
                lastDigitRemoved /= 10;
            }
            
            // we have a remainder that is not a prime
            if (lastDigitRemoved>0) {
                //System.err.println(i + " is NOT right truncable!");
                continue;
            }
            
            // check if left digits can be removed and leave prime
            int firstDigitRemoved=i;
            while (firstDigitRemoved>0 && prime[firstDigitRemoved]) {
                String str = Integer.toString(firstDigitRemoved);
                if (str.length() > 1) {
                    firstDigitRemoved = Integer.parseInt(Integer.toString(firstDigitRemoved).substring(1));
                } else {
                    firstDigitRemoved=0;
                }
            }
            
            // we have a remainder that is not a prime
            if (firstDigitRemoved>0) {
                //System.err.println(i + " is NOT left truncable!");
                continue;
            }
            
            //System.err.println(i + " is a match!");
            
            sum += i;
        }
        
        System.out.println(sum);
    }
}
