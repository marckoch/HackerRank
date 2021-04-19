package hackerrank.projecteuler.from101to125;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PE119 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        solve();
        System.out.println("took " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        solve2();
        System.out.println("took " + (System.currentTimeMillis() - start));
    }

    // too slow !!
    public static void solve() {
        for (long i = 10; i <= 1_000_000L; i++) {
            long digitSum = getDigitSum(i);
//            double exp = Math.log(i) / Math.log(digitSum);
//            if (Math.abs( Math.round(exp) - exp) < 0.000_001) {
//                System.out.println("winner: " + i + " = " + digitSum + "^" + exp);
//            }

            if (digitSum == 1) continue;
            if (i % 5 == 0 && digitSum % 5 != 0) continue;
            if (i % 5 != 0 && digitSum % 5 == 0) continue;
            if (i % 2 == 0 && digitSum % 2 != 0) continue;
            if (i % 2 != 0 && digitSum % 2 == 0) continue;

            long res = digitSum;
            int count = 1;
            while (res < i) {
                res *= digitSum;
                count++;
            }
            if (res == i) {
                System.out.println("winner: " + i + " = " + digitSum + "^" + count);
            }
        }
    }

    public static void solve2() {
        Map<BigInteger, String> winners = new TreeMap<>();
        for (int i = 2; i < 1000; i++) {
            BigInteger number = BigInteger.valueOf(i);
            for (int j = 1; j < 100; j++) {
                number = number.multiply(BigInteger.valueOf(i));
                if (getDigitSumString(number) == i) {
                    winners.put(number, String.valueOf(getDigitSumString(number)) + "^" + j);
                }
            }
        }
        System.out.println(winners.size());
        System.out.println(winners);

        ArrayList<Map.Entry<BigInteger, String>> entries = new ArrayList<>(winners.entrySet());
        for (int i = 0; i < entries.size(); i++) {
            Map.Entry<BigInteger, String> bigIntegerStringEntry = entries.get(i);
            System.out.println((i + 1) + " " + bigIntegerStringEntry);
        }
    }

    private static long getDigitSum(long i) {
        long digitSum = 0;
        while (i > 0) {
            long lastDigit = i % 10;
            digitSum += lastDigit;
            i /= 10;
        }
        return digitSum;
    }

    private static long getDigitSumString(BigInteger i) {
        long digitSum = 0;
        String s = i.toString();
        for (int j = 0; j < s.length(); j++) {
            digitSum += s.charAt(j) - '0';
        }
        return digitSum;
    }
}
