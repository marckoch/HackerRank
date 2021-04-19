package hackerrank.projecteuler.from026to050;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;

/**
 * Digit canceling fractions
 *
 * @author marckoch
 */
public class PE033 {

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    private static boolean isReducable(String debug, int N, int K, int topOrig, int bottomOrig, int topReduced, int bottomReduced) {

        if (countDigits(topOrig) == N // we start with N digits in the top
                && countDigits(bottomOrig) == N // we start with N digits in the bottom
                && countDigits(topReduced) < countDigits(topOrig) // top should have been reduced (have less digits)
                && countDigits(bottomReduced) < countDigits(bottomOrig) // bottom should have been reduced (have less digits)
                //&& countDigits(topReduced) == countDigits(bottomReduced) //NO! leading zeros in top are ok!
                //&& countDigits(topReduced) == (N - K)// NO ! not guaranteed
                ) {
            // nothing should be reduced to 0
            if (topOrig > 0 && bottomOrig > 0 && topReduced > 0 && bottomReduced > 0) {
                // before and after should be fractions < 1
                if (topOrig < bottomOrig && topReduced < bottomReduced) {
                    // top and bottom should have been reduced
                    if (topReduced < topOrig && bottomReduced < bottomOrig) {
                        // x/y == a/b --> x*b == a*y
                        if ((bottomOrig * topReduced) == (topOrig * bottomReduced)) {
                            System.err.printf(debug + ": %s/%s == %s/%s", topOrig, bottomOrig, topReduced, bottomReduced);
                            System.err.println();
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void solve(int N, int K) {
        int sumTop = 0;
        int sumBottom = 0;

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                for (int z = 0; z < 10; z++) {
                    for (int a = 0; a < 10; a++) {
                        for (int b = 0; b < 10; b++) {
                            for (int c = 0; c < 10; c++) {
                                //System.err.printf("%s %s %s %s %s %s\n", x, y, z, a, b, c);
                                int topOrig = 100 * x + 10 * y + z;
                                int bottomOrig = 100 * a + 10 * b + c;

                                if (K == 1) {
                                    // cancel x with a
                                    int topReduced = 10 * y + z;
                                    int bottomReduced = 10 * b + c;
                                    if (x == a && x > 0) {
                                        if (isReducable("x with a", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // cancel x with b
                                    topReduced = 10 * y + z;
                                    bottomReduced = 10 * a + c;
                                    if (x == b && x > 0) {
                                        if (isReducable("x with b", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // cancel x with c
                                    topReduced = 10 * y + z;
                                    bottomReduced = 10 * a + b;
                                    if (x == c && x > 0) {
                                        if (isReducable("x with c", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // cancel y with a
                                    topReduced = 10 * x + z;
                                    bottomReduced = 10 * b + c;
                                    if (y == a && y > 0) {
                                        if (isReducable("y with a", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // cancel y with b
                                    topReduced = 10 * x + z;
                                    bottomReduced = 10 * a + c;
                                    if (y == b && y > 0) {
                                        if (isReducable("y with b", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // cancel y with c
                                    topReduced = 10 * x + z;
                                    bottomReduced = 10 * a + b;
                                    if (y == c && y > 0) {
                                        if (isReducable("y with c", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // cancel z with a
                                    topReduced = 10 * x + y;
                                    bottomReduced = 10 * b + c;
                                    if (z == a && z > 0) {
                                        if (isReducable("z with a", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // cancel z with b
                                    topReduced = 10 * x + y;
                                    bottomReduced = 10 * a + c;
                                    if (z == b && z > 0) {
                                        if (isReducable("z with b", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // cancel z with c
                                    topReduced = 10 * x + y;
                                    bottomReduced = 10 * a + b;
                                    if (z == c && z > 0) {
                                        if (isReducable("z with c", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                        }
                                    }
                                } else if (K == 2) {
                                    // leave z/c
                                    int topReduced = z;
                                    int bottomReduced = c;

                                    if ((x == a && y == b && x > 0 && y > 0)
                                            || (x == b && y == a && x > 0 && y > 0)) {
                                        if (isReducable("leave z/c", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // leave z/b
                                    topReduced = z;
                                    bottomReduced = b;

                                    if ((x == a && y == c && x > 0 && y > 0)
                                            || (x == c && y == a && x > 0 && y > 0)) {
                                        if (isReducable("leave z/b", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // leave z/a
                                    topReduced = z;
                                    bottomReduced = a;

                                    if ((x == b && y == c && x > 0 && y > 0)
                                            || (x == c && y == b && x > 0 && y > 0)) {
                                        if (isReducable("leave z/a", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // leave y/a
                                    topReduced = y;
                                    bottomReduced = a;

                                    if ((x == b && z == c && x > 0 && z > 0)
                                            || (x == c && z == b && x > 0 && z > 0)) {
                                        if (isReducable("leave y/a", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // leave y/b
                                    topReduced = y;
                                    bottomReduced = b;

                                    if ((x == a && z == c && x > 0 && z > 0)
                                            || (x == c && z == a && x > 0 && z > 0)) {
                                        if (isReducable("leave y/b", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // leave y/c
                                    topReduced = y;
                                    bottomReduced = c;

                                    if ((x == a && z == b && x > 0 && z > 0)
                                            || (x == b && z == a && x > 0 && z > 0)) {
                                        if (isReducable("leave y/c", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // leave x/a
                                    topReduced = x;
                                    bottomReduced = a;

                                    if ((y == b && z == c && y > 0 && z > 0)
                                            || (y == c && z == b && y > 0 && z > 0)) {
                                        if (isReducable("leave x/a", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // leave x/b
                                    topReduced = x;
                                    bottomReduced = b;

                                    if ((y == a && z == c && y > 0 && z > 0)
                                            || (y == c && z == a && y > 0 && z > 0)) {
                                        if (isReducable("leave x/b", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }

                                    // leave x/c
                                    topReduced = x;
                                    bottomReduced = c;

                                    if ((y == a && z == b && y > 0 && z > 0)
                                            || (y == b && z == a && y > 0 && z > 0)) {
                                        if (isReducable("leave x/c", N, K, topOrig, bottomOrig, topReduced, bottomReduced)) {
                                            sumTop += topOrig;
                                            sumBottom += bottomOrig;
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sumTop + " " + sumBottom);
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int K = in.nextInt();
//
//        solve(N, K);
//    }
    public static void main(String[] args) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        solve(2, 1);
        Assert.assertEquals("110 322\n", outContent.toString());
        System.err.println(outContent.toString());

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        solve(3, 1);
        Assert.assertEquals("77262 163829\n", outContent.toString());
        System.err.println(outContent.toString());

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        solve(3, 2);
        Assert.assertEquals("7429 17305\n", outContent.toString());
        System.err.println(outContent.toString());

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // https://github.com/peeyushy95/Project-Euler/blob/master/Project%20Euler%20%2333%20Digit%20canceling%20fractions.cpp
        solve(4, 1);
        Assert.assertEquals("12999936 28131911\n", outContent.toString());
        System.err.println(outContent.toString());

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        solve(4, 2);
        Assert.assertEquals("3571225 7153900\n", outContent.toString());
        System.err.println(outContent.toString());

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        solve(4, 3);
        Assert.assertEquals("255983 467405\n", outContent.toString());
        System.err.println(outContent.toString());

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

    }
}
