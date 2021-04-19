package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * Largest product in a series
 * @author marckoch
 */
public class PE008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();
            int maxProd=0;
            for (int i=0; i+k<=num.length(); i++) {
                String sub = num.substring(i, i+k);
                int product=1;
                for (char c : sub.toCharArray()) {
                    int fac = Character.getNumericValue(c);
                    product *= fac;
                }
                maxProd = Math.max(maxProd, product);
            }
            System.out.println(maxProd);
        }
    }
}
