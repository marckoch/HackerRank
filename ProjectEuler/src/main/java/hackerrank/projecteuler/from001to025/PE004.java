package hackerrank.projecteuler.from001to025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Largest palindrome product
 * @author marckoch
 */
public class PE004 {
    private static boolean isPalindrome(int i) {
        String s = String.valueOf(i);
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString(); 
        //System.err.println("checking " + i + " " + s + " " + reverse);
        return s.equals(reverse);
    }
    
    public static void main(String[] args) {
        final List<Integer> palindromesList = new ArrayList<>();
        for (int i=101; i<1000; i++) {
            for (int j=101; j<1000; j++) {
                if (isPalindrome(i*j) && !palindromesList.contains(i*j)) {
                    palindromesList.add(i*j);
                }
            }
        }
        //System.err.println("number of palindromes=" + palindromesList.size());
        //System.err.println(palindromesList);
        
        int[] palindromes = new int[palindromesList.size()];
        for (int i=0; i<palindromesList.size(); i++) {
            palindromes[i] = palindromesList.get(i);
        }
        
        Arrays.sort(palindromes);
        //System.err.println(Arrays.toString(palindromes));
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            int index = Arrays.binarySearch(palindromes, n);
            //System.err.println(index);
            //System.err.println(-index-2 + " " + palindromes[-index-2]);
            if (index<0) 
                System.out.println(palindromes[-index-2]);
            else
                System.out.println(palindromes[index-1]);
        }
    }
}
