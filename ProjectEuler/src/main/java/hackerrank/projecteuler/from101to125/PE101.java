package hackerrank.projecteuler.from101to125;

import java.util.Arrays;

public class PE101 {


    public static void main(String[] args) {
        long[] coefficients = {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1};
        Polynom p = new Polynom(coefficients);
        System.out.println(p);

        long fits = 0;
        for (int n = 1; n <= p.getDegree(); n++) {
            long fit = lagrange(p, n);
            System.out.println(n + " fit=" + fit);
            fits += fit;
        }

        System.out.println("fits=" + fits);
        Lagrange();

        long p_3 = lagrange(new long[][]{{0, 1}, {1, 2}, {2, 5}}, 3);
//        System.out.println(p_3);

        fits = 0;
        for (int n = 1; n <= p.getDegree(); n++) {
            long[][] points = new long[n][2];
            for (int x = 0; x < n; x++) {
                points[x][0] = x + 1;   // 0 ==> x
                points[x][1] = p.evaluate(points[x][0]);   // 1 ==> y = f(x)
            }
//            System.out.println(n + " " + Arrays.deepToString(points));

            long fit = lagrange(points, n + 1);
            System.out.println(" fit == P(x+1) = P(" + (n + 1) + ") = " + fit);
            fits += fit;
        }
        System.out.println(fits);

        // n^3 again:
        fits = 0;
        p = new Polynom(new long[]{0, 0, 0, 1});
        for (int n = 1; n <= p.getDegree(); n++) {
            long[][] points = new long[n][2];
            for (int x = 0; x < n; x++) {
                points[x][0] = x + 1;
                points[x][1] = p.evaluate(points[x][0]);
            }
//            System.out.println(n + " " + Arrays.deepToString(points));

            long fit = lagrange(points, n + 1);
            System.out.println(" fit == P(x+1) = P(" + (n + 1) + ") = " + fit);
            fits += fit;
        }
        System.out.println(fits);
    }

    // http://mathworld.wolfram.com/LagrangeInterpolatingPolynomial.html
    static long lagrange(long[][] points, int x) {
        System.out.println("points=" + Arrays.deepToString(points));
        long p_x = 0;
        int n = points.length; // number of points

        for (int j = 1; j <= n; j++) {
            long y_j = points[j - 1][1];

            long top = 1;
            long bottom = 1;
            for (int k = 1; k <= n; k++) {
                long x_j = points[j - 1][0];
                long x_k = points[k - 1][0];
                if (j != k) {
                    top *= (x - x_k);
                    bottom *= (x_j - x_k);
                }
            }
            p_x += y_j * top / bottom;
        }

        return p_x;
    }

    // http://mathworld.wolfram.com/LagrangeInterpolatingPolynomial.html
    static long lagrange(Polynom p, int x) {
        long P_x = 0;
        for (int j = 1; j <= x; j++) {

            long top = 1;
            long bottom = 1;
            for (int k = 1; k <= x; k++) {
                if (k == j) {
                    continue;
                } else {
                    top *= (x + 1 - k);
                    bottom *= (j - k);
                }
            }

            long y_j = p.evaluate(j);
            P_x += top * y_j / bottom;
        }
        return P_x;
    }

    // https://www.mathblog.dk/files/euler/Problem101.cs
    public static void Lagrange() {
        //Generate the generator polynomial
        long[] coefficients = {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1};
        Polynom poly = new Polynom(coefficients);

        long fits = 0;
        for (long n = 1; n <= coefficients.length - 1; n++) {
            long fit = 0;
            for (int i = 1; i <= n; i++) {

                long temp1 = 1;
                long temp2 = 1;

                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    } else {
                        temp1 *= n + 1 - j;
                        temp2 *= i - j;
                    }
                }
                fit += temp1 * poly.evaluate(i) / temp2;
            }

            System.out.println(n + " fit=" + fit);
            fits += fit;
            //Console.WriteLine(result);
        }

        System.out.printf("The sum of FITs is %s\n", fits);
    }

    static class Polynom {
        private long[] coefficients;

        public Polynom(long[] coefficients) {
            this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
        }

        public int getDegree() {
            return coefficients.length - 1;
        }

        public long evaluate(long x) {
            long result = 0;
            for (int i = getDegree(); i >= 0; i--) {
                result = result * x + coefficients[i];
            }
            return result;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < coefficients.length; i++) {
                long c = coefficients[i];
                if (c == 0) continue;

                if (sb.length() > 0) {
                    sb.append(" + ");
                }
                sb.append(c);
                if (i > 0) {
                    sb.append("n^").append(i);
                }
            }
            return sb.toString();
        }
    }
}
