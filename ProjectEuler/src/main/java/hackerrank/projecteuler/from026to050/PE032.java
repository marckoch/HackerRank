package hackerrank.projecteuler.from026to050;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Pandigital products
 * @author marckoch
 */
public class PE032 {
    private static Set<Integer> matchingProducts = new HashSet<>();
    
    // from given array arr a number is created used array element "from" to "to"
    // e.g. [1,2,3,4,5,6] from=2 and to=4 --> 34
    private static int getNumber(int[] arr, int from, int to)  {
        int result = 0;
        for (int i=from; i<to; i++) {
            result *= 10;
            result += arr[i];
        }
        //System.err.println("getNumber(" + Arrays.toString(arr) + ", " + from + ", " + to + " -> " + result);
        return result;
    }
    
    // idea is:
    // - we have N numbers from 1 to N in the array
    // - we build every permutation of these numbers
    // - every permutation is "cut" in three parts:
    //   -- 0 .. limit1 is the first multiplicant n1
    //   -- limit1 .. limit2 is the second multiplicant n2
    //   -- limit2 .. array.length is the resulting product p
    // - we check if n1 * n2 == p
    private static int checkIfPandigital(int[] arr) {
        for (int limit1 = 1; limit1<arr.length-2; limit1++) {
            for (int limit2 = limit1+1; limit2<arr.length-1; limit2++) {
                int n1 = getNumber(arr, 0, limit1);
                int n2 = getNumber(arr, limit1, limit2);
                
                int product = getNumber(arr, limit2, arr.length);
                if (product == n1 * n2) 
                    return product;
            }
        }
        return -1;
    }
    
    // build all permutations of given array
    private static void permutate(int index, int[] arr) {
        if(index==arr.length) {
            //System.err.println(Arrays.toString(arr));
            int matchingProduct = checkIfPandigital(arr);
            if (matchingProduct > 0) {
                //System.err.println(" is a match! " + Arrays.toString(arr));
                matchingProducts.add(matchingProduct);
            }
        }           
        else {
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
        int N = in.nextInt();
        
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = i+1;
        }
        
        permutate(0, arr);
        
        int sum=0;
        Iterator<Integer> it = matchingProducts.iterator();
        while(it.hasNext()) {
            sum += it.next();
        }
        System.out.println(sum);
    }
}
