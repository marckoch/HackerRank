package hackerrank.projecteuler.from051to075;

import java.util.Scanner;

/**
 * Counting fractions in a range
 *
 * @author marckoch
 */
public class PE073 {

    // too slow, 38% on hackerrank, but solved Projecteuler (2, 12000) >> 7295372
    public static long fareyNaiveStart(int a, int n) {
        long count = 0;

        // we start with two smallest fractions : 0/1 and 1/n
        long top0 = 0;
        long bottom0 = 1;
        long top1 = 1;
        long bottom1 = n;

        //System.err.printf("%s/%s\n", top0, bottom0);
        //System.err.printf("%s/%s\n", top1, bottom1);
        long top2 = 0, bottom2 = 0;
        while (bottom2 != 1) {
            int k = (int) ((n + bottom0) / bottom1);
            top2 = k * top1 - top0;
            bottom2 = k * bottom1 - bottom0;

            //System.err.printf("%s/%s\n", top2, bottom2);
            // check if   1/(A+1) < frac2 < 1/A
            if ((bottom2 < top2 * (a + 1)) // 1/(A+1) < frac2
                    && (top2 * a < bottom2)) // frac2 < 1/A
            {
                count++;
            }

            if ((bottom2 < top2 * a)) // 1/(A) < frac2
            {
                break;
            }

            top0 = top1;
            top1 = top2;
            bottom0 = bottom1;
            bottom1 = bottom2;
        }
        //System.out.println("**" + count);
        return count;
    }

    // algorithm I:
    // count mediants between 1/fromD and 1/toD using recursion
    // 77% on hackerrank
    public static long recursion(int fromD, int toD, int D) {
        int mediantD = fromD + toD;
        // denominator too big ?
        if (mediantD > D) {
            return 0;
        }

        return 1 + recursion(fromD, mediantD, D) + recursion(mediantD, toD, D);
    }

    // algorithm II:
    // iteratively enumerate all denominators
    // 77% on hackerrank
    public static int iteration(int fromD, int toD, int D) {
        // find denominator of closest mediant of "from"
        // initial mediant
        int d = fromD + toD;
        // is there a mediant closer to fromD ?
        while (d + fromD <= D) {
            d += fromD;
        }

        // if prevD and d are denominators of adjacent fractions prevN/prevD and n/d
        // then the next denominator is nextD = maxD - (maxD + prevD) % d
        int prevD = fromD;

        int count = 0;
        // until we reach the final denominator
        while (d != toD) {
            // find next denominator
            int nextD = D - (D + prevD) % d;

            // shift denominators, the current becomes the previous
            prevD = d;
            d = nextD;

            count++;
        }

        return count;
    }

    // algorithm III:
    // return numbers of irreducible fractions a/b < n/d where b is less than maxD
    public static long rank(int n, int d, int D) {
        // algorithm from "Computer Order Statistics in the Farey Sequence" by C. & M. Patrascu
        // http://people.csail.mit.edu/mip/papers/farey/talk.pdf
        long[] data = new long[D + 1];
        for (int i = 0; i < data.length; i++) {
            data[i] = i * n / d; // n is always 1 but I wanted to keep the original algorithm
        }
        // remove all multiples of 2*i, 3*i, 4*i, ...
        // similar to a prime sieve
        for (int i = 1; i < data.length; i++) {
            for (int j = 2 * i; j < data.length; j += i) {
                data[j] -= data[i];
            }
        }

        // return sum of all elements
        long sum = 0;
        for (long x : data) {
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int D = in.nextInt();

        // System.out.println(fareyNaiveStart(A, D));
        // System.out.println(recursion(A + 1, A, D));
        // System.out.println(iteration(A + 1, A, D));
        System.out.println(rank(1, A, D) - rank(1, A + 1, D) - 1);
    }

}
