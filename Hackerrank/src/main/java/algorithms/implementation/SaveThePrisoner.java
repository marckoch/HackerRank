package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class SaveThePrisoner {

    static int saveThePrisoner(int noPrisoners, int noSweets, int startId) {
        //System.err.println("noPrisoners=" + noPrisoners + " noSweets=" + noSweets + " startId=" + startId);
        int res = startId - 1 + (noSweets % noPrisoners);
        if (res < 1) {
            return noPrisoners;
        } else if (res > noPrisoners) {
            return res % noPrisoners;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int a0 = 0; a0 < t; a0++) {
                int n = in.nextInt();
                int m = in.nextInt();
                int s = in.nextInt();
                int result = saveThePrisoner(n, m, s);
                System.out.println(result);
            }
        }
    }
}
