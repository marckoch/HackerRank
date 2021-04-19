package hackerrank.projecteuler.from676to700;

public class PE681 {


    public static void main(String[] args) {
        solveProjectEuler(100);
    }

    public static void solveProjectEuler(int n) {
        long start = System.currentTimeMillis();

        int to = (int) Math.sqrt(n);
        System.out.println("to=" + to);

        long SP = 0;
        for (int i = 1; i <= to; i++) {
            for (int j = i; j <= n / i; j++) {
                int len = 2 * i + 2 * j;
                SP += len;
                System.out.printf("i=%s, j=%s, area=%s, len=%s, SP=%s\n", i, j, i*j, len, SP);
            }
        }

        System.out.println("SP=" + SP + " duration: " + (System.currentTimeMillis() - start));
    }

}
