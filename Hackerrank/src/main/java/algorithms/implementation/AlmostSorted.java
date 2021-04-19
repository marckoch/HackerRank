package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class AlmostSorted {
    private static int getLeftWrong(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i+1])
                return i;
        return -1;
    }
    
    private static int getRightWrong(int[] arr) {
        for (int i = arr.length-1; i > 0; i--)
            if (arr[i-1] > arr[i])
                return i;
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = in.nextInt();
        }
        //System.err.println(Arrays.toString(a));
        solve(a);        
    }

    static void solve(int[] a) {
        int leftWrong = getLeftWrong(a);
        int rightWrong = getRightWrong(a);
        //System.err.println(leftWrong);
        //System.err.println(rightWrong);

        if (leftWrong < 0) {
            // already sorted
            System.out.println("yes");
        } else {
            // we try swapping
            int t = a[leftWrong];
            a[leftWrong] = a[rightWrong];
            a[rightWrong] = t;

            int leftWrongAfterSwap = getLeftWrong(a);
            //System.err.println("leftWrongAfterSwap=" + leftWrongAfterSwap);
            if (leftWrongAfterSwap<0) {
                System.out.println("yes");
                System.out.println("swap " + (leftWrong+1) + " " + (rightWrong+1));
            } else {
                // we try reversing
                
                // undo what we did in swap
                t = a[leftWrong];
                a[leftWrong] = a[rightWrong];
                a[rightWrong] = t;
                
                int[] reversedArr = new int[a.length];
                System.arraycopy(a, 0, reversedArr, 0, a.length);
                for (int i=0; i<=rightWrong-leftWrong; i++) {
                    reversedArr[leftWrong+i] = a[rightWrong-i];
                }

                int leftWrongAfterRev = getLeftWrong(reversedArr);
                //System.err.println("leftWrongAfterRev=" + leftWrongAfterRev);
                if (leftWrongAfterRev<0) {
                    System.out.println("yes");
                    System.out.println("reverse " + (leftWrong+1) + " " + (rightWrong+1));
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}
