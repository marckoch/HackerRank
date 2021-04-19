package hackerrank.projecteuler.from101to125;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PE103 {
    public static void main(String[] args) {
        int[] value = {3, 5, 6, 7};
        int max = 4;
        int min = -1;

        int diff = max - min + 1;

        int combis = (int) Math.pow(diff, value.length);

        int[] perturbations = new int[value.length];
        Arrays.fill(perturbations, min);

        long minSum = Long.MAX_VALUE;
        String setStringOfMinimum = "";

        for (int i = 0; i < combis; i++) {
//            System.out.println(Arrays.toString(perturbations));
            final int[] finalCopyOfC = Arrays.copyOf(perturbations, perturbations.length);

            int[] numbers = zip(value, finalCopyOfC);
            long countDistinctElements = Arrays.stream(numbers).distinct().count();
            if (countDistinctElements == numbers.length) {
                boolean check = check(numbers);
                if (check) {
                    long sum = Arrays.stream(numbers).sum();
                    String setString = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining());
                    System.out.println("  " + sum + " " + setString);
                    if (sum < minSum) {
                        System.out.println("found a new minimum !");
                        minSum = sum;
                        setStringOfMinimum = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining());
                    }
                }
            }

            updatePerturbationVector(perturbations, min, max);
        }

        System.out.println("minimum: " + minSum + " " + setStringOfMinimum);
    }

    private static boolean check(int[] numbers) {
        System.out.println("checking " + Arrays.toString(numbers));
        int totalSum = Arrays.stream(numbers).sum();
        int n = (int) Math.pow(2, numbers.length);

        Set<Integer> uniqueSums = new HashSet<>();

        // loop from 1 to n-1, exclude 0 and n itself (because than one set would be empty)
        for (int i = 1; i < n; i++) {
            int[] leftSet = buildArray(numbers, i);
            System.out.println(i + " " + Integer.toString(i, 2) + " " + Arrays.toString(leftSet));

            int sumLeftSet = Arrays.stream(leftSet).sum();
            if (uniqueSums.contains(sumLeftSet)) {
                return false;
            } else {
                uniqueSums.add(sumLeftSet);
            }

            long elementCountLeftSet = Arrays.stream(leftSet).filter(value -> value > 0).count();
            long elementCountRightSet = numbers.length - elementCountLeftSet;

            System.out.println("  " + Integer.toString(i, 2) + " " + Arrays.toString(leftSet) +
                    " sumLeft=" + sumLeftSet +
                    " countLeft=" + elementCountLeftSet + " countRight=" + elementCountRightSet);

//            if (elementCountLeftSet > elementCountRightSet) return false;
//            if (elementCountLeftSet < elementCountRightSet) return false;
        }
        System.out.println("good: " + Arrays.toString(numbers));
        return true;
    }

    private static boolean check_Wrong(int[] numbers) {
        System.out.println("checking " + Arrays.toString(numbers));
        int totalSum = Arrays.stream(numbers).sum();
        int n = (int) Math.pow(2, numbers.length);
        Set<Integer> uniqueSums = new HashSet<>();
        // loop from 1 to n-1, exclude 0 and n itself (because than one set would be empty)
        for (int i = 0; i < n; i++) {
            int[] leftSet = buildArray(numbers, i);
//            System.out.println(i + " " + Integer.toString(i, 2) + " " + Arrays.toString(leftSet));

            int sumLeftSet = Arrays.stream(leftSet).sum();
            int sumRightSet = totalSum - sumLeftSet;

            long elementCountLeftSet = Arrays.stream(leftSet).filter(value -> value > 0).count();
            long elementCountRightSet = numbers.length - elementCountLeftSet;

            System.out.println("  " + Integer.toString(i, 2) + " " + Arrays.toString(leftSet) +
                    " sumLeft=" + sumLeftSet + " sumRight=" + sumRightSet +
                    " countLeft=" + elementCountLeftSet + " countRight=" + elementCountRightSet);

            if (sumLeftSet == sumRightSet) return false;
            if (elementCountLeftSet > elementCountRightSet && sumLeftSet <= sumRightSet) return false;
            if (elementCountLeftSet < elementCountRightSet && sumLeftSet >= sumRightSet) return false;
        }
        System.out.println("good: " + Arrays.toString(numbers));
        return true;
    }

    public static int[] buildArray(int[] array, int x) {
        int len = array.length;
        int[] newArr = new int[len];
        for (int j = 0; j < len; j++) {
            if ((x & 1) == 1) {
                newArr[j] = array[j];
            }
            x >>= 1;
        }
        return newArr;
    }

    private static int[] zip(int[] arr1, int[] arr2) {
        int commonLength = Math.min(arr1.length, arr2.length);
        return IntStream.range(0, commonLength)
                .map(i -> arr1[i] + arr2[i])
                .toArray();
    }

    private static int[] updatePerturbationVector(int[] a, int min, int max) {
//        System.out.println(" before " + Arrays.toString(a));
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == max) continue;
            else {
                for (int j = i + 1; j < a.length; j++) {
                    a[j] = min;
                }
                a[i]++;
//                System.out.println(" middle  " + Arrays.toString(a));
                return a;
            }
        }
//        System.out.println(" after  " + Arrays.toString(a));
        return a;
    }


}
