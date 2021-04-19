package algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class FraudulentActivityNotifications {

    static int activityNotifications(int[] expenditure, int days) {
        int notifications = 0;
        int[] freq = new int[201];
        Queue<Integer> values = new LinkedList<>();
        for (int i = 0; i < expenditure.length; i++) {
            if (i >= days) {
                double median = getMedianOfFrequencyArray(freq, days);
                if (expenditure[i] >= 2 * median) {
                    notifications++;
                }

                //System.err.println("adding " + expenditure[i]);
                freq[expenditure[i]]++;
                values.add(expenditure[i]);

                Integer removedVal = values.remove();
                //System.err.println("removing " + removedVal);
                freq[removedVal]--;
            } else {
                //System.err.println("adding " + expenditure[i]);
                freq[expenditure[i]]++;
                values.add(expenditure[i]);
            }

            //System.err.println(values);
            //System.err.println(Arrays.toString(freq));
        }

        return notifications;
    }

    private static double getMedianOfFrequencyArray(int[] count, int numberOfElements) {
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            if (2 * sum < numberOfElements) {
                continue;
            } else if (2 * sum == numberOfElements) {
                return (2 * i + 1) / 2.0;
            } else {
                return i * 1.0;
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int N = in.nextInt();
            int days = in.nextInt();

            int[] expenditure = new int[N];
            for (int i = 0; i < N; i++) {
                expenditure[i] = in.nextInt();
            }
            int result = activityNotifications(expenditure, days);
            System.out.println(result);
        }
    }
}
