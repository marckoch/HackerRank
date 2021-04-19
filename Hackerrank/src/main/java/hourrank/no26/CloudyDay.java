package hourrank.no26;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class CloudyDay {

    static long maximumPeople(int[] population, int[] locationTown, int[] locationCloud, int[] rangeCloud) {
        // Return the maximum number of people that will be in a sunny town after removing exactly one cloud.
        int NO_TOWNS = locationTown.length;
        int NO_CLOUDS = locationCloud.length;
        //Arrays.sort(locationTown);
        //Arrays.sort(locationCloud);

        int MIN = 1;
        int MAX = 0;

        for (int x = 0; x < NO_TOWNS; x++) {
            MAX = Math.max(MAX, locationTown[x]);
        }

        int[] cloudFreq = new int[MAX + 2];

        for (int c = 0; c < NO_CLOUDS; c++) {
            int locCloud = locationCloud[c];
            int rngCloud = rangeCloud[c];
            
            int left = Math.max(MIN, (locCloud - rngCloud));
            
            long max = locCloud + rngCloud;
            int right = (int) Math.min(MAX, max);

            for (int x = left; x <= right; x++) {
                cloudFreq[x]++;
            }
        }

        long numberPeople = 0;
        long potentialMax = 0;

        for (int t = 0; t < NO_TOWNS; t++) {
            int locTown = locationTown[t];
            if (cloudFreq[locTown] == 0) { // always sunny, always include in sum
                numberPeople += population[t];
            } else if (cloudFreq[locTown] == 1) { // just one cloud, find maximum town just covered by one cloud
                potentialMax = Math.max(potentialMax, population[t]);
            }
        }

        return numberPeople + potentialMax;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int NO_TOWNS = in.nextInt();
            int[] population = new int[NO_TOWNS];
            for (int i = 0; i < NO_TOWNS; i++) {
                population[i] = in.nextInt();
            }
            int[] locationTown = new int[NO_TOWNS];
            for (int i = 0; i < NO_TOWNS; i++) {
                locationTown[i] = in.nextInt();
            }

            int NO_CLOUDS = in.nextInt();
            int[] locationCloud = new int[NO_CLOUDS];
            for (int i = 0; i < NO_CLOUDS; i++) {
                locationCloud[i] = in.nextInt();
            }
            int[] rangeCloud = new int[NO_CLOUDS];
            for (int i = 0; i < NO_CLOUDS; i++) {
                rangeCloud[i] = in.nextInt();
            }
            long result = maximumPeople(population, locationTown, locationCloud, rangeCloud);
            System.out.println(result);
        }
    }
}
