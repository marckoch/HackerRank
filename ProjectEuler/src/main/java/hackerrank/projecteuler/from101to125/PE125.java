package hackerrank.projecteuler.from101to125;

import java.util.Set;
import java.util.TreeSet;

public class PE125 {

    public static void main(String[] args) {
        long MAX_NUMBER = (long) Math.pow(10, 8);
        int limit = (int) Math.sqrt(MAX_NUMBER); // edge case: only one number squared is MAX_NUMBER

        Set<Long> palindromes = new TreeSet<>(); // some sums occur more than once!

        for (int start = 1; start <= limit; start++) {
            long sum = start * start;
            for (int x = start + 1; x <= limit; x++) {
                sum += x * x;
                if (sum >= MAX_NUMBER) {
                    break;
                }
                if (isPalindrome(sum)) {
//                    System.out.println(sum + " " + start + " " + x);
                    if (palindromes.contains(sum)) {
//                        System.out.println("found double: " + sum);
                    }
                    palindromes.add(sum);
                }
            }
        }

        System.out.println(palindromes);

        System.out.println(palindromes.stream().mapToLong(l -> l).sum());
    }

    public static boolean isPalindrome(long i) {
        String s = String.valueOf(i);
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        return s.equals(reverse);
    }

}
