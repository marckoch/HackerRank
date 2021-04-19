package hackerrank.projecteuler.from126to150;

public class PE135 {
    public static void main(String[] args) {
        int N = 1_000_000;
        int[] count = new int[N + 1];

        for (int u = 1; u <= N ; u++) {
            for (int v = 1; u * v <= N; v++) {
                if ((u + v) % 4 == 0 && // so d is an integer
                        3 * v > u && // or z would be negative
                        ((3 * v - u) % 4 == 0)) { // so z is an integer
//                    int d = (u + v) / 4;
//                    int z = (3 * v - u) / 4;
//
//                    int x = z + 2 * d;
//                    int y = z + d;
//                    int n = u * v;
//                    System.out.println(u + " " + v + " > d=" + d + "  " + x + "^2 - " + y + "^2 - " + z + "^2 = " + n);
                    count[u * v]++;
                }
            }
        }
//        System.out.println(Arrays.toString(count));
        int countTens = 0;
        for (int i = 0; i < count.length; i++) {
            int value = count[i];
            if (value == 10) {
                countTens++;
                //System.out.println(i + " " + value);
            }
        }
        System.out.println(countTens);
    }
}
