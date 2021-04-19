import java.util.Scanner;

public class SaveThePrisoner {

    static long saveThePrisoner(long noPrisoners, long noSweets, long startId){
        System.err.println("noPrisoners=" + noPrisoners + " noSweets=" + noSweets + " startId=" + startId);

        long res = startId - 1 + (noSweets % noPrisoners);

        // handle 'under' or overflow cases
        if (res < 1) return noPrisoners;
        else if (res > noPrisoners) {
            return res % noPrisoners;
        }
        else return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long noPrisoners = in.nextInt();
            long noSweets = in.nextInt();
            long startId = in.nextInt();
            long result = saveThePrisoner(noPrisoners, noSweets, startId);
            System.out.println(result);
        }
    }
}