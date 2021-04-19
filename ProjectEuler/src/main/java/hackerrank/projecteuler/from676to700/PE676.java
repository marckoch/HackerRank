package hackerrank.projecteuler.from676to700;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Arrays;

public class PE676 {


    public static void main(String[] args) {

//        System.out.println(M2(1000, 32, 2));
//        System.out.println(M2(1000, 32, 4));

//        System.out.println(M(1000000, 32, 2));
//        System.out.println(M(1000000, 64, 2));
//        System.out.println(M(10000, 32, 8));
//        System.out.println(Mfast(10000, 32, 8));

//        System.out.println(M(1_000_000, 8, 2));
//        System.out.println(Mfast(1_000_000, 8, 2));
//        System.out.println(M2(1_000_000, 8, 2));

//        System.out.println(M(1000000, 32, 8));
        //System.out.println(M2(1000, 32, 8));
//
//        System.out.println(getDigitSum(9167, 64));
//        System.out.println(getDigitSum(9167, 16));
//        System.out.println(M2(100, 32, 2));

//        System.out.println(M(10000, 16, 4));
//        System.out.println(M2(10000, 16, 4));
//        System.out.println(M2((long) Math.pow(10, 16), 8, 2));
//        System.out.println(M2((long) Math.pow(10, 16), 16, 2));
//        System.out.println(M2((long) Math.pow(10, 16), 32, 2));
        System.out.println(Mfast((long) Math.pow(2, 15), 32, 4));

//        System.out.println(Arrays.toString(digits(1024, 32)));
//        System.out.println(Arrays.toString(digits(1024 * 1024, 32)));
//        System.out.println(Arrays.toString(digits(1024, 4)));
//        System.out.println(Arrays.toString(digits(1024 * 1024, 4)));
//        System.out.println(Arrays.toString(digits(164896, 32)));
//        System.out.println(Arrays.toString(digits(164896, 4)));
//        System.out.println(Arrays.toString(digits(164896, 1024)));
//        System.out.println(Arrays.toString(digits((long) Math.pow(10, 16), 1024)));
//        System.out.println(Arrays.toString(digits((long) Math.pow(10, 16), 32)));
//        System.out.println(Arrays.toString(digits((long) Math.pow(10, 16), 4)));
//        solveProjectEuler(10);

//        System.out.println(Arrays.toString(digits(1023, 1024)));
//        System.out.println(Arrays.toString(digits(2385544225L, 32)));
//        System.out.println(Arrays.toString(digits(1023, 4)));
//        System.out.println(toLong(digits(2385544225L, 32), 32));
//        System.out.println(countDigits(123456789, 64));

//        for (int i = 0; i < 100; i++) {
//            System.out.println(i + " >> " + digitSum(i, 32) + " " + digitSum(i, 4) + " " + digitSum(i, 1024));
//        }
    }

    public static void solveProjectEuler(int limit) {
        long start = System.currentTimeMillis();

        BigInteger result = BigInteger.ZERO;
        for (int k = 3; k <= 6; k++) {
            for (int l = 1; l <= k - 2; l++) {
                int b1 = 1 << k;
                int b2 = 1 << l;
                long x = Double.valueOf(Math.pow(10, limit)).longValue();

                System.out.printf("k=%s, b1=%s, l=%s, b2=%s\n", k, b1, l, b2);

                BigInteger m;
                if (k % l == 0) {
                    m = M2(x, b1, b2);
                } else {
                    m = BigInteger.valueOf(Mfast(x, b1, b2));
                }
                System.out.printf("k=%s, b1=%s, l=%s, b2=%s, M=%s\n", k, b1, l, b2, m);

                result = result.add(m);
            }
        }
        System.out.println("result=" + result + " duration: " + (System.currentTimeMillis() - start));
    }

    public static long M(long n, int b1, int b2) {
        long start = System.currentTimeMillis();
        int count = 0;
        long sum = 0;
        for (long i = 0; i <= n; i++) {
            if (digitSum(i, b1) == digitSum(i, b2)) {
                count++;
                System.out.println(count + "\t" + i + ": " + Arrays.toString(digits(i, b1)) + "(" + b1 + ")" + "==" + Arrays.toString(digits(i, b2)) + "(" + b2 + ") HIT!");
                sum += i;
            }
        }
        System.out.println("count=" + count + "/" + n + " took " + (System.currentTimeMillis() - start));
        return sum;
    }

    public static long Mfast(long n, int b1, int b2) {
        long start = System.currentTimeMillis();
        int count = 0;
        long sum = 0;
        int maxDigitInSmallBase = b2 - 1;
        for (long i = 0; i <= n; i += b1) { // only check every b1-th number!

            long digitSumInBigBase = getDigitSum(i, b1);

            // no need to check numbers that have a digit sum in b1 that is bigger than the max in b2!
            // e.g. b2 = 2 and 4 digits >> max number is 1111(2), so max digit sum for b2 is 4
            // so any number in base 32 with digit > 4 is irrelevant (e.g. [0,7](32)
            int digitsInSmallBase = countDigits(i, b2);
            int maxDigitSumInSmallBase = digitsInSmallBase * maxDigitInSmallBase;
            if (digitSumInBigBase > maxDigitSumInSmallBase) continue;

            if (digitSumInBigBase == getDigitSum(i, b2)) {
                // if we have a match this number and all b2 following are a match!

                // sum up: i+0 + i+1 + i+2 + ... i+(b2-2) + i+(b2-1)
                //     =  i + i + ... + i +   0 + 1 + 2 + ... + (b2-2) + (b2-1)
                //     =  b2 * i   + SUM_from_0_to_b2-1
                sum += b2 * i;
                sum += (b2 * (b2 - 1)) / 2;

                for (int j = 0; j < b2; j++) {
                    long k = i + j;
                    System.out.println(count + "\t" + k + ": " + Arrays.toString(digits(k, b1)) + "(" + b1 + ")" + "==" + Arrays.toString(digits(k, b2)) + "(" + b2 + ") both have digitsum=" + getDigitSum(i, b1) + "   " + Arrays.toString(digits(k, 1024)));
                    //sum += k;
                }
                count += b2;
            } else {
                System.out.println(count + "\t" + i + ": " + Arrays.toString(digits(i, b1)) + "(" + b1 + ")" + "!=" + Arrays.toString(digits(i, b2)) + "(" + b2 + ")  " + Arrays.toString(digits(i, 1024)));
            }
        }
        System.out.println("count=" + count + "/" + (n / b1) + " took " + (System.currentTimeMillis() - start));
        return sum;
    }

    public static BigInteger M2(long n, int b1, int b2) {
        long start = System.currentTimeMillis();
        BigInteger sum = BigInteger.ZERO;
        long count = 0;
        int i = 0;
        long b1Number = 0;
        while (b1Number < n) {
            @NotNull int[] b2Number = digits(i, b2);
            b1Number = toLong(b2Number, b1);

            if (b1Number < n) {
//                System.out.println(i + " " + b1Number + " " + Arrays.toString(b2Number) + "(" + b1 + ")==" + Arrays.toString(digits(b1Number, b2)) + "(" + b2 + ")");
                sum = sum.add(BigInteger.valueOf(b1Number));
                count++;
                i++;
            }
        }
        System.out.println("count=" + count + "/" + i + " took " + (System.currentTimeMillis() - start));
        return sum;
    }

    private static long getDigitSum(long i, int base) {
        long digitSum = 0;
        while (i > 0) {
            long lastDigit = i % base;
            digitSum += lastDigit;
            i /= base;
        }
        return digitSum;
    }

    public static long digitSum(long l, int base) {
        int[] digits = digits(l, base);
        //System.out.println(l + "(" + base + ")==" + Arrays.toString(digits));
        return Arrays.stream(digits).sum();
    }

    @org.jetbrains.annotations.NotNull
    public static int[] digits(long i, int base) {
        int cd = countDigits(i, base);
        int[] result = new int[cd];
        int index = 0;
        while (i > 0) {
            int lastDigit = (int) (i % base);
            result[cd - 1 - index++] = lastDigit;
            i /= base;
        }
        return result;
    }

    public static int countDigits(long number, int base) {
        if (number == 0) return 1;
        return (int) (Math.log(number) / Math.log(base)) + 1;
    }

    // take given int[] and interpret it as number to base 'base' and calculate long
    public static long toLong(int[] digits, int base) {
        long result = 0;
        for (int i = digits.length - 1, pow = 0; i >= 0; i--, pow++) {
            int digit = digits[i];
            if (digit >= base) {
                throw new IllegalArgumentException("illegal digit " + digit + " in number to base " + base);
            }
            result += digit * Math.pow(base, pow);
        }
        return result;
    }
}
