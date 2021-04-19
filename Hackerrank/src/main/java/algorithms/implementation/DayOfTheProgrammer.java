package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class DayOfTheProgrammer {

    static String solve(int year) {
        String res = "";

        int sumDays = 31 + 31 + 30 + 31 + 30 + 31 + 31; // without feb! until august!

        if (year < 1918) {
            // Julian Calendar
            sumDays += (year % 4 == 0) ? 29 : 28;
        } else if (year == 1918) {
            // transition year
            sumDays += 15;
        } else {
            // > 1918 Gregorian calendar
            if (year % 400 == 0) {
                sumDays += 29;
            } else if (year % 4 == 0 && year % 100 > 0) {
                sumDays += 29;
            } else {
                sumDays += 28;
            }
        }

        int day = 256 - sumDays;
        res += day;
        res += ".09.";
        res += year;
        return res;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int year = in.nextInt();
            String result = solve(year);
            System.out.println(result);
        }
    }
}
