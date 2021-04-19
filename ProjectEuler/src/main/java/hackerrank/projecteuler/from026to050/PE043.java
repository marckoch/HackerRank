package hackerrank.projecteuler.from026to050;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Sub-string divisibility
 * @author marckoch
 */
public class PE043 {
    private static final Set<Long> matchingNumbers = new TreeSet<>();
    private static final int[] primes = new int[]{2,3,5,7,11,13,17};
    
    private static long checkNumber(int[] arr) {
        //System.err.println("checkNumber(" + Arrays.toString(arr) + ")");
        int primeIndex=0;
        for (int i=1; i+2<arr.length; i++) {
            long n = getNumber(arr, i, i+2);
            
            if (n % primes[primeIndex] != 0) {
                //System.err.println(n + " % " + primes[primeIndex] + " != 0");
                return -1;
            } else {
                //System.err.println(n + " % " + primes[primeIndex] + " == 0");
            }
            primeIndex++;
        }
        return getNumber(arr, 0, arr.length-1);
    }
    
    // from given array arr a number is created used array element "from" to "to"
    // e.g. [1,2,3,4,5,6] from=2 and to=4 --> 345
    private static long getNumber(int[] arr, int from, int to)  {
        //System.err.println("getNumber(" + Arrays.toString(arr) + ", " + from + ", " + to + ")");
        long result = 0;
        for (int i=from; i<=to; i++) {
            result *= 10;
            result += arr[i];
        }
        //System.err.println("getNumber(" + Arrays.toString(arr) + ", " + from + ", " + to + " -> " + result);
        return result;
    }
    
    // build all permutations of given array
    private static void permutate(int index, int[] arr) {
        if (index==arr.length) {
            //System.err.println(Arrays.toString(arr));
            long matchingNumber = checkNumber(arr);
            if (matchingNumber > 0) {
                //System.err.println(" is a match! " + Arrays.toString(arr));
                matchingNumbers.add(matchingNumber);
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
        Scanner in = new Scanner(System.in);
        int noOfDigits = in.nextInt();

        int[] digits = new int[noOfDigits + 1];
        for (int i=0; i<=noOfDigits; i++) {
            digits[i]=i;
        }
        //System.err.println(Arrays.toString(digits));

        permutate(0, digits);
        
        //System.err.println(matchingNumbers);
        //System.err.println(matchingNumbers.size());
        
        long sum=0;
        Iterator<Long> it = matchingNumbers.iterator();
        while (it.hasNext()) {
            sum += it.next();
        }
        System.out.println(sum);
    }
}
