package hourrank.no27;

import java.io.IOException;
import java.util.Scanner;

public class ImpressingTheBoss {

    private static void printArray(int[] ar) {
        String delimiter = "";
        for (int n : ar) {
            System.err.print(delimiter + n);
            delimiter = " ";
        }
        System.err.println("");
    }

    /*
     * Complete the canModify function below.
     */
    static String canModify(int[] a) {
        printArray(a);
        boolean fixed = false;

        for (int i = 0; i < a.length - 1; i++) {
            int first = a[i];
            int second = a[i + 1];

            if (first > second) {
                if (!fixed) {
                    a[i + 1] = first;
                    fixed = true;
                    
                    printArray(a);
                } else {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        try (final Scanner scanner = new Scanner(System.in)) {
            int q = scanner.nextInt();
            while (q-- > 0) {
                int n = scanner.nextInt();
                int[] a = new int[n];

                for (int i = 0; i < n; i++) {
                    a[i] = scanner.nextInt();
                }

                String result = canModify(a);

                System.out.println(result);
            }
        }
    }
}
