package algorithms.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class LilysHomework {
    private static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    
    private static int swapCount(int[] array, int[] sortedArray) {
        int swapCount=0;
        
        //System.err.println("counting " + Arrays.toString(array));
        //System.err.println("sorted   " + Arrays.toString(sortedArray));
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<array.length; i++) {
            map.put(array[i], i);
        }
        //System.err.println(map);
        
        for (int i=0; i<array.length; i++) {
            
            if (array[i] != sortedArray[i]) {
                //System.err.println("i= " + i + " swapping array["+i+"]="+array[i]+" and sortedArray["+i+"]=" + sortedArray[i]);
                swapCount++;
                
                // find pos it should have in sorted array
                int pos = map.get(sortedArray[i]);
                
                swap(array, pos, i);
                
                // adjust map to be in sync with swapped array
                map.put(array[pos], pos);
                map.put(array[i], i);
                
                //System.err.println(Arrays.toString(array));
                //System.err.println(map);
            }
        }
        //System.err.println(swapCount);
        //System.err.println("finished " + Arrays.toString(sortedArray));
        return swapCount;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = in.nextInt();
        }
        //System.err.println(Arrays.toString(A));
        
        int[] ascAr = new int[N];
        System.arraycopy(A, 0, ascAr, 0, N);
        Arrays.sort(ascAr);
        //System.err.println(Arrays.toString(ascAr));

        int[] descAr = new int[N];
        for (int i=0; i<N; i++) {
            descAr[i] = ascAr[N-1-i];
        }
        //System.err.println(Arrays.toString(descAr));
        
        int swapAsc=swapCount(A.clone(), ascAr);
        int swapDesc=swapCount(A.clone(), descAr);
        
        int swap = Math.min(swapAsc, swapDesc);
        
        System.out.println(swap);
    }
}
