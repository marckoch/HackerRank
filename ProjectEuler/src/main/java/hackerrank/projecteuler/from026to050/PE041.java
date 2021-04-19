package hackerrank.projecteuler.from026to050;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Pandigital prime
 * @author marckoch
 */
public class PE041 {
    private static int N = 10000000;
    private static Set<Integer> pandigitalPrimes = new TreeSet<>();
    private static int[] maxPandigitalPrimes;
    
    private static boolean checkIfPrime(int x) {
        if (x%2==0) return false;
        for (int i=3; i*i<=x; i+=2) {
            if (x%i==0) return false;
        }
        return true;
    }
    
    // e.g. [1,2,3,4,5,6] --> 123456
    private static int getNumber(int[] arr)  {
        int result = 0;
        for (int i=0; i<arr.length; i++) {
            result *= 10;
            result += arr[i];
        }
        return result;
    }
    
    // build all permutations of given array
    private static void permutate(int index, int[] arr) {
        if (index==arr.length) {
            //System.err.println(Arrays.toString(arr));
            int x = getNumber(arr);
            if (checkIfPrime(x)) {
                //System.err.println(x + " is a match!");
                pandigitalPrimes.add(x);
            }
        } else {
            for(int i=index;i<arr.length;i++) {
                swap(arr, index, i);
                permutate(index+1, arr);              
                swap(arr, index, i);
            }       
        }
    }   

    // helper method used in building array permutations
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]  = temp;
    } 
    
    public static void main(String[] args) {
        for (int noOfDigits=2; noOfDigits<10; noOfDigits++) {
            int[] digits = new int[noOfDigits];
            for (int i=0; i<noOfDigits; i++) {
                digits[i]=i+1;
            }
            //System.err.println(Arrays.toString(digits));
            
            permutate(0, digits);
        }        
        
        //System.err.println(pandigitalPrimes);
        //System.err.println(pandigitalPrimes.size());
        
        // build cumulative array
        int maxPandigitalPrime = -1;
        maxPandigitalPrimes = new int[N+1];
        for (int i=0; i<=N; i++) {
            if (pandigitalPrimes.contains(i)) {
                maxPandigitalPrime = i;
            }
            maxPandigitalPrimes[i] = maxPandigitalPrime;
        }
        
        // get the results
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int n = in.nextInt();
            
            System.out.println(n>maxPandigitalPrime ? maxPandigitalPrime : maxPandigitalPrimes[n]);
        }
    }
}
