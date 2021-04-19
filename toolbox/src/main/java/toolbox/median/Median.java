package toolbox.median;

import java.util.Arrays;

/**
 *
 * @author marckoch
 */
public class Median {

    private static double getMedianOfFrequencyArray(int[] freq, int numberOfElements) {
        int sum = 0;
        for (int i = 0; i < freq.length; i++) {
            sum += freq[i];
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
        int[] evenNumbers = {1, 3, 4, 2, 4, 5, 2, 8};

        int[] freqEven = new int[10];
        for (int i = 0; i < evenNumbers.length; i++) {
            freqEven[evenNumbers[i]]++;
        }
        System.err.println(Arrays.toString(freqEven));
        Arrays.sort(evenNumbers);
        System.err.println(Arrays.toString(evenNumbers));
        System.err.println("median of even numbers = " + getMedianOfFrequencyArray(freqEven, 8));

        int[] oddNumbers = {1, 3, 4, 2, 4, 5, 2, 8, 7};
        int[] freqOdd = new int[10];
        for (int i = 0; i < oddNumbers.length; i++) {
            freqOdd[oddNumbers[i]]++;
        }
        System.err.println(Arrays.toString(freqOdd));
        Arrays.sort(oddNumbers);
        System.err.println(Arrays.toString(oddNumbers));
        System.err.println("median of even numbers = " + getMedianOfFrequencyArray(freqOdd, 9));

    }
}
