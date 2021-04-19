package hackerrank.projecteuler.from126to150;

import toolbox.primes.GeneratePrimes;

public class PE131 {
    public static void main(String[] args) {
        int LIMIT = 1000;
        int result = 0;
        boolean[] primesArray = GeneratePrimes.getPrimesAsBooleanArray(1_000_000);
        for (int i = 0; i < LIMIT; i++) {
            int j = i + 1;
            int x = j * j * j - i * i * i;
            if (x > 1_000_000) break;
            if (primesArray[x]) {
                System.out.println(i + " " + x);
                result++;
            }
        }
        System.out.println(result);
    }
}
