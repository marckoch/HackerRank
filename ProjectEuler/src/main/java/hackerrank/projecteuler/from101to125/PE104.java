package hackerrank.projecteuler.from101to125;

import toolbox.pandigital.CheckIfPandigital;

import java.math.BigInteger;

/**
 *
 */
public class PE104 {

    public static void buildFib() {
        BigInteger f_n2 = BigInteger.ZERO;
        BigInteger f_n1 = BigInteger.ONE;
        BigInteger tailCutOff = BigInteger.TEN.pow(9);

        final int LIMIT = 400_000;

        for (int n = 2; n <= LIMIT; n++) {
            final BigInteger f_n = f_n1.add(f_n2);

            // System.err.println(n + " " + f_n);

            if (f_n.compareTo(tailCutOff) > 0) {
                //System.err.println(strFN);

                // string is too slow!!
                //final String last9digits = strFN.substring(len - 9);
                //final boolean last9arePanDigits = CheckIfPandigital.isPandigital(Long.valueOf(last9digits));

                // f_n mod 10^9 will give the last 9 digits
                final long last9digits = f_n.mod(tailCutOff).longValue();
                final boolean last9arePanDigits = CheckIfPandigital.isPandigital(last9digits);

                if (last9arePanDigits) {
                    final String strFN = f_n.toString();
                    System.out.println("match for last 9 " + n + " " + strFN);

                    final String first9digits = strFN.substring(0, 9);
                    final boolean first9arePanDigits = CheckIfPandigital.isPandigital(Long.valueOf(first9digits));
                    if (first9arePanDigits) {
                        System.out.println("match for first 9 " + n + " " + strFN);
                    }

                    if (first9arePanDigits && last9arePanDigits) {
                        System.out.println("the winner is " + n + " " + strFN);
                        break;
                    }
                }
            }

            f_n2 = f_n1;
            f_n1 = f_n;
        }
    }

    public static void main(String[] args) {
        buildFib();
    }
}
