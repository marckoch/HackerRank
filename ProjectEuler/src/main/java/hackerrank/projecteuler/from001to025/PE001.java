package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * Multiples of 3 and 5
 * @author marckoch
 */
public class PE001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextInt();
            
            long multipleOf3 = (n-1)/3;
            long sum3s = 3*multipleOf3*(multipleOf3+1) / 2;
            
            long multipleOf5 = (n-1)/5;
            long sum5s = 5*multipleOf5*(multipleOf5+1) / 2;
            
            long multipleOf15 = (n-1)/15;
            long sum15s = 15*multipleOf15*(multipleOf15+1) / 2;
            
            System.err.println(multipleOf3 + " " + multipleOf5 + " " + multipleOf15 + " " + sum3s + " " + sum5s + " " + sum15s);
            
            System.out.println(sum3s + sum5s - sum15s);
        }
    }
}
