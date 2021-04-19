package hackerrank.projecteuler.from001to025;

import java.util.Scanner;

/**
 * Counting Sundays
 * @author marckoch
 */
public class PE019 {
    // http://www.geeksforgeeks.org/zellers-congruence-find-day-date/
    private static String getZellerCongruence(int day, int month, long year)
    {
        //System.err.println(day + "." + month + "." + year);
        if (month == 1) {
            month = 13;
            year--;
        }
        if (month == 2) {
            month = 14;
            year--;
        }
        int q = day;
        int m = month;
        long k = year % 100;
        long j = year / 100;
        long h = q + 13*(m+1)/5 + k + k/4 + j/4 + 5*j;
        h = h % 7;
        //System.err.println(day + "." + month + "." + year + " --> " + h);
        switch ((int)h) {
            case 0 : return "Saturday";
            case 1 : return "Sunday"; 
            case 2 : return "Monday";
            case 3 : return "Tuesday";
            case 4 : return "Wednesday";
            case 5 : return "Thursday";
            case 6 : return "Friday";
        }
        return null;
    }
    
    private static boolean isBefore(int day1, int month1, long year1, int day2, int month2, long year2) {
        if (year1<year2) return true;
        if (year1>year2) return false;
        
        // years are equal -> compare months
        if (month1<month2) return true;
        if (month1>month2) return false;
        
        // months are equal -> compare days
        if (day1<day2) return true;
        return false;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++){
            in.nextLine();
            long year1 = in.nextLong();
            int month1 = in.nextInt();
            int day1 = in.nextInt();
            //System.err.println(day1 + "." + month1 + "." + year1);
            
            in.nextLine();
            long year2 = in.nextLong();
            int month2 = in.nextInt();
            int day2 = in.nextInt();
            //System.err.println(day2 + "." + month2 + "." + year2);
            
            // determine which date is first
            long yearEarlierDate = year1;
            int monthEarlierDate = month1;
            int dayEarlierDate = day1;

            long yearLaterDate = year2;
            int monthLaterDate = month2;
            int dayLaterDate = day2;

            // switch if neccessary
            if (! isBefore(day1, month1, year1, day2, month2, year2)) {
                yearEarlierDate = year2;
                monthEarlierDate = month2;
                dayEarlierDate = day2;

                yearLaterDate = year1;
                monthLaterDate = month1;
                dayLaterDate = day1;
            }
            
            // if first date is not on first on month move to first of next month
            if (dayEarlierDate > 1) {
                dayEarlierDate=1; 
                monthEarlierDate=monthEarlierDate+1;
                if (monthEarlierDate>12) {
                    monthEarlierDate=1;
                    yearEarlierDate++;
                }
            }
            
            // earlierDate will move up by one month
            long sundayCount=0;
            while (isBefore(1, monthEarlierDate, yearEarlierDate, 
                            1, monthLaterDate, yearLaterDate) ) {
                if ("Sunday".equals(getZellerCongruence(1, monthEarlierDate, yearEarlierDate)))
                    sundayCount++;
                
                // increase earlierDate by 1 month
                monthEarlierDate=monthEarlierDate+1;
                if (monthEarlierDate>12) {
                    monthEarlierDate=1;
                    yearEarlierDate++;
                }
            }
            
            if ("Sunday".equals(getZellerCongruence(1, monthEarlierDate, yearEarlierDate)))
                    sundayCount++;
            
            System.out.println(sundayCount);
        }
    }
}
